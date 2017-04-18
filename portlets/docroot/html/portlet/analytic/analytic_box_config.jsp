<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/html/common/init.jsp"%>

<form id="configForm" name="configFrm" 
	action="<liferay-portlet:actionURL portletConfiguration="true" />"
	method="post">
	<div class="box_analytic_config">
		<div class="analytic_config_title">
			<h2 class="title_tab">
				<span style="float: left;"><liferay-ui:message
						key="portlet.analytic.config.title" /></span>
			</h2>
		</div>
		<div class="analytic_option">
			<input type="radio" name="displayMode" onchange="checkOneAnalytic()"
			<c:if test="${displayMode == 'config_one'}">checked="checked"</c:if>
				id="config_one" value="config_one" /> <label for="config_one"><liferay-ui:message
					key="portlet.analytic.config.display.by.one" /></label>
		</div>
			<div class="analytic_option">
				<input type="radio" name="displayMode" onchange="multiAnalytic()"
					<c:if test="${displayMode == 'config_two'}">checked="checked"</c:if>
					id="config_two" value="config_two" onchange="" /> <label for="config_two">
					<liferay-ui:message key="portlet.analytic.config.display.by.two" />
				</label>
			</div>
			<div id="box_adm_config_analytic" class="box_adm_config_analytic" style="margin-left: 9px;">
				<c:forEach items="${analyticViewModes}" var="item">
					<div class="box_analytic_config_multi">
						<!-- display chechkbox:checked -->
						<c:if test="${multi.contains(item.id)}">
							<input id="chkAnalytic_${item.id}" class="analytic_checkbox" type="checkbox" name="analyticMulti" 
								<c:if test="${displayMode == 'config_one'}">disabled="disabled"</c:if> 
								value="${item.id}" checked="checked">${item.solieu}${item.content}
						</c:if>
						<!-- display unchechkbox:checked with chechkbox:checked-->
						<c:if test="${!multi.contains(item.id)}">
							<input id="chkAnalytic_${item.id}" class="analytic_checkbox" type="checkbox" name="analyticMulti" 
								<c:if test="${displayMode == 'config_one'}">disabled="disabled"</c:if> value="${item.id}">${item.solieu}${item.content}
						</c:if>
					</div>
				</c:forEach>
			</div>
		<br/>
		<input type="hidden" id="msg" value="<liferay-ui:message key="portlet.analytic.alert.message"/>" name="message"/>
		<input type="button" id="saveButton" onclick="checkSelectedCheckbox()" value="<liferay-ui:message key="portlet.analytic.config.submit"/>">
	</div>
</form>





