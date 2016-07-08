<%-- 
    Document   : formPesquisa
    Created on : 08/06/2016, 09:02:18
    Author     : 10070155
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../cabecalho.html"%> 
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    </head>
    <body>
        <div id="conteudo">
            <center>
                <h1>Pesquisar</h1>
                <fieldset id="fildespaco">
                    <legend>Informações para Pesquisa de Espaços</legend>
                    <div id="reserva" class="reservas">
                        <form action="/Gabinete/espacoControle">    
                            <input type="hidden" name="operacao" value="0">

                            <label for="numero" > Numero da sala:</label>
                            <br/>
                            <input type="text" name="numero" id="numero"  size="25" placeholder="Ex.: 409"/>
                            <br/>
                            <br/>

                            <label for="nome_espaco" > Nome do espaço:</label>
                            <br/>
                            <input type="text" name="nome_espaco" id="nome_espaco" placeholder="Ex.: Laboratório de Informática" />
                            <br/>
                            <br/>

                            <label for="tipo_espaco" > Tipo de espaço:</label>
                            <br/>
                            <select name="tipo_espaco" id="tipo_espaco" >
                                <option>-selecione-</option>
                                <option>Sala de aula</option>
                                <option>Laboratorio</option>
                                <option>Multifuncional</option>
                            </select>

                            <br/>
                            <br/>

                            <input id="inputEventos" type="submit" value="Pesquisar" name="pesquisar" />

                        </form>  
                    </div>
                </fieldset>
            </center>
        </div>
    </body>
    <%@include file="../menu.html"%>
    <%@include file="../rodape.html"%>
</html>
