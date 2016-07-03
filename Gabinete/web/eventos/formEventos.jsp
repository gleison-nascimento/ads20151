<%-- 
    Document   : formEvento.jsp
    Created on : 23/06/2016, 22:10: (Revisão | MathiasAzzolini)
    Author     : mathias
    Escopo     : Projeto/Eventos
    Descricao  : Tela JSP para solicitacao de eventos
    Observações: Pode ser alterado.
--%>


<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<script src="validacoes.js" type="text/javascript"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<%@include file="../cabecalho.html"%> 

<div id="conteudo">
    <div class="formularioEventos">
        <form action="EventosControl" method="post" onsubmit="return validarFormulario();">
                <fieldset id="fieldSolicitante">
                    <legend>
                        Informações de Contato
                    </legend>
                    <label for="solicitante">
                        Solicitante:
                    </label>
                    <br>
                    <input type="text" id="solicitante" placeholder="Digite seu nome..." required>
                    <br> 
                    <label for="entidade">
                        Entidade Solicitante
                    </label>
                    <br>
                    <input type="text" id="entidade" placeholder="Digite o nome da sua entidade..." required>
                    <br> 
                    <label for="email">
                        E-mail:
                    </label>
                    <br>
                    <input type="text" id="email" placeholder="Digite seu email para contato..." required>
                    <br> 
                    <label for="telefone">
                        Telefone de Contato:
                    </label>
                    <br>
                    <input type="tel" id="telefone" maxlength="15" placeholder="Ex: (51) 3333-3333" onkeypress="return mascaraTelefone(event,'telefone')" required>
                    <br>
                </fieldset>
                <br>
                <fieldset id="fieldEvento">
                    <legend>
                        Evento
                    </legend>
                    <label for="dataInicial">
                        Início do Evento:
                    </label>
                       <br>
                    <input type="DateTime-Local" id="dataInicial" onchange="verificaDataInicial();" required>
                    <br> 
                    <label for="dataFinal">
                        Fim do Evento:
                    </label>
                    <br> 
                    <input type="DateTime-Local" id="dataFinal" onchange="verificaDataFinal();" required>
                    <br> 
                    <label for="situacao">
                        Situacao:
                    </label>
                    <br> 
                    <input value="Pendente" type="text" readonly="readonly" id="situacao">
                    <br> 
                    <label for="descricao">
                        Descrição do Evento:
                    </label>
                    <br> 
                    <textarea id="descricao" required="true" required/></textarea>
                    <br>                    
                </fieldset>
                <br>                
                    <input id="inputEventos" type="submit" value="Enviar">
               
            </form>
    </div>
</div>

<%@include file="../menu.html"%>
<%@include file="../rodape.html"%>