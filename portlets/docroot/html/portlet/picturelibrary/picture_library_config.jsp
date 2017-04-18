<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>

<portlet:defineObjects />

<script type="text/javascript">
	AUI().use('gallery-yquery', function(A) {
		var jQueryPlugins = ['/tinhdo-portlet/html/js/jquery.treeview.js'];
		var jq = A.YQuery();
		jq.use(jQueryPlugins, function() {
			$(document).ready(function() {
				//$(".filetree").treeview({animated : "normal"});
				
				$(".divFullTreeView .filetree .folder").click(function(){
					var folderId = $(this).attr("id");
					$("#changeFolderForm #folderId").val(folderId);
					$("#changeFolderForm").submit();
				});
			});
		});
	});
</script>

<div>
<liferay-ui:success key="success" message="portlet.picturelibrary.config.message.success" />
<div class="pictures">
	<form id="picturelibraryconfigForm" action='<liferay-portlet:actionURL portletConfiguration="true" />' method="post">
		<div class="picture_config">
			<c:forEach items="${pictures}" var="picture" varStatus="status">
				<div class="picture_option">
					<input type="radio" id="radio${picture.fileId}" name="radioPicture" value="${picture.fileId}" <c:if test="${picture.fileId == radioPicture}">checked="checked"</c:if>>
					<label for="radio${picture.fileId}"><img id="img${picture.fileId}" alt="${picture.title}" src="${picture.url}&imageThumbnail=1"></label>
				</div>
			</c:forEach>
		</div>
		<div class="btnSubmit">
			<input type="button" onclick="submitPic();" id="saveButton" title="Save" value='<liferay-ui:message key="common.button.save"/>'>
		</div>
	</form>
</div>
<div class="divFullTreeView">${treeview}</div>

<input type="hidden" id="picturelibraryconfig_message_confirm" value="<liferay-ui:message key="portlet.picturelibrary.config.message.confirm"/>">
<input type="hidden" id="picturelibraryconfig_message_warning" value="<liferay-ui:message key="portlet.picturelibrary.config.message.warning"/>">

<form id="changeFolderForm" action='<liferay-portlet:actionURL portletConfiguration="true" />' method="post">
	<input type="hidden" id="folderId" name="folderId">
</form>
</div>