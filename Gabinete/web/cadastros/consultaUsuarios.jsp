<%-- 
    Document   : consultaUsuarios
    Created on : 01/07/2016, 08:13:23
    Author     : DTI
--%>

<%@page import="br.edu.ifrs.modelo.bean.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gabinete</title>
    </head>
    <body>
        <h1>Lista de Usuários</h1>
        <hr>
        
        <form action="/Gabinete/UsuarioControl">
            <input type="hidden" name="op" value="CONSULTA">
            
            <label for="nome">Nome: </label>
            <input type="text" id="nome" name="nome" size="20">
            
            <input type="submit" value="Pesquisar">
        </form>
        
        <hr>
        <a href="UsuarioControl?op=ABRIRFORM">Adicionar</a>
        <table border="1" cellpadding="1" cellspacing="0">
            <tr>
                <th>CPF/th>
                <th>Nome</th>
                <th>Perfil</th>
                <th>Situação</th>
                <th>Ações</th>
            </tr>
            <%
                Usuario[] usus = (Usuario[])request.getAttribute("usuarios");
                
                for (int i=0; i<usus.length; i++) {
            %>
                    <tr>
                        <td><%= usus[i].getCpf()%></td>
                        <td><%= usus[i].getNome()%></td>
                        <td><%= usus[i].getPerfil().getNome() %></td>
                        <td><%= usus[i].getSituacao()%></td>
                        <td>
                            <a href="UsuarioControl?op=CONSATUALIZAR&cpf=<%= usus[i].getCpf()%>">Atualizar</a>&nbsp;
                            <a href="UsuarioControl?op=EXCLUIR&cpf=<%= usus[i].getCpf()%>">Excluir</a>
                        </td>
                    </tr>
            <%
                }
            %>
        </table>
    </body>
</html>
