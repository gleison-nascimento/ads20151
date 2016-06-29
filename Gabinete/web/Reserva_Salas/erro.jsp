<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Erro</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    
    <body>
        <h1>ERRO</h1>
        <hr>
        <p><%= request.getAttribute("msg_erro")%></p>
        <a href="javascript:history.back(1)">Voltar</a>
    </body>
</html>