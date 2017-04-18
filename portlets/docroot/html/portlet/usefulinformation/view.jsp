<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@include file="/html/common/init.jsp" %>
<portlet:defineObjects />

<div class="useful_info_porlet">
	<div class="useful_info_wapper">
		<h2 class="title_tab">
			<span><liferay-ui:message key="useful-information"></liferay-ui:message></span>
		</h2>
		<div class="clear"></div>
		<div class = "useful_content_box">
		    <ul class="userful_info_box_tienich" style="margin-top: 0px;">
		    	<li>
		        	<span class="userful_info_icon_thoitiet"></span>
		        	<a href="./thoi-tiet"><liferay-ui:message key="portlet.userfull_info.weather"></liferay-ui:message></a>
		        </li>
		        <li>
		        	<span class="userful_info_icon_tigia"></span>
		            <a href="./ty-gia"><liferay-ui:message key="portlet.userfull_info.foreignexchange"></liferay-ui:message></a>
		        </li>
		        <li>
		        	<span class="userful_info_icon_giaca"></span>
		            <a href="./thong-tin-thi-truong"><liferay-ui:message key="portlet.userfull.info.market"></liferay-ui:message></a> 
		        </li>
		        <li>
		        	<span class="userful_info_icon_tell"></span>
		            <a href="./danh-ba-tra-cuu"><liferay-ui:message key="portlet.userfull_info.userfulphone"></liferay-ui:message></a>
		        </li>
		    </ul>
		</div>
	</div>
</div>