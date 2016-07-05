<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../cabecalho.html"%> 
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="imagens/icon.png">
        <link href="Estilo.css" rel="stylesheet" type="text/css"/>
        <script src="validacoes.js" type="text/javascript"></script>
    </head>
    <body>
        <div id="conteudo">
            <center><h1>Solicitar Espaço</h1></center>
            <hr>
            <form action="espacoControl" method="post" onsubmit="return validar()">
                <div id="AlinhandoLabel"><label for="solicitante">Solicitante: </label></div>
                <div id="AlinhandoForm"><input type="text" name="solicitante" id="solicitante" size="30"></div><br>

                <div id="AlinhandoLabel"><label for="entidade">Entidade: </label></div>
                <div id="AlinhandoForm"><input type="text" name="entidade" id="entidade" size="30"></div><br>

                <div id="AlinhandoLabel"><label for="email">Email de contato: </label></div>
                <div id="AlinhandoForm"><input type="text" name="email" id="email" size="30"></div><br>

                <div id="AlinhandoLabel"><label for="tel">Telefone de contato: </label></div>
                <div id="AlinhandoForm"><input type="text" name="tel" id="tel" size="30"></div><br>

                <div id="AlinhandoLabel"><label for="objetivo">Objetivo da reserva: </label></div>
                <div id="AlinhandoForm"><textarea name="objetivo" id="objetivo" rows="7" cols="60" size="30"></textarea></div><br>

                <div id="AlinhandoLabel"><label for="data">Data da solicitação: </label></div>
                <div id="AlinhandoForm"><input type="text" name="data" id="data" size="30"></div><br>

                <div id="AlinhandoLabel"><label for="datainicio">Data de início da reserva: </label></div>
                <div id="AlinhandoForm"><input type="text" name="datainicio" id="datainicio" size="30"></div><br>

                <div id="AlinhandoLabel"><label for="horainicio">Hora de início da reserva: </label></div>
                <div id="AlinhandoForm"><input type="text" name="horainicio" id="horainicio" size="30"></div><br>

                <div id="AlinhandoLabel"><label for="datatermino">Data de término da reserva: </label></div>
                <div id="AlinhandoForm"><input type="text" name="datatermino" id="datatermino" size="30"></div><br>

                <div id="AlinhandoLabel"><label for="horatermino">Hora de término da reserva: </label></div>
                <div id="AlinhandoForm"><input type="text" name="horatermino" id="horatermino" size="30"></div><br><br>

                <div id="AlinhandoForm"><input type="submit" value="Enviar"  action="CommonsMail">
                <input type="reset" value="Limpar"></div>
            </form>
        </div>        
    </body>
    <%@include file="../menu.html"%>
    <%@include file="../rodape.html"%>
</html>
