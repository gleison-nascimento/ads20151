<%-- 
    Document   : falhaLogin.jsp
    Created on : 21/06/2016, 09:33:20
    Author     : EvertonQuadros
    Escopo     : Eventos
    Descricao  : Tela JSP de teste para quando o perfil selecionado não tiver 
                 permissão de administrador do sistema.
    Observações: Pode ser alterado e deletado.
--%>

<%@page import="br.edu.ifrs.modelo.bean.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="../Estilo.css" rel="stylesheet" type="text/css"/>
<!DOCTYPE html>
<%@include file="../cabecalho.jsp"%>

        <%
            //Usuario p = new Usuario();
            if (request.getSession().getAttribute("login") != null) {
                p = (Usuario)request.getSession().getAttribute("login");
            }
        %>
    <%--  
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Usuário Não Autenticado</title>
        </head>
        <body>
            <div id="mensagemTela">
                <center>
                    <br>
                <img src="/Gabinete/imagens/proibido.png" alt="Erro"  title="Erro"  width="30" height="30px">   
                    <h3>ERRO <%= p.getUsername() %> Usuário não possui permissão de Acesso</h3><br>
                     <a href="index.jsp">Voltar</a>     
                 </div>
            </center>


        </body>
    </html>
    --%>

    <div id="conteudo">     
        <%
            if(p.getUsername() != null && !p.getUsername().equals("")){
                %>
            <center>
                <img src="../imagens/wrong-access.png" alt=""/>
                <h3>ERRO <%= p.getUsername() %> Usuário não possui permissão de Acesso</h3><br>
                <a href="/Gabinete/main.jsp">Voltar</a>
            </center>
                <%   
            }
            else{
            
                %>
            <center>
                <img src="../imagens/wrong-access.png" alt=""/>
                <h3>ERRO Apenas usuários autenticados podem acessar essa área</h3><br>
                <a href="../eventos/EventoLogin.jsp">Voltar</a>
            </center>    
                <%

            }
        %>
     
    </div>    
        
    <%@include file="../menu.html"%>
    <%@include file="../rodape.html"%>
    
