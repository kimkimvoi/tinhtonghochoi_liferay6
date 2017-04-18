function renderTable(tableId, data, pageNum, curPageId) {
	var items = $.parseJSON(data.items);
	var numOfPage = data.numOfPage;
	var html = "";
	if(items != undefined && items.length > 0) {
		for(var i = 0 ; i < items.length > 0 ; i++) {
			html += "<ul class=\"list_new\">" +
					"<li><div class=\"text\"><div class=\"title_v\">" +
					"<a href=\" " + items[i].detailUrl + "  \">" +
						items[i].title +
					"</a></div>" +
					"<div class=\"content_small\">" +
					items[i].summary +
					"</div>" +
					"</div></li></ul>";
		}
	}
	$('#listMaketInfoContent').html(html);
	
	var curPageTextId = tableId + "_curPageText";
	$("#" + curPageId).val(pageNum);
	$("span#" + curPageTextId).html(pageNum, curPageId);
	renderPaginator(tableId, numOfPage, curPageId);
	
}

function clickDetailMarketInfo(newsID){
	var url = $("#resouceMarketUrl").val();
	console.log("url: " + url);
	callAjaxGetDetail(newsID, url);
}

function callAjaxGetDetail(newsID, url) {
	$.ajax({
		sync: false,
		url: url,
		data: {'newsID':newsID},
		dataType: 'json',
		type: "POST",
		success: function(data) {
			renderView(data);
		},
		error: function(response) {
			alert("error");
		}
	});
}
