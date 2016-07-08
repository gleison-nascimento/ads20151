<%-- 
    Document   : Recepcao
    Created on : 10/06/2016, 09:04:14
    Author     : Rodrigo
--%>
<%@page import="br.edu.ifrs.modelo.bean.Recepcao"%>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<script src="validacoes.js" type="text/javascript"></script>
<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../cabecalho.jsp"%>

<%
            //Usuario p = new Usuario();
            if (request.getSession().getAttribute("login") != null && request.getSession().getAttribute("login") instanceof Usuario) {
                p = (Usuario)request.getSession().getAttribute("login");        
%>

<div id="conteudo">
    <div id="DivAbreChamado">
        <h1>Abertura de chamados</h1>
        <hr size="2">

        <form action="/Gabinete/RecepcaoControl" method="post" onsubmit="return ValidaCampoVazio()"> 
            <input type="hidden" name="op" value="INSERIR">            
            
            <label for="nome">Nome: </label><br>
            <input type="text" name="nome" id="nome" size="50" required><br> <%-- value="<%= p.getNome() %>" --%>

            <label for="Perfil">Perfil do Solicitante:</label><br>
            <select name="Perfil" id="Perfil" required>
                <option value="Aluno">Aluno</option>
                <option value="Servidor">Servidor</option>
                <option value="Pais">Pais</option>
                <option value="Comunidade externa">Comunidade externa</option>
            </select><br>

            <label for="mail">E-Mail: </label><br>
            <input type="text" name="email" id="email" size="50" required><br> <%-- value="<%= p.getNome() %>" --%>

            <label for="fone">Telefone: </label><br>
            <input type="text" name="telefone" id="telefone" size="50" ><br> <%-- value="<%= p.getNome() %>" --%>

            <label for="descr">Descrição da solicitação: </label><br>
            <textarea name="descricao" id="descricao" rows="5" cols="51" required></textarea><br>

            <label for="docs">Documentos em anexo: </label><br>
            <input type="text" name="documentos" id="documentos" size="50" ><br> <%-- value="<%= p.getNome() %>" --%>           

            <input type="submit" value="Enviar">
            <input type="reset" value="Limpar">

        </form> 
    </div>
</div>
            
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