function searchButtonClick(url){
	var contentSearch = $("#searchStaffInfo-contentSearchId").val();
	var typeSearch = $("#searchStaffInfo-typeSearchId").val();
	var organizations = $("#searchStaffInfo-organizationsId").val();
	$.ajax({	
		url : url,
		data : {contentSearch : contentSearch, typeSearch : typeSearch, organizations : organizations},
		type: 'POST',
		dataType : "json",
		success : function(data) {
			alert("data : " + data);
		},
		error : function(data) {
			alert("error");
		}
	});
};

function searchButtonClick(url){
	var tableId = "resultSearchStaffTable";
	var numPerPage = $("#"+ tableId + "_itemsPerPageInput").val();
	if (!isNumber(numPerPage)) {
		return;
	}
	var contentSearch = $("#searchStaffInfo-contentSearchId").val();
	var typeSearch = $("#searchStaffInfo-typeSearchId").val();
	var organizations = $("#searchStaffInfo-organizationsId").val();
	$.ajax({	
		url : url,
		data : {'numPerPage':numPerPage, contentSearch : contentSearch, typeSearch : typeSearch, 
			organizations : organizations},
		type: 'POST',
		dataType : "json",
		success : function(data) {
			renderTable(tableId, data, 1, "resultSearchStaffTable_curPageId");
			$("#button-searchId").blur();
		},
		error : function(data) {
			alert("error");
		}
	});
}

/*function setTypeSearchOption(typeSearch){
	$("#searchStaffInfo-typeSearchId option").each(function(){
		var value = this.getAttribute("value");
		if(value == typeSearch){
			this.setAttribute("selected", true);
		}
	});
}

function setOrganizationsSearchOption(organizations){
	$("#searchStaffInfo-organizationsId option").each(function(){
		var value = this.getAttribute("value");
		if(value == organizations){
			this.setAttribute("selected", true);
		}
	});
}

$(function(){
	var typeSearch = $("#typeSearch-hidden").val();
	var organizations = $("#organizationsSearch-hidden").val();
	setTypeSearchOption(typeSearch);
	setOrganizationsSearchOption(organizations);
});*/
