<%@page contentType="text/html;charset=UTF-8"%>
<%@include file="/html/common/init.jsp"%>
<%@include
	file="/html/portlet/culture-and-traveler/culture-and-traveler-init.jsp"%>

<c:if test="${!isHotNews}">
	<div class="box-content_dukhach margin">
		<h2 class="title_tab">
			<label><a href="${portletTitle}"><liferay-ui:message
						key="${portletTitle}"></liferay-ui:message> </a></label>
		</h2>
		<div class="clear"></div>
		<c:forEach items="${listNews}" var="news" varStatus="status">
			<c:if test="${status.index < quantityItemForSlide}">
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
			</c:if>
		</c:forEach>
		<div class="clear"></div>
		<a class="link_more" href="${portletTitle}">
			<liferay-ui:message key="view-all"></liferay-ui:message>
		</a>
	</div>
</c:if>
<c:if test="${isHotNews}">
	<div class="box_new_more">
		<c:forEach items="${listNews}" var="news" varStatus="status">
			<c:if test="${status.index == 0}">
				<div class="news">
					<h2 class="title_tab">
						<label><a href="${portletTitle}"><liferay-ui:message key="${portletTitle}"></liferay-ui:message></a></label>
					</h2>
					<div class="content_news">
						<a href="${news.urlDetail}">
							<img class="img" src="${news.imageURL}" />
						</a>
						<div class="boxtext">
							<h2 class="title">
								<a href="${news.urlDetail}">${news.title}</a>
							</h2>
							<div class="text">${news.summary}</div>
						</div>
					</div>
				</div>
			</c:if>
		</c:forEach>
			<div id="slide_culture_hot" class="carousel">
			<a class="navPrev"></a>
			<a class="navNext"></a>
				<ul>
				<c:forEach items="${listNews}" var="news" varStatus="status">
					<c:if test="${status.index <= quantityItemForSlide && status.index != 0}">
						<li class="photo">
							<div class="classphoto">
								<a href="${news.urlDetail}"> <img class="autotop" src="${news.imageURL}" title="${news.summary}"/></a>
								<h3>
									<a href="${news.urlDetail}">${news.title}</a>
								</h3>
							</div>
						</li>
					</c:if>
				</c:forEach>
				</ul>
			</div>
	</div>
</c:if>

