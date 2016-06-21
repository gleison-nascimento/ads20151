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
        <title>Gabinete Virtual</title>
    </head>
    <body>
        <h1>Ops...</h1>
        <hr>
        <p><%= request.getAttribute("msg_erro")%></p>
        <a href="eventos/EventoLogin.jsp">Voltar</a>
    </body>
</html>
