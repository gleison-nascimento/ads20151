<%-- 
    Document   : formPesquisa
    Created on : 08/06/2016, 09:02:18
    Author     : 10070155
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@include file="../cabecalho.jsp"%> 

        <%
            //Usuario p = new Usuario();
            if (request.getSession().getAttribute("login") != null && request.getSession().getAttribute("login") instanceof Usuario) {
                p = (Usuario)request.getSession().getAttribute("login");        
        %>
    <html>
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    </head>
    <body>
        <div id="conteudo">
            <center>
                <h1>Pesquisar</h1>
                <hr>
                <form action="/Gabinete/espacoControle">    
                    <input type="hidden" name="operacao" value="0">

                    <label for="numero" > Numero da sala:</label>
                    <br/>
                    <input type="text" name="numero" id="numero"  size="25" />
                    <br/>
                    <br/>

                    <label for="nome_espaco" > Nome do espaço:</label>
                    <br/>
                    <input type="text" name="nome_espaco" id="nome_espaco"  />
                    <br/>
                    <br/>

                    <label for="tipo_espaco" > Tipo de espaço:</label>
                    <br/>
                    <select name="tipo_espaco" id="tipo_espaco" >
                        <option>-selecione-</option>
                        <option>Sala de aula</option>
                        <option>Laboratorio</option>
                        <option>Multifuncional</option>
                    </select>

                    <br/>
                    <br/>

                    <input type="submit" value="Pesquisar" name="pesquisar" />

                </form>  
            </center>
        </div>
    </body>
      </html> 
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

