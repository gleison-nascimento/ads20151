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
                <hr>
                
                    <form action="ReservaControl" method="post" onsubmit="return ValidarEspaco()">

                        <label for="nome">Nome:</label><br>
                        <input type="text" name="nome" id="nome" size="30"><br><br>

                        <label for="numero">Numero da Sala:</label><br>
                        <input type="text" name="numero" id="numero" size="15" required><br><br>

                        <label for="descricao">Descrição:</label><br>
                        <input type="text" name="descricao" id="descricao" size="50" required><br><br>

                        <label for="lotacao">Numero máximo de pessoas na sala:</label><br>
                        <input type="text" name="lotacao" id="lotacao" size="15" required><br><br>

                        <label for="tipo_lab">Tipo de Laboratório:</label><br>
                        <select name="tipo_lab" id="tipo_lab">
                            <option value="">Selecione uma Sala</option>
                            <option value="1">Sala de Aula</option>
                            <option value="2">Laboratório</option>
                            <option value="3">Multifuncional</option>
                        </select><br><br>

                        <label for="projetor">Projetor na sala: </label>
                        <input type="radio" name="projetor" id="sitativo" value="S"><label for="sitativo">Sim</label>
                        <input type="radio" name="projetor" id="sitinativo" value="N" ><label for="sitativo">Não</label><br> <br>

                        <label for="internet">Internet na sala: </label>
                        <input type="radio" name="internet" id="sitativo" value="S"> <label for="sitativo">Sim</label>
                        <input type="radio" name="internet" id="sitinativo" value="N"><label for="sitinativo">Não</label><br> <br>

                        <label for="quadro">Quadro na sala: </label>
                        <input type="radio" name="quadro" id="sitativo" value="S"><label for="sitativo">Sim</label>
                        <input type="radio" name="quadro" id="sitinativo" value="N"><label for="sitinativo">Não</label><br><br> 

                    <label for="Equipamentos">Lista de Equipamentos:</label><br>
                    <input type="text" name="Equipamentos" id="lista_Equipamentos" size="40"><br><br>

                    <label for="situacao">Situação: </label>
                    <input type="radio" name="situacao" id="sitativo" value="A"><label for="sitativo" >Ativo</label>
                    <input type="radio" name="situacao" id="sitinativo" value="I"><label for="sitinativo">Inativo</label><br><br>

                    <input type="submit" value="Enviar">
                    <input type="reset" value="Limpar">  
                </form>        
            
            </center>
        </div>
    </body> 
    <%@include file="../menu.html"%>
    <%@include file="../rodape.html"%>
</html>
