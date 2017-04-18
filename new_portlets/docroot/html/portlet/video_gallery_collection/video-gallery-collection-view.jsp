<%@page import="com.fsoft.bn.portlet.news.NewsContants"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="cus" uri="/WEB-INF/tld/custom-tags.tld"%>
<%@include file="/html/common/init.jsp"%>

<style>
	span.disabled{
		 background-color: #f5f5f5;
		border: 1px solid #ebebeb;
		border-radius: 3px;
		color: #d7d7d7;
		cursor: default;
		font-size: 14px;
		font-weight: normal;
		line-height: 17px;
		margin: 0 5px 0 0;
		min-width: 5px;
		padding: 0 7px;
		text-align: center;
	}
	.pagingNumber{
		 background: -moz-linear-gradient(center top , #ffffff 0%, #efefef 100%) repeat scroll 0 0 rgba(0, 0, 0, 0);
	border: 1px solid #bbb;
	border-radius: 3px;
	color: #666;
	float: left;
	font-size: 11px;
	font-weight: normal;
	line-height: 17px;
	margin: 0 5px 0 0;
	min-width: 5px;
	padding: 0 5px;
	text-align: center;
	cursor: pointer;
	}
	.pagingLoadingIndicator{
		height: 100%;
	    left: 0;
	    position: absolute;
	    top: 0;
	    width: 100%;
	    background-color: #FFF;
	}
	.pagingLoadingIndicator_default{
		background: url('{{{contextPath}}}/banmai-portlet/html/images/default_loading_indicator.gif') no-repeat center ;
	}
	.clear {
		clear:both;
	}
	.pagingNumber.activePage {
		background: none repeat scroll 0 0 #318CB8;
		border-color: #308ab6;
		color: #fff;
		cursor: default;
	}
	.paging_container {
		display: inline-block;
		width: 100%;
	}
</style>

<portlet:resourceURL id="<%=NewsContants.RESOURCE_ACTION.LOAD_PAGE%>" var="loadPage"></portlet:resourceURL>

<div  class="box_bg" style="min-height: 380px;">
 <h2 class="title_tab">
  <label>Thư viện video</label>
 </h2>
 <c:if test="${not empty listVideo}">
 	<div id="video_list">  
		<ul>
			<c:forEach var="item" items="${listVideo}" varStatus="index">
		    	<li>
		    		<a class="video_item" href="https://www.youtube.com/embed/${item.id}?rel=0&autoplay=1" title="${item.title}" rel="p${index.index}">
			    		<div class="video-play-icon-container">  
						  	<div class="video-play-icon"></div>
							<img src="https://img.youtube.com/vi/${item.id}/mqdefault.jpg" width="196" height="110" alt="${item.title}"/>
								    		
						 </div>
						 <span>${item.title}</span>
		    		</a>
		    	</li>
		    </c:forEach>
	    </ul>
	 	<div class="clear"></div>
	 </div>
	 <div>
	 	<div id="paging" style="padding: 0px 5px 10px; display: inline-block; float: left;">
		</div>
	 </div>
 </c:if>
 <c:if test="${empty listVideo}">
  Dữ liệu đang cập nhật
 </c:if> 
</div>

<script>
	$(document).ready(function() {
		buildPaginatorSection(1, '${totalPages}');
	});
	
	function buildPaginatorSection(currentPage, totalPages) {
		var html = '';
		if (currentPage == 1) {
			html += '<span class="pagingNumber padding disabled">&lt;&lt; </span>';
			html += '<span class="pagingNumber padding disabled">&lt;</span>';
		} else {
			html += '<span class="pagingNumber padding" onclick="getPageData(1)">&lt;&lt; </span>';
			html += '<span class="pagingNumber padding" onclick="getPageData(' + (currentPage - 1) + ')">&lt;</span>';
		}
		
		var currentPageIndex = currentPage - 5;
		if (currentPageIndex > totalPages - 10) {
			currentPageIndex = totalPages - 10;
		}
		
		if (currentPageIndex < 0) {
			currentPageIndex = 0;
		}
		
		for (var i = currentPageIndex; i < totalPages; i++) {
			if (i - currentPageIndex >= 10) {
				break;
			} 
			
			if ((i + 1) == currentPage) {
				html += ' <span class="pagingNumber activePage">' + currentPage + '</span>';
			} else {
				html += '<span style="cursor: pointer;" class="pagingNumber" onclick="getPageData(' + (i + 1) + ')">' + (i + 1) + '</span>';
			}
		}
		
		if (currentPage == totalPages) {
			html += '<span class="pagingNumber padding disabled">&gt;</span>';
			html += '<span class="pagingNumber padding disabled">&gt;&gt; </span>';
		} else {
			html += '<span class="pagingNumber padding" onclick="getPageData(' + (currentPage + 1) + ')">&gt;</span>';
			html += '<span class="pagingNumber padding" onclick="getPageData(' + totalPages + ')">&gt;&gt;</span>';
		}
		
		$("#paging").html(html);
	}
	
	function getPageData(pageNumber) {
		showLoadingIndicator("video_list", "pagingLoadingIndicator_default");

		var loadPageURL = "${loadPage}";

		$.ajax({
			sync : false,
			url : loadPageURL,
			data : {
				'pageNum' : pageNumber
			},
			dataType : 'json',
			success : function(newPageData) {
				buildPageContent(newPageData.listVideo);
				buildPaginatorSection(pageNumber, newPageData.totalPages);
				hideLoadingIndicator("video_list", "pagingLoadingIndicator_default");
			},
			error : function(response) {
				console.log("error");
				console.log(response);
				hideLoadingIndicator("video_list", "pagingLoadingIndicator_default");
			}
		});
	}
	
	function buildPageContent(listVideo) {
		var html = '';
		if (listVideo != null) {
			html += '<ul>';
			for (var i = 0; i < listVideo.length; i++) {
				var item = listVideo[i];
				html += '<li><a class="video_item" href="https://www.youtube.com/embed/'+item.id+'?rel=0&autoplay=1" title="'+item.title+'" rel="p'+i+'">'
				html += '<div class="video-play-icon-container">'
				html += '<div class="video-play-icon"></div>'
				html += '<img src="https://img.youtube.com/vi/'+item.id+'/mqdefault.jpg" width="196" height="110" alt="'+item.title+'"/>'
				html += '</div>'
				html += '<span>'+item.title+'</span>'
				html += '</a></li>'
			}
			
			html += '</ul>';
			html += '<div class="clear"></div>';
		}
		
		$("#video_list").html(html);
	}
</script>

