<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
             <form action="RespondeChamado">
                 <label for="nome">Nome do Servidor: </label><br>
                 <input type="text" name="nome" id="nome" size="50" required><br> <%-- value="<%= p.getNome() %>" --%>
                 <label for="mail">E-Mail do Servidor: </label><br>
                 <input type="text" name="email" id="email" size="50" required><br> <%-- value="<%= p.getNome() %>" --%>
                 <label for="fone">Telefone do Servidor: </label><br>
                 <input type="text" name="telefone" id="telefone" size="50" ><br> <%-- value="<%= p.getNome() %>" --%>
                 <label for="descr">Descrição da Resposta: </label><br>
                 <textarea name="descricao" id="descricao" rows="5" cols="51" required></textarea><br>
             </form>
        </div>
    </body>
</html>
