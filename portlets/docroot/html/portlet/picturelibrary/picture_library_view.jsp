<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<portlet:defineObjects />

<div class="box-commons">
	<a href="./thu-vien-anh">
		<h2 class="title_tab">
			<span><liferay-ui:message key="portlet.picturelibrary.title"/></span>
		</h2>
	</a>
	<div class="box-content">
		<a href="./thu-vien-anh"><img src="${picture.url}&imagePreview=1" class="photo"/></a>
	</div>
</div>
<div class="clear"></div>