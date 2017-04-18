<%@page import="com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil"%>
<%@page import="org.apache.commons.collections.CollectionUtils"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFolder"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.util.DLPreviewableProcessor"%>
<%@page import="com.liferay.portal.kernel.image.ImageTool"%>
<%@page import="com.liferay.portlet.documentlibrary.util.PDFProcessorUtil"%>
<%@page import="com.liferay.portal.kernel.util.TextFormatter"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.repository.model.Folder"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFolderConstants"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowConstants"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.util.DLUtil"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLAppHelperLocalServiceUtil"%>
<%@ include file="init_pageImport.jsp"%>

<style>
#documentsContainer{
border: 1px solid #dedede;
border-color: #c0c2c5;
overflow-y:scroll;
border-top: none;

}
.fileEntryCheckBox{
margin-right:5px;
}
table td{
padding:5px 10px 5px 10px;
font-weight: bold;
font-size: 13px;
}
table td a{
color:blue;
}
.lfr-preview-file-image-current-column{
background: none;
padding: 20px;
position: relative;
}
</style>
<script type="text/javascript">
$(document).ready(function(){
	$(".im_tab").bind("click", function() {
		$(".im_tab").removeClass("current");
		$(this).addClass("current");
		loadTabData($(this).attr('id'));
		
		selectTab(0);
	});
	
	$(".im_tab").first().click();
});

function onYearTabClick(control) {
	$(".im_year_tab").removeClass("current");
	$(control).addClass("current");
	
	var index = $.inArray(control, $(".im_year_tab"));
	selectTab(index);
}

function selectTab(index) {	
	$(".im_year_tabs_div").children("div").css("display", "none");
	$("#im_tab_year_" + index).css("display", "");
}

function loadTabData(folderId) {
	var url = $('#handleAjaxActionURL').val();
	$.ajax({
		sync: false,
		url: url,
		data: {'folderId' : folderId},
		dataType: 'json',
		type: "POST",
		success: function(data) {
			refreshYearsTab(data);
			selectTab(0);
		},
		error: function(response) {
		}
	});
}

function refreshYearsTab(data) {
	var html = '';
	var subHtml = '';
	html += '<div class="im_year_tabs_div">';
	html += 	'<ul class="im_year_tabs_ul">';
	
	$.each(data, function(index, item) {		
		html += 		'<li>';
		if (index == 0) {
			html += 		'<a class="im_year_tab current" href="#" onclick="onYearTabClick(this)">' + item.name + '</a>';
		} else {
			html += 		'<a class="im_year_tab" href="#" onclick="onYearTabClick(this)">' + item.name + '</a>';
		}		
		
		html += 		'</li>';
		
		subHtml += 	'<div id="im_tab_year_'+ index + '">';
		$.each(item.files, function(i, file) {
			subHtml += '<portlet:renderURL var="documentRenderURL1">';
			subHtml += '<portlet:param name="fileEntryId" value="kiennn_text"/>';
			subHtml += '<portlet:param name="mvcPath" value="/html/portlet/documentviewer/document_viewer.jsp"/>';
			subHtml += '</portlet:renderURL>';
			
			var temp = '<%=documentRenderURL1%>';
			temp = temp.replace('kiennn_text', file._dlFileEntry._fileEntryId);
			subHtml += '<a class="underline_link" href="' + temp + '">' + file._dlFileEntry._title + '</a>';
			subHtml += '<span class="span_separator">|</span>';
		});
		subHtml += 	'</div>';		
	});
	
	html += 	'</ul>';
	
	html += subHtml;
	
	html += '</div>';	
	$("#magazine_Container").html(html);	
}
</script>
<%
long folderId=ParamUtil.getLong(renderRequest,"folderId");	
List<String> extensionList=new ArrayList<String>();
extensionList.add("pdf");
extensionList.add("doc");
extensionList.add("docx");

long internalMagazine_FolderId = 24262; // TODO: Need configured??
OrderByComparator obc =  OrderByComparatorFactoryUtil.create("dlfolder", "createDate", true);
List<DLFolder> folders = DLFolderLocalServiceUtil.getFolders(themeDisplay.getScopeGroupId(), internalMagazine_FolderId, -1, -1, obc);
//List<DLFolder> folders = DLFolderLocalServiceUtil.getFolders(themeDisplay.getScopeGroupId(), internalMagazine_FolderId);
%>
	<portlet:resourceURL escapeXml="false" id="handleAjaxAction" var="handleAjaxAction" />
	<input id="handleAjaxActionURL" type="hidden" value="<%= renderResponse.encodeURL(handleAjaxAction.toString()) %>" />
	<div id="documentsContainer">
		<aui:layout>
			<aui:column>
				<%
					if (folders != null && folders.size() > 0) {						
					%>
						<div class="im_left_panel">
							<ul class="im_tabs">				
								<%	for (DLFolder folder:folders) { %>
									<li>
										<% if (folders.indexOf(folder) == 0) { %>							
											<a class="im_tab current" href="#" id='<%= folder.getFolderId()%>'><%=folder.getName()%></a>
										<% } else { %>
											<a class="im_tab" href="#" id='<%= folder.getFolderId()%>'><%=folder.getName()%></a>
										<% } %>										
										</li>	
								<%	} %>
							</ul>	
						</div>
						<div id="magazine_Container">
							<%-- <%	for (DLFolder folder:folders) {
								List<DLFolder> subFolders = DLFolderLocalServiceUtil.getFolders(themeDisplay.getScopeGroupId(), 
																folder.getFolderId(), -1, -1, obc);
								if (subFolders != null && subFolders.size() > 0) { %>
								<div class="im_year_tabs_div">
									<ul class="im_year_tabs_ul">
										<%for (DLFolder subFolder:subFolders) { %>
											<li>
												<% if (subFolders.indexOf(subFolder) == 0) { %>							
													<a class="im_year_tab current" href="#"><%=subFolder.getName()%></a>
												<% } else { %>
													<a class="im_year_tab" href="#"><%=subFolder.getName()%></a>
												<% } %>										
											</li>
										<% } %>
									</ul>
								</div>
									
								<% }
								List<FileEntry> filesList = DLAppLocalServiceUtil
												.getFileEntries(themeDisplay.getScopeGroupId(), folder.getFolderId());
							%>
								<div id="im_tab_<%=folders.indexOf(folder)%>">					
									<%
										for (FileEntry fileEntry : filesList) {
											if(extensionList.contains(fileEntry.getExtension())){
									%>
										<portlet:renderURL var="documentRenderURL1">
										<portlet:param name="fileEntryId" value="<%=String.valueOf(fileEntry.getFileEntryId())%>"/>
										<portlet:param name="mvcPath" value="/html/portlet/documentviewer/document_viewer.jsp"/>
										</portlet:renderURL>						
										<a class="underline_link" href="<%=documentRenderURL1%>"><%=fileEntry.getTitle()%></a>
										<span class="span_separator">|</span>					
									<%
									}}
									%>
								</div>	
							<% } %> --%>
						</div>
				<%	} %>					
			</aui:column>
		</aui:layout>
	</div>