<%@page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />
<script>
    var YoutubeChannelId = 'UCJVtBYcFaWKcmkwo8M-amPg';
    var Google_API_KEY = 'AIzaSyB-a53O4BkwULEPV4oxb92FEkIiRlQTqBk';
    var videoId;
    
      function init() {
        gapi.client.setApiKey(Google_API_KEY);
        gapi.client.load('youtube', 'v3').then(makeRequest);
      }
      
      
      function makeRequest() {
        var request = gapi.client.youtube.search.list({
            part: 'snippet',
            channelId: YoutubeChannelId,
            maxResults: 1,
            type: 'video',
            eventType: 'live'
            
        });
        
        request.then(function(response) {
          processResult(response);
        }, function(reason) {
          console.log('Error: ' + reason.result.error.message);
        });
        
      }
      
      function processResult(result){
        
        var json = JSON.parse(result.body);
        if(json.pageInfo.totalResults == 0){
        	document.getElementById('player').innerHTML = "Hiện tại không có video được phát trực tuyến. Hãy thử lại sau!" ;
        } else {
        	videoId = json.items[0].id.videoId;
        	$("#liveVideoLabel").html('<strong><a href="https://www.youtube.com/user/chuatanvien/live">' + json.items[0].snippet.title + '</a></strong>');
        	createIframe();    
        }
        
      }
      
            
      /*****************************CREATING IFRAME*********************************/
      
      function createIframe(){
      // This code loads the IFrame Player API code asynchronously.
      var tag = document.createElement('script');
      tag.src = "https://www.youtube.com/iframe_api";
      var firstScriptTag = document.getElementsByTagName('script')[0];
      firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);
      }
      
      // This function creates an <iframe> (and YouTube player)
      //    after the API code downloads.
      var player;
      function onYouTubeIframeAPIReady() {
        player = new YT.Player('player', {
          height: '180',
          width: '320',
          videoId: videoId,
          events: {
            'onReady': onPlayerReady,
          }
        });
      }
      
            // 4. The API will call this function when the video player is ready.
      function onPlayerReady(event) {
        event.target.playVideo();
      }
      
      
    </script>
    <script src="https://apis.google.com/js/client.js?onload=init"></script>
<div class="box_bg" >
	<h2 class="title_tab">
		<label>Trực Tuyến</label>
	</h2>
	<div>
		<p id="liveVideoLabel"></p>
		<div id="player"></div>
	</div>
</div>
