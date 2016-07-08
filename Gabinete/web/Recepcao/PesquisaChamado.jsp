<%@page import="br.edu.ifrs.util.Util"%>
<%-- 
    Document   : ListarChamados
    Created on : Jun 16, 2016, 2:23:43 PM
    Author     : MARCIO
--%>

<%@page import="br.edu.ifrs.modelo.bean.Recepcao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@include file="../cabecalho.html"%> 
        
    <div id="conteudo">  

        <div  id="DivPesquisaChamado">
           <h1>Pesquisar Chamados</h1>
           <hr>
        
           <form action="RecepcaoControl" method="post"  onsubmit="return ValidaCampoVazio()">
                
                <input type="hidden" name="op" value="CONSULTA">
                        
                <label for="nome">Nome: </label><br>
                <input type="text" id="nome" name="nome" size="20"><br>
                
                <label for="inicio">Data de abertura:</label><br>
                <input type="date"><br>
                
                <label for="fim">Data do encerramento:</label><br>
                <input type="date"><br>                                           
            
               <label for="situacao">Situacao: </label><br>
               <select name="situacao" id="situacao" required>
                   <option value="">    </option>
                   <option value="aberto">Aberto</option>
                   <option value="atendimento">Em Atendimento</option>
                   <option value="concluido">Concluido</option>
                </select><br>
            
                <label for="responsavel">Usuario Responsavel: </label><br>
                <select name="responsavel" id="responsavel" required>
                   <option value=" "></option>   
                   <option value=" ">Usuario teste</option>     
                   <option value=" ">Usuario teste</option>      
                   <option value=" ">Usuario teste</option>      
                </select><br>   
            
                <input type="submit" value="Pesquisar">
            
            </form>
        
            <hr>
       
            <table border="1" cellpadding="1" cellspacing="0">
            
                <tr>
                   <th>Protocolo</th>
                   <th>Solicitante</th>
                   <th>Data de Abertura</th>
                   <th>Situação</th>                
                </tr>
                <%
                Recepcao[] busca = (Recepcao[])request.getAttribute("recepcao");
                
                for (int i=0; i<busca.length; i++) {
                %>   
                
                    <tr>
                        <td><%= busca[i].getId()%></td>
                        <td><%= busca[i].getNome_solicitante()%></td>
                        <td><%= Util.formataCalendarToString(busca[i].getData_abertura())%></td>
                        <td><%= busca[i].getSituacao()%></td>
                        <td>
                            <a href="RecepcaoControl?op=ATUALIZAR&id=<%= busca[i].getId()%>">Encaminhar</a>                          
                        </td>
                        <td>
                            <a href="RespondeChamado.jsp">Responder</a>                          
                        </td>
                        
                    </tr>  
                <%
                    }
                %>
                    
            </table>
            
        </div>
                
    </div>
                
<%@include file="../menu.html"%>
<%@include file="../rodape.html"%>
        
  
