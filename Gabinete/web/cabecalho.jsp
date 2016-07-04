<%-- 

    Documento   :  Cabecalho.jsp
    Created on  :  02/07/2016, 10:14:00
    Autor       :  EvertonQuadros
    Escopo      :  Projeto
    Descricao   :  Documento jsp do cabecalho com alterações de autenticação

--%>

<%@page session="true" %>
<%@page import="br.edu.ifrs.modelo.bean.Login"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Gabinete Virtual</title>
        
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="/Gabinete/imagens/icon.png">
        <link href="/Gabinete/Estilo.css" rel="stylesheet" type="text/css"/>
        
    </head>
    <body>
    
	<div id="Banner">            
            <div id="logo"> 
                <img src="/Gabinete/imagens/logo.png" alt="logo"  title="Logo IFRS-Campus Restinga"  width="120" height="160px">
            </div>   
            <div id="titulo">              
                <h1>Gabinete Virtual</h1>             
            </div> 
            <div id="icons">
                <table  cellspacing="30">
                    <tr>
                        <%
                            
                        Login p = new Login();
      
                        if (session.getAttribute("login") == null){
                           
                            if (request.getSession().getAttribute("login") != null && !request.getSession().getAttribute("login").equals("") && request.getSession().getAttribute("login") instanceof Login) {

                                p = (Login)request.getSession().getAttribute("login");
                                session.setAttribute("login", p);

                                %>

                                    <td><a href="/Gabinete/main.jsp"><img src="/Gabinete/imagens/home.png" alt="Inicio" title="Inicio" width="40" height="40px"></a> </td>     
                                    <td><a href="#"><img src="/Gabinete/imagens/meusDados.png" alt="Meus Dados" title="Meus Dados" width="40" height="40px"></a> </td>
                                    <td><a href="/Gabinete/index.jsp"><img src="/Gabinete/imagens/logout.png" alt="Sair" title="Sair" width="40" height="40px"></a> </td>                    

                                <%

                            }
                            else{
                                
                                %>
                                
                                
                                <td><a href="/Gabinete/eventos/EventoLogin.jsp"><img src="/Gabinete/imagens/loginIcon.png" alt="Login" title="Login" width="40" height="40px"></a> </td> 
                                <td><a href="/Gabinete/main.jsp"><img src="/Gabinete/imagens/home.png" alt="Inicio" title="Inicio" width="40" height="40px"></a> </td>     
                                <td><a href="#"><img src="/Gabinete/imagens/meusDados.png" alt="Meus Dados" title="Meus Dados" width="40" height="40px"></a> </td>  
                               
                                <% 
                                
                            }

                        }
                        else{
                            
                           // if (request.getSession().getAttribute("login") != null && !request.getSession().getAttribute("login").equals("") && request.getSession().getAttribute("login") instanceof Login) {
                           %>
                           
                           <td><a href="/Gabinete/main.jsp"><img src="/Gabinete/imagens/home.png" alt="Inicio" title="Inicio" width="40" height="40px"></a> </td>     
                           <td><a href="#"><img src="/Gabinete/imagens/meusDados.png" alt="Meus Dados" title="Meus Dados" width="40" height="40px"></a> </td>
                           <td><a href="/Gabinete/index.jsp"><img src="/Gabinete/imagens/logout.png" alt="Sair" title="Sair" width="40" height="40px"></a> </td>

                            <% 
                          } 
                        %>

                    </tr>                                           
                </table>
            </div>
      	</div>
    </body>
</html>
