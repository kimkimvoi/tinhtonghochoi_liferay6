function checkSelectedCheckbox() {
	if (document.getElementById('config_one').checked) {
		document.getElementById("configForm").submit();
	} else if (document.getElementById('config_two').checked) {
		var group = document.configFrm.analyticMulti;
		for ( var i = 0; i < group.length; i++) {
			if (group[i].checked){
				break;
			}
		}
		if(i == group.length){
			//var message = document.getElementsByName('message');
			var name = document.getElementById('msg');
			alert(name.value);
			document.configFrm.analyticMulti[0].checked = true;
		}else{
			document.getElementById("configForm").submit();
		}
	}
}

function checkOneAnalytic() {
	if (document.getElementById('config_one').checked) {
		for ( var i = 0; i < document.configFrm.analyticMulti.length; i++) {
			document.configFrm.analyticMulti[i].disabled = true;
		}
	}
}

function multiAnalytic() {
	if (document.getElementById('config_two').checked) {
		for ( var i = 0; i < document.configFrm.analyticMulti.length; i++) {
			document.configFrm.analyticMulti[i].disabled = false;
		}
	}
}
