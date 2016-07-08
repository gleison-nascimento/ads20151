<%-- 
    Document   : formPerfil
    Created on : 06/05/2016, 08:22:22
    Author     : DTI
--%>

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
        <h1>Cadastro de Perfis</h1>
        <hr>
        <%
            Perfil c = new Perfil();
            if (request.getSession().getAttribute("perfil") != null) {
                c = (Perfil)request.getSession().getAttribute("perfil");
            }
        %>    
  <!-- onsubmit="return validarPerfil();" -->      
        <form action="/Gabinete/PerfilControl" >
            <input type="hidden" name="op" value="<%= (c.getId() == 0 ? "INSERIR":"ATUALIZAR") %>">
            <input type="hidden" name="id" value="<%= c.getId() %>">
            
            <label for="nome">Nome: </label><br>
            <input type="text" name="nome" id="nome" size="50" value="<%= p.getNome() %>"><br>
            
            <label for="descricao">Descrição: </label><br>
            <textarea name="descricao" id="descricao" rows="5" cols="50"><%= c.getDescricao() %></textarea><br>
            
            <label for="situacao">Situação: </label>
            <input type="radio" name="situacao" id="sitativo" value="A" <%= (p.getSituacao().equals("A") ? "checked":"") %>><label for="sitativo" >Ativo</label>
            <input type="radio" name="situacao" id="sitinativo" value="I" <%= (p.getSituacao().equals("I") ? "checked":"") %>><label for="sitinativo">Inativo</label><br>
            
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
