<%--
    Document   : index.jsp
    Created on : 22/06/2016, 09:25:20 (Revisão | EvertonQuadros)
    Author     : Morgana/Natália
    Escopo     : Projeto/Designer
    Descricao  : Tela JSP de teste para novas funcionalidades e formulários
    Observações: Pode ser alterado e deletado.

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
<link href="Estilo.css" rel="stylesheet" type="text/css"/>
<%@include file="cabecalho.jsp"%> 

<div id="conteudo">
    <h1>Seja Bem vindo ao Gabinete Virtual</h1>
    <br><a href="eventos/aceite.jsp">Aceite</a> 
    <br><a href="eventos/erro.jsp">erro</a> 
    <br><a href="eventos/falhaLogin.jsp">Falha Login</a> 
    <br><a href="eventos/formEventos.jsp">Cadastrar Evento</a>     
    <br><a href="eventos/EventoLogin.jsp">Login</a> 
</div>

<%@include file="menu.html"%>
<%@include file="rodape.html"%>