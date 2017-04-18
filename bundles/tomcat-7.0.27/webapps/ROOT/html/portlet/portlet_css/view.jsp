<%--
/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ include file="/html/portlet/portlet_css/init.jsp" %>

<%
PortletURL portletURL = renderResponse.createRenderURL();
%>

<div id="lfr-look-and-feel">
	<div class="aui-tabview" id="portlet-set-properties">
		<liferay-ui:tabs names="portlet-configuration" url="<%= portletURL.toString() %>" />

		<aui:form method="post">
			<input id="portlet-area" name="portlet-area" type="hidden" />
			<input id="portlet-boundary-id" name="portlet-boundary-id" type="hidden" />

			<div class="aui-tabview-content">
				<aui:fieldset id="portlet-config">
					<span class="aui-field-row">
						<aui:input inlineField="<%= true %>" label="portlet-title" name="custom-title" />

						<aui:select inlineField="<%= true %>" label="portlet-title" name="lfr-portlet-language">

							<%
							Locale[] locales = LanguageUtil.getAvailableLocales();

							for (int i = 0; i < locales.length; i++) {
							%>

								<aui:option label="<%= locales[i].getDisplayName(locale) %>" value="<%= LocaleUtil.toLanguageId(locales[i]) %>" />

							<%
							}
							%>

						</aui:select>
					</span>

					<aui:input name="use-custom-title" type="checkbox" />

					<aui:select label="link-portlet-urls-to-page" name="lfr-point-links">
						<aui:option label="current-page" />

						<%
						String linkToLayoutUuid = StringPool.BLANK;

						LayoutLister layoutLister = new LayoutLister();

						Group group = layout.getGroup();

						LayoutView layoutView = layoutLister.getLayoutView(layout.getGroup().getGroupId(), layout.isPrivateLayout(), group.getName(), locale);

						List layoutList = layoutView.getList();

						for (int i = 0; i < layoutList.size(); i++) {

							// id | parentId | ls | obj id | name | img | depth

							String layoutDesc = (String)layoutList.get(i);

							String[] nodeValues = StringUtil.split(layoutDesc, '|');

							long objId = GetterUtil.getLong(nodeValues[3]);
							String name = nodeValues[4];

							int depth = 0;

							if (i != 0) {
								depth = GetterUtil.getInteger(nodeValues[6]);
							}

							for (int j = 0; j < depth; j++) {
								name = "-&nbsp;" + name;
							}

							Layout linkableLayout = null;

							try {
								if (objId > 0) {
									linkableLayout = LayoutLocalServiceUtil.getLayout(objId);
								}
							}
							catch (Exception e) {
							}

							if (linkableLayout != null) {
						%>

								<aui:option label="<%= name %>" selected="<%= linkableLayout.getUuid().equals(linkToLayoutUuid) %>" value="<%= linkableLayout.getUuid() %>" />

						<%
							}
						}
						%>

					</aui:select>

					<aui:select label="show-borders" name="show-borders" showEmptyOption="<%= true %>">
						<aui:option label="yes" value="true" />
						<aui:option label="no" value="false" />
					</aui:select>

					<span class="form-hint portlet-msg-info aui-helper-hidden" id="border-note">
						<liferay-ui:message key="this-change-will-only-be-shown-after-you-refresh-the-page" />
					</span>
				</aui:fieldset>

				<aui:button-row>
					<aui:button name="lfr-lookfeel-save" value="save" />

					<aui:button name="lfr-lookfeel-reset" value="reset" />
				</aui:button-row>
			</div>
		</aui:form>
	</div>
</div>