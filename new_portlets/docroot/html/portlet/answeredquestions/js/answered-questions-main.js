jQuery(document).ready(function() {
	$("#answeredQuestionSearchButton").click(function() {
		callAjaxQuestionSearch();
	});
	
	buildDetailRow();
});

//++ QuangTN3 - fix bug FIBIXBP-304 - 20140318
function searchKeyPress(e) {
    if (e.keyCode == 13) {
    	e.preventDefault();
        $('#answeredQuestionSearchButton').click();
    }
}
//-- QuangTN3 - fix bug FIBIXBP-304 - 20140318

function buildDetailRow() {
	var questionList = $.parseJSON($("#answeredQuestionTable_questionList").val());
	var answerList = $.parseJSON($("#answeredQuestionTable_answerList").val());
	var numberOfColumn = convertToArray("answeredQuestionTable_displayedPropertyList").length;
	var questionLabel = Liferay.Language.get("portlet.answeredquestions.label.question");
	var questionerLabel = Liferay.Language.get("portlet.answeredquestions.label.questioner");
	var addressLabel = Liferay.Language.get("portlet.answeredquestions.label.address");
	var answerLabel = Liferay.Language.get("portlet.answeredquestions.label.answer");
	var answerDepartmentLabel = Liferay.Language.get("portlet.answeredquestions.label.answerdepartment");
	var answerDateLabel = Liferay.Language.get("portlet.answeredquestions.label.answerdate");
	var questionDateLabel = Liferay.Language.get("portlet.answeredquestions.label.questiondate");
	var attachedFileLabel = Liferay.Language.get("portlet.common.form.attachedFile");
	var answerAttachFiles = $.parseJSON($("#answerAttachFiles").val());
	var questionAttachFiles = $.parseJSON($("#questionAttachFiles").val());
	
	$("#answeredQuestionTable tr.dataRow").each(function() {
		var questionId = $(this).find("td input._question_id").val();
		var answerId = $(this).find("td input._answer_id").val();
		var rowDetail = "";
		rowDetail += "<div style='display: none;'>";
		rowDetail += "<strong>" + questionLabel + ":</strong><br/><br/>";
		for (var i=0; i< questionList.length; i++) {
			if (questionId == questionList[i]._question_id) {
				rowDetail += questionList[i]._question_content;
				rowDetail += "<br/><br/>" + questionerLabel + ": " + questionList[i]._citizen_name;
				rowDetail += "<br/>" + addressLabel + ": " + questionList[i]._citizen_address;
				rowDetail += "<br/>" + questionDateLabel + ": " + questionList[i].dateDisplay;
				break;
			}
		}
		
		//build attached files for question
		if (questionAttachFiles.length > 0) {
			rowDetail += "<br/>" + attachedFileLabel + ":<br/>";
			for (var i=0; i< questionAttachFiles.length; i++) {
				if (questionId == questionAttachFiles[i].documentId) {
					rowDetail += "<img src="+$('#contextPath').val() +"/html/images/icons/icon_attachment.png>";
					rowDetail += "<a href=\""+questionAttachFiles[i].url+"\">";
					rowDetail += questionAttachFiles[i].description;
					rowDetail += "</a><br/>";
				}
			}
		}
		
		rowDetail += "<br/><br/><strong>" + answerLabel + ":</strong><br/><br/>";
		
		for (var i=0; i< answerList.length; i++) {
			if (answerId == answerList[i]._answer_id) {
				rowDetail += answerList[i]._answer_content;
				rowDetail += "<br/><br/>" + answerDepartmentLabel + ": " + answerList[i].organizationName;
				rowDetail += "<br/>" + answerDateLabel + ": " + answerList[i].formatedCreatedDate;
				break;
			}
		}
		
		//build attached files for answer
		if (answerAttachFiles.length > 0) {
			rowDetail += "<br/>" + attachedFileLabel + ":<br/>";
			for (var i=0; i< answerAttachFiles.length; i++) {
				if (answerId == answerAttachFiles[i].documentId) {
					rowDetail += "<img src="+$('#contextPath').val() +"/html/images/icons/icon_attachment.png>";
					rowDetail += "<a href=\""+answerAttachFiles[i].url+"\">";
					rowDetail += answerAttachFiles[i].description;
					rowDetail += "</a><br/>";
				}
			}
		}
		
		rowDetail += "</div>";
		$("<tr class='rowDetail' style='display: none;'><td  colspan='" + numberOfColumn + "'>" + rowDetail + "</td></tr>").insertAfter(this);
		
		$(this).click(function(){
			var detailRows =  document.getElementsByClassName("rowDetail");
			for (var i=0; i<detailRows.length; i++) {
				var detailRow = detailRows.item(i);
				if (detailRow.style.display != "none") {
					$(detailRow).slideToggle(500);
					$(detailRow.childNodes[0].childNodes[0]).slideToggle(500);
				}
			}
			if ($(this).next().css("display") == "none") {
				$(this).next().slideToggle(500);
				$(this).next().find("div").slideToggle(500);
			}
			
			
		});
	});
}

