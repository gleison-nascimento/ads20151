<%-- 
    Document   : semResultado
    Created on : 24/06/2016, 10:04:49
    Author     : 10070155
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    <%@include file="../cabecalho.jsp"%> 

        <%
            //Usuario p = new Usuario();
            if (request.getSession().getAttribute("login") != null && request.getSession().getAttribute("login") instanceof Usuario) {
                p = (Usuario)request.getSession().getAttribute("login");        
        %>
    <html>
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <div id="conteudo">
            <center>
                <h1>Dados não encontrados!</h1>
                <br><br>
                <a href="formPesquisa.jsp">Pesquisar novamente</a>
                <br>
                <a href="../main.jsp">Voltar ao inicio</a>
            <center>
        </div>
    </body>
</html>
<%   
            }
            else{
            %>
            
            <c:redirect url="/eventos/falhaLogin.jsp"/>
            
            <%

            }
            
            


        %>
    <%@include file="../menu.html"%>
    <%@include file="../rodape.html"%>
