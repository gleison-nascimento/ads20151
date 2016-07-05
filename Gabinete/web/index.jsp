<%-- 
    Document   : index.jsp
    Created on : 22/06/2016, 09:25:20 (Revisão | EvertonQuadros)
    Author     : Morgana/Natalia
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
<%@include file="cabecalho.html"%> 

<div id="conteudo">
    <center>
        <h1>Seja Bem vindo ao Gabinete Virtual</h1>
        <br><a href="eventos/EventoLogin.jsp">Login</a> 
    </center>
</div>

<%@include file="menu.html"%>
<%@include file="rodape.html"%>