<%-- 
    Document   : aceite.jsp
    Created on : 21/06/2016, 09:33:20
    Author     : EvertonQuadros
    Escopo     : Eventos
    Descricao  : Tela JSP de teste para quando o perfil selecionado tiver 
                 permissão de administrador do sistema.
    Observações: Pode ser alterado e deletado.

  Revisao     :  dia 01 de Julho
    Autor       : Morgana
    Escopo      :  Layout
    Descricao   :  Foi inserido nesta página os estilos padrão, no entanto não utilizamos os includes
                   pois existem informações do HEAD desta página, assim chamamos diretamente o css.
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
                
                <p>USUÁRIO <%= p.getUsername() %> LOGADO COM SUCESSO!</p><br>
                <a href="main.jsp">Voltar</a>
              <%--  <c:redirect url="main.jsp"/> --%>
                  
        </div>
        


<%@include file="../menu.html"%>
<%@include file="../rodape.html"%>