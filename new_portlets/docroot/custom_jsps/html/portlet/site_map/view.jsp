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

<%@page import="com.liferay.portal.model.Layout"%>
<%@page import="java.util.List"%>
<%@ include file="/html/portlet/site_map/init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<style>
#sm_content {
	padding: 5px;
}
#sm_content .column {
	width: 20%;
	float: left;
}
#sm_content h2.st_h {
	border-bottom: 1px solid #CCCCCC;
    display: inline-block;
    width: 100%;
    margin-top: 10px;
}
#sm_content h2 a {
	font-size: 15px;
}
#sm_content li {
	list-style: none;
}
#sm_content .grid1col {
	padding: 10px;
}
#sm_content h3 {
	font-size: 1em;
}
#sm_content .column ul li a {
	color: #76797C;
}
#sm_content .column ul{
	margin-left: 5px;
}
#sm_content .column ul li a:hover {
	text-decoration: underline;
}
</style>
<%
List<Layout> rootLayouts = LayoutLocalServiceUtil.getLayouts(layout.getGroupId(), layout.isPrivateLayout(), rootLayoutId);

StringBundler sb = new StringBundler();

_buildSiteMap(layout, rootLayouts, rootLayout, includeRootInTree, displayDepth, showCurrentPage, useHtmlTitle, showHiddenPages, 1, themeDisplay, sb);
%>
<div id="sm_content">

<h2 class="title_tab">
	<label><liferay-ui:message key="porlet.sitemap.title" /></label>
</h2>
	<%= sb.toString() %>
</div>
<%!
private void _buildSiteMap(Layout layout, List<Layout> layouts, Layout rootLayout, boolean includeRootInTree, int displayDepth, boolean showCurrentPage, boolean useHtmlTitle, boolean showHiddenPages, int curDepth, ThemeDisplay themeDisplay, StringBundler sb) throws Exception {
	if (layouts.isEmpty()) {
		return;
	}
	PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();
	for (int i = 0; i < layouts.size(); i++) {
		Layout curLayout = layouts.get(i);

		//if ((showHiddenPages || !curLayout.isHidden()) && LayoutPermissionUtil.contains(permissionChecker, curLayout, ActionKeys.VIEW)) {
		//	String cssClass = StringPool.BLANK;

		//	if (curLayout.getPlid() == layout.getPlid()) {
		//		cssClass = "current";
		//	}

		//	sb.append("<li>");

		//	_buildLayoutView(curLayout, cssClass, useHtmlTitle, themeDisplay, sb);

		//	if ((displayDepth == 0) || (displayDepth > curDepth)) {
		//		_buildSiteMap(layout, curLayout.getChildren(), rootLayout, includeRootInTree, displayDepth, showCurrentPage, useHtmlTitle, showHiddenPages, curDepth + 1, themeDisplay, sb);
		//	}

		//	sb.append("</li>");
		//}
		String layoutName = curLayout.getName(themeDisplay.getLocale());
		if(!curLayout.isHidden()) {
				sb.append("<h2 class=\"st_h\">");
					sb.append("<a href=\""+PortalUtil.getLayoutURL(curLayout, themeDisplay)+"\">");
						sb.append(layoutName);
					sb.append("</a>");
				sb.append("</h2>");
			_buildUL(curLayout.getChildren(),themeDisplay, sb);
		}
	}

	//sb.append("</ul>");
}
private void _buildUL(List<Layout> layouts , ThemeDisplay themeDisplay, StringBundler sb) throws Exception {
	for (int j = 0; j < layouts.size(); j++) {
		Layout curLayout = layouts.get(j);
		if(!curLayout.isHidden()) {
			if(j==0) {
				sb.append("<div class=\"column first\">");
			} else if(j == layouts.size()-1) {
				sb.append("<div class=\"column last\">");
			} else {
				sb.append("<div class=\"column\">");
			}
				sb.append("<h3>");
					sb.append(curLayout.getName(themeDisplay.getLocale()));
				sb.append("</h3>");
				if(curLayout.getChildren() != null && curLayout.getChildren().size() > 0) {
					List<Layout> subLayout = curLayout.getChildren();
					sb.append("<ul>");
						Layout subCurrentLayout;
						for (int k = 0; k < subLayout.size(); k++) {
							subCurrentLayout = subLayout.get(k);
							if(!subCurrentLayout.isHidden()) {
								sb.append("<li>");
								sb.append("<a href=\""+PortalUtil.getLayoutURL(subCurrentLayout, themeDisplay)+"\">");
									sb.append(subCurrentLayout.getName(themeDisplay.getLocale()));
								sb.append("</a>");
								sb.append("</li>");
							}
						}
					sb.append("</ul>");
				}
			sb.append("</div>");
		}
	}
	
}
%>