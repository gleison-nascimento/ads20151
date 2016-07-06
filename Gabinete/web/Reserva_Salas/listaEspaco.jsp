<%-- 
    Document   : listaespaco
    Created on : 15/06/2016, 09:53:38
    Author     : 10070155
--%>

<%@page import="br.edu.ifrs.modelo.bean.Espaco"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../cabecalho.html"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <div id="conteudo">
            <center>
                <h1>Resultado da busca:</h1>
                <br/><br/>
                <form action="espacoControle">

                    <table border="1" cellpadding="1" cellspacing="0">
                        <tr>
                            <th>Seleção</th>
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
                                    <td> <input type="radio" name="select_espaco" value="<%= espaco[i].getNumero() %>" /> </td>
                                    <td><%= espaco[i].getNome()%></td>
                                    <td><%= espaco[i].getNumero()%></td>
                                    <td><%= espaco[i].getDescricao()%></td>
                                    <td><%= espaco[i].getLotacao()%></td>
                                    <td><%= espaco[i].getTipo()%></td>
                                    <td><%= (espaco[i].isProjetor() == true?"Sim":"Não") %></td>
                                    <td><%= (espaco[i].isInternet() == true?"Sim":"Não")%></td>
                                    <td><%= (espaco[i].isQuadro() == true?"Sim":"Não")%></td>
                                    <td><%= espaco[i].getEspecialidade()%></td>
                                    <td><%= espaco[i].getLista_Equipamentos()%></td>
                                    <td><%= espaco[i].getSituacao()%></td>
                                </tr>

                        <%
                            }
                        %>

                    </table>

                    <select name="operacao">
                        <option value="2">ativar</option>
                        <option value="1">desativar</option>
                        <option value="3">editar</option>
                    </select>

                    <input type="submit" value="executar" name="botao" />
                </form>
            </center>
        </div>
    </body>
    <%@include file="../menu.html"%>
    <%@include file="../rodape.html"%>
</html>
