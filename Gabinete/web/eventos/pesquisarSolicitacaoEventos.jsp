<%-- 
    Document   : pesquisarSolicitacaoEventos.jsp
    Created on : 04/07/2016, 19:40: (Revis�o | MathiasAzzolini)
    Author     : mathias
    Escopo     : Projeto/Eventos
    Descricao  : Tela JSP para pesquisa solicitacao de eventos
    Observa��es: Pode ser alterado.
--%>


<%@page import="br.edu.ifrs.modelo.bean.Usuario"%>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<%@include file="../cabecalho.jsp"%> 

<div id="conteudo">
    
    <%
            if (request.getSession().getAttribute("login") != null && request.getSession().getAttribute("login") instanceof Usuario) {
                p = (Usuario)request.getSession().getAttribute("login");        
    %>
    
    <div class="formularioEventos">
        <form action="../EventosControl" method="post">
                <fieldset id="fieldSolicitante">
                    <legend> Solicitante</legend>
                    <input type="hidden" name="operacao" value="pesquisa">
                    <label for="nomeSolicitante"> Nome do Solicitante: </label>
                    <br>
                    <input type="text" id="nomeSolicitante" name="nomeSolicitante">
                    <br>
                    <label for="dataInicio">Data In�cio</label>
                    <br>
                    <input type="date" id="dataInicio" name="dataInicio">
                    <br>
                    <label for="dataLimite">Data Limite:</label>
                    <br>
                    <input type="date" id="dataLimite" name="dataLimite">
                    <br>
                    <label for="situacao" > Situa��o:</label>
                    <br/>
                    <select name="tipo_espaco" id="tipo_espaco" >
                        <option value="pendente">Pendente</option>
                        <option value="concluido">Conclu�do</option>
                        <option value="cancelado">Cancelado</option>
                    </select>
                </fieldset>
                <fieldset id="fieldAcao" name="fieldAcao">
                    <legend>
                        Finalizar
                    </legend>
                    <br>
                    <input type="submit" value="Enviar">
                </fieldset>
            </form>
    </div>
    <%   
            }
            else{
            %>
            
            <c:redirect url="/eventos/falhaLogin.jsp"/>
            
            <%

            }
            
            


        %>
</div>

<%@include file="../menu.html"%>
<%@include file="../rodape.html"%>