<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="cus" uri="/WEB-INF/tld/custom-tags.tld"%>
<%@include file="/html/common/init.jsp"%>
<portlet:defineObjects />
<portlet:actionURL name="addNewQuestion" var="addNewQuestionUrl" />
<input type="hidden" value="${result}" id="result"/>
<aui:form action="${addNewQuestionUrl}" method="POST" enctype="multipart/form-data"
	name="frmQuestionSubmit" id="quesitonSumitFrm">
	
	<!--start content-->
	<div class="content_header" >
		<h2 class="title_tab">
			<label><liferay-ui:message key="portlet.questionsubmit.title" /></label>
		</h2>
	</div>
	<div id="img_question_submit"><img src="${pageContext.request.contextPath}/html/images/<liferay-ui:message key="portlet.questionsubmit.image" />" /></div>
	<div class="box_bg" id="content_submit_question" style="display: none;">
		<liferay-ui:error key="name-is-required" message="portlet.questionsubmit.notice1"></liferay-ui:error>  
		<liferay-ui:error key="age-is-required" message="portlet.questionsubmit.notice1"></liferay-ui:error>  
		<liferay-ui:error key="email-is-required" message="portlet.questionsubmit.notice1"></liferay-ui:error> 
		<div style="display:none" id="MSG_SUCCESS" class="portlet-msg-success"><liferay-ui:message key="common.msg.success" /></div>
		<div style="display:none" id="MSG_ERROR" class="portlet-msg-error"><liferay-ui:message key="common.msg.error" /></div>
		<div style="display:none" id="MSG_INVALID_CAPTCHA" class="portlet-msg-error"><liferay-ui:message key="portlet.questionsubmit.error.captcha" /></div>
		<div class="clear"></div>
		<ul class="list_question">
			<li class="note"><liferay-ui:message key="portlet.questionsubmit.notice1" />: (<span class="red">*</span>) 
			<liferay-ui:message key="portlet.questionsubmit.notice2" />
			</li>
			<li>
				<div class="rowa">
					<label><liferay-ui:message key="portlet.questionsubmit.citizenname" />: (<span class="red">*</span>) </label>
						<aui:input cssClass="input_question" name="citizenName"  label="" maxlength="255" value="${questionModel.citizenName}">
	        				<aui:validator errorMessage="portlet.common.validator.required" name="required" />
	        				<aui:validator name="maxLength">'255'</aui:validator>
	        				<aui:validator  name="custom"  errorMessage="portlet.common.validator.name" >
								function (val, fieldNode, ruleValue) {
									var result = true;
									if(val.match(/[0-9]/g) ) {
										result = false;
									}
									return result;
								}
							</aui:validator>
	       				</aui:input>
				</div>
				<div class="rowb">
					<label><liferay-ui:message key="portlet.questionsubmit.citizenaddress" />: (<span class="red">*</span>)
						<aui:input name="citizenAddress"  label="" maxlength="1024" value="${questionModel.citizenAddress}">
	        				<aui:validator errorMessage="portlet.common.validator.required"  name="required"/>
	        				<aui:validator name="maxLength">'1024'</aui:validator>
	       				</aui:input>
					</label>
				</div>
			</li>
			<li>
				<div class="rowa">
					<label><liferay-ui:message  key="portlet.questionsubmit.citizenphone" />: </label>
					<aui:input name="citizenPhoneNumber" label=""  maxlength="20" value="${questionModel.citizenPhone}">
						<aui:validator name="number" errorMessage="portlet.common.validator.number" />
						<aui:validator name="maxLength">'20'</aui:validator>
					</aui:input>
				</div>
				<div class="rowb">
					<label><liferay-ui:message key="portlet.questionsubmit.citizenemail" />: </label> 
					<aui:input name="citizenEmail"  label=""  maxlength="255" value="${questionModel.citizenEmail}">
						<aui:validator errorMessage="portlet.common.validator.email" name="email" />
						<aui:validator name="maxLength">'255'</aui:validator>
					</aui:input>
				</div>
			</li>

			<li><label><liferay-ui:message key="portlet.questionsubmit.questiontitle" />: (<span class="red">*</span>)
			</label><aui:input name="questionTitle" cssClass="full_width"  label=""  maxlength="255" value="${questionModel.citizenQuestionTitle}">
	        				<aui:validator errorMessage="portlet.common.validator.required" name="required" />
	        				<aui:validator name="maxLength">'255'</aui:validator>
	       				</aui:input></li>
			<li><label><liferay-ui:message key="portlet.questionsubmit.questiontypes" />: (<span
					class="red">*</span>)
			</label>
			<aui:select cssClass="full_width" name="questionTypes" label=""  >
				<aui:option value=""><liferay-ui:message key="portlet.common.form.dropdownlist.firstoption" />
				
				</aui:option>
          		<c:forEach items="${dataDictionarySet.records}" var="item">
              		<aui:option value="${item.key}" label="${item.value}"
              		selected="${item.key == questionModel.citizenQuestionType}" />
              	</c:forEach>
      		</aui:select>
    		<aui:script use="aui-form-validator, aui-overlay-context-panel">
				      var validator1 = new A.FormValidator({
				      boundingBox: '#<portlet:namespace/>frmQuestionSubmit',
				      
				      rules: {
				      
				      <portlet:namespace/>questionTypes: {
				      required: true
				      },
				      
				      },
				      
				      fieldStrings: {
				       <portlet:namespace/>questionTypes: {
				        required: '<liferay-ui:message key="portlet.common.validator.required" />'
				       }
				      }
				      })
			</aui:script>
			</li>
			<li><label><liferay-ui:message key="portlet.common.form.attachedFile" /></label>
				<cus:mutil-uploader tagName="attachedFile" hiddenTagName="attachedFileName" 
				
					mimeType="txt,pdf,doc,docx,png,jpg,xls,xlsx,TXT,PDF,DOC,DOCX,PNG,XLS,XLSX"/>
					<!-- mimeType="txt,pdf,doc,docx,png,jpg,xls,xlsx,txt,pdf,doc,docx,png,xls,xlsx"/> -->
					 
					
			<li>
				<label>
					<liferay-ui:message key="portlet.questionsubmit.questioncontent" />: (<span
					class="red">*</span>)
				</label>
	       		<liferay-ui:input-editor cssClass="editor_html" name="questionContent"/>
				<aui:script>
				window.<portlet:namespace/>initEditor = function() {
					$('.editor_html').append('<div class="error_mes"><liferay-ui:message key="portlet.common.validator.required" /></div>');
					$('.editor_html').append('<div class="error_mes_maxlength"><liferay-ui:message key="portlet.common.validator.max.length" /></div>');
					return '';
				}
				CKEDITOR.instances['<portlet:namespace/>questionContent'].on('blur',	function() {
					validateFocusOut();
				});
				</aui:script>
	       	</li>
	       	
			<li>
				<liferay-ui:error key="Invalid-captcha" message="Invalid-captcha" ></liferay-ui:error>
	            <portlet:resourceURL var="captchaURL" />
	    		<liferay-ui:captcha url="<%= captchaURL %>" />
    		</li>
    		
			<li class="rowbutton">
			<input type="submit" class="btn" value="<liferay-ui:message key="portlet.questionsubmit.submitbutton" />" onclick="return validateEditor()" />
			<input type="button" id="btnCancel" class="btn" value="<liferay-ui:message key="common.button.cancel" />" />
			</li>
		</ul>
	</div>
	<!--end content-->
</aui:form>
<input id="responServer" 			type="hidden" 	value="${responServer}"	name="responServer"/>
<input id="questionContentRe"		type="hidden" 	value="${questionModel.citizenQuestionContent}"	name="questionContentRe"/>

<input id="REFRESH_CAPTCHA_LABEL" 	type="hidden"	value="<liferay-ui:message key="portlet.common.form.recaptcha" />"  />