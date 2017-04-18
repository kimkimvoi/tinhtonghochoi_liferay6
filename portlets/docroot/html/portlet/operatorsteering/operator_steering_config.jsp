<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@include file="/html/common/init.jsp" %>
<portlet:defineObjects />


<div>
	<form id="<portlet:namespace />configForm" action="<liferay-portlet:actionURL portletConfiguration="true" />" method="post">
		<div class="schedule_config">
			<div class="schedule_config_title"><liferay-ui:message key="portlet.operator_steering.config.struture.header.title"/>:</div>
			<div>
				<select name="structureId" id="structureId">
					<c:forEach items="${operatorSteeringStructures}" var="item">
						<c:if test="${structureIdChoose == item.id}">
							<option value="${item.id }" selected="selected"><liferay-ui:message key="${item.keyNameDisplay }" /></option>
						</c:if>
						<c:if test="${structureIdChoose != item.id}">
							<option value="${item.id }"><liferay-ui:message key="${item.keyNameDisplay }" /></option>
						</c:if>
					</c:forEach>
				</select>
			</div>
			<input type="submit" id="saveButton" class="saveButtonViewMode" title="Save" value="<liferay-ui:message key="common.button.save"/>">
		</div>
	</form>
</div>