<%-- 
    Document   : Formreserva
    Created on : 22/06/2016, 09:36:33
    Author     : 10070174
--%>

<%@page import="br.edu.ifrs.modelo.bean.Espaco"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../cabecalho.html"%> 
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="Estilos.css" rel="stylesheet" type="text/css"/>
        <script src="Validacoes.js" type="text/javascript"></script>
    </head>
    <body>
        <center>
            <h1>Cadastro de Espaço</h1><br>
            <hr>
            <% Espaco R = (Espaco)request.getAttribute("R"); %>

            <div id="conteudo">
                <form action="espacoControle" method="post" onsubmit="return ValidarEspaco()">

                    <input type="hidden" name="operacao" value="4">

                    <label for="nome">Nome:</label><br>
                    <input type="text" name="nome" id="nome" size="30" value="<%= R.getNome()%>">
                    <br><br>

                    <label for="numero">Numero da Sala:</label><br>
                    <input type="text" name="numero" id="numero" size="15" value="<%= R.getNumero()%>" required><br><br>

                    <label for="descricao">Descrição:</label><br>
                    <input type="text" name="descricao" id="descricao" size="50" value="<%=R.getDescricao()%>" required><br><br>

                    <label for="lotacao">Numero máximo de pessoas na sala:</label><br>
                    <input type="text" name="lotacao" id="lotacao" size="15" value="<%=R.getLotacao()%>"required><br><br>

                    <label for="tipo">Tipo de Laboratório:</label><br>
                    <select name="tipo"  id="tipo">
                        <option value="" <%= (R.getTipo().equals("")?"selected":"") %> >Selecione uma Sala</option>
                        <option value="Sala de Aula" <%= (R.getTipo().equals("Sala de Aula")?"selected":"") %> >Sala de Aula</option>
                        <option value="Laboratorio" <%= (R.getTipo().equals("Laboratorio") ? "selected":"") %> >Laboratório</option>
                        <option value="Multifuncional" <%= (R.getTipo().equals("Multifuncional") ? "selected":"") %> >Multifuncional</option>
                    </select><br><br>

                    <label for="projetor">Projetor na sala: </label>
                    <input type="radio" name="projetor"   <%= (R.isProjetor() ? "checked":"") %> ><label for="sitativo">Sim</label>
                    <input type="radio" name="projetor"   <%= (!R.isProjetor() ? "checked":"") %> ><label for="sitativo">Não</label><br> <br>

                    <label for="internet">Internet na sala: </label>
                    <input type="radio" name="internet"   <%= (R.isInternet() ? "checked":"") %> > <label for="sitativo">Sim</label>
                    <input type="radio" name="internet"   <%= (!R.isInternet() ? "checked":"") %> ><label for="sitinativo">Não</label><br> <br>

                    <label for="quadro">Quadro na sala: </label>
                    <input type="radio" name="quadro"   <%= (R.isQuadro() ? "checked":"") %>><label for="sitativo">Sim</label>
                    <input type="radio" name="quadro"   <%= (!R.isQuadro() ? "checked":"") %>><label for="sitinativo">Não</label><br><br> 

                    <label for="especialidade">Especialidades:</label><br>
                    <input type="text" name="especialidade" id="especialidade" size="50" value="<%=R.getEspecialidade()%>" required><br><br>

                    <label for="equipamentos">Equipamentos:</label><br>
                    <input type="text" name="equipamentos" id="equipamentos" size="40" value="<%=R.getLista_Equipamentos()%>"><br><br>

                    <label for="situacao">Situação: </label>
                    <input type="radio" name="situacao" value="Ativo"  <%= (R.getSituacao().equals("Ativo") ? "checked":"") %>><label for="sitativo" >Ativo</label>
                    <input type="radio" name="situacao" value="Inativo"  <%= (!R.getSituacao().equals("Ativo") ? "checked":"") %>><label for="sitinativo">Inativo</label><br>

                    <input type="submit" value="Alterar">

                </form>        
            </div>
        </center>
    </body>
    <%@include file="../menu.html"%>
    <%@include file="../rodape.html"%>
</html>
