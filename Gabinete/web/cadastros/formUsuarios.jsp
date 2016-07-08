<%-- 
    Document   : formUsuarios
    Created on : 11/05/2016, 08:27:48
    Author     : DTI
--%>

<%@page import="br.edu.ifrs.modelo.bean.Usuario"%>
<%@page import="br.edu.ifrs.modelo.bean.Perfil"%>
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
        <title>Gabinete Virtual</title>
        <script src="validacoes.js" type="text/javascript"></script>
    </head>
    <body>
        <h1>Cadastro de Usuários</h1>
        <hr>
        <%
            Usuario u = new Usuario();
            if (request.getSession().getAttribute("usuario") != null) {
                u = (Usuario)request.getSession().getAttribute("usuario");
            }
        %>
        <form action="/Gabinete/UsuarioControl" method="post" onsubmit="return validarUsuario();">
            <input type="hidden" name="op" value="<%= (u.getCpf() == "" ? "INSERIR":"ATUALIZAR") %>">
            
            <label for="cpf">CPF: </label><br>
            <input type="text" name="cpf" id="cpf" value="<%= u.getCpf()%>" size="20" required><br>
            
            <label for="matricula">Matrícula: </label><br>
            <input type="text" name="matricula" id="matricula" value="<%= u.getMatricula()%>" size="10"><br>
            
            <label for="nome">Nome: </label><br>
            <input type="text" name="nome" id="nome" value="<%= u.getNome()%>" size="50" required><br>
            
            <label for="sexo">Sexo: </label>
            <input type="radio" name="sexo" id="feminino" value="F" <%= u.getSexo().equals("F") ? "checked":"" %> required><label for="feminino">Feminino</label>
            <input type="radio" name="sexo" id="masculino" value="M" <%= u.getSexo().equals("M") ? "checked":"" %>><label for="masculino">Masculino</label><br>
            
            <label for="endereco">Endereço: </label><br>
            <textarea name="endereco" id="endereco" rows="5" cols="50"><%= u.getEndereco()%></textarea><br>
            
            <label for="email">Email: </label><br>
            <input type="text" name="email" id="email" value="<%= u.getEmail()%>" size="30"><br>
            
            <label for="telefone">telefone: </label><br>
            <input type="text" name="telefone" id="telefone" value="<%= u.getTelefoneResidencial()%>" size="20"><br>
            
            <label for="perfil">Perfil: </label>
            <select name="perfil" id="perfil">
            <%
                Perfil[] perfis = (Perfil[])request.getAttribute("perfis");
                for (int i=0; i<perfis.length; i++) {
            %>
                    <option value="<%= perfis[i].getId()%>" <%= u.getPerfil().getId() == perfis[i].getId() ? "selected":"" %>><%= perfis[i].getNome()%></option>
            <%
                }
            %>
            </select><br>
            
            <label for="username">Username: </label><br>
            <input type="text" name="username" value="<%= u.getUsername()%>" id="username" size="30"><br>
            
            <label for="senha">Senha: </label><br>
            <input type="password" name="senha" id="senha" size="20"><br>
            
            <label for="confsenha">Confimar Senha: </label><br>
            <input type="password" name="confsenha" id="confsenha" size="20"><br>
            
            <label for="situacao">Situação: </label>
            <input type="radio" name="situacao" id="sitativo" <%= u.getSituacao().equals("A") ? "checked":"" %> value="A"><label for="sitativo">Ativo</label>
            <input type="radio" name="situacao" id="sitinativo" <%= u.getSituacao().equals("I") ? "checked":"" %> value="I"><label for="sitinativo">Inativo</label><br>
            
            <input type="submit" value="Enviar">
            <input type="reset" value="Limpar">
        </form>
        
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