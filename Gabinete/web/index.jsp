<%--
    Document   : index.jsp
    Created on : 22/06/2016, 09:25:20 (Revis�o | EvertonQuadros)
    Author     : Morgana/Nat�lia
    Escopo     : Projeto/Designer
    Descricao  : Tela JSP de teste para novas funcionalidades e formul�rios
    Observa��es: Pode ser alterado e deletado.

    Revisao     :  dia 23 de julho
    Autor       :  Mathias Azzolini
    Escopo      :  organizacao / refatoracao
    Descricao   :  foi criado o arquivo index.jsp para tela inicial e corrigido 
                   algum erros de sintaxe do html.


--%>

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<%@page session="true" %>
<%

    session.setAttribute("login", null);


%>

<%@include file="main.jsp"%>