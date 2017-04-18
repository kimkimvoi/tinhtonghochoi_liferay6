function submitPic() {
	var selectedRadio = $(".picture_config input[name='radioPicture']:checked");
	var warningMessage = $("#picturelibraryconfig_message_warning").val();
	var numberSelected = selectedRadio.length;
	if (numberSelected == 0) {
		alert(warningMessage);
	} else {
		console.log(selectedRadio.attr("value"));
		var pictureName = $("#img" + selectedRadio.attr("value")).attr("alt");
		var confirmMessage = $("#picturelibraryconfig_message_confirm").val();
		confirmMessage = confirmMessage.replace("{0}", "'" + pictureName + "'");
		if (confirm(confirmMessage)) {
			$("#picturelibraryconfigForm").submit();
		}
	}
}