function callAjaxQuestionSearch() {
	var searchKeyWord = $("#answeredQuestionKeyWord").val();
	var questionType = $("#_answered_questions_WAR_bacninhportlet_questionTypes").val();
	var loadPageURLId = "answeredQuestionTable_SearchURL";
	var numPerPage = $("#answeredQuestionTable_itemsPerPageInput").val();
	if (!isNumber(numPerPage)) {
		return;
	}
	$.ajax({
		sync: false,
		url: $("#" + loadPageURLId).val(),
		data: {'searchKeyWord':searchKeyWord, 'questionType' : questionType, 'numPerPage':numPerPage},
		dataType: 'json',
		type: "POST",
		success: function(data) {
			renderTable("answeredQuestionTable", data, 1, "answeredQuestionTable_curPageNum");
			$("#answeredQuestionTable_questionList").val(data.items);
			$("#answeredQuestionTable_answerList").val(data.answerList);
			buildDetailRow();
		},
		error: function(response) {
			alert("error");
		}
	});
}

//override function callAjaxLoadPage trong common.js de truyen them 2 parameters searchKeyWord va questionType
function callAjaxLoadPage(tableId, pageNum, curPageId) {
	var loadPageURLId = tableId + "_loadPageURL";
	var searchKeyWord = $("#answeredQuestionKeyWord").val();
	var questionType = $("#_answered_questions_WAR_bacninhportlet_questionTypes").val();
	var numPerPage = $("#"+ tableId + "_itemsPerPageInput").val();
	if (!isNumber(numPerPage)) {
		return;
	}
	$.ajax({
		sync: false,
		url: $("#" + loadPageURLId).val(),
		data: {'pageNum':pageNum, 'searchKeyWord':searchKeyWord, 'questionType' : questionType, 'numPerPage':numPerPage},
		dataType: 'json',
		type: "POST",
		success: function(data) {
			renderTable(tableId, data, pageNum, curPageId);
			$("#answeredQuestionTable_questionList").val(data.items);
			$("#answeredQuestionTable_answerList").val(data.answerList);
			buildDetailRow();
		},
		error: function(response) {
			alert("error");
		}
	});
}

function renderTable(tableId, data, pageNum, curPageId) {
	var items = $.parseJSON(data.items);
	var recordPerPage = $.parseJSON(data.recordPerPage);
	var numOfPage = data.numOfPage;
	var headers = convertToArray(tableId + "_headerList");
	var displayedPropertyList = convertToArray(tableId + "_displayedPropertyList");
	var hiddenPropertyList = convertToArray(tableId + "_hiddenPropertyList");
	var curPageTextId = tableId + "_curPageText";
	var headerClass = $("#" + tableId + "_headerClass").val();
	var tableContent = "<tr class='" + headerClass + "'>";
	var indicatorList = $("#indicatorList").val();
	var showIndicator = (indicatorList != null) && (indicatorList.split(",").length > 0);
	
	for (var i = 0;i < headers.length; i++) {
		tableContent += "<th>"+headers[i]+"</th>";
	}
	tableContent += "</tr>";
	for (var i = 0; i < items.length; i++) {
		if(showIndicator) {
			tableContent += "<tr class='dataRow' onclick='toggleIndicator(this)' >";
		} else {
			tableContent += "<tr class='dataRow'>";
		}
		
		for (var j = 0;j < displayedPropertyList.length; j++) {
			var displayedProperty = displayedPropertyList[j].trim();
			if (displayedProperty == "_stt") {
				var stt = i + 1 + recordPerPage*(pageNum - 1);
				
				if (showIndicator) {
					tableContent += "<td class='center'>" + addIndicator(j, stt) +"</td>";
				} else {
					tableContent += "<td class='center'>" + stt +"</td>";
				}
			} else {
				var displayedPropertySubArray = displayedProperty.split("&");
				var displayedValue = items[i][displayedPropertySubArray[0]];
				if(displayedPropertySubArray.length > 1){
					for(var a = 1; a < displayedPropertySubArray.length; a++){
						displayedValue = displayedValue + " " +items[i][displayedPropertySubArray[a]];
					}
				}
				
				if (showIndicator) {
					tableContent += "<td>" + addIndicator(j, displayedValue) +"</td>";
				} else {
					tableContent += "<td>" + displayedValue +"</td>";
				}
			}
		}
		
		if (null != hiddenPropertyList && hiddenPropertyList.length > 0) {
			tableContent += "<td style='display:none;'>";
			for (var j = 0;j < hiddenPropertyList.length; j++) {
				var hiddenProperty = hiddenPropertyList[j].trim();
				tableContent += "<input type='hidden' class='" + hiddenProperty + "' value='" + items[i][hiddenProperty] + "'/>";
			}
			tableContent += "</td>";
		}
		
		tableContent += "</tr>";
	}
	$("#" + tableId).html(tableContent);
	
	$("#" + curPageId).val(pageNum);
	$("span#" + curPageTextId).html(pageNum, curPageId);
	renderPaginator(tableId, numOfPage, curPageId);
}