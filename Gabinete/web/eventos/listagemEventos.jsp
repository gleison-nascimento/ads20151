<%-- 
    Document   : formEvento.jsp
    Created on : 22/06/2016, 09:40: (Revis�o | MathiasAzzolini)
    Author     : mathias
    Escopo     : Projeto/Eventos
    Descricao  : Tela JSP para solicitacao de eventos
    Observa��es: Pode ser alterado.
--%>


<%@page import="java.util.ArrayList"%>
<%@page import="br.edu.ifrs.modelo.bean.Evento"%>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<%@include file="../cabecalho.html"%> 

<div id="conteudo">
    <center><h3> Lista de Solicita��o de Eventos:</h3></center>
    <center><table>
            <tr>
                <td>ID solicita��o</td>
                <td>Solicitante</td>
                <td>Data de Solicita��o</td>
                <td>Descri��o</td>
                <td>Situa��o</td>
                <td>A��es</td>
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
</div>

<%@include file="../menu.html"%>
<%@include file="../rodape.html"%>