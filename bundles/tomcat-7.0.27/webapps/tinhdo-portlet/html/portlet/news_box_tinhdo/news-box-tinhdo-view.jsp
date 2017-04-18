<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@include file="/html/common/init.jsp"%>
<%@page contentType="text/html;charset=UTF-8"%>
<portlet:defineObjects />
<div class="box_bg">
	<div class="about_content">
		<c:if test="${boxType == '5' }">
			<div class="box-content_dukhach margin fixwidth ">
				<h2 class="title_tab margin_top_0">
					<label>
						<c:forEach items="${listBoxType}" var="item">
							<c:if test="${item.key == boxType}">
								<a href="#"><liferay-ui:message key="portlet.NewsBoxTinhDo.type${item.key}" /></a>
							</c:if>
						</c:forEach>
					</label>
				</h2>
				<div class="clear"></div>
				<div class="box_dk">
					<a href="${news.urlDetail}"> <img src="${news.imageURL}"
						class="img" /></a>
					<div class="text">
						<h2 class="title_v">
							<a href="${news.urlDetail}">${news.title}</a>
						</h2>
						<div class="updateTime">${news.createdDate}</div>
						<div class="content_text">${news.summary}</div>
					</div>
				</div>
				<div class="clear"></div>
				<a href="${news.urlDetail}" class="link_more">Xem chi tiết</a>
			</div>
		</c:if>
		<c:if test="${boxType != '5' && boxType != 'none'}">
			<div class="box_ttchidao_index">
				<h2 class="title_tab">
					<label>
						<c:forEach items="${listBoxType}" var="item">
							<c:if test="${item.key == boxType}">
								<a href="#"><liferay-ui:message key="portlet.NewsBoxTinhDo.type${item.key}" /></a>
							</c:if>
						</c:forEach>
					</label>
				</h2>
				<div class="clear"></div>
				<c:if test="${fn:length(listNews) gt 0}">
					<ul class="list">
						<c:forEach items="${listNews}" var="item">
							<li>
								<a href="${item.urlDetail}">${item.title}
									<span class="time">&#40;${item.createdDate}&#41;</span>
								</a>
							</li>
						</c:forEach>
					</ul>
				</c:if>
				<c:if test="${fn:length(listNews) eq 0}">
					<p class="updating_data"><liferay-ui:message key="portlet.common.data.updating" /></p>
				</c:if>
			</div>
		</c:if>
		<c:if test="${boxType == 'none'}">
			<h1>Need config</h1>
		</c:if>
	</div>
</div>