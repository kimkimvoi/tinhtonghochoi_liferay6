<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib prefix="cus" uri="/WEB-INF/tld/custom-tags.tld"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/html/common/init.jsp"%>
<portlet:defineObjects />
<link rel="stylesheet" href="${pageContext.request.contextPath}/html/portlet/advertisement/themes/default/default.css" type="text/css" media="screen" />
<c:set var="advertisement_display_type_banner" value="<%= CommonConstants.ADVERTISEMENT_DISPLAY_TYPE_BANNER %>" />
<c:set var="advertisement_display_type_logo" value="<%= CommonConstants.ADVERTISEMENT_DISPLAY_TYPE_LOGO %>" />
<c:if test="${adv.displayType != advertisement_display_type_logo}">
	<script type="text/javascript">
		$(document).ready(function() {
			if(${adv.pictures.size() } > 1) {
				if(${adv.displayType == advertisement_display_type_banner}) {
						$('#${adv.portletId }').nivoSlider({
							effect:"random",
					        slices:15,
					        boxCols:8,
					        boxRows:4,
					        animSpeed:500,
					        pauseTime:3000,
					        startSlide:0,
					        directionNav:true,
					        controlNav:false,
					        controlNavThumbs:false,
					        pauseOnHover:true,
					        manualAdvance:false
					    });
					
				} else {
					$('#${adv.portletId }').slidesjs({
						width : ${adv.imageWidth },
						height : ${adv.imageHeigh },
						navigation : {
							active: false,
							effect: "slide"
						},
						pagination: {
					      active: ${adv.displayType == advertisement_display_type_banner},
					      effect: "slide"
						},
						play : {
							auto : true,
							interval : 1000 * ${adv.durationTime },
							swap : true
						}
					});
				}
			}
		});
		
	</script>
	<div class="advertisement_box <c:if test="${adv.displayType == advertisement_display_type_banner}">slider-wrapper theme-default</c:if>">
		<div id="${adv.portletId }" class="nivoSlider" style="width:${adv.imageWidth }px;height:${adv.imageHeigh }px">
				<c:if test="${adv.displayType != advertisement_display_type_banner}">
				 	<c:forEach items="${adv.pictures }" var="item" varStatus="s">
						<div class="photo_adv">
							<div>
								<a href="${item.link}" target="_blank"><img width="${adv.imageWidth }px" height="${adv.imageHeigh }px" src="${item.url}" alt="${item.title}"></a>
							</div>
						
						
						</div>
					</c:forEach>
				</c:if>
				<c:if test="${adv.displayType == advertisement_display_type_banner}">
					<c:forEach items="${adv.pictures }" var="item" varStatus="s">
								<img width="${adv.imageWidth }px" height="${adv.imageHeigh }px" src="${item.url}" alt="${item.title}"/>
					</c:forEach>
				</c:if>
		</div>
	</div>
</c:if>
<c:if test="${adv.displayType == advertisement_display_type_logo}">
<script type="text/javascript">
$( document ).ready(function() {
	$(".carousel_logo").jCarouselLite({
		auto: 10000,
	    speed: 1000,
	    scroll: 1,
	    visible:${adv.pictures.size()},
	    btnNext: ".navNext",
	    btnPrev: ".navPrev",
	    mouseWheel: true
	});
});
</script>
<div id="slide_news_hot" class="carousel_logo">
	<a class="navPrev"></a>
	<a class="navNext"></a>
		<ul>
		<c:forEach items="${adv.pictures}" var="item" varStatus="status">
				<li class="photo">
					<div class="classphoto2">
						<a href="${item.link}" target="_blank"><img class="img_transfer_logo" src="${item.url}" alt="${item.title}"></a>
					</div>
				</li>
		</c:forEach>
		</ul>
</div>
</c:if>