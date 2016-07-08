<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../cabecalho.jsp"%> 

        <%
            //Usuario p = new Usuario();
            if (request.getSession().getAttribute("login") != null) {
                p = (Usuario)request.getSession().getAttribute("login");        
        %>
                
                <div id="conteudo">
                    <div class="formularioEventos">
                        <form action="../EventosControl" method="post">
                                <fieldset id="fieldSolicitante">
                                    <legend>
                                        Solicitante
                                    </legend>
                                    <input type="hidden" name="operacao" value="cadastro">
                                    <label for="solicitante">
                                        Solicitante:
                                    </label>
                                    <br>
                                    <input type="text" id="solicitante" name="solicitante">
                                    <br>
                                    <label for="entidade">
                                        Entidade Solicitante
                                    </label>
                                    <br>
                                    <input type="text" id="entidade" name="entidade">
                                    <br>
                                    <label for="email">
                                        E-mail:
                                    </label>
                                    <br>
                                    <input type="text" id="email" name="email">
                                    <br>
                                    <label for="telefone">
                                        Telefone de Contato:
                                    </label>
                                    <br>
                                    <input type="tel" id="telefone" name="telefone">
                                    <br>
                                </fieldset>
                                <br>
                                <fieldset id="fieldEvento" name="fieldEvento">
                                    <legend>
                                        Evento
                                    </legend>
                                    <label for="dataInicial">
                                        Início do Evento:
                                    </label>
                                    <br>
                                    <input type="datetime-local" id="dataInicial" name="dataInicial">
                                    <br>
                                    <label for="dataFinal">
                                        Fim do Evento:
                                    </label>
                                    <br>
                                    <input type="datetime-local" id="dataFinal" name="dataFinal">
                                    <br>
                                    <label for="data">
                                        Data da Solicitação:
                                    </label>
                                    <br>
                                    <input type="date" id="data" name="data">
                                    <br>
                                    <label for="situacao">
                                        Situacao:
                                    </label>
                                    <br>
                                    <input value="Pendente" type="text" readonly="readonly" id="situacao" name="situacao">
                                    <br>
                                    <label for="descricao">
                                        Descrição do Evento:
                                    </label>
                                    <br>
                                    <textarea id="descricao" name="descricao">
                                        Digite sua descricao aqui!
                                    </textarea>
                                    <br>
                                </fieldset>
                                <br>
                                <fieldset id="fieldAcao" name="fieldAcao">
                                    <legend>
                                        Finalizar
                                    </legend>
                                    <br>
                                    <input type="submit" value="Enviar">
                                </fieldset>
                            </form>
                    </div>
                </div>
                
            <%   
            }
            else{
            %>
            
            <c:redirect url="/eventos/falhaLogin.jsp"/>
            
            <%

            }
            
            


        %>


<%@include file="../menu.html"%>
<%@include file="../rodape.html"%>
