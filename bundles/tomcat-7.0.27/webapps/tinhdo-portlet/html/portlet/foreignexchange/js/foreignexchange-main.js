$("#foreign_exchange_porlet_div").ready(function(){
	var bankXmlUrl = "http://www.vietcombank.com.vn/exchangerates/ExrateXML.aspx"; 
	var url = "http://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20xml%20where%20url%3D%22" +  
                      encodeURIComponent(bankXmlUrl) + "%22&format=json'&callback=?"; 
	
	document.getElementById('foreign_exchange_porlet_error').hidden = true;
	document.getElementById('foreign_exchange_table').hidden = true;
	
	$.ajax({  
        url:url,  
        dataType: 'jsonp',  
        success: function(resp){
        	console.log("Load Exchange Rates success");
             var data = '';
             var i=1;
             if (resp.results.length > 0)  
             {  
                  var xml = resp.results[0];  
                  xmlDoc = $.parseXML( xml );  
                  $xml = $( xmlDoc );  
                  $exrates = $xml.find("Exrate").each(function() {  
                 var $exrate = $(this);  
                       var code = $exrate.attr("CurrencyCode");
                       var name = $exrate.attr("CurrencyName");
                       var buy = $exrate.attr("Buy");
                       var tranfer = $exrate.attr("Transfer");
                       var sell = $exrate.attr("Sell");
                       
                       if(i%2==0){
                    	   data += '<tr class="tr-content-foreignexchange_even" height="25"><td>' + code + '</td><td>'+ name + '</td><td>' + buy + '</td><td>'+ tranfer + '</td><td>' + sell + '</td></tr>';  
                       }else{
                    	   data += '<tr class="tr-content-foreignexchange_uneven" height="25"><td>' + code + '</td><td>'+ name + '</td><td>' + buy + '</td><td>'+ tranfer + '</td><td>' + sell + '</td></tr>';
                       }
                       
                       i++;
                });  
             }                 
             $('tr.tr-content-foreignexchange').replaceWith(data);
             document.getElementById('foreign_exchange_table').hidden = false;
             document.getElementById('foreign_exchange_porlet_error').hidden = true;
        },
        error: function () {
	        ErrorFunction();
	    }
	});       
});

function ErrorFunction(){
	 console.log("get Exchange Rates error");
	 document.getElementById('foreign_exchange_table').hidden = true;
     document.getElementById('foreign_exchange_porlet_error').hidden = false;
};
