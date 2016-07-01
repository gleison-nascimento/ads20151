<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<!DOCTYPE html>

<%@include file="../cabecalho.html"%> 

<div id="conteudo">
    <div id="DivRespondeChamado">
        <h1>Responder Chamado</h1>
        <hr size="2">
        <form action="RespondeChamado">
                 <input type="hidden" name="op" value="ATUALIZAR">   
                 <label>Nome do Servidor:</label>
                 <label for="nome"><b>Nome</b></label><br><br>
                 <label>E-mail do Servidor:</label>
                 <label for="email"><b>E-mail</b></label><br><br>
                 <label>Telefone do Servidor:</label>
                 <label for="telefone"><b>Telefone</b></label><br><br>
                 <label for="inicio">Data da Resposta:</label>
                 <input type="date" required><br><br>
                 <label>Descrição da Resposta:</label><br>
                 <textarea name="descricao" id="descricao" rows="5" cols="51" required></textarea><br>
                 <input type="submit" value="Salvar Resposta"><br><br><br>
                 <input type="file" value="Anexar Documento"><br><br><br>
                 <input type="reset" value="Limpar">
                 <input type="submit" value="Responder Chamado">
             </form>
    </div>
</div>

<%@include file="../menu.html"%>
<%@include file="../rodape.html"%>        