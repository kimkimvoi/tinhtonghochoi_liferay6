
jQuery(document).ready(function() {
	if($("#result" ).val() =="") {
		$('#content_submit_question').hide();
		$('#img_question_submit').show();
	} else {
		$('.portlet-msg-success')[0].remove();
		$('#img_question_submit').hide();
		$('#content_submit_question').show();
	}
	$('#img_question_submit').click(function() {
		showQuestionBox(true);
	});
	$('#btnCancel').click(function() {
		showQuestionBox(false);
	});
	if($("#result" ).val() =='success') {
		$('#MSG_SUCCESS').show();
		//++ QUANGTN3 20140313 fix bug FIBIXBP-211
		$('#content_submit_question').hide();
		$('#img_question_submit').show();
		//-- QUANGTN3 20140313 fix bug FIBIXBP-211
	}else if ($("#result" ).val() =='invalid_captcha') {
		window._questionsubmit_WAR_tinhdoportlet_questionContent.setHTML($("#questionContentRe").val());
		console.log($("#questionContentRe").val());
		$('#MSG_INVALID_CAPTCHA').show();
	}else if ($("#result" ).val() =='error') {
		$('#MSG_ERROR').show();
	}
	$('.taglib-captcha').append('<div class="recaptcha_position"><a id="btnRefreshCaptcha" href="#">['+ $('#REFRESH_CAPTCHA_LABEL').val() +']</a></div>');
	$("#btnRefreshCaptcha").click(function() {
			$(".captcha").attr("src", $(".captcha").attr("src")+"&force=" + new Date().getMilliseconds());
			return false;
	});
	
});
function showQuestionBox(value) {
	if(value == true) {
		$('#content_submit_question').show();
		$('#img_question_submit').hide();
	} else {
		$('#content_submit_question').hide();
		$('#img_question_submit').show();
	}
}
function validateEditor() {
	if(_questionsubmit_WAR_tinhdoportlet_questionContent.getHTML() =='') {
		showError(true , 'required');
		_questionsubmit_WAR_tinhdoportlet_questionContent.focus();
		return false;
	} else if(_questionsubmit_WAR_tinhdoportlet_questionContent.getHTML().length > 4000) {
		showError(true , 'maxlength');
		_questionsubmit_WAR_tinhdoportlet_questionContent.focus();
		return false;
	} else {
		showError(false);
	}
}
function validateFocusOut() {
	if(_questionsubmit_WAR_tinhdoportlet_questionContent.getHTML() =='') {
		showError(true , 'required');
		return false;
	} else if(_questionsubmit_WAR_tinhdoportlet_questionContent.getHTML().length > 4000) {
		showError(true , 'maxlength');
		return false;
	} else {
		showError(false ,'');
	}
}

function validateCaptcha() {
	$.ajax({
		sync: false,
		url: $("#validCaptcha_URL").val(),
		data : $("#quesitonSumitFrm").serialize(),
		dataType: 'json',
		type: "POST",
		success: function(data) {
			if (data.status == "true") {
				$(selectedRow.find('td')[4]).html('Đã trả lời');
			} 
		},
		error: function(response) {
			alert(response);
		}
	});
} 

function showError(boolean , valiatorType) {
	if(boolean) {
		if(valiatorType =='required') {
			_questionsubmit_WAR_tinhdoportlet_questionContent.setHTML('');
		}
		$('#cke__questionsubmit_WAR_tinhdoportlet_questionContent').addClass('error_editor');
		$( "#cke__questionsubmit_WAR_tinhdoportlet_questionContent").bind( "mouseenter", function() {
			if(valiatorType =='required') {
				$('.error_mes').css('display','inline-block');
			} else if(valiatorType == 'maxlength') {
				$('.error_mes_maxlength').css('display','inline-block');
			}
		});
		$( "#cke__questionsubmit_WAR_tinhdoportlet_questionContent").bind( "mouseleave", function() {
			if(valiatorType =='required') {
				$('.error_mes').css('display','none');
			} else if(valiatorType == 'maxlength') {
				$('.error_mes_maxlength').css('display','none');
			}
		});
	} else {
		$('#cke__questionsubmit_WAR_tinhdoportlet_questionContent').removeClass('error_editor');
		$( "#cke__questionsubmit_WAR_tinhdoportlet_questionContent").unbind( "mouseenter");
		$( "#cke__questionsubmit_WAR_tinhdoportlet_questionContent").unbind( "mouseleave");
		if(valiatorType =='required') {
			$('.error_mes').css('display','none');
		} else if(valiatorType == 'maxlength') {
			$('.error_mes_maxlength').css('display','none');
		} else {
			$('.error_mes').css('display','none');
			$('.error_mes_maxlength').css('display','none');
		}
	}
}