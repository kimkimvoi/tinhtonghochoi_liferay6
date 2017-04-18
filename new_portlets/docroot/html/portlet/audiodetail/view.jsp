<%@page import="com.fsoft.bn.domain.news.News"%>
<%@page import="com.liferay.portal.util.PortletKeys"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="com.liferay.portlet.polls.service.persistence.PollsQuestionUtil"%>
<%@page import="com.liferay.portlet.polls.service.PollsQuestionServiceWrapper"%>
<%@page import="com.liferay.portlet.polls.model.PollsQuestionModel"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portlet.polls.NoSuchChoiceException"%>
<%@page import="com.liferay.portlet.polls.DuplicateVoteException"%>
<%@page import="com.liferay.util.CookieUtil"%>
<%@page import="com.liferay.portlet.polls.NoSuchVoteException"%>
<%@page import="com.liferay.portlet.polls.service.PollsVoteLocalServiceUtil"%>
<%@page import="com.liferay.portlet.polls.service.PollsQuestionLocalServiceUtil"%>
<%@page import="com.liferay.portlet.polls.service.PollsQuestionLocalService"%>
<%@page import="com.liferay.portlet.polls.service.PollsQuestionServiceUtil"%>
<%@page import="com.liferay.portlet.polls.model.PollsChoice"%>
<%@page import="com.liferay.portlet.polls.model.PollsQuestion"%>
<%@include file="/html/portlet/news_detail/news-detail-init.jsp" %>
<%@include file="/html/common/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<script src="${pageContext.request.contextPath}/html/portlet/audioplayer/audioplayerengine/amazingaudioplayer.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/html/portlet/audiodetail/audioplayerengine/initaudioplayer-1.css">
<script src="${pageContext.request.contextPath}/html/portlet/audiodetail/audioplayerengine/initaudioplayer-1.js"></script>

<div id="fb-root"></div>
<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v2.0";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>
<script type="text/javascript">
	$(document).ready( function() {
		$('#voteButton').click( function(e) {
			handleVoteButton();
		});
		
		$('#showResultButton').click( function(e){
			if ($("#showResultButton").val() == '<%= LanguageUtil.get(pageContext, "portlet.newsdetails.button.displayresult") %>') {
				$("#showResultButton").val('<%= LanguageUtil.get(pageContext, "portlet.newsdetails.button.hideresult") %>');
				$("#vote_result_section").css("display", "");
			} else {
				$("#showResultButton").val('<%= LanguageUtil.get(pageContext, "portlet.newsdetails.button.displayresult") %>');
				$("#vote_result_section").css("display", "none");
			}
			
		});
		
		if ($("#question_choices_section") == null || $("#question_choices_section") == undefined 
				|| $("#question_choices_section").length == 0) {
			$("#vote_result_section").css("display", "");
		}
	});
	
	function handleVoteButton() {
		var url = $('#handleVoteAjaxActionURL').val();
		$.ajax({
			sync: false,
			url: url,
			data: $('#voteQuestionSection_form').serialize(),
			dataType: 'json',
			type: "POST",
			success: function(data) {
				$("#question_choices_section").css("display", "none");
				refreshResultSection(data);
			},
			error: function(response) {
			}
		});
	}
	
	function refreshResultSection(data) {
		var totalVotes = 0;
		var html = '';
		$.each(data, function(index, item) {
			html += '<div class="vote-choice-result">';
			html += '<div class="vote-choice-text">' + item.questionText + '</div>';
			html += '<div class="vote-choice-ChartContainer">' 
					+ '<div class="vote-choice-chart" style="width:' + item.percentage 
					+ '%"></div></div>';
			html += '<div class="vote-choice-statistic"><div class="vote-choice-percentage">' 
					 + item.percentage + '%</div>'
					 + '<div class="vote-choice-numberOfChoices">(' + item.numberOfChoices + ' phiếu)</div></div>';
			html += '</div>';
			
			totalVotes = item.totalVoteOfQuestions;
		});
		
		html += '<br /><div class="clear"></div>';
		html += '<div id="vote-result-numberOfVote">';
		html += '<strong>Tổng bình chọn: </strong>' + totalVotes + '</div>';
	
		$("#vote_result_section").html(html);
		$("#vote_result_section").css("display", "");
	}
</script>
<style>

.vote-choice-result {
    height: 22px;
    padding-bottom: 8px;
    padding-left: 20px;
}

.vote-choice-text {
    float: left;
    width: 260px;
}

.vote-choice-ChartContainer {
    border: 1px solid #A52A2A;
    float: left;
    margin-right: 20px;
    width: 200px;
}

.vote-choice-chart {
    background-color: #FF0000;
    height: 20px;
    top: auto;
}

.vote-choice-percentage {
    float: left;
    margin-right: 8px;
}

.vote-choice-numberOfChoices {
    float: left;
}
</style>

	<c:set var="req" value="${pageContext.request}" />
	<c:set var="baseURL" value="${req.scheme}://${req.serverName}:${req.serverPort}" />	
	<div class="box_news_detail">

	    <h2 class="title_tab">
	    	<label>
	    		<a href='#'>
					<liferay-ui:message key="${newsDetail.cateName}"></liferay-ui:message>
				</a>
			</label>
		</h2>		
		<div class="clear"></div>
			<div class="content_detail_news">
					<h1 class="title">${newsDetail.title}</h1>
					<div class="date_time2">
						<span class="song_info">
							<b>Tác giả: </b>${newsDetail.author} | <b><liferay-ui:message key="listen.count"/>: </b> ${newsDetail.viewCount} 
							| <a href="${newsDetail.source}" style="font-size: 11px;">Tải về</a>
						</span> 
					</div>
					<div id="amazingaudioplayer-1" style="display:block;position:relative;width:320px;height:auto;margin:0px auto 0px;">
				        <ul class="amazingaudioplayer-audios" style="display:none;">
				            <li data-artist="${newsDetail.author}" data-title="${newsDetail.title}" data-album="" data-info="" data-image="" data-duration="">
				                <div class="amazingaudioplayer-source" data-src="${newsDetail.source}" data-type="audio/mpeg" />
				            </li>
				        </ul>
				    </div>
					<div style="margin-top:5px;" class="fb-like" data-href="http://banmaischool.edu.vn/index.php" data-layout="standard" data-action="like" data-show-faces="false" data-share="true"></div>
			</div>
		<div class="clear"></div>
		<c:if test="${fn:length(lstOtherNews) gt 0}">
			<ul class='list list_audio'>
				<li class="title">
					<c:if test="${empty param.urlAuthor}">Pháp âm cùng chuyên mục:</c:if>
					<c:if test="${not empty param.urlAuthor}">Pháp âm cùng tác giả:</c:if>
				</li>
				<c:forEach items="${lstOtherNews}" var="news" varStatus="status">
						<c:if test="${newsDetail.id != news.id}">
							<li>
								<div class="text">
									<div class="title_img">
										<a href="${news.urlDetailAudio}">${news.title}</a>
									</div>
								</div>
								<div class="song_info">
								<span>Tác giả: <a href="${news.urlDetail}">${news.author}</a></span> |
								<span>Ngày đăng: ${news.createdDate}</span> |
								<span>Lượt nghe: ${news.viewCount}</span> | 
								<span><a href="${news.source}">Tải về</a></span>
								</div>
							</li>
						</c:if>
				</c:forEach>
			</ul>
		</c:if>
</div>