function legalDocsSearchActionAjax(url){
	console.log("call function legalDocsSearchAction() with url: " + url);
	var legalDomain = $("#legalDomailSearch").val();
	var legalCategory = $('#legalDocCategorySearch').val();
	var legalAbstract = $("#legalDocs-legalAbstractID").val();
	var yearPublish = $("#yearPublish").val();
	var legalTextSymbol = $("#legalDocs-textSymbolsID").val();
	
	var portletNameSpace = $("#portletNameSpace").val();
	var startDay = $('#'+ portletNameSpace + "startDay").val();
	var startMonthStr = $('#'+ portletNameSpace + "startMonth").val();
	var startMonth = parseInt(startMonthStr) + 1;
	var startYear = $('#'+ portletNameSpace + "startYear").val();	
	var startDate = startDay + "-" + startMonth + "-" + startYear;
	console.log("start date: " + startDate);
	
	var endDay = $('#'+ portletNameSpace + "endDay").val();
	var endMonthStr = $('#'+ portletNameSpace + "endMonth").val();
	var endMonth = parseInt(endMonthStr) + 1;
	var endYear = $('#'+ portletNameSpace + "endYear").val();	
	var endDate = endDay + "-" + endMonth + "-" + endYear;
	console.log("end date: " + endDate);
	
	var tableId = "resultSearchLegalDocumentsTable";
	$.ajax({
		sync: false,
		url : url,
		data : {legalDomain : legalDomain, legalCategory : legalCategory, legalAbstract : legalAbstract,
			yearPublish : yearPublish, legalTextSymbol : legalTextSymbol, startDate : startDate, endDate : endDate},
		type: 'POST',
		dataType : "json",
		success : function(data) {
			renderTable(tableId, data, 0, "Page1");
		},
		error : function(data) {
			alert("ERROR!");
		}
	});
}

function getDetailLegalDocAjax( idDetail) {
	var url = $("#getDetailLegalDocUrl").val();
	console.log("call url: " + url);
	console.log("=========================");
	console.log("parram: " + idDetail);
	$.ajax({
		sync: false,
		url : url,
		data : {legalDocID: idDetail},
		type: 'POST',
		dataType : "json",
		success : function(data) {
			getLegalDataDetailSuccess(data);
		},
		error : function(data) {
			alert("error");
		}
	});	
}

$(function() {
	$("#resultSearchLegalDocumentsTable tr").click(function(){
		var idElement = $(this).find("input[class='id']");
		if(idElement != undefined){
			var id = idElement.val();
			getDetailLegalDocAjax(id);
		}
	});
	
	$( "#legalDocs-startDateSearchID" ).datepicker({ dateFormat: "dd-mm-yy" });
	$( "#legalDocs-endDateSearchID" ).datepicker({ dateFormat: "dd-mm-yy" });
});

function resultSearchLegalDocumentsTable_onClick(row){
	var idElement = $(row).find("input[class='id']");
	if(idElement != undefined){
		var id = idElement.val();
		getDetailLegalDocAjax(id);
	}
	console.log("resultSearchLegalDocumentsTable_onClick " + row);
};

function getLegalDataDetailSuccess(data){
	if(null != data){
		$("#details_doc_symbol").html(data.document_symbol);
		$("#details_doc_description").html(data.document_description);
		$("#details_doc_date_publish").html(data.publish_date);
		$("#details_doc_date_publish").html(data.publish_date);
		$("#details_doc_effect_date").html(data.effect_date);
		$("#details_doc_category").html(data.document_form);
		$("#details_doc_grade_publisher").html(data.grade_publisher);
		$("#details_doc_organ_publisher").html(data.organ_publisher);
		$("#details_doc_signer").html(data.signer);
		
		var attachArray =  data.file_attach;
		var attachhtml = "";
		for(var i = 0; i < attachArray.length; i++){
			attachhtml += "<a href='" + attachArray[i] +"'><div class='file_attach_icon'></div></a>";
		}
		$("#details_file_attach").html(attachhtml);
		
		document.getElementById('legal_doc_detail_content').hidden = false;
		document.getElementById('legal_doc_list_content').hidden = true;
	}
}

function backToListLegalDoc(){
	document.getElementById('legal_doc_detail_content').hidden = true;
    document.getElementById('legal_doc_list_content').hidden = false;
}

/** Convert C -> CN and Th -> T2, ... ,T7**/
$(document).ready(function(){
	$(".inputDateRowA").click(function(){
		var len = $('.aui-calendar-week:visible').length;
		for (var i = 0; i < len; i++) {
			if ($($('.aui-calendar-week:visible')[i]).text() == 'C') {
				$($('.aui-calendar-week:visible')[i]).text('CN');
			}

			if ($($('.aui-calendar-week:visible')[i]).text() == 'Th ') {
				$($('.aui-calendar-week:visible')[i]).text('T'+ (i+1));
			}
		}
		
	});
	
	
	$(".inputDateRowB").click(function(){
		var len = $('.aui-calendar-week:visible').length;
		for (var i = 0; i < len; i++) {
			if ($($('.aui-calendar-week:visible')[i]).text() == 'C') {
				$($('.aui-calendar-week:visible')[i]).text('CN');
			}

			if ($($('.aui-calendar-week:visible')[i]).text() == 'Th ') {
				$($('.aui-calendar-week:visible')[i]).text('T'+ (i+1));
			}
		}
	  });
});