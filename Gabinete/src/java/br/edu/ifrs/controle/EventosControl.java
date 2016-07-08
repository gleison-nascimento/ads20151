/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.controle;

import br.edu.ifrs.modelo.bean.Evento;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String op = "";
        op = request.getParameter("op");
        if(op.equals("listar")){
            try{
                ArrayList<Evento> eventos = new ArrayList<>();
                eventos = Evento.listarEventos();
                String resposta = "tentando listar";
                request.setAttribute("msg_erro", resposta);
                request.setAttribute("eventos", eventos);
                RequestDispatcher dispatcher = request.getRequestDispatcher("eventos/listagemEventos.jsp");
                dispatcher.forward(request, response);
            } catch (Exception ex){
                String resposta = "Ocorreu um erro ao listar" + ex.getMessage();
                request.setAttribute("msg_erro", resposta);
                RequestDispatcher dispatcher = request.getRequestDispatcher("eventos/listagemEventos.jsp");
                dispatcher.forward(request, response);
            }
        }
        
        if(op.equals("excluir")){
            try{
                int id = parseInt(request.getParameter("id"));
                Evento.excluirEvento(id);
                ArrayList<Evento> eventos = new ArrayList<>();
                eventos = Evento.listarEventos();
                request.setAttribute("eventos", eventos);
                RequestDispatcher dispatcher = request.getRequestDispatcher("eventos/listagemEventos.jsp");
                dispatcher.forward(request, response);
            } catch (Exception ex){
                String resposta = "Ocorreu um erro ao listar" + ex.getMessage();
                request.setAttribute("msg_erro", resposta);
                RequestDispatcher dispatcher = request.getRequestDispatcher("eventos/listagemEventos.jsp");
                dispatcher.forward(request, response);
            }
        }
        
        if(op.equals("aceitar")){
            try{
                int id = parseInt(request.getParameter("id"));
                Evento.aceitarEvento(id);
                Evento.excluirEvento(id);
                ArrayList<Evento> eventos = new ArrayList<>();
                eventos = Evento.listarEventos();
                request.setAttribute("eventos", eventos);
                System.out.println("Passou por aqui, antes de encaminhas para listagem");
                RequestDispatcher dispatcher = request.getRequestDispatcher("eventos/listagemEventos.jsp");
                dispatcher.forward(request, response);
            } catch (Exception ex){
                String resposta = "Ocorreu um erro ao listar" + ex.getMessage();
                request.setAttribute("msg_erro", resposta);
                RequestDispatcher dispatcher = request.getRequestDispatcher("eventos/listagemEventos.jsp");
                dispatcher.forward(request, response);
            }
        }
        
        if(op.equals("eventosAceitos")){
            try{
                ArrayList<Evento> eventos = new ArrayList<>();
                System.out.println(eventos.size());
                eventos = Evento.listarEventosAceitos();
                System.out.println(eventos.size());
                String resposta = "tentando listar";
                request.setAttribute("msg_erro", resposta);
                request.setAttribute("eventos", eventos);
                RequestDispatcher dispatcher = request.getRequestDispatcher("eventos/listagemEventos.jsp");
                dispatcher.forward(request, response);
            } catch (Exception ex){
                String resposta = "Ocorreu um erro ao listar" + ex.getMessage();
                request.setAttribute("msg_erro", resposta);
                RequestDispatcher dispatcher = request.getRequestDispatcher("eventos/listagemEventos.jsp");
                dispatcher.forward(request, response);
            }
        }
        
        if(op.equals("pesquisarSolicitacaoEventos")){
            RequestDispatcher dispatcher = request.getRequestDispatcher("eventos/listagemEventos.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Entrou no post");
        if(request.getParameter("operacao").equals("cadastro")){
            this.cadastrarSolicitacao(request, response);
        }
        
        if(request.getParameter("operacao").equals("pesquisa")){
            this.cadastroDePesquisa(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
    
    private void cadastrarSolicitacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Evento meuEvento = new Evento();
        try {
            meuEvento.setSolicitante(request.getParameter("solicitante"));
            meuEvento.setEntidadeSolicitante(request.getParameter("entidade"));
            meuEvento.setEmail(request.getParameter("email"));
            meuEvento.setTelefone(request.getParameter("telefone"));
            meuEvento.setInicioEvento(request.getParameter("dataInicial").replaceAll("T", " "));
            meuEvento.setFimEvento(request.getParameter("dataFinal").replaceAll("T", " "));            
            meuEvento.setDiaSolicitacao(request.getParameter("data"));
            request.getParameter(request.getParameter("data"));
            meuEvento.setSituacao(request.getParameter("situacao"));
            meuEvento.setDescricao(request.getParameter("descricao"));
            meuEvento.adicionar();            
            RequestDispatcher dispatcher = request.getRequestDispatcher("eventos/formEventos.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            request.setAttribute("msg_erro", e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("eventos/erro.jsp");
            dispatcher.forward(request, response);
        }
    }

    private void cadastroDePesquisa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try{
            System.out.println("Entrou no try da pesquisa");
            String nome = request.getParameter("nomeSolicitante");
            String dataInicio = request.getParameter("dataInicio");
            String dataLimite = request.getParameter("dataLimite");
            String situacao = request.getParameter("situacao");
            
            ArrayList<Evento> eventos = Evento.listarComParametros(nome, dataInicio, dataLimite, situacao);
            
            if(eventos.isEmpty()){
                request.setAttribute("msg_erro", "Nenhum resultado aparente");
                RequestDispatcher dispatcher = request.getRequestDispatcher("eventos/erro.jsp");
                dispatcher.forward(request, response);
            } else {
                request.setAttribute("eventos", eventos);
                RequestDispatcher dispatcher = request.getRequestDispatcher("eventos/listagemEventos.jsp");
                dispatcher.forward(request, response);
            }
        } catch (Exception e){
            request.setAttribute("msg_erro", e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("eventos/erro.jsp");
            dispatcher.forward(request, response);
        }
    }
}
