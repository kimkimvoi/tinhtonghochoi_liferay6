<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@include file="/html/common/init.jsp" %>

<portlet:defineObjects />

<script type="text/javascript">
	AUI().use('gallery-yquery', function(A) {
		var jq = A.YQuery();
		jq.use(function() {
			$(document).ready(function() {
				$("#config_video_save").click(function(){
					var check_box_choose = $(".video_checkbox:checked");
					var length = check_box_choose.length;
					if(length == 0){
						var alert_content = $("#no_choose_video_alert").val();
						alert(alert_content);
					}else{
						$("#config_video_form").submit();
					}
				});
			});
		});
	});
</script>

<form id="config_video_form" action="<liferay-portlet:actionURL portletConfiguration="true" />" method="post">
    <div id="videoConfig" class="video_Config_list">
		<c:forEach items="${videoList}" var="item" varStatus="status">
			<div class="config_video">
				<c:if test="${videoIdChoosed.contains(item.fileId)}">
					<input id="video_checkbox_id_${item.fileId}" type="checkbox" class="video_checkbox" name="video_checkbox" value="${item.fileId}" checked="checked">
				</c:if>
				<c:if test="${!videoIdChoosed.contains(item.fileId)}">
					<input id="video_checkbox_id_${item.fileId}" type="checkbox" class="video_checkbox" name="video_checkbox" value="${item.fileId}">
				</c:if>
				<label for="video_checkbox_id_${item.fileId}">
					<div class="video_content">
						<img src="${item.imageThums}">
						<div class="box_video"></div>
						<h3 class="title_video">
							${item.title}
						</h3>
					</div>
				</label>
			</div>
		</c:forEach>
	</div>
	<div class="clear"></div>
	<input id="config_video_save" type="button" value="<liferay-ui:message key="portlet.video_player.config.save" />" /> 
</form>
<input type="hidden" value="<liferay-ui:message key="portlet.video_player.config.no_choose"/>" id="no_choose_video_alert"/>