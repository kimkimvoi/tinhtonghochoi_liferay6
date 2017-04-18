<%@ include file="/html/common/init_config.jsp"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>

<portlet:defineObjects />
<h2 class="title_tab">
	<label><liferay-ui:message key="portlet.picturegallery.config.title"/></label>
</h2>
<form name="pictureGalleryForm" id="pictureGalleryForm" action="<liferay-portlet:actionURL portletConfiguration="true" />" method="POST">
	<div class="crumbs">
		<ul>
			<c:forEach var="item" items="${breadcumbs}" varStatus="status">
				<c:if test="${!status.last}">
					<li><a href="#" onclick="getConfigFolderId('${item.key}')">${item.value}</a></li>
				</c:if>
				<c:if test="${status.last}">
					<li><a href="javascript:void(0);">${item.value}</a></li>
				</c:if>
			</c:forEach>
		</ul>
	</div>
	<div class="clear"></div>
	<div>
		<div class="box_config_folders" id="box_sub_folders_picture">
			<ul class="box_list_photo">
				<li>
					<a><strong><liferay-ui:message key="portlet.picturegallery.config.number.folder.name"/></strong></a> 
					<div class="count-subfolder">
						<div class="box_count_folder"><span><strong><liferay-ui:message key="portlet.picturegallery.config.number.folder.quantity"/></strong></span></div>
						<div class="box_count_folder"><span style="margin-left: 50px;"><strong><liferay-ui:message key="portlet.picturegallery.config.number.folder.file"/></strong></span></div>
					</div>
				</li>
				<c:forEach var="folder" items="${subFolders}">
					<li>
						
						<c:if test="${folder.countSubFolder == 0 }">
							<a href="javascript:void(0);" onclick="findSubFolder();" id="link-subfolder" >${folder.name}</a>
						</c:if>
						<c:if test="${folder.countSubFolder > 0 }">
							<a href="javascript:void(0);" id="link-subfolder" onclick="getConfigFolderId('${folder.folderId}')">${folder.name}</a>
						</c:if>	
						<div class="count-subfolder">
							<span class="box_count_folder">(<b>${folder.countSubFolder}</b>- <liferay-ui:message key="portlet.picturegallery.config.folder"/>)</span> 
							<span class="box_count_folder" style="margin-left: 120px;">(${folder.countFileInFolder}- <liferay-ui:message key="portlet.picturegallery.config.picture"/>)</span>
						</div>
						<div class="box_btn_choose">
							<c:if test="${folder.folderId == pictureGalleryFolderId }">
								<input type="button" name="btnChoose" value="Chon" disabled="disabled"  id="button_choose_${folder.folderId}"
								class="button_choose_folder button_actived" onclick="chooseFolderToDisplay('${folder.folderId}','${folder.name}')" />
							</c:if> 
							<c:if test="${folder.folderId != pictureGalleryFolderId }">
								<input type="button" name="btnChoose" value="<liferay-ui:message key="portlet.picturegallery.config.choose"/>"  id="button_choose_${folder.folderId}" class="button_choose_folder" 
								onclick="chooseFolderToDisplay('${folder.folderId}','${folder.name}')"/>
							 </c:if>
						</div>
					</li>
				</c:forEach>
			</ul>
			<div class="clear"></div>
		</div>
	</div>
	<p>
		<input type="button" name="btnSave" onclick="sendPictureGalleryRequest();" id="picturegallery_config_save" value="<liferay-ui:message key="common.button.save"/>" />
		<c:if test="${pictureGalleryFolderId > 0 }">
			<input style="margin-bottom: 15px;" type="button" name="btnCancel" onclick="deleteChoosedFolder();"  id="picturegallery_config_cancel" class="picturegallery_config" value="<liferay-ui:message key="portlet.picturegallery.config.default"/>"  />
		</c:if>
		<c:if test="${pictureGalleryFolderId <= 0 }">
			<input style="margin-bottom: 15px;" type="button" name="btnCancel" onclick="deleteChoosedFolder();" disabled="disabled"  id="picturegallery_config_cancel" class="picturegallery_config button_actived" value="<liferay-ui:message key="portlet.picturegallery.config.default"/>"  />
		</c:if>
	</p>
	
	<input type="hidden" id="pictureGalleryFolderId" name="picturegalleryfolId" value="${pictureGalleryFolderId }" /> 
	<input type="hidden" id="pictureLinkFolderId" name="pictureLinkFolderId" value="${rootSuFolderId }" /> 
	<input type="hidden" id="pictureGalleryActionName" name="pictureGalleryActionName" value="" />
	<input type="hidden" id="pictureGalleryMessage" name="pictureGalleryMessage" value="<liferay-ui:message key="portlet.picturegallery.config.message"/>" />
</form>

