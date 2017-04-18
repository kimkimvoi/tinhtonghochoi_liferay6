<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@include file="/html/common/init.jsp"%>
<%@page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="cus" uri="/WEB-INF/tld/custom-tags.tld"%>
<portlet:defineObjects />
<c:if test="${mode == 'detail'}">
	<div class="box_bg">
		<h2 class="title_tab">
			<label>Bạn đọc viết về Bắc Ninh</label>
		</h2>
		<div class="clear"></div>
		<div class="content_detail_news">
			<h1 class="title">${writingAbouttinhdoModel.title}</h1>
			<div class="date_time">
				<span>Thứ hai - 19/08/2013 13:18 | Nguồn: Bộ văn hóa thông
					tin Việt Nam</span> <a href="#" class="icon_mail"></a> <a
					class="icon_print" href="#"></a>
			</div>
			<div class="supdetail">${writingAbouttinhdoModel.description}</div>
			<div class="textdetail">${writingAbouttinhdoModel.content}</div>
		</div>
		<div class="clear"></div>
		<c:if test="${fn:length(listLatest) gt 0}">
			<ul class="list_detail">
				<li class="title">Các bài viết mới</li>
				<c:forEach items="${listLatest}" var="item" begin="0" end="4"
					varStatus="status">
					<li><a
						href="/ban-doc-viet-ve-bac-ninh?mode=detail&id=${item.id}">${item.title}&#40;${item.createDate}&#41;</a><label
						class="icon_news"></label></li>
				</c:forEach>
			</ul>
		</c:if>
		<c:if test="${fn:length(listLatest) gt 4}">
			<ul class="list_detail">
				<li class="title">Các tin cũ khác</li>
				<c:forEach items="${listLatest}" var="item" begin="5" end="9"
					varStatus="status">
					<li><a
						href="/ban-doc-viet-ve-bac-ninh?mode=detail&id=${item.id}">${item.title}&#32;&#40;${item.createDate}&#41;</a></li>
				</c:forEach>
			</ul>
		</c:if>
	</div>
</c:if>
<c:if test="${mode == 'list'}">
	<div class="box_bg">
		<h2 class="title_tab">
			<label>Bạn đọc viết về Bắc Ninh</label>
		</h2>
		<ul class="list_new" id="writingAbouttinhdoUl">
			<c:forEach items="${listWritingAbouttinhdo}" var="item">
				<li><a href="/ban-doc-viet-ve-bac-ninh?mode=detail&id=${item.id}" > <img class="photo"
						src="${item.picture}">
				</a>
					<div class="tex_list">
						<div class="title_v">
							<a href="/ban-doc-viet-ve-bac-ninh?mode=detail&id=${item.id}">${item.title}</a>
						</div>
						<div class="content_small">${item.description}</div>
					</div></li>
			</c:forEach>
		</ul>
		<div class="clear"></div>
	</div>
	<cus:paginator curPageStatusText="${curPageStatusText}"
	numOfPage="${numOfPage}" tableId="writingAbouttinhdo" itemsPerPageText="${itemsPerPageText}" numPerPage="${numPerPage}"/>
	<portlet:resourceURL var="writingAbouttinhdo_LoadPage" escapeXml="false" id="writingAbouttinhdo_LoadPage" />					
	<input type="hidden" id="writingAbouttinhdo_loadPageURL" value="<%=renderResponse.encodeURL(writingAbouttinhdo_LoadPage.toString()) %>"/>
</c:if>