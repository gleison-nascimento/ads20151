<%-- 
    Document   : listaespaco
    Created on : 15/06/2016, 09:53:38
    Author     : 10070155
--%>

<%@page import="modelo.Espaco"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../cabecalho.html"%> 
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista</title>
    </head>
    <body>
        <div id="conteudo">
            <center>
                <h1>Resultado da busca:</h1>

                <br/><br/>

                <table border="1" cellpadding="1" cellspacing="0">
                    <tr>
                        <th>Nome</th>
                        <th>Numero</th>
                        <th>Descrição</th>
                        <th>Lotação</th>
                        <th>Tipo</th>
                        <th>Tem Projetor</th>
                        <th>Tem Internet</th>
                        <th>Tem Quadro</th>
                        <th>Especialidade</th>
                        <th>Lista de Equipamentos</th>
                        <th>Situação</th>
                    </tr>

                    <% 
                        Espaco [] espaco = (Espaco[])request.getAttribute("espacos");

                        for (int i=0; i<espaco.length; i++) { 
                    %> 

                            <tr>
                                <td><%= espaco[i].getNome()%></td>
                                <td><%= espaco[i].getNumero()%></td>
                                <td><%= espaco[i].getDescricao()%></td>
                                <td><%= espaco[i].getLotacao()%></td>
                                <td><%= espaco[i].getTipo()%></td>
                                <td><%= espaco[i].isProjetor()%></td>
                                <td><%= espaco[i].isInternet()%></td>
                                <td><%= espaco[i].isQuadro()%></td>
                                <td><%= espaco[i].getEspecialidade()%></td>
                                <td><%= espaco[i].getLista_Equipamentos()%></td>
                                <td><%= espaco[i].getSituacao()%></td>
                            </tr>

                    <%
                        }
                    %>
                </table>
            </center>
        </div>
    </body>
    <%@include file="../menu.html"%>
    <%@include file="../rodape.html"%>
</html>
