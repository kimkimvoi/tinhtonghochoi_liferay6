var selectedRow;
var nameSpace;
jQuery(document).ready(function() {
	// call when press search button
	$("#questionSearchButton").click(function() {
		callAjaxQuestionSearchBySearchButton();
	});
	$("#rejectButton").click(function() {
		callAjaxRejectQuestion();
	});
	$("#revertButton").click(function() {
		callAjaxRevertQuestion();
	});
	
	
	
	
	nameSpace = $("#nameSpace");
	renderClickFuncOnTable();
	
	$('#cancelButton').click(function(){
		// set data for hidden field
		selectedRow.removeClass("selected");
		$("#questionIdProcess").val("");
		$("#answerIdProcess").val("");
		$("#details").hide("slow");
	});
	
	$(".portlet-msg-success").css("display","none");
	$("#_adminqamanagement_WAR_tinhdoportlet_questionStatus").change(function(){
		$("#result").fadeOut(1000);
	});
	$("#_adminqamanagement_WAR_tinhdoportlet_questionSelected").change(function(){
		$("#result").fadeOut(1000);
	});
	$("#textQuestionSearch").focus(function(){
		$("#result").fadeOut(1000);
	});
	
	$("#details").hide();
	if($("#responServer").val() =='SUCCESS') {
		setResultSuccess();
	} else if ($("#responServer").val() =='ERROR') {
		setResultError();
	} else if ($("#responServer").val() =='WARNING') {
		setResultWarning($("#responServerContent").val());
	} else {
		$("#result").hide();
	}
});
//++ QuangTN3 - fix bug FIBIXBP-304 - 20140318
function searchKeyPress(e) {
    if (e.keyCode == 13) {
    	$("#result").fadeOut(1000);
    	e.preventDefault();
        $('#questionSearchButton').click();
    }
}
//-- QuangTN3 - fix bug FIBIXBP-304 - 20140318

function renderClickFuncOnTable() {
	$('.admin_qa_management table#answeredQuestionTable tr.dataRow').click(function(e) {
		$(this).addClass("selected").siblings().removeClass("selected");
		selectedRow = $(this);
		var questionId = $(this).find("td input._question_id").val();
		
		if (questionId != $("#questionIdProcess").val()) { 
			var answerId = $(this).find("td input._answer_id").val();
			var questioners="";
			var address="";
			var title="";
			var questionContent="";		
			var answerContent="";
			var question_status_id="";
			var answerAttachLists="";
			var questionAttachLists="";
			var questionList = $.parseJSON($("#answeredQuestionTable_questionList").val());
			var answerList = $.parseJSON($("#answeredQuestionTable_answerList").val());
			var answerAttachFiles = $.parseJSON($("#answerAttachFiles").val());
			var questionAttachFiles = $.parseJSON($("#questionAttachFiles").val());
			for (var i=0; i< questionList.length; i++) {
				if (questionId == questionList[i]._question_id) {
					questioners = questionList[i]._citizen_name;
					address = questionList[i]._citizen_address;
					title = questionList[i]._question_title;
					questionContent = questionList[i]._question_content;
					question_status_id = questionList[i]._question_status_id;
				}
			}
			
			for (var i=0; i< answerList.length; i++) {
				if (answerId == answerList[i]._answer_id) {
					answerContent = answerList[i]._answer_content;
				}
			}
			// display question details
			$("#citizenName").html(questioners);
			$("#citizenAdd").html(address);
			$("#quesTitle").html(title);
			/*window._adminqamanagement_WAR_tinhdoportlet_questionContent.setHTML(questionContent);*/
			$("#questionContent").html(questionContent);
			window._adminqamanagement_WAR_tinhdoportlet_answerContent.setHTML(answerContent);
			// set data foe hidden field
			$("#questionIdProcess").val(questionId);
			$("#answerIdProcess").val(answerId);
			// set answer attach files
			answerAttachLists = "";
			for (var i=0; i< answerAttachFiles.length; i++) {
				if (answerId == answerAttachFiles[i].documentId) {
					answerAttachLists += "<img src="+$('#contextPathAdminQa').val() +"/html/images/icons/icon_attachment.png>";
					answerAttachLists += "<a href=\""+answerAttachFiles[i].url+"\">";
					answerAttachLists += answerAttachFiles[i].title;
					answerAttachLists += "</a><br/>";
				}
			}
			for (var i=0; i< questionAttachFiles.length; i++) {
				if (questionId == questionAttachFiles[i].documentId) {
					questionAttachLists += "<img src="+$('#contextPathAdminQa').val() +"/html/images/icons/icon_attachment.png>";
					questionAttachLists += "<a href=\""+questionAttachFiles[i].url+"\">";
					questionAttachLists += questionAttachFiles[i].title;
					questionAttachLists += "</a><br/>";
				}
			}
			$(".answerAttachFiles").html(answerAttachLists);
			$(".questionAttachFiles").html(questionAttachLists);
			if (question_status_id == '1') {
				$("#rejectButton").show();			
				$("#revertButton").hide();			
			} else if (question_status_id == '2' ) {
				$("#rejectButton").hide();
				$("#revertButton").hide();	
			} else if (question_status_id == '3') {
				$("#rejectButton").hide();			
				$("#revertButton").show();	
			}
			// show content
			$("#details").show( "slow");
		} else {
			selectedRow.removeClass("selected");
			$("#questionIdProcess").val("");
			$("#answerIdProcess").val("");
			$("#details").hide("slow");
		}
	});
}


