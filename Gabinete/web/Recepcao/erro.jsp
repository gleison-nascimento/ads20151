<%-- 
    Document   : erro
    Created on : 29/06/16
    Author     : Rodrigo Sebben
--%>

<%@page import="br.edu.ifrs.modelo.bean.Usuario"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<%@include file="../cabecalho.jsp"%> 
           
        <%
            //Usuario p = new Usuario();
            if (request.getSession().getAttribute("login") != null) {
                p = (Usuario)request.getSession().getAttribute("login");
            }
            
        %>
        
        <link href="../Estilo.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     
 
 
        <div id="conteudo">     
                
               <p><%= request.getAttribute("msg_erro")%></p>
                <a href="AbreChamado.jsp">Voltar</a>
              <%--  <c:redirect url="main.jsp"/> --%>
                  
        </div>
        


<%@include file="../menu.html"%>
<%@include file="../rodape.html"%>