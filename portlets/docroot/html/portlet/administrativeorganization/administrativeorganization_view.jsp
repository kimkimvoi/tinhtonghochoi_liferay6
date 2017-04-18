<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@include file="/html/common/init.jsp" %>
<%@page contentType="text/html;charset=UTF-8"%>

<portlet:defineObjects />

<div class="administrative_organization_portlet" id="tabs_administativeOganization">
	<div class="administrative_organization_portlet_wapper">
		<ul class="tab_box_mn">
			<li class=""><a href="#tabs_tinhuy"><liferay-ui:message key="portlet.administrative.organization.tab.title.tinhuy"/></a></li>
			<li><a href="#tabs_hoidongnhandan"><liferay-ui:message key="portlet.administrative.organization.tab.title.hoidongnhandan"/></a></li>
			<li><a href="#tabs_uybannhandan"><liferay-ui:message key="portlet.administrative.organization.tab.title.uybannhandan"/></a></li>
			<li><a href="#tab_sobannganh"><liferay-ui:message key="portlet.administrative.organization.tab.title.sobannganh"/></a></li>
			<li><a href="#tab_huyenthithanh"><liferay-ui:message key="portlet.administrative.organization.tab.title.huyenthithanh"/></a></li>
		</ul>
		<div class="clear"></div>
		<div>
			<div id="tabs_tinhuy">
				<div class="padding_left">
					<h4 class="title_h4"><liferay-ui:message key="portlet.administrative.organization.introduce.title"/></h4>
					<c:if test="${tinhUyIntroduce != null }">
						<div class="box_article_content">
							<a href="${tinhUyIntroduce.urlDetail}">
								<img class="photo" src="${tinhUyIntroduce.imageURL}">
							</a>
							<div class="text">
									${tinhUyIntroduce.contentDescription}
							</div>
						</div>
						<a class="link_more" href="${tinhUyIntroduce.urlDetail}"><liferay-ui:message key="common.link.view.detail"/></a>
						<div class="clear"></div>
					</c:if>
					<!-- functional and task -->
					<h4 class="title_h4"><liferay-ui:message key="portlet.administrative.organization.functionsandtasks.title"/></h4>
					<c:if test="${tinhUyFunctional != null }">
						<div class="box_article_content">
							<a href="${tinhUyFunctional.urlDetail}">
								<img class="photo" src="${tinhUyFunctional.imageURL}">
							</a>
							<div class="text">
									${tinhUyFunctional.contentDescription}
							</div>
						</div>
						<a class="link_more" href="${tinhUyFunctional.urlDetail}"><liferay-ui:message key="common.link.view.detail"/></a>
						<div class="clear"></div>
					</c:if>
					<!--administrative organization -->
					<h4 class="title_h4"><liferay-ui:message key="portlet.administrative.organization.administative.title"/></h4>
					<div class="box_list_article_content">
						<ul class="list_new">
							<c:if test="${listAdminOrganizationPage != null}">
								<c:forEach items="${listAdminOrganizationPage}" var="itemArticle">
									<li>
										<a href="${itemArticle.urlDetail}">
		                                    <img class="photo" style="margin-left: 0px;" src="${itemArticle.imageURL}">
		                                </a>
		                                <div class="text">
		                                    <div class="title_v">
		                                    	<a href="${itemArticle.urlDetail}">${itemArticle.title}</a>
		                                    </div>
		                                    <div class="content_small">
		                                    	${itemArticle.contentDescription}  
		                                    </div>
		                                </div>
									</li>
								</c:forEach>
							</c:if>
						</ul>
						<c:if test="${listAdminOrganizationPage.size() >=3}">
							<portlet:actionURL var="categoryTinhUy">
								<portlet:param name="cateTypeTinhUy" value="${tinhUyFunctional.organizationName}" />
							</portlet:actionURL>
							<a class="link_more" href="${categoryTinhUy}"><liferay-ui:message key="common.link.view.all"/></a>
						</c:if>
					</div>
				</div>
			</div>
			<div id="tabs_hoidongnhandan">
				<div class="padding_left">
					<h4 class="title_h4"><liferay-ui:message key="portlet.administrative.organization.introduce.title"/></h4>
					<c:if test="${hoidongIntroduce != null }">
						<div class="box_article_content">
							<a href="${hoidongIntroduce.urlDetail}">
								<img class="photo" src="${hoidongIntroduce.imageURL}">
							</a>
							<div class="text">
									${hoidongIntroduce.contentDescription}
							</div>
						</div>
						<a class="link_more" href="${hoidongIntroduce.urlDetail}"><liferay-ui:message key="common.link.view.detail"/></a>
						<div class="clear"></div>
					</c:if>
					<!-- functional and task -->
					<h4 class="title_h4"><liferay-ui:message key="portlet.administrative.organization.functionsandtasks.title"/></h4>
					<c:if test="${hoiDongFunctional != null }">
						<div class="box_article_content">
							<a href="${hoiDongFunctional.urlDetail}">
								<img class="photo" src="${hoiDongFunctional.imageURL}">
							</a>
							<div class="text">
									${hoiDongFunctional.contentDescription}
							</div>
						</div>
						<a class="link_more" href="${hoiDongFunctional.urlDetail}"><liferay-ui:message key="common.link.view.detail"/></a>
						<div class="clear"></div>
					</c:if>
					<!--administrative organization -->
					<h4 class="title_h4"><liferay-ui:message key="portlet.administrative.organization.administative.title"/></h4>
					<div class="box_list_article_content">
						<ul class="list_new">
							<c:if test="${hoiDongBoMay != null}">
								<c:forEach items="${hoiDongBoMay}" var="itemArticle">
									<li>
										<a href="${itemArticle.urlDetail}">
		                                    <img class="photo" style="margin-left: 0px;" src="${itemArticle.imageURL}">
		                                </a>
		                                <div class="text">
		                                    <div class="title_v">
		                                    	<a href="${itemArticle.urlDetail}">${itemArticle.title}</a>
		                                    </div>
		                                    <div class="content_small">
		                                    	${itemArticle.contentDescription}  
		                                    </div>
		                                </div>
									</li>
								</c:forEach>
							</c:if>
						</ul>
						<c:if test="${hoiDongBoMay.size() >=3}">
							<portlet:actionURL var="cateTypeHoiDongNhanDan">
								<portlet:param name="cateTypeHoiDongNhanDan" value="${hoiDongFunctional.organizationName}" />
							</portlet:actionURL>
							<a class="link_more" href="${cateTypeHoiDongNhanDan}"><liferay-ui:message key="common.link.view.all"/></a>
						</c:if>
					</div>
				</div>
			</div>
			<div id="tabs_uybannhandan">
				<div class="padding_left">
					<h4 class="title_h4"><liferay-ui:message key="portlet.administrative.organization.introduce.title"/></h4>
					<c:if test="${uybanIntroduce != null }">
						<div class="box_article_content">
							<a href="${uybanIntroduce.urlDetail}">
								<img class="photo" src="${uybanIntroduce.imageURL}">
							</a>
							<div class="text">
									${uybanIntroduce.contentDescription}
							</div>
						</div>
						<a class="link_more" href="${uybanIntroduce.urlDetail}"><liferay-ui:message key="common.link.view.detail"/></a>
						<div class="clear"></div>
					</c:if>
					<!-- functional and task -->
					<h4 class="title_h4"><liferay-ui:message key="portlet.administrative.organization.functionsandtasks.title"/></h4>
					<c:if test="${uybanFunctional != null }">
						<div class="box_article_content">
							<a href="${uybanFunctional.urlDetail}">
								<img class="photo" src="${uybanFunctional.imageURL}">
							</a>
							<div class="text">
									${uybanFunctional.contentDescription}
							</div>
						</div>
						<a class="link_more" href="${uybanFunctional.urlDetail}"><liferay-ui:message key="common.link.view.detail"/></a>
						<div class="clear"></div>
					</c:if>
					<!--administrative organization -->
					<h4 class="title_h4"><liferay-ui:message key="portlet.administrative.organization.administative.title"/></h4>
					<div class="box_list_article_content">
						<ul class="list_new">
							<c:if test="${uyBanBoMay != null}">
								<c:forEach items="${uyBanBoMay}" var="itemArticle">
									<li>
										<a href="${itemArticle.urlDetail}">
		                                    <img class="photo" style="margin-left: 0px;" src="${itemArticle.imageURL}">
		                                </a>
		                                <div class="text">
		                                    <div class="title_v">
		                                    	<a href="${itemArticle.urlDetail}">${itemArticle.title}</a>
		                                    </div>
		                                    <div class="content_small">
		                                    	${itemArticle.contentDescription}  
		                                    </div>
		                                </div>
									</li>
								</c:forEach>
							</c:if>
						</ul>
						<c:if test="${uyBanBoMay.size() >=3}">
							<portlet:actionURL var="cateTypeUyBanNhanDan">
								<portlet:param name="cateTypeUyBanNhanDan" value="${uybanFunctional.organizationName}" />
							</portlet:actionURL>
							<a class="link_more" href="${cateTypeUyBanNhanDan}"><liferay-ui:message key="common.link.view.all"/></a>
						</c:if>
					</div>
				</div>
			</div>
			<div id="tab_sobannganh">
				<div class="padding_left">
					<c:forEach items="${listSoBanNganh}" varStatus="sts"  var="link">
						<c:if test="${sts.index%10==0}">
							<ul class="list_sbn">
						</c:if>
							<li><a target="_blank" href="${link.url}">${link.title}</a></li>
						<c:if test="${sts.index%10==9}">
							</ul>
						</c:if>
					</c:forEach>
				</div>
			</div>
			<div id="tab_huyenthithanh" class="padding_left">
				<div class="padding_left">
					<c:forEach items="${listHuyenThiThanh}" varStatus="sts"  var="link">
						<c:if test="${sts.index%10==0}">
							<ul class="list_sbn">
						</c:if>
							<li><a target="_blank" href="${link.url}">${link.title}</a></li>
						<c:if test="${sts.index%10==9}">
							</ul>
						</c:if>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</div>
