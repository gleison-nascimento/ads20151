<%-- 
    Document   : formUsuarios
    Created on : 11/05/2016, 08:27:48
    Author     : DTI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gabinete Virtual</title>
        <script src="validacoes.js" type="text/javascript"></script>
    </head>
    <body>
        <h1>Cadastro de Usuários</h1>
        <hr>
        <form action="UsuarioControl" method="post" onsubmit="return validarUsuario();">
            <label for="cpf">CPF: </label><br>
            <input type="text" name="cpf" id="cpf" size="20" required><br>
            
            <label for="matricula">Matrícula: </label><br>
            <input type="text" name="matricula" id="matricula" size="10"><br>
            
            <label for="nome">Nome: </label><br>
            <input type="text" name="nome" id="nome" size="50" required><br>
            
            <label for="sexo">Sexo: </label>
            <input type="radio" name="sexo" id="feminino" value="F" required><label for="feminino">Feminino</label>
            <input type="radio" name="sexo" id="masculino" value="M"><label for="masculino">Masculino</label><br>
            
            <label for="endereco">Endereço: </label><br>
            <textarea name="endereco" id="endereco" rows="5" cols="50"></textarea><br>
            
            <label for="email">Email: </label><br>
            <input type="text" name="email" id="email" size="30"><br>
            
            <label for="telefone">telefone: </label><br>
            <input type="text" name="telefone" id="telefone" size="20"><br>
            
            <label for="perfil">Perfil: </label>
            <select name="perfil" id="perfil">
                <option value="1">Servidor</option>
                <option value="2">Aluno</option>
            </select><br>
            
            <label for="username">Username: </label><br>
            <input type="text" name="username" id="username" size="30"><br>
            
            <label for="senha">Senha: </label><br>
            <input type="password" name="senha" id="senha" size="20"><br>
            
            <label for="confsenha">Confimar Senha: </label><br>
            <input type="password" name="confsenha" id="confsenha" size="20"><br>
            
            <label for="situacao">Situação: </label>
            <input type="radio" name="situacao" id="sitativo" value="A"><label for="sitativo">Ativo</label>
            <input type="radio" name="situacao" id="sitinativo" value="I"><label for="sitinativo">Inativo</label><br>
            
            <input type="submit" value="Enviar">
            <input type="reset" value="Limpar">
        </form>
        
    </body>
</html>
