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

<%@page import="br.edu.ifrs.modelo.bean.Login"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>        
        <%
            Login p = new Login();
            if (request.getSession().getAttribute("login") != null) {
                p = (Login)request.getSession().getAttribute("login");
            }
        %>
        
        <link href="../Estilo.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro feito com Sucesso</title>
    </head>
    <body>
        
    <center>
        <div id="mensagemTela">     
                
                <p>USUÁRIO <%= p.getLogin() %> LOGADO COM SUCESSO!</p><br>
                <c:redirect url="main.jsp"/>
                  
        </div>
        
    </center>
        
        
        
        
        
    </body>
</html>
