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
            <center>
                <h1>Solicitar Espaço</h1>
                <hr>
                <form action="/Gabinete/SolicitacaoReservaControl" method="post" onsubmit="return validar()">
                    
                    <label for="solicitante">Solicitante: </label><br>
                    <input type="text" name="solicitante" id="solicitante" size="30"><br><br>

                    <label for="entidade">Entidade: </label><br>
                    <input type="text" name="entidade" id="entidade" size="30"><br><br>

                    <label for="email">Email de contato: </label><br>
                    <input type="text" name="email" id="email" size="30"><br><br>

                    <label for="tel">Telefone de contato: </label><br>
                    <input type="text" name="tel" id="tel" size="30"><br><br>

                    <label for="objetivo">Objetivo da reserva: </label><br>
                    <textarea name="objetivo" id="objetivo" rows="7" cols="60"></textarea><br><br>

                    <label for="data">Data da solicitação: </label><br>
                    <input type="text" name="data" id="data" size="30"><br><br>

                    <label for="datainicio">Data de início da reserva: </label><br>
                    <input type="text" name="datainicio" id="datainicio" size="30"><br><br>

                    <label for="horainicio">Hora de início da reserva: </label><br>
                    <input type="text" name="horainicio" id="horainicio" size="30"><br><br>

                    <label for="datatermino">Data de término da reserva: </label><br>
                    <input type="text" name="datatermino" id="datatermino" size="30"><br><br>

                    <label for="horatermino">Hora de término da reserva: </label><br>
                    <input type="text" name="horatermino" id="horatermino" size="30"><br><br>

                    <input type="submit" value="Enviar">
                    <input type="reset" value="Limpar"><br><br><br>
                </form>
            </center>
        </div>        
    </body>
    <%@include file="../menu.html"%>
    <%@include file="../rodape.html"%>
</html>
