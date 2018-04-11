function getButtonProperty (e) {
	alert(e);
	console.log(e);
	var send = document.getElementsByName("buttonSend");
	var recive = document.getElementsByName("buttonRecive");
	
	var enviar = send[e].dataset;
	var receber = recive[e].dataset;
	
	if(enviar != null && receber != null ){
		console.log(enviar);
		console.log(receber);
	}
	
	
}
