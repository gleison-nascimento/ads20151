<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gabinete Virtual</title>
        <link rel="shortcut icon" href="imagens/icon.png">
        <link href="Estilo.css" rel="stylesheet" type="text/css"/>
        <script src="validacoes.js" type="text/javascript"></script>
    </head>
    
    <body>
        <h1>Solicitar espaço</h1>
        <hr>
        <form action="espacoControl" method="post" onsubmit="return validar()">
            <label for="solicitante">Solicitante: </label>
            <input type="text" name="solicitante" id="solicitante" size="20"><br>

            <label for="entidade">Entidade: </label>
            <input type="text" name="entidade" id="entidade" size="20"><br>

            <label for="email">Email de contato: </label>
            <input type="text" name="email" id="email" size="20"><br>

            <label for="tel">Telefone de contato: </label>
            <input type="text" name="tel" id="tel" size="20"><br>

            <label for="objetivo">Objetivo da reserva do espaço: </label><br>
            <textarea name="objetivo" id="objetivo" rows="3" cols="40"></textarea><br>

            <label for="data">Data da solicitação: </label>
            <input type="text" name="data" id="data" size="20"><br>

            <label for="datainicio">Data de início da reserva: </label>
            <input type="text" name="datainicio" id="datainicio" size="20"><br>

            <label for="horainicio">Hora de início da reserva: </label>
            <input type="text" name="horainicio" id="horainicio" size="20"><br>

            <label for="datatermino">Data de término da reserva: </label>
            <input type="text" name="datatermino" id="datatermino" size="20"><br>

            <label for="horatermino">Hora de término da reserva: </label>
            <input type="text" name="horatermino" id="horatermino" size="20"><br><br>

            <input type="submit" value="Enviar"  action="CommonsMail">
            <input type="reset" value="Limpar">
        </form>
    </body>
</html>

<!--http://www.guj.com.br/t/melhor-maneira-de-enviar-e-mail-com-java/111932/6-->
