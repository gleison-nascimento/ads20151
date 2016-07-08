<%-- 
    Document   : RetornaProtocolo
    Created on : 07/07/2016, 19:30:16
    Author     : Rodrigo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../cabecalho.jsp"%> 
           
        <%
            //Usuario p = new Usuario();
            if (request.getSession().getAttribute("login") != null) {
                p = (Usuario)request.getSession().getAttribute("login");
            }
            
        %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gabinete Virtual</title>
    </head>
    <body>
        <h1>CHAMADO CADASTRADO COM SUCESSO!</h1>
        <p> Foi criado o protocolo: <%= request.getAttribute("Protocolo")%></p>
        <a href="/Gabinete/main.jsp">Voltar</a>
    </body>
</html>

<%@include file="../menu.html"%>
<%@include file="../rodape.html"%>