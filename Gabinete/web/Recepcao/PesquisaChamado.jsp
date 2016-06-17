<%-- 
    Document   : ListarChamados
    Created on : Jun 16, 2016, 2:23:43 PM
    Author     : MARCIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gabinete</title>
    </head>
    <body>
        <h1>Pesquisar Chamados</h1>
        <hr>
        
        <form action="PesquisaChamado">
                        
            <label for="nome">Nome: </label><br>
            <input type="text" id="nome" name="nome" size="20"><br>
            
            <label for="inicio">Data de Inicio: </label><br>
            <input type="text" name="inicio" id="inicio"  size="20" required><br> <%-- value="<%= p.getNome() %>" --%>
            
            <label for="fim">Data de Encerramento: </label><br>
            <input type="text" name="fim" id="fim" size="20" required><br> <%-- value="<%= p.getNome() %>" --%>
            
            <label for="situacao">Situacao: </label><br>
            <select name="situacao" id="situacao" required>
                <option value="aberto">Aberto</option>
                <option value="atendimento">Em Atendimento</option>
                <option value="concluido">Concluido</option>
            </select><br>
            
            <label for="responsavel">Usuario Responsavel: </label><br>
            <select name="responsavel" id="responsavel" required>
               <option value=" ">Usuario teste</option>     
               <option value=" ">Usuario teste</option>      
               <option value=" ">Usuario teste</option>      
            </select><br>   
            
            <input type="submit" value="Pesquisar">
            
        </form>
        
        <hr>
        <a href="">Adicionar</a>
        <table border="1" cellpadding="1" cellspacing="0">
            
            <tr>
                <th>Protocolo</th>
                <th>Solicitante</th>
                <th>Data de Abertura</th>
                <th>Situação</th>                
            </tr>
            
                    <tr>
                        <td>     </td>
                        <td>     </td>
                        <td>     </td>
                        <td>     </td>
                        <td>
                            <a href="EncaminhaChamado.jsp">Encaminhar</a>;                            
                        </td>
                    </tr>   
                    
        </table>
        
    </body>
</html>
