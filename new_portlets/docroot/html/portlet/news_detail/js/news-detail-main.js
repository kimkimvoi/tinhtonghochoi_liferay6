
function expandingWindow(website) {
	var heightspeed = 2; // vertical scrolling speed (higher = slower)
	var widthspeed = 7; // horizontal scrolling speed (higher = slower)
	var leftdist = 0; // distance to left edge of window
	var topdist = 0; // distance to top edge of window
	var winwidth = window.screen.availWidth - leftdist;
	var winheight = window.screen.availHeight - topdist;
	var sizer = window.open(website, "", "left=" + leftdist + ",top=" + topdist
			+ ",width=1,height=1,scrollbars=yes");
	for (sizeheight = 1; sizeheight < winheight; sizeheight += heightspeed) {
		sizer.resizeTo("1", sizeheight);
	}
	for (sizewidth = 1; sizewidth < winwidth; sizewidth += widthspeed) {
		sizer.resizeTo(sizewidth, sizeheight);
	}
	sizer.location = website;
}

	