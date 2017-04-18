var tableId = "resultSearchPublicNewsTable";
function searchPublicNewsAjax(url){
	var numPerPage = $("#"+ tableId + "_itemsPerPageInput").val();
	if (!isNumber(numPerPage)) {
		return;
	}
	
	/*var contentPublicNews = $("#contentPublicNews").val();*/
	var numberPublicNews = $("#numberPublicNews").val();
	var keyPublicNews = $("#keyPublicNews").val();
	var yearPublish = $("#yearPublish").val();
	var signer = $("#signer").val();
	var typePublicNews = $("#typePublicNews").val();
	var fieldsPublicNews = $("#fieldsPublicNews").val();
	var quote = $("#quote").val();
	var publisher = $("#publisher").val();
	$.ajax({	
		url : url,
		data : {'numPerPage':numPerPage, numberPublicNews : numberPublicNews, keyPublicNews : keyPublicNews, 
			yearPublish : yearPublish, signer : signer,
			typePublicNews : typePublicNews, fieldsPublicNews : fieldsPublicNews,
			quote : quote, publisher : publisher},
		type: 'POST',
		dataType : "json",
		success : function(data) {
			renderTable(tableId, data, 1, "resultSearchPublicNewsTable_curPageId");
			$("#public_new_details").hide();
			$("#publicnews_button_search").blur();
		},
		error : function(data) {
			alert("error");
		}
	});
}

$(function() {
	$("#resultSearchPublicNewsTable tr").click(function(){
		var idElement = $(this).find("input[class='id']");
		if($(this).hasClass("dataRow")){
			var id = idElement.val();
			var url = $("#getDetailsPublicNewsAjax_Url").val();
			getDetailsPublicNewsAjax(id, url);
		}
	});
});

function resultSearchPublicNewsTable_onClick(row){
	var idElement = $(row).find("input[class='id']");
	if(idElement != undefined){
		var id = idElement.val();
		var url = $("#getDetailsPublicNewsAjax_Url").val();
		getDetailsPublicNewsAjax(id, url);
	}
};


function getDetailsPublicNewsAjax(id, url){
	$.ajax({	
		url : url,
		data : {'public_news_id' : id},
		type: 'POST',
		dataType : "json",
		success : function(data) {
			var publicNews = data.publicNews;
			renderDetailPublicNewsData(JSON.parse(publicNews));
			/*$("#public_new_details").show();*/
			if("none" == $("#public_new_details").css("display")){
				$("#public_new_details").slideToggle(500);
			}
		},
		error : function(data) {
			alert("error");
		}
	});
}

function renderDetailPublicNewsData(publicNews){
	$("#details_number").html(publicNews.number);
	$("#details_publisher").html(publicNews.publisher);
	$("#details_key").html(publicNews.key);
	$("#details_publisher_date").html(publicNews.publisher_date);
	$("#details_effect_date").html(publicNews.effect_date);
	$("#details_signer").html(publicNews.signer);
	$("#details_type").html(publicNews.type);
	$("#details_fields").html(publicNews.fields);
	$("#details_quote").html(publicNews.quote);
	$("#details_title").html(publicNews.title);
	
	var attachArray =  publicNews.attachUrlList;
	var attachhtml = "";
	for(var i = 0; i < attachArray.length; i++){
		attachhtml += "<a href='" + attachArray[i] +"'><div class='file_attach_icon'></div></a>";
	}
	$("#details_file_attach").html(attachhtml);
}

function searchKeyPress(e) {
    if (e.keyCode == 13) {
    	e.preventDefault();
        $('#publicnews_button_search').click();
    }
}