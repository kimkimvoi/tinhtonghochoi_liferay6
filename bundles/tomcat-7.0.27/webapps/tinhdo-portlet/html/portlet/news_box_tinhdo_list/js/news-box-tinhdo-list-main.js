function renderTable(tableId, data, pageNum, curPageId) {
	var items = $.parseJSON(data.items);
	var numOfPage = data.numOfPage;
	var html = ''; 
	if(items != undefined && items.length > 0) {
		for(var i = 0 ; i < items.length > 0 ; i++) {
			html += '<li><a href="/ban-doc-viet-ve-bac-ninh?mode=detail&id='+items[i].id+'"><img class="photo" src="'+items[i].picture+'" >'
				+ '<div class="tex_list"><div class="title_v">'
				+ '<a href="/ban-doc-viet-ve-bac-ninh?mode=detail&id='+items[i].id+'">'+items[i].title+'</a>'
				+ '<div class="content_small">'+items[i].description+'</div>'
				+ '</div></div></li>';
		}
	}
	$('#writingAbouttinhdoUl').html(html);
	var curPageTextId = tableId + "_curPageText";
	$("#" + curPageId).val(pageNum);
	$("span#" + curPageTextId).html(pageNum, curPageId);
	renderPaginator(tableId, numOfPage, curPageId);
}