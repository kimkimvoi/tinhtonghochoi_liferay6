$( document ).ready(function() {
	$('.top').tooltip({align: 'top'});
	$('.right').tooltip({align: 'right'});
	$('.bottom').tooltip({align: 'bottom'});
	$('.left').tooltip({align: 'left'});
	$('.autotop').tooltip({align: 'autoTop'});
	$('.autoleft').tooltip({align: 'autoLeft'});
	
	$(".aui-datepicker-button-wrapper").click(function(){
		$('.aui-calendar-week:visible').each(function(i){
			if ($(this).html() == 'C') {
				$(this).html('CN');
			} else if ($(this).html() == 'Th ') {
				$(this).html('T'+ (i+1));
			}
		});
	});
});
