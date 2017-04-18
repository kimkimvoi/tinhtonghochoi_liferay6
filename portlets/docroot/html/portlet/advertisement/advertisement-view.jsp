<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib prefix="cus" uri="/WEB-INF/tld/custom-tags.tld"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/html/common/init.jsp"%>
<portlet:defineObjects />
<script type="text/javascript">

	$(document).ready(function() {
		if(${adv.pictures.size() } > 1) {
			$('#${adv.portletId }').slidesjs({
				width : ${adv.imageWidth },
				height : ${adv.imageHeigh },
				navigation : false,
				pagination: {
			      active: false,
			      effect: "slide"
				},
				play : {
					auto : true,
					interval : 1000 * ${adv.durationTime },
					swap : true
				}
			});
		}
	});
	
</script>
<div class="advertisement_box">
	<div id="${adv.portletId }" style="width:${adv.imageWidth }px;height:${adv.imageHeigh }px">
		<c:forEach items="${adv.pictures }" var="item" varStatus="s">
			<div class="photo_adv">
				<div>
					<a href="${item.link}" target="_blank"><img width="${adv.imageWidth }px" height="${adv.imageHeigh }px" src="${item.url}" alt="${item.title}"></a>
				</div>
			</div>
		</c:forEach>
	</div>
</div>
