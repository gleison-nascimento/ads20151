<%-- 
    Document   : erro
    Created on : 29/06/16
    Author     : Rodrigo Sebben
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
        <a href="AbreChamado.jsp">Voltar</a>
    </body>
</html>
