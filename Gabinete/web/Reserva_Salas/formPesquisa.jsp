<%-- 
    Document   : formPesquisa
    Created on : 08/06/2016, 09:02:18
    Author     : 10070155
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa</title>
    </head>
    <body>
        
        <form action="espacoControle">    

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
            
    </body>
</html>
