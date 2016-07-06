function validarSolicitacao() {
    var sol = document.getElementById("solicitante");
    var email = document.getElementById("email");
    var tel = document.getElementById("tel");
    var obj = document.getElementById("objetivo");
    var datai = document.getElementById("datainicio");
    var horai = document.getElementById("horainicio");
    var datat = document.getElementById("datatermino");
    var horat = document.getElementById("horatermino");
    
    if (sol.value === '' || sol.value === null) {
        alert('O campo `Solicitante´ é de preenchimento obrigatório.');
        sol.focus();
        return false;
    } else if (email.value === '' || email.value === null) {
        alert('O campo `Email de contato é de preenchimento´ obrigatório.');
        email.focus();
        return false;
    } else if (tel.value === '' || tel.value === null) {
        alert('O campo `Telefone de contato é de preenchimento´ obrigatório.');
        tel.focus();
        return false;
    } else if (obj.value === '' || obj.value === null) {
        alert('O campo `Objetivo da reserva do espaço´ é de preenchimento obrigatório.');
        obj.focus();
        return false;
    } else if (datai.value === '' || datai.value === null) {
        alert('O campo `Data de inicio da reserva´ é de preenchimento obrigatório.');
        datai.focus();
        return false;
    } else if (horai.value === '' || horai.value === null) {
        alert('O campo `Hora de inicio da reserva´ é de preenchimento obrigatório.');
        horai.focus();
        return false;
    } else if (datat.value === '' || datat.value === null) {
        alert('O campo `Data de término da reserva´ é de preenchimento obrigatório.');
        datat.focus();
        return false;
    } else if (horat.value === '' || horat.value === null) {
        alert('O campo `Hora de término da reserva´ é de preenchimento obrigatório.');
        horat.focus();
        return false;
    }
    
    return true;
}

function validarConsulta() {
    var sol = document.getElementById("solicitante");
    var sit = document.getElementById("situacao");
    
    if((sol.value === '' || sol.value === null) && (sit.value === '' || sit.value === null)) {
        alert('Preencha ao menos um campo para realizar a pesquisa.');
        return false;
    }
    
    return true;
}

function validarReserva() {
    var espaco = document.getElementById("espaco");
    
    if(espaco.value === '' || espaco.value === null) {
        alert('Campo `Espaço reservado´ é obrigatório.');
        espaco.focus();
        return false;
    }
    
    return true;
}

function ValidarEspaco(){
    var nome = document.getElementById('nome').value();
    var numero = Integer.parseInt(document.getElementsById('numero').value());
    var lotacao = document.getElementsById('lotacao').value();
    var tipo_lab = document.getElementById('tipo_lab').value();
    
    if (nome.value === '') {
        alert('O campo nome é de preenchimento obrigatório.');
        nome.focus();
        return false;
    }
    if(tipo_lab.value === ''){
        alert('O campo escolha a sala deve ser preenchido');
        return false;
    }
    if(lotacao === null){
        alert('o campo lotação deve estar preenchido');
        return false;   
    }
    if(numero.value <= 100 || numero.value >=700){
        alert('o numero da sala deve ser maior que 100 e menor que 700');
        return false;
    }
    if((numero % 100)>=30){
        alert('A dezena não pode ser maior que 30');
        return false;
    }
    
        return true;
}
    