/*function updateAnswerQuestion() {
	var loadPageURLId = "updateAnswer_URL";
	$.ajax({
		sync: false,
		url: $("#" + loadPageURLId).val(),
		data : $("#questionSubmit").serialize(),
		dataType: 'json',
		type: "POST",
		success: function(data) {
			if (data.status == "true") {
				$(selectedRow.find('td')[4]).html('Đã trả lời');
			} 
		},
		error: function(response) {
			alert(response);
		}
	});
}*/


function callAjaxQuestionSearchBySearchButton() {
	var searchKeyWord = $("#textQuestionSearch").val();
	var questionType = $("#_adminqamanagement_WAR_tinhdoportlet_questionSelected").val();
	var questionStatus = $("#_adminqamanagement_WAR_tinhdoportlet_questionStatus").val();
	var numPerPage = $("#answeredQuestionTable_itemsPerPageInput").val();
	var loadPageURLId = "answeredQuestionTable_SearchURL";
	$.ajax({
		sync: false,
		url: $("#" + loadPageURLId).val(),
		data: {
			'searchKeyWord':searchKeyWord, 
			'questionType' : questionType,
			'questionStatus' : questionStatus,
			'numPerPage': numPerPage,
			},
		dataType: 'json',
		type: "POST",
		success: function(data) {
			renderTable("answeredQuestionTable", data, 1, "answeredQuestionTable_curPageNum");
			$("#answeredQuestionTable_questionList").val(data.items);
			$("#answeredQuestionTable_answerList").val(data.answer);
			$("#answerAttachFiles").val(data.answerAttachs);
			$("#questionAttachFiles").val(data.questionAttachFiles);
			renderClickFuncOnTable();
			setResult(data);
			$("#details").hide();
		},
		error: function(response) {
			setResultError();
		}
	});
}

function callAjaxRejectQuestion() {
	var rejectQuestionURLId = "rejectQuestion_URL";
	var numPerPage = $("#answeredQuestionTable_itemsPerPageInput").val();
	$.ajax({
		sync: false,
		url: $("#" + rejectQuestionURLId).val(),
		data: {
			'questionIdProcess':$("#questionIdProcess").val(), 
			'numPerPage': numPerPage,
			},
		dataType: 'json',
		type: "POST",
		success: function(data) {
			renderTable("answeredQuestionTable", data, 1, "answeredQuestionTable_curPageNum");
			$("#answeredQuestionTable_questionList").val(data.items);
			$("#answeredQuestionTable_answerList").val(data.answer);
			$("#answerAttachFiles").val(data.answerAttachs);
			$("#questionAttachFiles").val(data.questionAttachFiles);
			renderClickFuncOnTable();
			setResult(data);
			$("#details").hide();
		},
		error: function(response) {
			setResultError();
		}
	});
}
function callAjaxRevertQuestion() {
	var revertQuestionURLId = "revertQuestion_URL";
	var numPerPage = $("#answeredQuestionTable_itemsPerPageInput").val();
	$.ajax({
		sync: false,
		url: $("#" + revertQuestionURLId).val(),
		data: {
			'questionIdProcess':$("#questionIdProcess").val(), 
			'numPerPage': numPerPage,
		},
		dataType: 'json',
		type: "POST",
		success: function(data) {
			renderTable("answeredQuestionTable", data, 1, "answeredQuestionTable_curPageNum");
			$("#answeredQuestionTable_questionList").val(data.items);
			$("#answeredQuestionTable_answerList").val(data.answer);
			$("#answerAttachFiles").val(data.answerAttachs);
			$("#questionAttachFiles").val(data.questionAttachFiles);
			renderClickFuncOnTable();
			setResult(data);
			$("#details").hide();
		},
		error: function(response) {
			setResultError();
		}
	});
}

