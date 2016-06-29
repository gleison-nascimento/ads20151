<%-- 
    Document   : EventoLogin.jsp
    Created on : 21/06/2016, 16:28:07
    Author     : EvertonQuadros
    Escopo     : Eventos
    Descricao  : Stand-Alone para testes do módulo de evento, gera pequeno formulário para
                 login de perfil e teste de sessões:
                 administrador - admin123
                 user - user123
    Observações: Alterar conforme necessidade.
--%>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<%@include file="../cabecalho.html"%> 

<div id="conteudo">
        <h1>Teste Login:</h1>
        <hr>
       
        <form action="/Gabinete/LoginControl" method="POST" >
           
            <label for="login">login: </label><br>
            <input type="text" name="login" id="login" size="100"><br>
            <br>
            <label for="senha">senha: </label><br>
            <input type="password" name="senha" id="senha" size="50"><br>
            <br>
            <input type="submit" value="Enviar">
            <input type="reset" value="Limpar">
            
        </form>
       </div>

<%@include file="../menu.html"%>
<%@include file="../rodape.html"%>