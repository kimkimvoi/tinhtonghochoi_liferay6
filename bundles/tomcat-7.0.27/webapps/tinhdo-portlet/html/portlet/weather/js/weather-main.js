/*$("#weatherBodyContentId").bind("onload", function(){
	CallURL();
	alert("1111111111111");
});
*/
$("#weatherBodyContentId").ready(function(){
	CallURL();
});

function CallURL(){
	document.getElementById('weather_porlet_getdata_error').hidden = true;
	document.getElementById('weather_content_detail').hidden = true;
	
	$.ajax({	
	    //url: 'http://api.openweathermap.org/data/2.5/weather?q=HaNoi,vi',
		url: 'http://api.openweathermap.org/data/2.5/weather?id=1591449',
	    type: "GET",
	    dataType: "jsonp",
	    async:false,
	     success: function (msg) {
	         JsonpCallback(msg);
	    },
	    error: function () {
	        ErrorFunction();
	    }
});
}

function ErrorFunction(){
	document.getElementById('weather_porlet_getdata_error').hidden = false;
	document.getElementById('weather_content_detail').hidden = true;
}

function JsonpCallback(json){	
	if(json != null){
		//current temperature
		var current_temp = json.main.temp;
		current_temp = ConvertTemperatureKtoC(current_temp);
		document.getElementById("weather_current_temperature").innerHTML = "" + current_temp + "&#186;C";
		
		//get icon weather
		var icon_weather_name = json.weather[0].icon;
		if(null != icon_weather_name){
			var urlImg =  "/tinhdo-portlet/html/portlet/weather/images/" + icon_weather_name + ".png";
			 $("#img_icon_weather_stt").attr('src', urlImg);
		}
		
		//min-max temperature
		var min_temp = json.main.temp_min;
		var max_temp = json.main.temp_max;
		
		if((null != min_temp) && (null != max_temp)){
			min_temp = ConvertTemperatureKtoC(min_temp);
			max_temp = ConvertTemperatureKtoC(max_temp);
			var min_max_temp = "(" + min_temp + "&#186;C-" + max_temp + "&#186;C)";
			document.getElementById("weather_min_max_temperature").innerHTML = "" + min_max_temp;
		}
		
		//current weather
		var current_weather = json.weather[0].id;
		var weather_status = "";
		
		if((current_weather>=200) &&(current_weather<300)){
			weather_status = "MƯA DÔNG";
		}else if((current_weather >= 300)&&(current_weather<322)){
			weather_status = "MƯA RÀO";
		}else if((current_weather >= 500)&&(current_weather<532)){
			weather_status = "MƯA";
		}else if((current_weather >= 600)&&(current_weather<632)){
			weather_status = "TUYẾT";
		}else if((current_weather >= 600)&&(current_weather<632)){
			weather_status = "SƯƠNG MÙ";
		}else if((current_weather >= 700)&&(current_weather<782)){
			weather_status = "SƯƠNG MÙ";
		}else if((current_weather >= 800)&&(current_weather<810)){
			weather_status = "NHIỀU MÂY";
		}
		
		document.getElementById("weather_curent_weather").innerHTML = "" + weather_status;
		
		//Wind direction in degrees
		var current_wind_deg = json.wind.deg;
		var win_deg_status = GetDegreeOfWind(current_wind_deg);
		document.getElementById("weather_curent_wind_deg").innerHTML = "" + win_deg_status;
		
		//wind speed status
		var current_wind_speed = json.wind.speed;
		current_wind_speed = ConvertSpeedMpstoKmps(current_wind_speed);
		current_wind_speed = current_wind_speed.toFixed(2);
		document.getElementById("weather_curent_wind_speed").innerHTML = "" + current_wind_speed + " Km/h";
		
		//current humidity
		var current_humidity = json.main.humidity;
		document.getElementById("weather_curent_humidity").innerHTML = "" + current_humidity + " %";
		
		//current pressure
		var current_pressure = json.main.pressure;
		var atm_pressure = current_pressure*0.000987;
		atm_pressure = Math.round(atm_pressure);
		document.getElementById("weather_curent_pressure").innerHTML = "" + atm_pressure + " atm";
		
		document.getElementById('weather_porlet_getdata_error').hidden = true;
		document.getElementById('weather_content_detail').hidden = false;
	}else{
		document.getElementById('weather_porlet_getdata_error').hidden = false;
		document.getElementById('weather_content_detail').hidden = true;
	}
/*	console.log("resul json:" + json.length);
 document.getElementById('weatherBodyContentId').innerHtml=json.result;*/
}

function ConvertTemperatureKtoC(temp){
	var tempc = temp-273.15;
	tempc = Math.round(tempc);
	return tempc;
}

function ConvertSpeedMpstoKmps(value){
	var tem = value*3.6;
	return tem;
}

function GetDegreeOfWind(value){
	var str_deg = "";
	
	if((value >=337.5)||(value < 22.5)){
		str_deg = "Bắc";
	}else if((value >=22.5)&&(value < 67.5)){
		str_deg = "Đông Bắc";
	}else if((value >=67.5)&&(value < 112.5)){
		str_deg = "Đông";
	}else if((value >=112.5)&&(value < 157.5)){
		str_deg = "Đông Nam";
	}else if((value >=157.5)&&(value < 202.5)){
		str_deg = "Nam";
	}else if ((value >=202.5)&&(value < 247.5)){
		str_deg = "Tây Nam";
	}else if ((value >=247.5)&&(value < 292.5)){
		str_deg = "Tây";
	}else if((value >=292.5)&&(value < 337.5)){
		str_deg = "Tây Bắc";
	}
	return str_deg;
}