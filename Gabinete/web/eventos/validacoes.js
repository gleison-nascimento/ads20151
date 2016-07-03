function validarFormulario() {
    var solicitante = document.getElementById('solicitante');
    var entidade = document.getElementById('entidade');
    var email = document.getElementById('email');
    var telefone = document.getElementById('telefone');
    var descricao = document.getElementById('descricao');
	var dataInicial = document.getElementById("dataInicial");
	var dataFinal = document.getElementById("dataFinal");
    
    if (solicitante.value == ""){
                     alert("O campo solicitante deve ser preenchido!");
                     solicitante.focus();
                     return false;
           }
           
    if (entidade.value == ""){
                     alert("O campo entidade deve ser preenchido!");
                     entidade.focus();
                     return false;
           }
    if (email.value == "" || validacaoEmail(email) == false){
                     alert("O campo email deve ser preenchido com um email valido!");
                     email.focus();
                     return false;
           }
    if (telefone.value.length < 14){
        alert("O campo telefone deve ser preenchido com um telefone valido!");
        telefone.focus();
        return false;
    }
    if (descricao.value.length > 300){
        alert("O campo descrição permite um máximo de 350 caracteres");
        descricao.focus();
        return false;
    }
	
	if(verificaDataInicial() == false){
		alert("O campo inicio do evento deve ser maior que 20 dias da data de hoje!");
		dataInicial.focus();
		return false;
	}
	
	if(verificaDataFinal() == false){
		alert("O fim do evento deve ser maior que a data e hora inicial do evento!");
		dataFinal.focus();
		return false;
	}
	
    return true;
}
function validacaoEmail(field){
    usuario = field.value.substring(0, field.value.indexOf("@"));
    dominio = field.value.substring(field.value.indexOf("@")+ 1, field.value.length);

    if ((usuario.length >=1) &&
        (dominio.length >=3) && 
        (usuario.search("@")==-1) && 
        (dominio.search("@")==-1) &&
        (usuario.search(" ")==-1) && 
        (dominio.search(" ")==-1) &&
        (dominio.search(".")!=-1) &&      
        (dominio.indexOf(".") >=1)&& 
        (dominio.lastIndexOf(".") < dominio.length - 1)) 
        return true;
    else{
        /*alert("teste");
        field.focus();*/
        return false ;
    }
}

function mascaraTelefone(event,telefone){     
    var campo = document.getElementById(telefone);        
    
    if (validarTeclasEspeciais(event)) {
        return true;
    }
            
    if (validarDigitacaoNumerica(event)) {
        // coloca a mascara no telefone (nn) nnnn-nnnnn
        if(campo.value.length === 0)
            campo.value = '(' + campo.value; //quando começamos a digitar, o script irá inserir um parênteses no começo do campo.
        if(campo.value.length === 3)
            campo.value = campo.value + ') '; //quando o campo já tiver 3 caracteres (um parênteses e 2 números) o script irá inserir mais um parênteses, fechando assim o código de área.
        if(campo.value.length === 9)
            campo.value = campo.value + '-'; //quando o campo já tiver 9 caracteres, o script irá inserir um tracinho, para melhor visualização do telefone.
        return true;
    }
    return false;
}

function validarDigitacaoNumerica(event) {
    var tecla = event.keyCode || event.charCode; // compatibilidade dos browsers    
    // 48 - 57: 0 - 9
    // aceita apenas numeros na digitacao
    if ((tecla < 48) || (tecla > 57)) {                
        return false;
    }
    return true;
}

function validarTeclasEspeciais(event) {    
    var tecla = event.keyCode || event.charCode; // compatibilidade dos browsers        
    // 8: backspace
    // 9: tab
    // 10: enter
    // 127: del
    if ((tecla !== 8) && (tecla !== 9) &&
        (tecla !== 13) && (tecla !== 127)) {                
        return false;
    }    
    return true;    
}

function verificaDataInicial(){
	 
    var dataTeste = new Date();
    dataTeste.setDate(dataTeste.getDate()+20);
    
    var x = document.getElementById("dataInicial").value;
    
    var dataInicio = new Date(x.substring(0,4), parseInt(x.substring(5,7))-1, x.substring(8,10), 00, 00, 00, 00);
    
    
    if(dataInicio.getTime() < dataTeste.getTime()){
        return false;
    } else return true;

}	
function verificaDataFinal(){
    new Date();
    var x = document.getElementById("dataInicial").value;
    var dataInicio = new Date(x.substring(0,4), parseInt(x.substring(5,7))-1, x.substring(8,10),x.substring(11,13), x.substring(14,16), 00, 00);
    
    var y = document.getElementById("dataFinal").value;
    var dataFim = new Date(y.substring(0,4), parseInt(y.substring(5,7))-1, y.substring(8,10), y.substring(11,13), y.substring(14,16), 00, 00);
    
    if(dataFim.getTime() <= dataInicio.getTime()){
        return false;
    }else return true;
}
