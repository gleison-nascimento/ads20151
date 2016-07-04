<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<%@include file="../cabecalho.jsp"%> 

<div id="conteudo">
    <div class="formularioEventos">
        <form action="EventosControl" method="post">
                <fieldset id="fieldSolicitante">
                    <legend>
                        Informações de Contato
                    </legend>
                    <label for="solicitante">
                        Solicitante:
                    </label>
                    <br>
                    <input type="text" id="solicitante" value="solicitante">
                    <br> 
                    <label for="entidade">
                        Entidade Solicitante
                    </label>
                    <br>
                    <input type="text" id="entidade" value="entidade">
                    <br> 
                    <label for="email">
                        E-mail:
                    </label>
                    <br>
                    <input type="text" id="email" value="email">
                    <br> 
                    <label for="telefone">
                        Telefone de Contato:
                    </label>
                    <br>
                    <input type="tel" id="telefone" value="telefone">
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
                    <input type="DateTime-Local" id="dataInicial">
                    <br> 
                    <label for="dataFinal">
                        Fim do Evento:
                    </label>
                    <br> 
                    <input type="DateTime-Local" id="dataFinal">
                    <br> 
                    <label for="data">
                        Data da Solicitação:
                    </label>
                    <br> 
                    <input type="date" id="data">
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
                    <textarea id="descricao">
                    </textarea>
                    <br>                    
                </fieldset>
                <br>                
                    <input id="inputEventos" type="submit" value="Enviar">
               
            </form>
    </div>
</div>

<%@include file="../menu.html"%>
<%@include file="../rodape.html"%>
