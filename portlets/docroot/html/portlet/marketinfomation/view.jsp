<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@include file="/html/common/init.jsp" %>
<%@ taglib prefix="cus" uri="/WEB-INF/tld/custom-tags.tld" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<portlet:defineObjects />
<portlet:resourceURL id="getDetailMarketInfoUrl" var="detailInfoUrl"></portlet:resourceURL>

<div class="useful_info_market_porlet">
	<div class="useful_info_market_content-padding">
		<h2 class="title_tab">
				<span><liferay-ui:message key="portlet.useful-information-market"></liferay-ui:message></span>
		</h2>

		<div id="market_info_body_content">
			<div class="content" id="listMaketInfoContent">
				<ul class="list_new">
					<c:forEach items="${lstMarketInfos}" var="news" varStatus="indexNews">
						<li>
							<div class="text">
								<div class="title_v">
									<a href="${news.detailUrl}">
										${news.title}
									</a>
								</div>
								<div class="content_small"> ${news.summary} </div>
							</div>
						</li>
					</c:forEach>
				</ul>
			</div>

			<cus:paginator curPageStatusText="${curPageStatusText}" itemsPerPageText="${itemsPerPageText}" numOfPage="${numOfPage}" numPerPage="${numPerPage}" tableId="listMaketInfoContent" />
			<portlet:resourceURL escapeXml="false" id="listMaketInfoContent_LoadPage" var="listMaketInfoContent_LoadPage" />
			<input id="listMaketInfoContent_loadPageURL" type="hidden" value="<%=renderResponse.encodeURL(listMaketInfoContent_LoadPage.toString()) %>" />
			<input id="listMaketInfoContent_headerList" type="hidden" value="${headerList}" />
			<input id="listMaketInfoContent_displayedPropertyList" type="hidden" value="${displayedPropertyList}" />
			<input id="listMaketInfoContent_hiddenPropertyList" type="hidden"  value="${hiddenPropertyList}" />
			<input id="listMaketInfoContent_headerClass" type="hidden" value="title" />

		</div>
		<input id="resouceMarketUrl" type="hidden" value="${detailInfoUrl}" />
		<div hidden="true" id="market_info_detail_content">
		</div>
	</div>
</div>