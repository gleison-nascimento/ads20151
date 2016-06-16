/* 
    Feito por: Rodrigo Sebben
*/

function ValidaCampoVazio()
{
    var nome = document.getElementById("nome");
    var perfil = document.getElementById("Perfil");
    var email = document.getElementById("email");
    var descricao = document.getElementById("descricao");
    var dataIni = document.getElementById("inicio");
    var dataFim = document.getElementById("fim");
    var situacao = document.getElementById("situacao");  
    var servidores = document.getElementById("servodores");  
    
    if (nome.value==='')
    {
        alert('O nome deve ser digitado!');
        nome.focus();
        return false;        
    }      
    
    if (perfil.value==='')
    {
        alert('O perfil deve ser selecionado!');
        perfil.focus();
        return false;        
    }    

    if (email.value==='')
    {
        alert('O e-mail deve ser digitado!');
        email.focus();
        return false;        
    }    

    if (descricao.value==='')
    {
        alert('A descricao deve ser digitado!');
        descricao.focus();
        return false;        
    } 
    
    if (dataIni.value ===''){
        
        alert('A data de inicio deve ser digitada!');
        dataIni.focus();
        return false;        
    }
    
    if (dataFim.value ===''){
        
        alert('A data final deve ser digitada!');
        dataFim.focus();
        return false;        
    }
    
    if (situacao.value==='')
    {
        alert('A situação deve ser selecionada!');
        situacao.focus();
        return false;        
    }    
    
     if (servidores.value==='')
    {
        alert('Um servidor deve ser selecionado!');
        servidores.focus();
        return false;        
    }    
}

