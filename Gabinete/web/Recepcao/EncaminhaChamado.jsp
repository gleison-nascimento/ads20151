<%-- 
    Document   : EncaminhaChamado
    Created on : Jun 16, 2016, 3:25:06 PM
    Author     : MARCIO
--%>

<%@page import="br.edu.ifrs.modelo.bean.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../cabecalho.jsp"%> 

        <%
            //Usuario p = new Usuario();
            if (request.getSession().getAttribute("login") != null && request.getSession().getAttribute("login") instanceof Usuario) {
                p = (Usuario)request.getSession().getAttribute("login");        
        %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gabinete</title>
    </head>
    <body>
        <h1>Encaminhar Chamados</h1>
        
        <form action="RecepcaoControl" method="post"  onsubmit="return ValidaCampoVazio()">
            
            <input type="hidden" name="op" value="ATUALIZAR">
            
            <%
                Usuario[] busca = (Usuario[])request.getAttribute("servidor");
                
                for (int i=0; i<busca.length; i++) {
            %>   
            
                <label for="servidor">Servidores: </label><br>
                <select name="servidor" id="servidor" required>
                    <option value=" "><%= busca[i].getNome()%></option>                       
                </select><br>   
            
            <%
                }
            %>
            
            <label for="descricao">Descrição do encaminhamento: </label><br>
            <textarea name="descricao" id="descricao" rows="5" cols="51" required></textarea><br>
            
            <input type="submit" value="Encaminhar Chamado">
            
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
