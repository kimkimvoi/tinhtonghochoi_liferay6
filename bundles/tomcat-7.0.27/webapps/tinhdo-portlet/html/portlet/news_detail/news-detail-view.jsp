<%@include file="/html/portlet/news_detail/news-detail-init.jsp" %>
<%@include file="/html/common/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<input id="printPageURL" type="hidden" value="${printPageURL}" />
<c:choose>
<c:when test="${print}">
	<div class="content_detail_news">
			<h1 class="title">${newsDetail.title}</h1>
			<div class="date_time">
				<span>${newsDetail.createdDate}</span>
				<a class="icon_print" title="Print" href="javascript:printArticle()"></a>
			</div>
			<div class="supdetail">${newsDetail.summary}</div>
			<div class="textdetail">
				${newsDetail.content}
			</div>	
			<div class="author">
				${newsDetail.author}
			</div>
			<c:if test="${newsDetail.source != null && newsDetail.source != ''}">
				<div class="source">
					<span> <liferay-ui:message key="source" />: ${newsDetail.source}</span> 
				</div>	
			</c:if>
	</div>
	<div class="clear"></div>

</c:when>
<c:otherwise>
	<div class="box_news_detail">

	    <h2 class="title_tab">
	    	<label>
	    		<a href='#'>
					<liferay-ui:message key="${newsDetail.cateName}"></liferay-ui:message>
				</a>
			</label>
		</h2>		
		<div class="clear"></div>
			<div class="content_detail_news">
					<h1 class="title">${newsDetail.title}</h1>
					<div class="date_time">
						<span>${newsDetail.createdDate} 
							<liferay-ui:message key="view.count"/>: ${newsDetail.viewCount}
						</span> 
						<a class="icon_print" title="<liferay-ui:message key="print" />" href="javascript:<portlet:namespace />printPage();"></a>
					</div>
					<div class="supdetail">${newsDetail.summary}</div>
					<div class="textdetail">
						${newsDetail.content}
					</div>	
					<div class="author">
						${newsDetail.author}
					</div>
					<c:if test="${newsDetail.source != null && newsDetail.source != ''}">
						<div class="source">
							<span> <liferay-ui:message key="source" />: ${newsDetail.source}</span> 
						</div>	
					</c:if>	
			</div>
		<div class="clear"></div>
		<c:if test="${fn:length(lstOtherNews) gt 0}">
			<ul class="list_detail">
				<li class="title"><liferay-ui:message key="portlet.newsdetail.othersnews" /></li>
				<c:forEach items="${lstOtherNews}" var="news" varStatus="status">
					<c:if test="${status.index < quanOtherNewsShow}">
						<li><a href="${news.urlDetail}"> ${news.title} (${news.createdDate}) </a></li>
					</c:if>
				</c:forEach>
			</ul>
		</c:if>
</div>


</c:otherwise>
</c:choose>
<script type="text/javascript">
	function printArticle() {
		print();
	}
	
	var printPageURL = $('#printPageURL').val();
	function <portlet:namespace />printPage() {
		expandingWindow(printPageURL);
		//window.open(printPageURL, '', "directories=0,height=480,left=80,location=1,menubar=1,resizable=1,scrollbars=yes,status=0,toolbar=0,top=180,width=640");
	}
</script>