<%@page import="com.fsoft.bn.portlet.audiolibrary.AudioLibraryConfigModel"%>
<%@ page import="org.apache.commons.lang.RandomStringUtils" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<portlet:defineObjects />
<%
	String audioList = (String) request.getAttribute("audioList");
	String audioCategoryList = (String) request.getAttribute("audioCategoryList");
	String categoryMap = (String) request.getAttribute("categoryMap");
	String randomId = RandomStringUtils.randomAlphabetic(10);
%>
<script>
	var <portlet:namespace />audioList = <%=audioList%>;
	var <portlet:namespace />audioCategoryList = <%=audioCategoryList%>;
	var <portlet:namespace />categoryMap = <%=categoryMap%>;
	var divId = '<%=randomId%>';
	var <portlet:namespace />activePage = 1;
	var <portlet:namespace />isPaging = ${config.isPaging};
	if (<portlet:namespace />isPaging == true) {
		var <portlet:namespace />numPerPage = ${config.selectedNumPerPage};
		var <portlet:namespace />pages = 0;
		if (${config.byCategory} == true) {
			<portlet:namespace />pages = Math.ceil(<portlet:namespace />audioCategoryList.length / <portlet:namespace />numPerPage);
		} else {
			<portlet:namespace />pages = Math.ceil(<portlet:namespace />audioList.length / <portlet:namespace />numPerPage);
		}
	}
	
	function <portlet:namespace />audioGetPage(pageNum) {
		<portlet:namespace />activePage = pageNum;
		if (${config.byCategory} == true) {
			<portlet:namespace />categoryRenderResult((pageNum - 1) * <portlet:namespace />numPerPage, pageNum * <portlet:namespace />numPerPage - 1);
		} else {
			<portlet:namespace />audioRenderResult((pageNum - 1) * <portlet:namespace />numPerPage, pageNum * <portlet:namespace />numPerPage - 1);
		}
		
		switch (<portlet:namespace />activePage) {
			case 1: 
				$("#<portlet:namespace />first").addClass("disabled");
				$("#<portlet:namespace />prev").addClass("disabled");
				if (<portlet:namespace />pages == 1) {
					$("#<portlet:namespace />next").addClass("disabled");
					$("#<portlet:namespace />last").addClass("disabled");
				} else {
					$("#<portlet:namespace />next").removeClass("disabled");
					$("#<portlet:namespace />last").removeClass("disabled");
				}
				break;
			case <portlet:namespace />pages:
				$("#<portlet:namespace />first").removeClass("disabled");
				$("#<portlet:namespace />prev").removeClass("disabled");
				$("#<portlet:namespace />next").addClass("disabled");
				$("#<portlet:namespace />last").addClass("disabled");
				break;
			default: 
				$("#<portlet:namespace />first").removeClass("disabled");
				$("#<portlet:namespace />prev").removeClass("disabled");
				$("#<portlet:namespace />next").removeClass("disabled");
				$("#<portlet:namespace />last").removeClass("disabled");
				break;
		}
		if (pageNum - 2 > 0 && pageNum + 2 <= <portlet:namespace />pages) {
			<portlet:namespace />addNumSpan(pageNum - 3, pageNum + 1);
		} else if (pageNum == 1 || pageNum == 2) {
			if (<portlet:namespace />pages > <portlet:namespace />numPerPage) {
				<portlet:namespace />addNumSpan(0, <portlet:namespace />numPerPage - 1);
			} else {
				<portlet:namespace />addNumSpan(0, <portlet:namespace />pages - 1);
			}
		} else {
			<portlet:namespace />addNumSpan(<portlet:namespace />pages - <portlet:namespace />numPerPage, <portlet:namespace />pages - 1);
		}
	}
	
	function <portlet:namespace />categoryRenderResult(start, end) {
		$("#<portlet:namespace />result").html("");
		var out = "";
		if (end > <portlet:namespace />audioCategoryList.length - 1) {
			end = <portlet:namespace />audioCategoryList.length - 1;
		}
		if (!<portlet:namespace />isPaging) {
			start = 0;
			end = <portlet:namespace />audioCategoryList.length - 1;
		}
		for (var i = start; i <= end; i++) {
			var audioCategory = <portlet:namespace />audioCategoryList[i];
			var category = JSON.parse(<portlet:namespace />categoryMap[audioCategory._key]);
			out += "<li>";
			out += "<div class='text'>";
			out += "<div class='title_img'>";
			out += "<a href='" + category.categoryUrl + "'>" + audioCategory._value + "</a>";
//  			if (audio.isNew) {
//  				out += '<img class="news-icon" src="${pageContext.request.contextPath}/html/images/icons/icon_new_2.gif" />';
//  			}
			out += "</div>";
			out += "</div>";
			out += "<div class='audio_info'>";
			out += "<span>Số pháp âm: " + category.count + "</span>";
 			out += " | ";
 			out += "<span>";
 			out += "Người đăng: <a href='#'>";
 			if (category.username == null || category.username == "") {
 				out += "Không rõ";
 			} else {
 				out += category.username;
 			}
 			out += "</a></span>";
 			out += " | ";
			out += "<span>Ngày đăng: " + category.createDate + "</span>";
			out += " | ";
			out += "<span>Ngày cập nhật: " + category.lastPostDate + "</span>";
  			out += " | ";
  			out += "<span>Lượt nghe: " + category.viewCount + "</span>";
			out += "</div>";
			out += "</li>";
		}
		$("#<portlet:namespace />result").html(out);
	}

	function <portlet:namespace />audioRenderResult(start, end) {
		$("#<portlet:namespace />result").html("");
		var out = "";
 		if (end > <portlet:namespace />audioList.length - 1) {
 			end = <portlet:namespace />audioList.length - 1;
 		}
 		if (!<portlet:namespace />isPaging) {
 			start = 0;
 			end = <portlet:namespace />audioList.length - 1;
 		}
		num = 0;
		for (var i = start; i <= end; i++) {
			var audio = <portlet:namespace />audioList[i];
			//if (audio.strucId == categoryId || $.inArray(audio.strucId, <portlet:namespace />categoryMap[categoryId])) {
				num++;
				out += "<li>";
				out += "<div class='text'>";
				out += "<div class='title_img'>";
				out += "<a href='" + audio.urlDetailAudio + "'>" + audio.title + "</a>";
				if (audio.isNew) {
					out += '<img class="news-icon" src="${pageContext.request.contextPath}/html/images/icons/icon_new_2.gif" />';
				}
				out += "</div>";
				out += "</div>";
				out += "<div class='audio_info'>";
				out += "<span>";
				out += "Tác giả: <a href='" + audio.urlDetail + "'>";
				if (audio.author == null || audio.author == "") {
					out += "Không rõ";
				} else {
					out += audio.author;
				}
				out += "</a></span>";
				out += " | ";
				out += "<span>Ngày đăng: " + audio.createdDate + "</span>";
				out += " | ";
				out += "<span>Lượt nghe: " + audio.viewCount + "</span>";
				out += " | ";
				out += "<span><a href='" + audio.source + "'>Tải về</a></span>";
				out += "</div>";
				out += "</li>";
			//}
		}
		$("#<portlet:namespace />result").html(out);
	}
	
	function <portlet:namespace />addNumSpan(start, end) {
		if (!<portlet:namespace />isPaging) {
			return;
		}
		if (start < 0) {
			start = 0;
		}
		if (end > <portlet:namespace />pages - 1) {
			end = <portlet:namespace />pages - 1;
		}
		$("#<portlet:namespace />numSpan").html('');
		var out = "";
		for (var i = start; i <= end; i++) {
			if (i + 1 == <portlet:namespace />activePage) {
				out += "<span onclick='<portlet:namespace />audioGetPage(" + (i + 1) + ")' class='pagingNumber activePage'> " + (i + 1) + " </span>";
			} else {
				out += "<span onclick='<portlet:namespace />audioGetPage(" + (i + 1) + ")' class='pagingNumber'> " + (i + 1) + " </span>";
			}
		}
		$("#<portlet:namespace />numSpan").html(out);
	}
	
	$(document).ready(function() {
		<portlet:namespace />audioGetPage(1);
		
		$("#<portlet:namespace />first").click(function() {
			if (!$("#<portlet:namespace />first").hasClass("disabled")) {
				<portlet:namespace />audioGetPage(1);
			}
		});
		
		$("#<portlet:namespace />last").click(function() {
			if (!$("#<portlet:namespace />last").hasClass("disabled")) {
				<portlet:namespace />audioGetPage(<portlet:namespace />pages);
			}
		});
		
		$("#<portlet:namespace />prev").click(function() {
			if (!$("#<portlet:namespace />prev").hasClass("disabled")) {
				<portlet:namespace />audioGetPage(<portlet:namespace />activePage - 1);
			}
		});
		
		$("#<portlet:namespace />next").click(function() {
			if (!$("#<portlet:namespace />next").hasClass("disabled")) {
				<portlet:namespace />audioGetPage(<portlet:namespace />activePage + 1);
			}
		});
		
		if (${config.byCategory} == true) { 
			<portlet:namespace />categoryRenderResult(0, <portlet:namespace />numPerPage - 1);
		} else {
			<portlet:namespace />audioRenderResult(0, <portlet:namespace />numPerPage - 1);
		}
		
		<portlet:namespace />addNumSpan(0, <portlet:namespace />numPerPage - 1);
	}); 
