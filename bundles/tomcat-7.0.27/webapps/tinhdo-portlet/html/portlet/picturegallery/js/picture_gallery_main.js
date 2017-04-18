function renderTable(tableId, data, pageNum, curPageId) {
	var items = $.parseJSON(data.items);
	var numOfPage = data.numOfPage;
	var html = "";
	if(data.recordPerPage >= 1){
		if(items != undefined && items.length > 0) {
			html+="<ul class='list_photo'>";
			for(var i = 0 ; i < items.length > 0 ; i++) {
				html += "<li onclick=\"previewPictureByFolder('"+items[i].folderId+"')\">";
				html += "<div class='photo'>";
				html+="<a href=\"javascript:void(0);\">";
				if(items[i].imageThumb.url.length > 0){
					html+="<img src=\"" + items[i].imageThumb.url + "\">";
				}else{
					html+="<img src=\"/tinhdo-portlet/html/images/no_images.jpg\">";
				}
				html+="</a>";
				html += "</div>";
				
				html += "<p>";
					html+="<a href=\"javascript:void(0);\">" + items[i].name + "</a>";
				html += "</p>";
				
				html += "</li>";
			}
			html+="</ul>";
		}
		$('#sub_folders_picture').html(html);
		
		var curPageTextId = tableId + "_curPageText";
		$("#" + curPageId).val(pageNum);
		$("span#" + curPageTextId).html(pageNum, curPageId);
		renderPaginator(tableId, numOfPage, curPageId);
	}
}

$(document).ready(function() {
	$(".picturegallery-portlet .filetree .folder").click(function(){
		var folderId = $(this).attr("id");
		$("#pictureGallery_Folder_Form #folderId").val(folderId);
		$("#pictureGallery_Folder_Form").submit();
	});
});

function previewPictureByFolder(folderId) {
	$("#folderId").val(folderId);
	$("#pictureGallery_Folder_Form").submit();
}

function chooseFolderToDisplay(folderId,name) {
	$("#pictureGalleryFolderId").val(folderId);
	//for each 
	$(".button_choose_folder").each(function(){
		$(this).removeAttr('disabled');
		$(this).removeClass("button_actived");
	});
	
	$(".picturegallery_config").each(function(){
		$(this).removeAttr('disabled');
		$(this).removeClass("button_actived");
	});
	$("#button_choose_"+folderId).addClass("button_actived");
	$("input[name='btnCancel']").attr('disabled',false);
	$("#pictureGalleryActionName").val('actionChoosedFolder');
}

function getConfigFolderId(folderId) {
	$("#pictureLinkFolderId").val(folderId);
	$("#pictureGalleryActionName").val('actionClickSubFolder');
	$("#pictureGalleryForm").submit();
}

function deleteChoosedFolder(){
	$(".button_choose_folder").each(function(){
		$(this).removeAttr('disabled');
		$(this).removeClass("button_actived");
	});
	$("#pictureGalleryFolderId").val(0);
	$("input[name='btnCancel']").attr('disabled',true);
	$("#picturegallery_config_cancel").addClass("button_actived");
}

function sendPictureGalleryRequest(){
	$("#pictureGalleryForm").submit();
	reloadPictureGallery();
}

function findSubFolder(){
	alert($("#pictureGalleryMessage").val());
}

function reloadPictureGallery(){
	$('.mygallery').tn3({
		skinDir : "skins",
		imageClick : "fullscreen",
		image : {
			maxZoom : 4,
			crop : true,
			clickEvent : "dblclick",
			transitions : [{type : "blinds"}, {type : "grid"}, {
				type : "grid",
				duration : 300,
				easing : "easeInQuad",
				gridX : 1,
				gridY : 5,
				// flat, diagonal, circle, random
				sort : "random",
				sortReverse : false,
				diagonalStart : "bl",
				// fade, scale
				method : "scale",
				partDuration : 100,
				partEasing : "easeOutSine",
				partDirection : "left"
			}]
		},
		thumbnailer:{
				useTitle: true
		}
	});
}

