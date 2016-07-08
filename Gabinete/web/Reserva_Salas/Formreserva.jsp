<%-- 
    Document   : Formreserva
    Created on : 22/06/2016, 09:36:33
    Author     : 10070174
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../cabecalho.html"%> 
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="Estilos.css" rel="stylesheet" type="text/css"/>
        <script src="Validacoes.js" type="text/javascript"></script>
    </head>
    <body>
        <div id="conteudo">
            <center>
                <h1>Cadastro de Espaço</h1><br>
                <fieldset id="fildespaco">
                    <legend>Informações para Cadastro de Espaços</legend>
                    <div id="reserva" class="reservas">
                    
                        <form action="/Gabinete/ReservaControl" method="post" onsubmit="return ValidarEspaco()">

                            <label for="nome">Nome:</label><br>
                            <input type="text" name="nome" id="nome" size="30" placeholder="Digite o nome da Sala"><br>

                            <label for="numero">Numero da Sala:</label><br>
                            <input type="text" name="numero" id="numero" size="15" placeholder="Digite o número da sala" required><br>

                            <label for="descricao">Descrição:</label><br>
                            <input type="text" name="descricao" id="descricao" size="50" placeholder="Informe algumas caracteristicas" required><br>

                            <label for="lotacao">Numero máximo de pessoas na sala:</label><br>
                            <input type="text" name="lotacao" id="lotacao" size="15" placeholder="Digite o número máximo de pessoas para esta sala" required><br>

                            <label for="tipo">Tipo de Laboratório:</label><br>
                            <select name="tipo" id="tipo_lab">
                                <option value="">Selecione uma Sala</option>
                                <option value="Sala de Aula">Sala de Aula</option>
                                <option value="Laboratorio">Laboratório</option>
                                <option value="Multifuncional">Multifuncional</option>
                            </select><br>
                    </div>

                    <div id="reserva">
                            <label for="projetor">Projetor na sala: </label>
                            <input type="radio" name="projetor" id="sitativo" value="true"><label for="sitativo">Sim</label>
                            <input type="radio" name="projetor" id="sitinativo" value="false" ><label for="sitativo">Não</label><br>

                            <label for="internet">Internet na sala: </label>
                            <input type="radio" name="internet" id="sitativo" value="true"> <label for="sitativo">Sim</label>
                            <input type="radio" name="internet" id="sitinativo" value="false"><label for="sitinativo">Não</label><br>

                            <label for="quadro">Quadro na sala: </label>
                            <input type="radio" name="quadro" id="sitativo" value="true"><label for="sitativo">Sim</label>
                            <input type="radio" name="quadro" id="sitinativo" value="false"><label for="sitinativo">Não</label><br> 
                    </div>

                    <label for="especalidade">Especialidade</label>
                    <input type="text" name="especialidade" value="" />
                    
                    <div id="reserva" class="reservas">
                            <label for="equipamentos">Lista de Equipamentos:</label><br>
                            <input type="text" name="equipamentos" id="lista_Equipamentos" size="40" placeholder="Informe os equipamentos disponíveis"><br>
                    </div>

                    <div id="reserva">
                            <label for="situacao">Situação: </label>
                            <input type="radio" name="situacao" id="sitativo" value="Ativo"><label for="sitativo" >Ativo</label>
                            <input type="radio" name="situacao" id="sitinativo" value="Inativo"><label for="sitinativo">Inativo</label><br>
                    </div><br/>

                    <div id="reserva" class="reservas">
                            <input id="inputEventos" type="submit" value="Enviar">
                            <input id="inputEventos" type="reset" value="Limpar">  
                        </form>
                    </div>
                </fieldset>
            </center>
        </div>
    </body> 
    <%@include file="../menu.html"%>
    <%@include file="../rodape.html"%>
</html>
