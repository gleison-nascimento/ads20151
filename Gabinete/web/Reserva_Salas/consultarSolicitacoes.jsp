<%@page import="br.edu.ifrs.modelo.bean.Solicitacoes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../cabecalho.html"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="validacoes.js" type="text/javascript"></script>
    </head>
    
    <body>
        <div id="conteudo">
            <center>
                <h1>Lista de solicitações</h1>
                <fieldset id="fildespaco">
                    <legend>Informações para Pesquisa</legend>
                    <div id="reserva" class="reservas">

                        <form action="/Gabinete/SolicitacaoControl" onsubmit="return validarConsulta()">
                            <input type="hidden" name="op" value="CONSULTA">

                            <label for="solicitante">Solicitante: </label><br/>
                            <input type="text" id="solicitante" name="solicitante" size="20"><br>

                            <label for="situacao">Situação da solicitação: </label><br/>
                            <input type="text" id="situacao" name="situacao" size="20"><br/><br/>

                            <input id="inputEventos" type="submit" value="Pesquisar">
                        </form>
                    </div>
                </fieldset>
                
                <fieldset id="fildespaco">
                    <legend>Resultado da Pesquisa</legend>
                    <table border="1" cellpadding="1" cellspacing="0">
                        <tr>
                            <th>Número da solicitação</th>
                            <th>Nome do solicitante</th>
                            <th>Objetivo da reserva</th>
                            <th>Data de solicitação</th>
                            <th>Situação</th>
                        </tr>
                        <%

                            if(request.getAttribute("s") == null){

                            }else{

                            Solicitacoes[] s = (Solicitacoes[])request.getAttribute("s");

                                for(int i = 0; i < s.length; i++)
                            {
                        %>
                                <tr>
                                    <td><%= s[i].getId()%></td>
                                    <td><%= s[i].getSolicitante()%></td>
                                    <td><%= s[i].getObjetivo()%></td>
                                    <td><%= s[i].getData()%></td>
                                    <td><%= s[i].getSituacao()%></td>
                                    <td><a href="SolicitacaoControl?op=RESERVATT&id=<%= s[i].getId()%>">Reservar espaço</a></td>
                                </tr>
                        <%
                            }  
                            }
                        %>
                    </table>
                </fieldset>
            </center>
        </div>
    </body>
    <%@include file="../menu.html"%>
    <%@include file="../rodape.html"%>
</html>

