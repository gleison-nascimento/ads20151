<%@page import="br.edu.ifrs.modelo.bean.Solicitacoes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@include file="../cabecalho.jsp"%> 

        <%
            //Usuario p = new Usuario();
            if (request.getSession().getAttribute("login") != null && request.getSession().getAttribute("login") instanceof Usuario) {
                p = (Usuario)request.getSession().getAttribute("login");        
        %>
    <html>    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="validacoes.js" type="text/javascript"></script>
    </head>
    
    <body>
        <div id="conteudo">
            <center>
                <h1>Lista de solicitações</h1>
                <hr>

                <form action="/Gabinete/SolicitacaoControl" onsubmit="return validarConsulta()">
                    <input type="hidden" name="op" value="CONSULTA">

                    <label for="solicitante">Solicitante: </label>
                    <input type="text" id="solicitante" name="solicitante" size="20"><br>

                    <label for="situacao">Situação da solicitação: </label>
                    <input type="text" id="situacao" name="situacao" size="20">

                    <input type="submit" value="Pesquisar">
                </form>

                <hr>
                <table border="1" cellpadding="1" cellspacing="0">
                    <tr>
                        <th>Número da solicitação</th>
                        <th>Nome do solicitante</th>
                        <th>Objetivo da reserva</th>
                        <th>Data de solicitação</th>
                        <th>Situação</th>
                    </tr>
                    <%
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
                                <td><a href="espacoControl?op=RESERVATT&id=<%= s[i].getId()%>">Reservar espaço</a></td>
                            </tr>
                    <%
                        }
                    %>
                </table>
            </center>
        </div>
    </body>
    </html>
    
               <%   
            }
            else{
            %>
            
            <c:redirect url="/eventos/falhaLogin.jsp"/>
            
            <%

            }
            
            


        %>
    
    <%@include file="../menu.html"%>
    <%@include file="../rodape.html"%>