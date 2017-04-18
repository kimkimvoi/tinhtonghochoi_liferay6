<%@include file="/html/common/init.jsp"%>
<div class="box_cdtu">

	<div class="box_one_option">
		<h2 class="title_tab">
			<span><liferay-ui:message key="portlet.analytic.title" /></span>
		</h2>
		<div class="content_small">
			<c:if test="${analyticViewModes.size() == 0}">
				<span><liferay-ui:message key="portlet.analytic.message" /></span>
			</c:if>
				<a class="analytic_data" href="#">${analyticViewMode.solieu}</a>
			${analyticViewMode.content}
			<div class="box_multi_option">
					<c:forEach items="${list}" var="item">
						<ul>
							<li>${item.solieu}&nbsp;${item.content}</li>
						</ul>
					</c:forEach>
				</div>
		</div>
	</div>
</div>
<div class="clear" style="clear: both;"></div>