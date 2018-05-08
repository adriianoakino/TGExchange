
var receber;
var enviar;

function liberar(e, tipo){
	alert(tipo);
	if(tipo == "send"){
		var send = document.getElementsByName("buttonSend");
		enviar = send[e].dataset;
		console.log("1 receber: " , receber);
		console.log("1 enviar: " + enviar);
	}
	
	if(tipo == "recive"){
		var recive = document.getElementsByName("buttonRecive");
		receber = recive[e].dataset;
		console.log("2: " + receber);
		console.log("2: " + enviar);
	}
	if(!enviar == "" || !enviar == null && !receber == "" || !receber == null) {
		var emailorwallet = document.getElementById("emailorwallet");
		var email = document.getElementById("email");
		if(e < 4){
			emailorwallet.placeholder="Email da sua conta do "+ receber.ecurr;
			email.placeholder = "Digite seu Email ";
		}else {
			emailorwallet.placeholder="Digite o endereço carteira "+ receber.ecurr;
			email.placeholder = "Digite seu Email ";
		}
	}
}

