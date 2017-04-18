<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@page import="com.fsoft.bn.portlet.booklibrary.BookModel"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<portlet:defineObjects />

<%
	String bookList = (String) request.getAttribute("bookList");
	String bookAuthorList = (String) request.getAttribute("bookAuthorList");
	String bookCategoryList = (String) request.getAttribute("bookCategoryList");
%>
<script>
	bookList = <%=bookList%>;
	bookAuthorList = <%=bookAuthorList%>;
	bookCategoryList = <%=bookCategoryList%>;
</script>

<h2 class="title_tab">
	<label><liferay-ui:message key="portlet.booklibrary.title" /></label>
</h2>
<div id="selectDiv" style='margin-bottom: 20px'>
</div>
<div id="resultDiv">
</div>
