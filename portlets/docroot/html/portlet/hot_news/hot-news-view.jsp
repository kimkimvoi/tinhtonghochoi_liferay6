<%@page contentType="text/html;charset=UTF-8"%>
<%@include file="/html/common/init.jsp"%>
<%@include file="/html/portlet/hot_news/hot-news-init.jsp" %>
<% 
List<News> lstNews = (List<News>) request.getAttribute("lstNews"); 
if ((null != lstNews) && (0 < lstNews.size())) { 
%>

<div class="box_new_more">
	<div class="news">
		<a href="${lstNews[0].urlDetail}"> <img class="img" src="${lstNews[0].imageURL}" /></a>
		<div class="boxtext">
         	<h2 class="title">
             	<a href="${lstNews[0].urlDetail}">${lstNews[0].title} </a>
             </h2>
            <div class="text">
            	${lstNews[0].summary}
            </div>
          </div>
	</div>
	<div id="slide_news_hot" class="carousel">
	<a class="navPrev"></a>
	<a class="navNext"></a>
		<ul>
		<c:forEach items="${lstNews}" var="news" varStatus="status">
			<c:if test="${status.index > 0}">
				<li class="photo">
					<div class="classphoto">
					   <a href="${news.urlDetail}"> <img class="autotop" src="${news.imageURL}" title="${news.summary}"/></a>
					   <h3>
							<a href="${news.urlDetail}" >${news.title} </a>
					   </h3>
					</div>
				</li>
			</c:if>
		</c:forEach>
		</ul>
	</div>
</div>
<div class="clear"></div>

<% } else {%>
	<div class="no_news_input">
		<liferay-ui:message key="portlet.hot.news.no-news-input"></liferay-ui:message>
	</div>
<% } %>

<script type="text/javascript">
$( document ).ready(function() {
	$(".carousel").jCarouselLite({
		auto: 10000,
	    speed: 1000,
	    scroll: 1,
	    visible:5,
	    btnNext: ".navNext",
	    btnPrev: ".navPrev",
	    mouseWheel: true
	});

	$('.top').tooltip({align: 'top'});
	$('.right').tooltip({align: 'right'});
	$('.bottom').tooltip({align: 'bottom'});
	$('.left').tooltip({align: 'left'});
	$('.autotop').tooltip({align: 'autoTop'});
	$('.autoleft').tooltip({align: 'autoLeft'});
});

</script>