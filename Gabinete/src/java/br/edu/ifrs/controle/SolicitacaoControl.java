package br.edu.ifrs.controle;

import br.edu.ifrs.modelo.dao.SolicitacaoDAO;
import br.edu.ifrs.modelo.bean.Solicitacoes;
import br.edu.ifrs.modelo.bean.SolicitacaoReserva;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "espacoControl", urlPatterns = {"/espacoControl"})
public class SolicitacaoControl extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String op = request.getParameter("op");
            
            if (op.equals("CONSULTA") || op.equals("RESERVATT")) consultar(request, response, op);
            else if(op.equals("RESERVAR")) reservar(request, response);
        } catch (Exception ex) {
            request.setAttribute("msg_erro", ex.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("eventos/erro.jsp");
            dispatcher.forward(request, response);
        }
    }
    
    protected void consultar(HttpServletRequest request, HttpServletResponse response, String op) throws ServletException, IOException {
        try {           
            String pagina = "";
            if (op.equals("CONSULTA")) {
                Solicitacoes[] s = null;
                s = SolicitacaoDAO.consultar(request.getParameter("solicitante"), request.getParameter("situacao"));
                pagina = "consultarSolicitacoes.jsp";
                request.setAttribute("s", s);
            } else {
                Solicitacoes s = null;
                s = SolicitacaoDAO.consultar(Integer.parseInt(request.getParameter("id")));
                pagina = "formReserva.jsp";
                request.getSession().setAttribute("s", s);
            }
            
            RequestDispatcher dispatcher = request.getRequestDispatcher(pagina);
            dispatcher.forward(request, response);
        } catch (Exception e) {
            request.setAttribute("msg_erro", e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("eventos/erro.jsp");
            dispatcher.forward(request, response);
        }
    }
    
    protected void reservar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Solicitacoes s = new Solicitacoes();
        
        try {
            s.setId(Integer.parseInt(request.getParameter("id")));
            s.setDataReserva(request.getParameter("datareserva"));
            s.setObs(request.getParameter("obs"));
            s.setSituacao("concluida");
            s.setEspacoReservado(request.getParameter("espaco"));

            SolicitacaoDAO.atualizar(s);

            RequestDispatcher dispatcher = request.getRequestDispatcher("Reserva_Salas/sucesso.html");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            request.setAttribute("msg_erro", "[EspacoControl.reservar]"+e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("eventos/erro.jsp");
            dispatcher.forward(request, response);
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SolicitacaoReserva eM = new SolicitacaoReserva();
        
        try {
            eM.setSolicitante(request.getParameter("solicitante"));
            eM.setEntidade(request.getParameter("entidade"));
            eM.setEmail(request.getParameter("email"));
            eM.setTel(request.getParameter("tel"));
            eM.setObjetivo(request.getParameter("objetivo"));
            eM.setData(request.getParameter("data"));
            eM.setDataInicio(request.getParameter("datainicio"));
            eM.setHoraInicio(request.getParameter("horainicio"));
            eM.setDataTermino(request.getParameter("datatermino"));
            eM.setHoraTermino(request.getParameter("horatermino"));
            
            eM.adicionar();
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("Reserva_Salas/sucesso.html");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            request.setAttribute("msg_erro", e.getMessage());
            RequestDispatcher dispatcher = request.getRequestDispatcher("Reserva_Salas/erro.jsp");
            dispatcher.forward(request, response);
        }
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}