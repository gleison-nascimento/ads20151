<%-- 
    Document   : erro.jsp
    Created on : 06/05/2016, 08:56:07
    Author     : EvertonQuadros
    Escopo     : Eventos
    Descricao  : Tela de erro padrão.
    Observações: Alterar conforme necessidade.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Erro</title>
        <link href="../Estilo.css" rel="stylesheet" type="text/css"/>
        
    </head>
    <body>
        <div id="mensagemTela">
            <center>
                 <h1>Ocorreu um Erro!</h1>
            <img src="/Gabinete/imagens/erro.png" alt="Erro"  title="Erro"  width="130" height="200px">   
                
            </center>
            
        <hr>
        <p><%= request.getAttribute("msg_erro")%></p>
        <a href="../eventos/EventoLogin.jsp">Voltar</a>
            
        </div>
       
    </body>
</html>
