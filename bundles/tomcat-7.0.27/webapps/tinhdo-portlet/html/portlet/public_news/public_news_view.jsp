<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib prefix="cus" uri="/WEB-INF/tld/custom-tags.tld" %>
<%@include file="/html/common/init.jsp" %>

<portlet:defineObjects />
<portlet:actionURL var="searchPublicNewsAction" name="searchPublicNewsAction"></portlet:actionURL>
<portlet:resourceURL var="searchPublicNewsAjax" id="searchPublicNewsAjax"></portlet:resourceURL>
<portlet:resourceURL var="getDetailsPublicNewsAjax" id="getDetailsPublicNewsAjax"></portlet:resourceURL>
<input type="hidden" id="getDetailsPublicNewsAjax_Url" value="${getDetailsPublicNewsAjax }"/>
<div class="public_news">
	<div class="box_bg">
		<h2 class="title_tab">
			<label><liferay-ui:message key="portlet.public_news.title" /></label>
		</h2>
		<div class="clear"></div>
		<%-- <form action="${searchPublicNewsAction}" method="post"> --%>
		<div class="box_congbao">
			<ul class="list_tracuu">
				<li>
					<label><liferay-ui:message key="portlet.public_news.search.year.label" /></label>
					<%-- <input type="hidden" value="${yearPublish }" id = "yearPublish-hidden">  --%>
					<select class="select" name="yearPublish" id="yearPublish">
						<option value="0"><liferay-ui:message key="portlet.public_news.search.all.title" /></option>
						<c:if test="${yearPublishList != null }">
							<c:forEach items="${yearPublishList }" var="yearPublish">
								<option value="${yearPublish}">${yearPublish}</option>
							</c:forEach>
						</c:if>
					</select>
				</li>
				<li>
					<label><liferay-ui:message key="portlet.public_news.search.number.label" /></label> 
					<%-- <input type="hidden" value="${numberPublicNews }" id="numberPublicNews-hidden">  --%>
					<select class="select" name="numberPublicNews" id="numberPublicNews">
						<option value="0"><liferay-ui:message key="portlet.public_news.search.all.title" /></option>
						<c:forEach begin="1" end="${maxNumber }" step="1" var="number">
							<option value="${maxNumber - number + 1}">${maxNumber - number + 1}</option>
						</c:forEach>
					</select>
				</li>
				<%-- <li>
					<label><liferay-ui:message key="portlet.public_news.search.content.label" /></label> 
					<input type="text" name="contentPublicNews" class="input" id="contentPublicNews" value="${contentPublicNews }"/>
				</li> --%>
				<li>
					<label><liferay-ui:message key="portlet.public_news.search.publisher.label" /></label> 
					<select class="select" name="publisher" id="publisher">
						<option value="0"><liferay-ui:message key="portlet.public_news.search.all.title" /></option>
						<c:if test="${publisherList != null }">
							<c:forEach items="${publisherList}" var="publisher">
								<option value="${publisher.key}">${publisher.value}</option>
							</c:forEach>
						</c:if>
					</select>
				</li>
				<li>
					<label><liferay-ui:message key="portlet.public_news.search.key.label" /></label> 
					<input type="text" name="keyPublicNews" maxlength="100" class="input" id="keyPublicNews" onkeypress="searchKeyPress(event);"/>
				</li>
				<li>
					<label><liferay-ui:message key="portlet.public_news.search.signer.label" /></label> 
					<input type="text" name="signer" class="input" maxlength="100" id="signer" onkeypress="searchKeyPress(event);"s/>
				</li>
				<li>
					<label><liferay-ui:message key="portlet.public_news.search.type.label" /></label>
					<select class="select" name="typePublicNews" id="typePublicNews">
						<option value="0"><liferay-ui:message key="portlet.public_news.search.all.title" /></option>
						<c:if test="${typePublicNewsList != null }">
							<c:forEach items="${typePublicNewsList}" var="typePublicNews">
								<option value="${typePublicNews.key}">${typePublicNews.value}</option>
							</c:forEach>
						</c:if>
					</select>
				</li>
				<li>
					<label><liferay-ui:message key="portlet.public_news.search.fields.label" /></label>
					<select class="select" name="fieldsPublicNews" id="fieldsPublicNews">
						<option value="0"><liferay-ui:message key="portlet.public_news.search.all.title" /></option>
						<c:if test="${fieldPublicNewsList != null }">
							<c:forEach items="${fieldPublicNewsList}" var="fieldsPublicNews">
								<option value="${fieldsPublicNews.key}">${fieldsPublicNews.value}</option>
							</c:forEach>
						</c:if>
					</select>
				</li>
				
				<li>
					<label><liferay-ui:message key="portlet.public_news.search.quote.label" /></label> 
					<input type="text" name="quote" class="input" maxlength="1000" id="quote" onkeypress="searchKeyPress(event);"/>
				</li>
				
				<li>
                	<input type="button" id="publicnews_button_search" onclick="searchPublicNewsAjax('${searchPublicNewsAjax}');" value="<liferay-ui:message key="portlet.public_news.search.button" />" class="buttons right">
                </li>
			</ul>
		</div>
		<!-- </form> -->
		<div class="clear"></div>
		<div class="list_result">
			<h2 class="title_tab">
				<label><liferay-ui:message key="portlet.public_news.result.title" /></label>
			</h2>
			<cus:table dataList="${publicNewsList }" displayedPropertyList="${displayedPropertyList }" headerClass="title" headers="${headersList }" id="resultSearchPublicNewsTable" hiddenPropertyList="${hiddenPropertyList}"/>
			<cus:paginator curPageStatusText="${curPageStatusText }" numOfPage="${numOfPage}" tableId="resultSearchPublicNewsTable" itemsPerPageText="${itemsPerPageText}" numPerPage="${numPerPage}"/>
			<portlet:resourceURL escapeXml="false" id="resultSearchPublicNewsTable_LoadPage" var="resultSearchPublicNewsTable_LoadPage">
			</portlet:resourceURL>
			<input id="resultSearchPublicNewsTable_loadPageURL" type="hidden" value="<%=renderResponse.encodeURL(resultSearchPublicNewsTable_LoadPage.toString()) %>" />
			<input id="resultSearchPublicNewsTable_headerList" type="hidden" value="${headersList}" />
			<input id="resultSearchPublicNewsTable_displayedPropertyList" type="hidden" value="${displayedPropertyList}" />
			<input id="resultSearchPublicNewsTable_hiddenPropertyList" type="hidden" value="${hiddenPropertyList}" />
			<input id="resultSearchPublicNewsTable_headerClass" type="hidden" value="title" />
			<input id="resultSearchPublicNewsTable_curPageId" type="hidden" value="1" />
		</div>
		
		<div class="clear"></div>
		<div class="public_new_details" id="public_new_details" style="display: none;">
			<h2 class="title_tab">
				<label><liferay-ui:message key="portlet.public_news.details.title" /></label><label id="details_title"></label>
			</h2>
			<table>
            	<tr>
                	<td width="35%"><strong><liferay-ui:message key="portlet.public_news.search.number.label"/></strong></td>
                    <td width="65%" id="details_number"></td>
                </tr>
                <tr>
                	<td><strong><liferay-ui:message key="portlet.public_news.search.publisher.label"/></strong></td>
                    <td id="details_publisher"></td>
                </tr>
                <tr>
                	<td><strong><liferay-ui:message key="portlet.public_news.search.key.label"/></strong></td>
                    <td id="details_key"></td>
                </tr> 
                <tr>
                	<td><strong><liferay-ui:message key="portlet.public_news.search.publisher_date.label"/></strong></td>
                    <td id="details_publisher_date"></td>
                </tr> 
                <tr>
                	<td><strong><liferay-ui:message key="portlet.public_news.search.effect_date.label"/></strong></td>
                    <td id="details_effect_date"></td>
                </tr>
                <tr>
                	<td><strong><liferay-ui:message key="portlet.public_news.search.signer.label"/></strong></td>
                    <td id="details_signer"></td>
                </tr>
                
                <tr>
                	<td><strong><liferay-ui:message key="portlet.public_news.search.type.label"/></strong></td>
                    <td id="details_type"></td>
                </tr> 
                <tr>
                	<td><strong><liferay-ui:message key="portlet.public_news.search.fields.label"/></strong></td>
                    <td id="details_fields"></td>
                </tr> 
                <tr>
                	<td><strong><liferay-ui:message key="portlet.public_news.search.quote.label"/></strong></td>
                    <td id="details_quote"></td>
                </tr>
                <tr>
                	<td><strong><liferay-ui:message key="portlet.public_news.search.attach_file.label"/></strong></td>
                    <td id="details_file_attach"></td>
                </tr> 
                                                     
           </table>
		</div>
	</div>
</div>
