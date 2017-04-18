/** Convert C -> CN and Th -> T2, ... ,T7**/
$(document).ready(function(){
	$("#buttonTest").click(function(){
		var len = $('.aui-calendar-week:visible').length;
		for (var i = 0; i < len; i++) {
			if ($($('.aui-calendar-week:visible')[i]).text() == 'C') {
				$($('.aui-calendar-week:visible')[i]).text('CN');
			}

			if ($($('.aui-calendar-week:visible')[i]).text() == 'Th ') {
				$($('.aui-calendar-week:visible')[i]).text('T'+ (i+1));
			}
		}
		
	});
});