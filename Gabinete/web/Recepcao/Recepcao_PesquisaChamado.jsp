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
            <form action="">
                <label for="solicitante">Solicitante: </label><br>
                <input type="text" name="solicitante" id="solicitante" size="50" required><br> <%-- value="<%= p.getNome() %>" --%>
                
                <label for="abertura">Data de abertura: </label><br>
                <input type="text" name="abertura" id="abertura" size="20" required><br> <%-- value="<%= p.getNome() %>" --%>
                
                <label for="fecha">Data de encerramento: </label><br>
                <input type="text" name="fecha" id="fecha" size="20" required><br> <%-- value="<%= p.getNome() %>" --%>
                
                
                <label for="situacao">Situacao: </label><br>
                <select name="situacao" id="situacao" required>
                   <option value="aberto">Aberto</option>
                   <option value="atendimento">Em Atendimento</option>
                   <option value="concluido">Concluido</option>
                </select><br>
                
                <label for="responsavel">Usuario responsavel: </label><br>
                <input type="text" name="responsavel" id="responsavel" size="50" required><br> <%-- value="<%= p.getNome() %>" --%>
                
                <input type="submit" value="Enviar">
                <input type="reset" value="Limpar">         
                
            </form>
        </div>
    </body>
</html>