function setResult(data) {
	var items = $.parseJSON(data.items);
	var MsgContent ="";
	if (items.length == 0 ) {
		$('#result').addClass("portlet-msg-alert");
		MsgContent += $("#msgKeyWord").val() +" \'";
		MsgContent += 	$("#textQuestionSearch").val() +"\' " + $("#msgNoresult").val();
		MsgContent += "<ul class='warningResult'>"+  $("#msgSugg").val();
		MsgContent += "<li>"+ $("#msgSuggSt").val();
		MsgContent += "<li>"+ $("#msgSuggNd").val();
		MsgContent += "<li>"+ $("#msgSuggRd").val();
		MsgContent += "<li>"+ $("#msgSuggTh").val() +"</ul>";
		$('#result').addClass("portlet-msg-alert");
		$('#result').html(MsgContent);	
		$('#result').show();
	}
}
function setResultError() {
	var MsgContent ="";
	MsgContent += $("#responServerContent").val();
	$('#result').addClass("portlet-msg-error");
	$('#result').html(MsgContent);	
	$('#result').show();
}

function setResultSuccess() {
	var MsgContent ="";
	MsgContent += $("#msgSuccess").val();
	$('#result').addClass("portlet-msg-success");
	$('#result').html(MsgContent);	
	$('#result').show();
}

function setResultWarning(content) {
	$('#result').addClass("portlet-msg-alert");
	$('#result').html(content);	
	$('#result').show();
}


//override function callAjaxLoadPage trong common.js de truyen them 2 parameters searchKeyWord va questionType
function callAjaxLoadPage(tableId, pageNum, curPageId) {
	var loadPageURLId = tableId + "_loadPageURL";
	var searchKeyWord = $("#answeredQuestionKeyWord").val();
	var questionType = $("#_adminqamanagement_WAR_tinhdoportlet_questionSelected").val();
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
			$("#answeredQuestionTable_answerList").val(data.answer);
			renderClickFuncOnTable();
			$("#details").hide();
		},
		error: function(response) {
			setResultError();
		}
	});
}

function setFileNameToHiddenField(value) {
	$("#fileNameAttach").val(value);
}

function renderTable(tableId, data, pageNum, curPageId) {
	var items = $.parseJSON(data.items);
	var answer =  $.parseJSON(data.answer);
	var recordPerPage = $.parseJSON(data.recordPerPage);
	var numOfPage = data.numOfPage;
	var headers = convertToArray(tableId + "_headerList");
	var displayedPropertyList = convertToArray(tableId + "_displayedPropertyList");
	var hiddenPropertyList = convertToArray(tableId + "_hiddenPropertyList");
	var curPageTextId = tableId + "_curPageText";
	var headerClass = $("#" + tableId + "_headerClass").val();
	var tableContent = "<tr class='" + headerClass + "'>";
	
	for (var i = 0;i < headers.length; i++) {
		tableContent += "<th>"+headers[i]+"</th>";
	}
	tableContent += "</tr>";
	for (var i = 0; i < items.length; i++) {
		tableContent += "<tr class='dataRow'>";
		for (var j = 0;j < displayedPropertyList.length; j++) {
			var displayedProperty = displayedPropertyList[j].trim();
			if (displayedProperty == "_stt") {
				var stt = i + 1 + recordPerPage*(pageNum - 1);
				tableContent += "<td>" + stt + "</td>";
			} else {
				var displayedPropertySubArray = displayedProperty.split("&");
				var displayedValue = items[i][displayedPropertySubArray[0]];
				if(displayedPropertySubArray.length > 1){
					for(var a = 1; a < displayedPropertySubArray.length; a++){
						displayedValue = displayedValue + " " +items[i][displayedPropertySubArray[a]];
					}
				}
				tableContent += "<td>" + displayedValue + "</td>";
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

	// set data to hidden filed
	$("#answeredQuestionTable_questionList").val(items);
	$("#answeredQuestionTable_answerList").val(answer);
}

