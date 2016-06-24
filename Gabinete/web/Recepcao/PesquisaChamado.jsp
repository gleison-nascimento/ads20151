 <%-- 
    Document   : ListarChamados
    Created on : Jun 16, 2016, 2:23:43 PM
    Author     : MARCIO
--%>

<%@page import="br.edu.ifrs.modelo.bean.Recepcao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gabinete</title>
    </head>
    <body>
        <div>
           <h1>Pesquisar Chamados</h1>
           <hr>
        
           <form action="PesquisaChamado">
                        
                <label for="nome">Nome: </label><br>
                <input type="text" id="nome" name="nome" size="20"><br>
                
                <label for="inicio">Data de abertura:</label>
                <input type="date"><br><br>
                
                <label for="fim">Data do encerramento:</label>
                <input type="date"><br><br>                                           
            
               <label for="situacao">Situacao: </label><br>
               <select name="situacao" id="situacao" required>
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
                Recepcao[] busca = (Recepcao[])request.getAttribute("chamados");
                
                for (int i=0; i<busca.length; i++) {
                %>   
                
                    <tr>
                        <td><%= busca[i].getId()%></td>
                        <td><%= busca[i].getNome_solicitante()%></td>
                        <td><%= busca[i].getData_abertura()%></td>
                        <td><%= busca[i].getSituacao()%></td>
                        <td>
                            <a href="EncaminhaChamado.jsp">Encaminhar</a>                          
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
        
    </body>
</html>
