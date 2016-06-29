<%-- 
    Document   : aceite.jsp
    Created on : 21/06/2016, 09:33:20
    Author     : EvertonQuadros
    Escopo     : Eventos
    Descricao  : Tela JSP de teste para quando o perfil selecionado tiver 
                 permissão de administrador do sistema.
    Observações: Pode ser alterado e deletado.
--%>

<%@page import="br.edu.ifrs.modelo.bean.Login"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>        
        <%
            Login p = new Login();
            if (request.getSession().getAttribute("login") != null) {
                p = (Login)request.getSession().getAttribute("login");
            }
        %>
        
        <link href="../Estilo.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sucesso</title>
    </head>
    <body>
        <div id="CadastroComSucesso">
            <center>
                
                <p>USUÁRIO <%= p.getLogin() %> LOGADO COM SUCESSO!</p><br>
                   <a href="eventos/EventoLogin.jsp">Voltar</a>
                   
            </center>
            
        </div>
        
    </body>
</html>
