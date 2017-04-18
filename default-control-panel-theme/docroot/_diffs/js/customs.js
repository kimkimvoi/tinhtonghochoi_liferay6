$(document).ready(function() {
	$(window).scroll(function() {
		if ($(this).scrollTop() != 0) {
			$('.icon_top').fadeIn();
		} else {
			$('.icon_top').fadeOut();
		}
	});
	$('.icon_top').click(function() {
		$('body,html').animate({
			scrollTop : 0
		}, 200);
	});
	
	$(window).scroll(function() {
		if ($(this).scrollTop() >= 132) {
			$("#navi").css('position','fixed');
			$("#navi").css('left','0');
			if ($("#dockbar").css("position") == 'fixed') {
				$("#navi").css('top','30px');
			} else {
				$("#navi").css('top','0');
			}
		} else {
			$("#navi").css('position','');
			$("#navi").css('top','');
			$("#navi").css('left','');
		}
	});
	

	$('[placeholder]').focus(function() {
		var input = $(this);
		if (input.val() == input.attr('placeholder')) {
			input.val('');
			input.removeClass('placeholder');
		}
	}).blur(function() {
		var input = $(this);
		if (input.val() == '' || input.val() == input.attr('placeholder')) {
			input.addClass('placeholder');
			input.val(input.attr('placeholder'));
		}
	}).blur();
});