jQuery(document).ready(function() {
	$("#video_gallery_btn_back" ).click(function() {
		$("#video_player_warraper").hide('slow');
		$("#video_gallery_btn_back").hide('slow');
	});
});
function clickViewVideo(url,title) {
	$("#video_player_warraper").show('slow');
	$("#video_gallery_btn_back").show('slow');
	$('#video_player').attr('src',url);
	$f().play(url);
	$('#title_video').html(title);
}
function renderTableFolder(data, cssSelector) {
	var html = ''; 
	if(data.items != undefined && data.items.length > 0) {
		for(var i = 0 ; i < data.items.length > 0 ; i++) {
			html += generateHTMLTemplateFolder(data.items[i]);
		}
	}
	$(cssSelector).html(html);
}
function renderTableVideo(data, cssSelector) {
	var html = ""; 
	if(data.items != undefined && data.items.length > 0) {
		for(var i = 0 ; i < data.items.length > 0 ; i++) {
			html += generateHTMLTemplateVideo(data.items[i]);
		}
	}
	$(cssSelector).html(html);
}
function generateHTMLTemplateFolder(video) {
	var html ='';
	html += '<li>'
		+ '<div class="photo" onclick="viewDetailFolder(\''+video.url+'\')">';
	if(video.imageThumb != undefined) {
		html += '<a href="'+video.url+'" >'
		+ '<img src="'+video.imageThumb.url+'">'
		+  '</a>'
		+	'<div class="bg_folder_video"></div>';
	} else {
		html += '<a href="'+video.url+'" >'
		+ 	'<img src="'+getContextPath()+'/html/images/no_images.jpg">'
		+  '</a>';
	}
	html 	+='</div>'
		+ '<p>'
		+	'<a href="javascript:void(0);" onclick="viewDetailFolder(\''+video.url+'\')">'
		+		video.name
		+   '</a>'
		+ '</p>'
		+	'</li>';
	return html;
}
function generateHTMLTemplateVideo(video) {
	return "<div class=\"thumb_video\" onclick=\"clickViewVideo('"+video.url+"','"+video.title+"')\">"
	+ "<img src=\""+video.imageThums+"\"><div class=\"bgvideo\"></div>"
	+ "<h3 class=\"title\"> " + video.title+"</h3></div>";
}
function getContextPath() {
	   return $('#CONTEXT_PATH').val();
}

