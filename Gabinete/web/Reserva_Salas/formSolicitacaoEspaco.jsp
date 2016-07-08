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
                <fieldset id="fildespaco">
                    <legend>Informações para Solicitação de Espaços</legend>
                    <div id="reserva" class="reservas">
                        <form action="/Gabinete/SolicitacaoReservaControl" method="post" onsubmit="return validar()">

                            <label for="solicitante">Solicitante: </label><br>
                            <input type="text" name="solicitante" id="solicitante" size="30"  placeholder="Digite seu Nome"><br>

                            <label for="entidade">Entidade: </label><br>
                            <input type="text" name="entidade" id="entidade" size="30"  placeholder="Digite o nome da Entidade. Ex.: IFRS"><br>

                            <label for="email">E-mail de contato: </label><br>
                            <input type="text" name="email" id="email" size="30"  placeholder="Digite seu E-mail"><br>

                            <label for="tel">Telefone de contato: </label><br>
                            <input type="text" name="tel" id="tel" size="30"  placeholder="Ex.: 51 3333-2222"><br>

                            <label for="objetivo">Objetivo da reserva: </label><br>
                            <textarea name="objetivo" id="objetivo" rows="7" cols="60"  placeholder="Informe o motivo da solicitação"></textarea><br>

                            <label for="data">Data da solicitação: </label><br>
                            <input type="text" name="data" id="data" size="30"  placeholder="Digite a data de hoje"><br>

                            <label for="datainicio">Data de início da reserva: </label><br>
                            <input type="text" name="datainicio" id="datainicio" size="30"  placeholder="Informe a data inicial da reserva"><br>

                            <label for="horainicio">Hora de início da reserva: </label><br>
                            <input type="text" name="horainicio" id="horainicio" size="30"  placeholder="Informe a hora inicial da reserva"><br>

                            <label for="datatermino">Data de término da reserva: </label><br>
                            <input type="text" name="datatermino" id="datatermino" size="30"  placeholder="Informe a data final da reserva"><br>

                            <label for="horatermino">Hora de término da reserva: </label><br>
                            <input type="text" name="horatermino" id="horatermino" size="30"  placeholder="Informe a hora final da reserva"><br>

                            <br/>
                            <input id="inputEventos" type="submit" value="Enviar">
                            <input id="inputEventos" type="reset" value="Limpar"><br>
                        </form>
                    </div>
                </fieldset>
            </center>
        </div>        
    </body>
    <%@include file="../menu.html"%>
    <%@include file="../rodape.html"%>
</html>
