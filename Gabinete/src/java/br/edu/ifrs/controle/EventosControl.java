/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.controle;

import br.edu.ifrs.modelo.bean.Evento;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mathias
 * Data: 24 / 06
 * Descricao: Servlet basico para pegar valores do Formulario FormularioEventos
 */
@WebServlet(name = "EventosControl", urlPatterns = {"/EventosControl"})
public class EventosControl extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
        Evento meuEvento = new Evento();
        SimpleDateFormat formatoDeData = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            meuEvento.setSolicitante(request.getParameter("solicitante"));
            meuEvento.setEntidadeSolicitante(request.getParameter("entidade"));
            meuEvento.setEmail(request.getParameter("email"));
            meuEvento.setTelefone(request.getParameter("telefone"));
            meuEvento.setInicioEvento(formatoDeData.parse(request.getParameter("dataInicial")));
            meuEvento.setFimEvento(formatoDeData.parse(request.getParameter("dataFinal")));
            meuEvento.setDiaSolicitacao(formatoDeData.parse(request.getParameter("data")));
            meuEvento.setSituacao(request.getParameter("situacao"));
            meuEvento.setDescricao(request.getParameter("descricao"));
            meuEvento.adicionar();
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            request.setAttribute("msg_erro", e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("erro.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
