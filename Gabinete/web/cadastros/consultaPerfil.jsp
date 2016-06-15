<%-- 
    Document   : consultaPerfil
    Created on : 01/06/2016, 08:34:25
    Author     : DTI
--%>

<%@page import="br.edu.ifrs.modelo.bean.Perfil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gabinete</title>
    </head>
    <body>
        <h1>Lista de Perfis</h1>
        <hr>
        
        <form action="/Gabinete/PerfilControl">
            <input type="hidden" name="op" value="CONSULTA">
            
            <label for="nome">Nome: </label>
            <input type="text" id="nome" name="nome" size="20">
            
            <input type="submit" value="Pesquisar">
        </form>
        
        <hr>
        <a href="cadastros/formPerfil.jsp">Adicionar</a>
        <table border="1" cellpadding="1" cellspacing="0">
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Descrição</th>
                <th>Situação</th>
                <th>Ações</th>
            </tr>
            <%
                Perfil[] per = (Perfil[])request.getAttribute("perfis");
                
                for (int i=0; i<per.length; i++) {
            %>
                    <tr>
                        <td><%= per[i].getId()%></td>
                        <td><%= per[i].getNome()%></td>
                        <td><%= per[i].getDescricao()%></td>
                        <td><%= per[i].getSituacao()%></td>
                        <td>
                            <a href="PerfilControl?op=CONSATUALIZAR&id=<%= per[i].getId()%>">Atualizar</a>&nbsp;
                            <a href="PerfilControl?op=EXCLUIR&id=<%= per[i].getId()%>">Excluir</a>
                        </td>
                    </tr>
            <%
                }
            %>
        </table>
        
    </body>
</html>
