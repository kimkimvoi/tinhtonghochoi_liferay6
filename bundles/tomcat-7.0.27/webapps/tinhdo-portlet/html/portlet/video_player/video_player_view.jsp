<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@include file="/html/common/init.jsp" %>

<portlet:defineObjects />

<%-- <div id="main">
	<div id="content">
		<!--content-->
		<div class="content">
			<!--++detail video-->
			<div class="margin10">
				<h1 class="title"></h1>
				<video controls="controls">
					<source src="${pageContext.request.contextPath}/html/portlet/video_player/movie.mp4" type="video/mp4">
					<source src="${pageContext.request.contextPath}/html/portlet/video_player/movie.ogg" type="video/ogg">
					Your browser does not support the video tag
				</video>
			</div>
		</div>
	</div>
</div> --%>
<div class="box_bg">
	<h2 class="title_tab">
		<a href="/thu-vien-video"> <span><liferay-ui:message
					key="portlet.video_player.title" /></span>
		</a>
	</h2>
	<div class="clear"></div>
	<a class = "video-player-block" href="${urlFirst }" id="player">
	</a>
	
	<div class="clear"></div>
	<c:if test="${videoModels != null }">
		<ul class="list_link_video" id="list_link_video">
			<c:forEach items="${videoModels }" var="video">
				<li><a class="link_video_player" rel="${video.url}" href="">${video.title }</a></li>
			</c:forEach>
		</ul>
	</c:if>
</div>
<script type="text/javascript">
	$f("player","${pageContext.request.contextPath}/html/swf/flowplayer-3.2.16.swf",{
		clip:{
			autoPlay: false,
	        autoBuffering: false
	    },
	    plugins: { // load one or more plugins
	          controls: { // load the controls plugin
	              // always: where to find the Flash object
	              url: '${pageContext.request.contextPath}/html/swf/flowplayer.controls-3.2.15.swf',
	 
	              // now the custom options of the Flash object
	              playlist: false,
	              /* time : true, */
	              scrubber : false,
	              play: false,
	              tooltips: { // this plugin object exposes a 'tooltips' object
	                  buttons: false,
	                  fullscreen: 'Enter Fullscreen mode',
	              }
	          }
	      }
	});
	
	$(".link_video_player").click(function(){
		$f().play($(this).attr("rel"));
		return false;
	});
	
	$(function(){
		$f().onFullscreen(function(){
			console.log("onFullscreen");
			$f().getControls().css("scrubber", true);
		});
		$f().onFullscreenExit(function(){
			console.log("onFullscreenExit");
			$f().getControls().css("scrubber", false);
		});
	});
</script>

