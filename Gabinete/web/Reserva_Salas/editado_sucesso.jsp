<%-- 
    Document   : editado_sucesso
    Created on : 05/07/2016, 17:04:18
    Author     : Portal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../cabecalho.jsp"%>
    
    <%
            //Usuario p = new Usuario();
            if (request.getSession().getAttribute("login") != null) {
                p = (Usuario)request.getSession().getAttribute("login");
            }
            
    %>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <div id="conteudo">
            <center>
                <h1>O espaço foi editado com sucesso.</h1>
                <a href="/Gabinete/main.jsp">Voltar ao inicio</a>
            </center>
        </div>
    </body>
    <%@include file="../menu.html"%>
    <%@include file="../rodape.html"%>
</html>
