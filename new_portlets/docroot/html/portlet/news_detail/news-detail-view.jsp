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

<input id="printPageURL" type="hidden" value="${printPageURL}" />
<c:choose>
<c:when test="${print}">
	<div class="content_detail_news">
			<h1 class="title">${newsDetail.title}</h1>
			<div class="date_time">
				<span>${newsDetail.createdDate}</span>
				<a class="icon_print" title="Print" href="javascript:printArticle()"></a>
			</div>
			<div class="supdetail">${newsDetail.summary}</div>
			<div class="textdetail">
				${newsDetail.content}
			</div>	
			<div class="author">
				${newsDetail.author}
			</div>
			<c:if test="${newsDetail.source != null && newsDetail.source != ''}">
				<div class="source">
					<span> <liferay-ui:message key="source" />: ${newsDetail.source}</span> 
				</div>	
			</c:if>
	</div>
	<div class="clear"></div>

</c:when>
<c:otherwise>
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
					<div class="date_time">
						<span>${newsDetail.createdDate}&nbsp; 
							<liferay-ui:message key="view.count"/>: ${newsDetail.viewCount}
						</span> 
						<a class="icon_print" title="<liferay-ui:message key="print" />" href="javascript:<portlet:namespace />printPage();"></a>
					</div>
					<div class="supdetail">${newsDetail.summary}</div>
					<div class="textdetail">
						${newsDetail.content}
					</div>	
					<div class="author">
						${newsDetail.author}
					</div>
					<c:if test="${newsDetail.source != null && newsDetail.source != ''}">
						<div class="source">
							<span> <liferay-ui:message key="source" />: ${newsDetail.source}</span> 
						</div>	
					</c:if>
					<liferay-util:html-top>
						<meta property="og:title" content="${newsDetail.title}"/>
						<meta property="og:type" content="article"/>
						<meta property="og:url" content="${newsDetail.urlDetail}"/>
						<meta property="og:image" content="${newsDetail.imageURL}"/>
						<meta property="og:site_name" content="tinhtonghochoi.vn"/>
						<meta property="og:description" content="${newsDetail.summary}"/>
					</liferay-util:html-top>
			</div>
		<div class="clear"></div>
		<div style="margin-top:5px;" class="fb-like" data-href="${newsDetail.urlDetail}" data-layout="standard" data-action="like" data-show-faces="false" data-share="true"></div>
		<div class="fb-comments" data-href="${newsDetail.urlDetail}"  data-width="650" data-numposts="5" data-colorscheme="light"></div>
		<c:if test="${fn:length(lstOtherNews) gt 0}">
			<ul class="list_detail">
				<li class="title"><liferay-ui:message key="portlet.newsdetail.othersnews" /></li>
				<c:forEach items="${lstOtherNews}" var="news" varStatus="status">
					<c:if test="${status.index < quanOtherNewsShow}">
						<li><a href="${news.urlDetail}"> ${news.title} (${news.createdDate}) </a></li>
					</c:if>
				</c:forEach>
			</ul>
		</c:if>
</div>

</c:otherwise>

</c:choose>

<%
	PollsQuestion question = (PollsQuestion)request.getAttribute("pollsQuestion");
