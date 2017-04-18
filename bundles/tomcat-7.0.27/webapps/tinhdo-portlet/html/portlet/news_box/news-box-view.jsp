<%@include file="/html/common/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="cus" uri="/WEB-INF/tld/custom-tags.tld" %>
<portlet:defineObjects />

<div class="box_bg">
	<!--box 1-->
	<div class="box_ttchidao_index" style="<c:if test='${displayFullSize}'>width: 728px; height: auto</c:if>">
		<!-- <h2 class="title_tab"><label><a href="#">${newsBoxTitle}</a></label></h2>  -->
		<h2 class="title_tab"><label><aui:a href="#" label="${newsBoxTitle}"></aui:a></label></h2>
	    <div class="clear"></div>
	    <ul class="list">
		    <c:forEach items="${listNews}" var="news">
		   		<li style="<c:if test='${!displayImage}'>background: url('/tinhdo-portlet/html/images/icons/icon_row_back.png') no-repeat scroll 7px 10px rgba(0, 0, 0, 0); margin-left: 2%;</c:if>">
		   			<c:if test="${displayImage}">
		   				<a href="${news.urlDetail}">
							<img class="photo" src="${news.imageURL}">
						</a>
					</c:if>
					<div class="text">
						<div class="title_v">
							<a href="${news.urlDetail}"> ${news.title} <span class="time">(${news.createdDate})</span></a>
						</div>
						<c:if test="${displaySummary}">
							<div class="content_small">${news.summary}</div>
						</c:if>
					</div>
					<%-- <a href="${news.urlDetail}"> ${news.title} <span class="time">(29/07/2013)</span></a> --%>
				</li>
			</c:forEach>
		</ul>
	</div>
</div>
<div class="clear"></div>