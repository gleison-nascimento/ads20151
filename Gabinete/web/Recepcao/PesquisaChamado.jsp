<%-- 
    Document   : Recepcao_PesquisaChamado
    Created on : 15/06/2016, 09:17:13
    Author     : 10070160
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <form action="PesquisaChamado">
                
                <label for="nome">Nome do Solicitante: </label><br>
                <input type="text" name="nome" id="nome" size="40" required><br> <%-- value="<%= p.getNome() %>" --%>
                
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
                </select><br>              
                                
                <input type="submit" value="Enviar">
                <input type="reset" value="Limpar">        
                
            </form>
        </div>                
                
    </body>
</html>