%>
<c:if test="<%= question != null %>">
	<%
	String redirect = StringPool.BLANK;
	question = question.toEscapedModel();

	List<PollsChoice> choices = question.getChoices();
	boolean hasVoted = false;
	
	if (themeDisplay.isSignedIn()) {
		try {
			PollsVoteLocalServiceUtil.getVote(
				question.getQuestionId(), themeDisplay.getUserId());
		}
		catch (NoSuchVoteException nsve) {
			
		}

		hasVoted = true;
	} else {
		String cookieName = PollsQuestion.class.getName() + StringPool.POUND + question.getQuestionId();
		String cookie = CookieUtil.get(request, cookieName);
	
		hasVoted = GetterUtil.getBoolean(cookie);
	}
	%>
	<div class="vote_section">
	<%= StringUtil.replace(question.getDescription(locale), StringPool.NEW_LINE, "<br />") %>
	
	<c:if test="<%= !question.isExpired() && !hasVoted%>">
		<portlet:resourceURL escapeXml="false" id="handleVoteAjaxAction" var="handleVoteAjaxAction" />
		<input id="handleVoteAjaxActionURL" type="hidden" value="<%= renderResponse.encodeURL(handleVoteAjaxAction.toString()) %>" />
		
		<form id="voteQuestionSection_form">
			<input id="voteQuestionId" name="questionId" type="hidden" value="<%= question.getQuestionId() %>" />
			<input id="voteSuccessMessage" name="successMessage" type="hidden" value='<%= LanguageUtil.get(pageContext, "thank-you-for-your-vote") %>' />
			<input id="voteDuplicateErrorMsg" type="hidden" value='<%= LanguageUtil.get(pageContext, "you-may-only-vote-once") %>' />
			<input id="voteNoOptionSelectedErrorMsg" type="hidden" value='<%= LanguageUtil.get(pageContext, "please-select-an-option") %>' />
			<div id="question_choices_section">
					<%
					for (PollsChoice choice : choices) {
						choice = choice.toEscapedModel();
						String choiceElementId = "choiceId_" + choices.indexOf(choice);
					%>
						<div class="question_choice">
							<input id="<%=choiceElementId%>" name="choiceId" type="radio" value="<%= choice.getChoiceId() %>" />
							<label for="<%=choiceElementId%>"><%= "<strong>" + choice.getName() + ".</strong> " + choice.getDescription(locale) %></label>
						</div>
					<%
					}
					%>
				
				<input id="voteButton" type="button" value='<%= LanguageUtil.get(pageContext, "portlet.newsdetails.button.vote") %>' />
				<input id="showResultButton" type="button" value='<%= LanguageUtil.get(pageContext, "portlet.newsdetails.button.displayresult") %>' />
			</div>
		</form>
	</c:if>
	
	<div id="vote_result_section" style="display:none;">
		<%
		NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);
		NumberFormat percentFormat = NumberFormat.getPercentInstance(locale);		
		int totalVotes = question.getVotesCount();
		
		for (int i = 0; i < choices.size(); i++) {
			PollsChoice choice = (PollsChoice)choices.get(i);
		
			choice = choice.toEscapedModel();
		
			int choiceVotes = choice.getVotesCount();
		
			double votesPercent = 0.0;
		
			if (totalVotes > 0) {
				votesPercent = (double)choiceVotes / totalVotes;
			}
		
			int votesPixelWidth = 35;
		
			/* if (windowState.equals(WindowState.MAXIMIZED)) {
				votesPixelWidth = 100;
			} */
		
			int votesPercentWidth = (int)Math.floor(votesPercent * 100);
		%>
		
		<div class="vote-choice-result">
			<div class="vote-choice-text">
				<%= choice.getDescription(locale) %>
			</div>
			<div class="vote-choice-ChartContainer">
				<div class="vote-choice-chart"  style="width: <%= votesPercentWidth %>%;">
				
				</div>				
			</div>
			
			<div class="vote-choice-statistic">
				<div class="vote-choice-percentage"><%= votesPercentWidth %>%</div>
				<div class="vote-choice-numberOfChoices">(<%= numberFormat.format(choiceVotes) %> phiếu)</div>
			</div>
		</div>
		<%
		}
		%>
		
		<br />
		<div class="clear"></div>
		<div id="vote-result-numberOfVote">
			<strong><liferay-ui:message key="total-votes" />:</strong> <%= numberFormat.format(totalVotes) %>
		</div>				
	</div>
	</div>
</c:if>

<script type="text/javascript">
	function printArticle() {
		print();
	}
	
	var printPageURL = $('#printPageURL').val();
	function <portlet:namespace />printPage() {
		expandingWindow(printPageURL);
		//window.open(printPageURL, '', "directories=0,height=480,left=80,location=1,menubar=1,resizable=1,scrollbars=yes,status=0,toolbar=0,top=180,width=640");
	}
</script>