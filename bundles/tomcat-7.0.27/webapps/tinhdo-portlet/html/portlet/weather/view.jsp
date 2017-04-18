<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@include file="/html/common/init.jsp" %>
<portlet:defineObjects />
<div id='weatherBodyContentId' class ="weather_portlet">
	<div class="weather_portlet_wapper">
		<h2 class="title_tab">
			<span><liferay-ui:message key="portlet.userfull_phone.weather-title"></liferay-ui:message></span>
		</h2>
		<div class="clear"></div>
		<h3 class="weather_porlet_title-h3">
			<liferay-ui:message key="portlet.userfull_phone.weather-title"></liferay-ui:message>
		</h3>
		<div id="weather_content_detail" class="weather_content_detail_css">
			<table cellspacing="0" cellpadding="0" border="0" align="center" style="width: 100%">
				<tr>
					<td class="style5" valign="middle" align="center" style="padding-left: 5px;width: 50%;">
						<img id="img_icon_weather_stt" alt="" src="${pageContext.request.contextPath}/html/portlet/weather/images/28.gif"/>
					</td>
					<td style="width: 50%;" align="center">
						<div id="weather_current_temperature" class="div-current-tem"></div>
						<div id="weather_min_max_temperature" class="div-minmax-temp"></div>
						<div id="weather_curent_weather" class="div-current-weather"></div>
					</td>
				</tr>
				<tr>
					<td align="center" colspan="2" style="padding-top: 15px;">
						<table width="100%" cellspacing="0" cellpadding="1" border="0">
							<tr height="30px">
								<td class="weather_style2">
								 	<liferay-ui:message key="portlet.userfull_phone.weather-wind-deg"></liferay-ui:message>
								</td>
								<td class="weather_style2"> 
									<div id="weather_curent_wind_deg"></div>
								</td>
							</tr>
							<tr height="30px">
								<td class="weather_style2">
									<liferay-ui:message key="portlet.userfull_phone.weather-wind-speed"></liferay-ui:message>
								</td>
								<td class="weather_style2" > 
									<div id="weather_curent_wind_speed"></div>
								</td>
							</tr>
							<tr height="30px">
								<td class="weather_style2">
									<liferay-ui:message key="portlet.userfull_phone.weather-humidity"></liferay-ui:message>
								</td>
								<td class="weather_style2" > 
									<div id="weather_curent_humidity"></div>
								</td>
							</tr>
							<tr height="30px">
								<td class="weather_style2">
									<liferay-ui:message key="portlet.userfull_phone.weather-pressure"></liferay-ui:message>
								</td>
								<td class="weather_style2" > 
									<div id="weather_curent_pressure"></div>
								</td>
							</tr>
							<tr height="30px">
								<td class="weather_style2">
									<liferay-ui:message key="portlet.userfull_phone.weather-sunrise"></liferay-ui:message>
								</td>
								<td class="weather_style2" > 
									<div id="weather_curent_sunrise">6:14 am</div>
								</td>
							</tr>
							<tr height="30px">
								<td class="weather_style2">
									<liferay-ui:message key="portlet.userfull_phone.weather-sunset"></liferay-ui:message>
								</td>
								<td class="weather_style2" > 
									<div id="weather_curent_sunrise">5:13 pm </div>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</div>
		<div id = weather_porlet_getdata_error>
			<liferay-ui:message key="portlet.foreignexchange-loaderror"/>
		</div>
	</div>
</div>
<script type="text/javascript">
	var dongbac = '<liferay-ui:message key="portlet.userfull_phone.weather-sunset"></liferay-ui:message>';
	
</script>