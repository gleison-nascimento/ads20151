<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Responder Chamado</title>
    </head>
    <body>
        <div>
             <form action="RespondeChamado">
                 <label>Nome do Servidor:</label>
                 <label for="nome"><b>Nome</b></label><br><br>
                 <label>E-Mail do Servidor:</label>
                 <label for="email"><b>E-mail</b></label><br><br>
                 <label>Telefone do Servidor:</label>
                 <label for="telefone"><b>Telefone</b></label><br><br>
                 <label>Descrição da Resposta:</label><br>
                 <textarea name="descricao" id="descricao" rows="5" cols="51" required></textarea><br>
                 <input type="submit" value="Salvar Resposta"><br><br>
                 <label for="inicio">Data da Resposta:</label>
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
                 </select><br><br>
                 <label for="inicio"><b>Nenhum arquivo selecionado</b></label><br>
                 <input type="submit" value="Anexar Documento"><br><br><br>
                 <input type="reset" value="Limpar">
                 <input type="submit" value="Responder Chamado">
             </form>
        </div>
    </body>
</html>