</script>
<h2 class="title_tab">
	<label>
		<c:if test="${config.byCategory == true }">
			<c:if test="${empty config.selectedCategoryList}">Album Pháp Âm Tổng Hợp</c:if>
			<c:if test="${fn:length(config.selectedCategoryList) gt 1}">Album Pháp Âm Tổng Hợp</c:if>
			<c:if test="${fn:length(config.selectedCategoryList) eq 1}">Album ${config.selectedCategoryList[0].value}</c:if>
		</c:if>
		<c:if test="${config.byCategory != true }">
			<c:if test="${empty config.selectedCategoryList}">Pháp Âm Tổng Hợp</c:if>
			<c:if test="${fn:length(config.selectedCategoryList) gt 1}">Pháp Âm Tổng Hợp</c:if>
			<c:if test="${fn:length(config.selectedCategoryList) eq 1}">${config.selectedCategoryList[0].value}</c:if>
		</c:if>
	</label>
</h2>
<div>
<div id="audio_list">
	<ul id="<portlet:namespace />result" class="list audio_list">
		
	</ul>
</div>
<div id="pagingDiv" style="margin-bottom: 30px;">
	<div style="padding: 0px 5px 10px; display: inline-block; float: right;" id="<%=randomId%>">
		<c:if test="${config.isPaging == true}">
			<span>
				<span id="<portlet:namespace />first" class="pagingNumber padding disabled">&lt;&lt; </span>
			</span> 
			
			<span>
				<span id="<portlet:namespace />prev" class="pagingNumber padding disabled">&lt;</span>
			</span> 
			<span id="<portlet:namespace />numSpan">
			
			</span>
			
			 <span>
				<span id="<portlet:namespace />next" class="pagingNumber padding disabled">&gt;</span>
			</span>
			
			 <span>
				<span id="<portlet:namespace />last" class="pagingNumber padding disabled">&gt;&gt;</span>
			</span> 
		</c:if>
	</div>
</div>
</div>