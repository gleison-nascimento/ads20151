<%-- 
    Document   : Recepcao
    Created on : 10/06/2016, 09:04:14
    Author     : Rodrigo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%-- <%@include file="cabecalho.html"%> --%>
<html>
    <div>
        <form action="CadastraChamado">
            <label for="nome">Nome: </label><br>
            <input type="text" name="nome" id="nome" size="50" required><br> <%-- value="<%= p.getNome() %>" --%>

            <label for="Perfil">Perfil do Solicitante:</label>
            <select name="Perfil" id="Perfil" required>
                <option value="Aluno">Aluno</option>
                <option value="Servidor">Servidor</option>
                <option value="Pais ou comunidade externa">Pais ou comunidade externa</option>
            </select><br>
            
            <label for="mail">E-Mail: </label><br>
            <input type="text" name="email" id="email" size="80" required><br> <%-- value="<%= p.getNome() %>" --%>

            <label for="fone">Telefone: </label><br>
            <input type="text" name="telefone" id="telefone" size="50" ><br> <%-- value="<%= p.getNome() %>" --%>
            
            <label for="descr">Descrição da solicitação: </label><br>
            <textarea name="descricao" id="descricao" rows="5" cols="40" required></textarea>

            <label for="docs">Documentos em anexo: </label><br>
            <input type="text" name="documentos" id="documentos" size="80" ><br> <%-- value="<%= p.getNome() %>" --%>           

            <input type="submit" value="Enviar">
            <input type="reset" value="Limpar">
            
        </form> 
    </div>
</html>
<%-- <%@include file="rodape.html"%> --%>
