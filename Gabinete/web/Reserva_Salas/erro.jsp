<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
        <%@include file="../cabecalho.html"%>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    
    <body>
        <div id="conteudo">
            <center>
                <h1>ERRO</h1>
                <hr>
                <p><%= request.getAttribute("msg_erro")%></p>
                <a href="/Gabinete/index.jsp">Voltar</a>
            </center>
        </div>
    </body>
    <%@include file="../menu.html"%>
    <%@include file="../rodape.html"%>
</html>