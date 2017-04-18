jQuery(document).ready(function() {
	
	$("#investmentProjectSearchButton").click(function() {
		callAjaxInvestmentProjectSearch();
	});
	
	$("#addNewProjectBtn").click(function() {
		addNewProject(this);
	});
	
	$("#cancelBtn").click(function() {
		cancelProcess();
	});
	
});

function addNewProject(item) {
	clearForm();
	var addNewInvestmentProjectDiv = $("#addNewInvestmentProjectDiv");
	$("#addNewProjectFormHeader").show();
	$("#editProjectFormHeader").hide();
	$(item).hide(300);
	
	if (addNewInvestmentProjectDiv.css("display") == "none") {
		addNewInvestmentProjectDiv.slideToggle(300);
	} else {
		addNewInvestmentProjectDiv.hide();
		addNewInvestmentProjectDiv.slideToggle(300);
	}
	
	$("#selectedProjectId").val("");
}

function updateProject(item) {
	var addNewInvestmentProjectDiv = $("#addNewInvestmentProjectDiv");
	$("#addNewProjectFormHeader").hide();
	$("#editProjectFormHeader").show();
	$("#addNewProjectBtn").show(300);
	
	if (addNewInvestmentProjectDiv.css("display") == "none") {
		addNewInvestmentProjectDiv.slideToggle(300);
	} else {
		addNewInvestmentProjectDiv.hide();
		addNewInvestmentProjectDiv.slideToggle(300);
	}
	
	var projectId = $(item).parent().next().find("input._project_id").val();
	$("#selectedProjectId").val(projectId);
	
	$.ajax({
		sync: false,
		url: $("#investmentProject_LoadDetailURL").val(),
		data: {'selectedProjectId' : projectId},
		dataType: 'json',
		type: "POST",
		success: function(data) {
			var selectedProject = $.parseJSON(data.selectedProject);
			populateProjectDetailToEditForm(selectedProject);
		},
		error: function(response) {
			alert("error");
		}
	});
}

function populateProjectDetailToEditForm(selectedProject) {
	var portletNameSpace = $("#portletNameSpace").val();
	document.getElementsByName(portletNameSpace + "projectName")[0].value = selectedProject._project_name;
	document.getElementsByName(portletNameSpace + "totalInvestmentMin")[0].value = selectedProject._total_investment_min;
	document.getElementsByName(portletNameSpace + "totalInvestmentMax")[0].value = selectedProject._total_investment_max;
	document.getElementsByName("implementationLocation")[0].value = selectedProject._implementation_location;
	document.getElementsByName(portletNameSpace + "projectPurpose")[0].value = selectedProject._project_purpose;
	document.getElementsByName(portletNameSpace + "charterCapital")[0].value = selectedProject._charter_capital;
	document.getElementsByName(portletNameSpace + "technicalSpecifications")[0].value = selectedProject._technical_specifications;
	document.getElementsByName("competentOrganizationId")[0].value = selectedProject._competent_organization_id;
	document.getElementsByName("investmentFormId")[0].value = selectedProject._investment_form_id;
	document.getElementsByName("projectCategoryId")[0].value = selectedProject._project_category_id;	
	document.getElementsByName("currencyTypeId")[0].value = selectedProject._currency_type_id;
	document.getElementsByName("keyProject")[0].checked = selectedProject._key_project;
	document.getElementsByName(portletNameSpace + "startDay")[0].value = selectedProject.startDay;
	document.getElementsByName(portletNameSpace + "startMonth")[0].value = selectedProject.startMonth;
	document.getElementsByName(portletNameSpace + "startYear")[0].value = selectedProject.startYear;
	document.getElementsByName(portletNameSpace + "endDay")[0].value = selectedProject.endDay;
	document.getElementsByName(portletNameSpace + "endMonth")[0].value = selectedProject.endMonth;
	document.getElementsByName(portletNameSpace + "endYear")[0].value = selectedProject.endYear;
}

function clearForm(selectedProject) {
	var portletNameSpace = $("#portletNameSpace").val();
	document.getElementsByName(portletNameSpace + "projectName")[0].value = "";
	document.getElementsByName(portletNameSpace + "totalInvestmentMin")[0].value = "";
	document.getElementsByName(portletNameSpace + "totalInvestmentMax")[0].value = "";
	document.getElementsByName("implementationLocation")[0].value = "";
	document.getElementsByName(portletNameSpace + "projectPurpose")[0].value = "";
	document.getElementsByName(portletNameSpace + "charterCapital")[0].value = "";
	document.getElementsByName(portletNameSpace + "technicalSpecifications")[0].value = "";
	document.getElementsByName("competentOrganizationId")[0].value = "-1";
	document.getElementsByName("investmentFormId")[0].value = "-1";
	document.getElementsByName("projectCategoryId")[0].value = "-1";	
	document.getElementsByName("currencyTypeId")[0].value = "1";
	document.getElementsByName("keyProject")[0].checked = false;
	document.getElementsByName(portletNameSpace + "startDay")[0].value = "1";
	document.getElementsByName(portletNameSpace + "startMonth")[0].value = "0";
	document.getElementsByName(portletNameSpace + "startYear")[0].value = "1950";
	document.getElementsByName(portletNameSpace + "endDay")[0].value = "1";
	document.getElementsByName(portletNameSpace + "endMonth")[0].value = "0";
	document.getElementsByName(portletNameSpace + "endYear")[0].value = "1950";
}

function cancelProcess() {
	$("#addNewInvestmentProjectDiv").slideToggle(300);
	$("#addNewProjectBtn").show(300);
	$("#selectedProjectId").val("");
}

function callAjaxInvestmentProjectSearch() {
	var numPerPage = $("#investmentProjectTable_itemsPerPageInput").val();
	if (!isNumber(numPerPage)) {
		return;
	}
	$.ajax({
		sync: false,
		url: $("#investmentProjectTable_SearchURL").val(),
		data: $("#investmentProjectSearchForm").serialize(),
		dataType: 'json',
		type: "POST",
		success: function(data) {
			renderTable("investmentProjectTable", data, 1, "investmentProjectTable_curPageNum");
			$("#investmentProjectTable_questionList").val(data.items);
			$("#investmentProjectTable_answerList").val(data.answerList);
		},
		error: function(response) {
			alert("error");
		}
	});
}
