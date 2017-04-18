<%@page contentType="text/html;charset=UTF-8"%>
<%@include file="/html/common/init.jsp"%>
<%@include file="/html/portlet/hot_news/hot-news-init.jsp" %>
<script type="text/javascript">
$(function() {
	$("#tabs").tabs({ selected: 0 });
	});
</script>
<div class="box_new_more">
	<h2 class="title_tab">
			<label><liferay-ui:message key="portlet.hotnews.title"></liferay-ui:message></label>
	</h2>
	<div class="hot-news-container">
		<div class="pin-news-container">
			<div class="pin-news">
				<div class="news-item">
					<c:if test="${ not empty pinNews}">
						<a href="${pinNews.urlDetail}"><img class="img" src="${pinNews.imageURL}" /></a>
						<div class="boxtext">
				         	<h2 class="h2">
				             	<a href="${pinNews.urlDetail}">
					             	<p>${pinNews.title}
					             		<span class="created-date">&#40;${pinNews.createdDate}&#44; Lượt xem ${pinNews.viewCount}&#41;</span>
					             		<c:if test="${pinNews.isNew()}">
											<img class="news-icon" src="${pageContext.request.contextPath}/html/images/icons/icon_new_2.gif" />
										</c:if>
					             	</p>
				             	</a>
				             </h2>
				            <div class="text">
				            	${pinNews.summary}
				            </div>
			           </div>
		           </c:if>
				</div>
			</div>
			<div class="tab-news-container">
				<div id="tabs">
					<ul class="latest-news">
					<li><a href="#tabs-1">Mới nhất</a></li>
					<li><a href="#tabs-2">Xem nhiều</a></li>
					</ul>
					<div id="tabs-1">
						<ul>
							<jsp:useBean id="now" class="java.util.Date"/>
							<jsp:useBean id="createdDate" class="java.util.Date"></jsp:useBean>
							<c:forEach items="${latestNews}" var="news" varStatus="status">
							<li>
								<a href="${news.urlDetail}">
									<p>${news.title}
									<span class="created-date">&#40;${news.createdDate}&#44; Lượt xem ${news.viewCount}&#41;</span>
									<c:if test="${news.isNew()}">
										<img src="${pageContext.request.contextPath}/html/images/icons/icon_new_2.gif" />
									</c:if>
									</p>
								</a>
							</li>
							</c:forEach>
						</ul>
					</div>
					<div id="tabs-2">
						<ul>
							<c:forEach items="${mostViewNews}" var="news" varStatus="status">
							<li>
								<a href="${news.urlDetail}"><p>${news.title}<span class="created-date">&#40;${news.createdDate}&#44; Lượt xem ${news.viewCount}&#41;</span>
									<c:if test="${news.isNew()}">
										<img src="${pageContext.request.contextPath}/html/images/icons/icon_new_2.gif" />
									</c:if>
								</p></a>
							</li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
			<div class="sub-pin-news">
				<c:if test="${ not empty listPinNews}">
					<ul>
						<c:forEach items="${listPinNews}" var="news" varStatus="status">
						<li>
							<span><img class="img-sub-list autotop" src="${news.imageURL}" title="${news.summary}" /></span>
							<a href="${news.urlDetail}"><p>${news.title}
								<c:if test="${news.isNew()}">
									<img src="${pageContext.request.contextPath}/html/images/icons/icon_new_2.gif" />
								</c:if>
							</p></a>
						</li>
						</c:forEach>
					</ul>
				</c:if>
			</div>
		</div>
	</div>
</div>
<div class="clear"></div>
<script type="text/javascript">
$( document ).ready(function() {
	$('.top').tooltip({align: 'top'});
	$('.right').tooltip({align: 'right'});
	$('.bottom').tooltip({align: 'bottom'});
	$('.left').tooltip({align: 'left'});
	$('.autotop').tooltip({align: 'autoTop'});
	$('.autoleft').tooltip({align: 'autoLeft'});
});

</script>
