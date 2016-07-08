<%-- 
    Document   : desativado_sucesso
    Created on : 29/06/2016, 09:07:00
    Author     : 10070155
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
                <h1>O espaço foi desativado com sucesso.</h1>
                <a href="/Gabinete/main.jsp">Voltar ao inicio</a>
            </center>
        </div>
    </body>
    <%@include file="../menu.html"%>
    <%@include file="../rodape.html"%>
</html>
