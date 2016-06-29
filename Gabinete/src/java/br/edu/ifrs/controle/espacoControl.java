package br.edu.ifrs.controle;

import br.edu.ifrs.modelo.espacoModelo;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "espacoControl", urlPatterns = {"/espacoControl"})
public class espacoControl extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        espacoModelo eM = new espacoModelo();
        
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
                        
            RequestDispatcher dispatcher = request.getRequestDispatcher("sucesso.html");
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
    }// </editor-fold>
}