function validar() {
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