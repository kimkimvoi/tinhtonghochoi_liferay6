
function menuItemOnclick(item, url){
	var tableId = "administrationProcedureListTable";
	var numPerPage = $("#"+ tableId + "_itemsPerPageInput").val();
	if (!isNumber(numPerPage)) {
		return;
	}
	backFromDetail();
	var organizations = "0";
	var txtKeySearch = "";
	var levelAdministrationProcedure = "0";
	
	$.ajax({	
		url : url,
		data : {'numPerPage':numPerPage, fields: item, organizations: organizations, levelAdministrationProcedure: levelAdministrationProcedure, txtKeySearch: txtKeySearch},
		type: 'POST',
		dataType : "json",
		success : function(data) {
			renderTable(tableId, data, 1, "resultSearchPublicAdministrationTable_Id");
			$("#publics_administration_procedure_details").hide();
		},
		error : function(data) {
			alert("error");
		}
	});
}

function menuItemSoBanNganhOnclick(item, url){
	var tableId = "administrationProcedureListTable";
	var numPerPage = $("#"+ tableId + "_itemsPerPageInput").val();
	if (!isNumber(numPerPage)) {
		return;
	}
	backFromDetail();
	var fields = "0";
	var txtKeySearch = "";
	var levelAdministrationProcedure = "0";
	
	$.ajax({	
		url : url,
		data : {'numPerPage':numPerPage, fields: fields, organizations: item, levelAdministrationProcedure: levelAdministrationProcedure, txtKeySearch: txtKeySearch},
		type: 'POST',
		dataType : "json",
		success : function(data) {
			renderTable(tableId, data, 1, "resultSearchPublicAdministrationTable_Id");
			$("#publics_administration_procedure_details").hide();
		},
		error : function(data) {
			alert("error");
		}
	});
}

//search ajax
function searchPublicAdministrationProcedureAjax(url){
	var tableId = "administrationProcedureListTable";
	var numPerPage = $("#"+ tableId + "_itemsPerPageInput").val();
	if (!isNumber(numPerPage)) {
		return;
	}
	
	var fields = $("#fields").val();
	var organizations = $("#organization").val();
	var txtKeySearch = $("#txtKeySearch").val();
	var levelAdministrationProcedure = $('#levelAdministrationProcedure').val();
	
	$.ajax({	
		url : url,
		data : {'numPerPage':numPerPage, fields: fields, organizations: organizations, levelAdministrationProcedure: levelAdministrationProcedure, txtKeySearch: txtKeySearch},
		type: 'POST',
		dataType : "json",
		success : function(data) {
			renderTable(tableId, data, 1, "resultSearchPublicAdministrationTable_Id");
			$("#publics_administration_procedure_details").hide();
		},
		error : function(data) {
			alert("error");
		}
	});
}

//display detail
function getDetailsPublicAdminstrationProcedureAjax(id, url){
	$.ajax({	
		url : url,
		data : {'publicAdministratrionProcedureId' : id},
		type: 'POST',
		dataType : "json",
		success : function(data) {
			var publicAdministrationProcedure = data.publicAdministratrionProcedure;
			var listOtherProcedure = data.lisOther;
			renderDetailPublicAdministrationProcedureData(JSON.parse(publicAdministrationProcedure));
			renderLisOtherPublicAdministrationProcedureData(listOtherProcedure);
			$("#publics_administration_procedure_details").show();
			$("#tim_kiem_danh_sach_tthc").hide();
		},
		error : function(data) {
			alert("error");
		}
	});
}

//back function
function backFromDetail(){
	$("#publics_administration_procedure_details").hide();
	$("#tim_kiem_danh_sach_tthc").show();
}

//table id
$(function() {
	$("#administrationProcedureListTable tr").click(function(){
		var idElement = $(this).find("input[class='id']");
		if($(this).hasClass("dataRow")){
			var id = idElement.val();
			var url = $("#getDetailsAdministrationProcedureAjax_Url").val();
			getDetailsPublicAdminstrationProcedureAjax(id, url);
		}
	});
});

function administrationProcedureListTable_onClick(row){
	var idElement = $(row).find("input[class='id']");
	if(idElement != undefined){
		var id = idElement.val();
		var url = $("#getDetailsAdministrationProcedureAjax_Url").val();
		getDetailsPublicAdminstrationProcedureAjax(id, url);
	}
};

//get
function renderDetailPublicAdministrationProcedureData(publicAdministratrionProcedure){
	$("#details_name_procedure").html(publicAdministratrionProcedure.title);
	$("#details_order").html(publicAdministratrionProcedure.execution);
	$("#details_perform").html(publicAdministratrionProcedure.perform);
	$("#details_profile").html(publicAdministratrionProcedure.profile);
	$("#details_resolution").html(publicAdministratrionProcedure.processing);
	$("#details_object_procedure").html(publicAdministratrionProcedure.object);
	$("#details_ororganizations").html(publicAdministratrionProcedure.agency);
	$("#details_result").html(publicAdministratrionProcedure.result);
	$("#details_fees").html(publicAdministratrionProcedure.cost);
	$("#details_application").html(publicAdministratrionProcedure.formSheets);
	$("#details_requirement").html(publicAdministratrionProcedure.condition);
	$("#details_legal_basis").html(publicAdministratrionProcedure.legalBases);
	$("#details_contact").html(publicAdministratrionProcedure.contact);
	
	var attachArray =  publicAdministratrionProcedure.attachment;
	var attachhtml = "";
	for(var i = 0; i < attachArray.length; i++){
		attachhtml += "<a href='" + attachArray[i] +"'><div class='file_attach_icon'></div></a>";
	}
	$("#details_attach_document").html(attachhtml);
	
	var button_area = "";
	if("Mức 3" == publicAdministratrionProcedure.level){
		button_area += "<span>"
					+ "<input onclick='backFromDetail()' type=\"button\" value=\"Quay lại\" class=\"buttons back_from_administration_procedure_details\">"
					+ "</span>";
		button_area += "<span>"
					+ "<input type=\"button\" value=\"<liferay-ui:message key=\"Đăng ký hồ sơ trực tuyến\">\" class=\"buttons right\">"
					+ "</span>"
					+ "<div class=\"clear\"></div>";
		$("#public_administration_procedure_bark_area").html(button_area);
	}else{
		button_area += "<span>"
				+ "<input onclick='backFromDetail()' type=\"button\" value=\"Quay lại\" class=\"buttons right\">"
				+ "</span>";
		$("#public_administration_procedure_bark_area").html(button_area);
	}
}

function renderLisOtherPublicAdministrationProcedureData(lisOther){
	var url = $("#getDetailsAdministrationProcedureAjax_Url").val();	
	var list = $.parseJSON(lisOther);
	var listInfo = "<div class=\"list_other_title\">Các thủ thục khác:</div>";
	if(lisOther != undefined){
		listInfo +="<div class=\"list_other_description\"><ul>";
		for(var i = 0; i < list.length; i++){
			listInfo += "<a onclick=\"getDetailsPublicAdminstrationProcedureAjax('" + list[i].id + "','" + url + "');\">"+ list[i].title +"</a><br/>";
		}
		listInfo +="</ul></div>";
		$("#list_other_public_administration_procedure").html(listInfo);
	}
}