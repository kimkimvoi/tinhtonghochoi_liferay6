<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib prefix="cus" uri="/WEB-INF/tld/custom-tags.tld"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/html/common/init.jsp"%>
<portlet:defineObjects />
<div id="right-categories">
	<div class="box-commons">
		<h2 class="title_tab">
			<span><liferay-ui:message key="portlet.rightcategories.title"/></span>
		</h2>
		<div class="box-content">
			<ul class="list_danhmuc">
				<li class="icon_lich_lv"><a href="./lich-lam-viec"><liferay-ui:message key="portlet.rightcategories.workschedule"/></a></li>
				<li class="icon_congbaotinh"><a href="./cong-bao-tinh"><liferay-ui:message key="portlet.rightcategories.provincialofficialgazette"/></a></li>
				<li class="icon_vanbanphatquy"><a href="./van-ban-phap-quy"><liferay-ui:message key="portlet.rightcategories.regulatorydocuments"/></a></li>
				<li class="icon_danhbadientu"><a href="./danh-ba-dien-tu"><liferay-ui:message key="portlet.rightcategories.electronicphonebook"/></a></li>
				<li class="icon_thutuchanhchinh"><a href="./thu-tuc-hanh-chinh"><liferay-ui:message key="portlet.rightcategories.administrativeprocedures"/></a></li>
				<li class="icon_dichvucong"><a href="./dich-vu-cong-muc-do-3"><liferay-ui:message key="portlet.rightcategories.publicserviceslevel3"/></a></li>
			</ul>
		</div>
	</div>
</div>
