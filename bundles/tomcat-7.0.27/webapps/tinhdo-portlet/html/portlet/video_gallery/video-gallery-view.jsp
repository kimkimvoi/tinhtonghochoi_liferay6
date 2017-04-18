<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@include file="/html/common/init.jsp"%>
<%@ taglib prefix="cus" uri="/WEB-INF/tld/custom-tags.tld"%>
<%@page contentType="text/html;charset=UTF-8"%>
<script type="text/javascript">
function viewDetailFolder(url) {
	location.href = url;
}
</script>
<portlet:defineObjects />
<div class="box_bg">
	<div>
		<h2 class="title_tab">
			<c:if test="${viewMode == 'listVideo'}">
				<label><a href="/thu-vien-video">Thư Viện Video</a> &#9658; ${folderName}</label>
			</c:if>
			<c:if test="${viewMode != 'listVideo'}">
				<label>Thư Viện Video</label>
			</c:if>
		</h2>
	</div>
	<div class="clear"></div>
	<div id="video_player_warraper" style="display: none;">
		<span id="title_video" class="title" ></span>
		<a class = "video-player-block" href="#" id="player_video">
		</a>
		<hr style="border-style: dotted;"/>
	</div>
	<c:if test="${viewMode == 'listVideo'}">
		<div id="videoTable" >
			<!-- content ajax load data -->
		</div>
		<%-- paging --%>
		<portlet:resourceURL var="getListVideo" escapeXml="false" id="getListVideo" />	
		<tag:paging loadPageURL="${renderResponse.encodeURL(getListVideo.toString())}" pageWrapperCSSSelector="#videoTable" renderPageJsFunction="renderTableVideo"></tag:paging>
		<span class="back_btn"><a href="/thu-vien-video">Back</a></span>
	</c:if>
	<c:if test="${viewMode != 'listVideo'}">
		<div class="sub_folders" id="folder_list_container">
			<ul class="list_photo" id="folder_list">
				<!-- content ajax load data -->
			</ul>
		</div>
		<%-- paging --%>
		<portlet:resourceURL var="getListFolder" escapeXml="false" id="getListFolder" />	
		<tag:paging loadPageURL="${renderResponse.encodeURL(getListFolder.toString())}" pageWrapperCSSSelector="#folder_list" renderPageJsFunction="renderTableFolder"></tag:paging>
	</c:if>
</div>
<input type="hidden" id="CONTEXT_PATH" value="${pageContext.request.contextPath}"/>
<script type="text/javascript">
	$f("player_video","${pageContext.request.contextPath}/html/swf/flowplayer-3.2.16.swf",{
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
