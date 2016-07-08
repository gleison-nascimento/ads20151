<%-- 
    Document   : formEvento.jsp
    Created on : 22/06/2016, 09:40: (Revisão | MathiasAzzolini)
    Author     : mathias
    Escopo     : Projeto/Eventos
    Descricao  : Tela JSP para solicitacao de eventos
    Observações: Pode ser alterado.
--%>


<%@page import="br.edu.ifrs.modelo.bean.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.edu.ifrs.modelo.bean.Evento"%>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<%@include file="../cabecalho.jsp"%> 

<div id="conteudo">
    
    <%
            if (request.getSession().getAttribute("login") != null) {
                p = (Usuario)request.getSession().getAttribute("login");        
    %>
    
    <center><h3> Lista de Solicitação de Eventos:</h3></center>
    <center><table>
            <tr>
                <td>ID solicitação</td>
                <td>Solicitante</td>
                <td>Data de Solicitação</td>
                <td>Descrição</td>
                <td>Situação</td>
                <td>Ações</td>
            </tr>
            <%
                if(request.getAttribute("eventos") instanceof ArrayList){
                    ArrayList<Evento> minhaArray = (ArrayList) request.getAttribute("eventos");
                    for (int i=0; i<minhaArray.size(); i++) {
            %>
                    <tr>
                        <td><%= minhaArray.get(i).getId()%></td>
                        <td><%= minhaArray.get(i).getSolicitante()%></td>
                        <td><%= minhaArray.get(i).getDiaSolicitacao()%></td>
                        <td><%= minhaArray.get(i).getDescricao()%></td>
                        <td><%= minhaArray.get(i).getSituacao()%></td>
                        <td>
                                <a href="EventosControl?op=aceitar&id=<%= minhaArray.get(i).getId()%>">Aceitar</a>&nbsp;
                                <a href="EventosControl?op=excluir&id=<%= minhaArray.get(i).getId()%>">Excluir</a>
                        </td>
                    </tr>
            <%
                }
                }
            %>
    </table></center>
    
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
