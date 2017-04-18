<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib prefix="cus" uri="/WEB-INF/tld/custom-tags.tld"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/html/common/init.jsp"%>
<%@include file="/html/common/init_config.jsp"%>
<script id="" type="text/javascript" src="${contextPath}/public-theme/js/jquery-ui.js"></script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">
  <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
  
<portlet:defineObjects />
<script type="text/javascript">
$(document).ready( function() {
	$(function() {
	    $( "#time_slider" ).slider({
	    	min:1,
	    	max:60,
	    	step:1,
	    	value:$('#_time_slide').val(),
	    	slide: function( event, ui ) {
	    		changeDisplayTimeDurationSlide(ui.value);
	    	}
	    });
	  });
	
	$(function() {
	    $( "#image_width_slider" ).slider({
	    	min:100,
	    	max:1004,
	    	step:1,
	    	value:$('#_image_width').val(),
	    	slide: function( event, ui ) {
	    		changeDisplayImageWidthSlide(ui.value);
	    	}
	    });
	  });
	
	$(function() {
	    $( "#image_heigh_slider" ).slider({
	    	min:50,
	    	max:600,
	    	step:1,
	    	value:$('#_image_heigh').val(),
	    	slide: function( event, ui ) {
	    		changeDisplayImageHeighSlide(ui.value);
	    	}
	    });
	  });
	updateDisplayOptions('${adv.displayType}');
});

function changeDisplayTimeDurationSlide(value) {
	$('#_time_slide').attr('value',value);
}
function changeDisplayImageWidthSlide(value) {
	$('#_image_width').attr('value',value);
}
function changeDisplayImageHeighSlide(value) {
	$('#_image_heigh').attr('value',value);
}
function updateDisplayOptions(val) {
	if(val == '<%= CommonConstants.ADVERTISEMENT_DISPLAY_TYPE_BANNER%>') {
		$('.display_type_banner').show();
		$('.display_type_default').show();
	} else if (val == '<%= CommonConstants.ADVERTISEMENT_DISPLAY_TYPE_LOGO%>') {
		$('.display_type_banner').hide();
		$('.display_type_default').hide();
	} else {
		$('.display_type_banner').hide();
		$('.display_type_default').show();
	}
	
}
</script>
<c:set var="displayTypes" value="<%=CommonConstants.ADVERTISEMENT_DISPLAY_TYPES %>" />
<c:set var="ADVERTISEMENT_DISPLAY_TYPE_LOGO" value="<%=CommonConstants.ADVERTISEMENT_DISPLAY_TYPE_LOGO %>" />

<div>
	<liferay-ui:success key="success" message="Configuration saved successfully!" />
	<form id="<portlet:namespace />configForm" action="<liferay-portlet:actionURL portletConfiguration="true" />" method="post">
		<aui:select name="displayType" label="portlet.news.config.display-type" inlineLabel="true" onChange="updateDisplayOptions(this.value)">
			<c:forEach items="${displayTypes}" var="val">
				<aui:option value="${val}" selected="${adv.displayType == val }">
					<liferay-ui:message key="${val}" />
				</aui:option>
			</c:forEach>
		</aui:select>
		<br>
		<div class="display_type_banner">
			<span class="title_sl"><label>Tiêu đề phía dưới banner : </label><input type="text" name="title" width="300px;" style="width: 390px;" value="${adv.title}"/></span>
		</div>
		<div class="display_type_default">
			<div class="time_slide">
				<label>Tự động thay đổi ảnh sau: </label>
				<input type="text" readonly="readonly" id="_time_slide" name="_time_slide" value="${adv.durationTime }" class="slide_input" /> giây. <i>(Kéo để thay đổi thời gian)</i>
				<div id="time_slider"></div>
			</div>
			<div class="time_slide">
				<label>Độ rộng ảnh: </label>
				<input type="text" readonly="readonly" id="_image_width" name="_image_width" value="${adv.imageWidth }" class="slide_input" />. <i>(Kéo để thay đổi độ rộng ảnh)</i>
				<div id="image_width_slider"></div>
			</div>
			<div class="time_slide">
				<label>Độ cao ảnh: </label>
				<input type="text" readonly="readonly" id="_image_heigh" name="_image_heigh" value="${adv.imageHeigh }" class="slide_input" />. <i>(Kéo để thay đổi độ cao ảnh)</i>
				<div id="image_heigh_slider"></div>
			</div>
		</div>
		<hr>
		<div class="box_calender_work">
			<ul class="list_photo">
				<c:forEach items="${adv.pictures }" var="item" varStatus="s">
					<li>
						<div class="photo">
							<div>
								<img src="${item.url}">
							</div>
							<input class="checkbox" <c:if test="${item.display}">checked="checked"</c:if> type="checkbox" name="${item.fileId}" value="${item.fileId}" id="${item.fileId}" />
						</div>
						<p>${item.title}</p>
					</li>
				</c:forEach>
			</ul>
		</div>
		<input type="submit" id="saveButton" title="Save" value="<liferay-ui:message key="common.button.save"/>">
	</form>
</div>
