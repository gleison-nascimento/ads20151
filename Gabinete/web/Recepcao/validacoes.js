/* 
    Feito por: Rodrigo Sebben
*/

function ValidaCampoVazio()
{
    var nome = document.getElementById("nome");
    var perfil = document.getElementById("Perfil");
    var email = document.getElementById("email");
    var descricao = document.getElementById("descricao");
    
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
}

