<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Responder Chamado</title>
        <style>
            textarea { 
                resize: none; 
            }
        </style>
    </head>
    <body>
        <div>
             <form action="RespondeChamado">
                 <label>Nome do Servidor:</label>
                 <label for="nome"><b>Nome</b></label><br><br>
                 <label>E-Mail do Servidor:</label>
                 <label for="email"><b>E-mail</b></label><br><br>
                 <label>Telefone do Servidor:</label>
                 <label for="telefone"><b>Telefone</b></label><br><br>
                 <label for="inicio">Data da Resposta:</label>
                 <input type="date"><br><br>
                 <label>Descrição da Resposta:</label><br>
                 <textarea name="descricao" id="descricao" rows="8" cols="80" required></textarea><br>
                 <input type="submit" value="Salvar Resposta"><br><br>
                 <label for="inicio"><b>Nenhum arquivo selecionado</b></label><br>
                 <input type="submit" value="Anexar Documento"><br><br><br>
                 <input type="reset" value="Limpar">
                 <input type="submit" value="Responder Chamado">
             </form>
        </div>
    </body>
</html>
