<%-- 
    Document   : ListarChamados
    Created on : Jun 16, 2016, 2:23:43 PM
    Author     : MARCIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gabinete</title>
    </head>
    <body>
        <div>
           <h1>Pesquisar Chamados</h1>
           <hr>
        
           <form action="PesquisaChamado">
                        
               <label for="nome">Nome: </label><br>
               <input type="text" id="nome" name="nome" size="20"><br>
            
               <label for="inicio">Data de Abertura:</label><br>
                 <select>
                     <option>Ano</option>
                     <option value="2000">2000</option>
                     <option value="2001">2001</option>
                     <option value="2002">2002</option>
                     <option value="2003">2003</option>
                     <option value="2004">2004</option>
                     <option value="2005">2005</option>
                     <option value="2006">2006</option>
                     <option value="2007">2007</option>
                     <option value="2008">2008</option>
                     <option value="2009">2009</option>
                     <option value="2010">2010</option>
                     <option value="2011">2011</option>
                     <option value="2012">2012</option>
                     <option value="2013">2013</option>
                     <option value="2014">2014</option>
                     <option value="2015">2015</option>
                     <option value="2016">2016</option>
                 </select>
               
                <select>
                    <option>Mês</option>
                    <option value="01">01</option>
                    <option value="02">02</option>
                    <option value="03">03</option>
                    <option value="04">04</option>
                    <option value="05">05</option>
                    <option value="06">06</option>
                    <option value="07">07</option>
                    <option value="08">08</option>
                    <option value="09">09</option>
                    <option value="10">10</option>
                    <option value="11">11</option>
                    <option value="12">12</option>
                 </select>
               
                 <select>                    
                    <option>Dia</option>
                    <option value="01">01</option>
                    <option value="02">02</option>
                    <option value="03">03</option>
                    <option value="04">04</option>
                    <option value="05">05</option>
                    <option value="06">06</option>
                    <option value="07">07</option>
                    <option value="08">08</option>
                    <option value="09">09</option>
                    <option value="10">10</option>
                    <option value="11">11</option>
                    <option value="12">12</option>
                    <option value="13">13</option>
                    <option value="14">14</option>
                    <option value="15">15</option>
                    <option value="16">16</option>
                    <option value="17">17</option>
                    <option value="18">18</option>
                    <option value="19">19</option>
                    <option value="20">20</option>
                    <option value="21">21</option>
                    <option value="22">22</option>
                    <option value="23">23</option>
                    <option value="24">24</option>
                    <option value="25">25</option>
                    <option value="26">26</option>
                    <option value="27">27</option>
                    <option value="28">28</option>
                    <option value="29">29</option>
                    <option value="30">30</option>
                    <option value="31">31</option>
                  </select><br>
            
                 <label for="fim">Data de encerramento:</label><br>
                 <select>
                    <option>Ano</option>
                     <option value="2000">2000</option>
                     <option value="2001">2001</option>
                     <option value="2002">2002</option>
                     <option value="2003">2003</option>
                     <option value="2004">2004</option>
                     <option value="2005">2005</option>
                     <option value="2006">2006</option>
                     <option value="2007">2007</option>
                     <option value="2008">2008</option>
                     <option value="2009">2009</option>
                     <option value="2010">2010</option>
                     <option value="2011">2011</option>
                     <option value="2012">2012</option>
                     <option value="2013">2013</option>
                     <option value="2014">2014</option>
                     <option value="2015">2015</option>
                     <option value="2016">2016</option>
                 </select>
                 <select>
                    <option>Mês</option>
                    <option value="01">01</option>
                    <option value="02">02</option>
                    <option value="03">03</option>
                    <option value="04">04</option>
                    <option value="05">05</option>
                    <option value="06">06</option>
                    <option value="07">07</option>
                    <option value="08">08</option>
                    <option value="09">09</option>
                    <option value="10">10</option>
                    <option value="11">11</option>
                    <option value="12">12</option>
                 </select>                 
                 <select>
                    <option>Dia</option>
                    <option value="01">01</option>
                    <option value="02">02</option>
                    <option value="03">03</option>
                    <option value="04">04</option>
                    <option value="05">05</option>
                    <option value="06">06</option>
                    <option value="07">07</option>
                    <option value="08">08</option>
                    <option value="09">09</option>
                    <option value="10">10</option>
                    <option value="11">11</option>
                    <option value="12">12</option>
                    <option value="13">13</option>
                    <option value="14">14</option>
                    <option value="15">15</option>
                    <option value="16">16</option>
                    <option value="17">17</option>
                    <option value="18">18</option>
                    <option value="19">19</option>
                    <option value="20">20</option>
                    <option value="21">21</option>
                    <option value="22">22</option>
                    <option value="23">23</option>
                    <option value="24">24</option>
                    <option value="25">25</option>
                    <option value="26">26</option>
                    <option value="27">27</option>
                    <option value="28">28</option>
                    <option value="29">29</option>
                    <option value="30">30</option>
                    <option value="31">31</option>
                 </select><br>                 
            
               <label for="situacao">Situacao: </label><br>
               <select name="situacao" id="situacao" required>
                   <option value="aberto">Aberto</option>
                   <option value="atendimento">Em Atendimento</option>
                   <option value="concluido">Concluido</option>
                </select><br>
            
                <label for="responsavel">Usuario Responsavel: </label><br>
                <select name="responsavel" id="responsavel" required>
                   <option value=" "></option>   
                   <option value=" ">Usuario teste</option>     
                   <option value=" ">Usuario teste</option>      
                   <option value=" ">Usuario teste</option>      
                </select><br>   
            
                <input type="submit" value="Pesquisar">
            
            </form>
        
            <hr>
       
            <table border="1" cellpadding="1" cellspacing="0">
            
                <tr>
                   <th>Protocolo</th>
                   <th>Solicitante</th>
                   <th>Data de Abertura</th>
                   <th>Situação</th>                
                </tr>
            
                    <tr>
                        <td>     </td>
                        <td>     </td>
                        <td>     </td>
                        <td>     </td>
                        <td>
                            <a href="EncaminhaChamado.jsp">Encaminhar</a>                          
                        </td>
                        <td>
                            <a href="RespondeChamado.jsp">Responder</a>                          
                        </td>
                        
                    </tr>   
                    
            </table>
            
        </div>
        
    </body>
</html>
