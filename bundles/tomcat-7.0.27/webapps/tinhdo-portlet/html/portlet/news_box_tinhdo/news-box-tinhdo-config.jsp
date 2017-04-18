<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib prefix="cus" uri="/WEB-INF/tld/custom-tags.tld"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/html/common/init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<portlet:defineObjects />
<liferay-ui:success key="success" message="common.msg.success" />
<liferay-ui:success key="error" message="common.msg.error" />
<liferay-portlet:actionURL portletConfiguration="true" var="configWriteAbouttinhdo"/>
<div>
<aui:form action="${configWriteAbouttinhdo}" name="frmConfigWriteAbouttinhdo" method="POST">
	<ul>
		<li>
			<div class="rowa">
				<label><liferay-ui:message
						key="portlet.writingabouttinhdo.config.boxtype" />: </label>
				<aui:select cssClass="full_width" id="listTypeBox" name="typeBox" label=""  >
				<aui:option value=""><liferay-ui:message key="portlet.common.form.dropdownlist.firstoption" /></aui:option>
          		<c:forEach items="${listBoxType}" var="item">
          			<c:if test="${currentType == item.key}">
	              		<aui:option value="${item.key}" selected="true" label="${item.value}"/>
              		</c:if>
          			<c:if test="${currentType != item.key}">
	              		<aui:option value="${item.key}" label="${item.value}"/>
	              	</c:if>
              	</c:forEach>
      		</aui:select>
			</div>
			<div class="rowa">
				<label id="recordPerPage"><liferay-ui:message
						key="portlet.common.record.display" />:</label>
				<aui:input name="recordPerPage" label="" type="text" value="${currentPageDisplay}" />
			</div>
			<div class="rowb">
				<input name="submitConfig" type="submit" value="<liferay-ui:message key="common.button.save"/>" />
			</div>
		</li>
	</ul>
</aui:form>
</div>
