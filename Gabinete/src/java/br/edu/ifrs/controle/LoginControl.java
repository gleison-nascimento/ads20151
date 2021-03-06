package br.edu.ifrs.controle;

import br.edu.ifrs.modelo.bean.Usuario;
import br.edu.ifrs.modelo.dao.LoginDAO;
import br.edu.ifrs.modelo.dao.UsuarioDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 
 * Document   : LoginControl.java
 * Created on : 21/06/2016, 17:21:07
 * Author     : EvertonQuadros
 * Escopo     : Eventos/Projeto
 * Descricao  : Arquivo de controle para efetuar login no sistema
 * Observações: Alterar com aviso prévio, comentar revisões.
 */

@WebServlet(name = "LoginControl", urlPatterns = {"/LoginControl"})
public class LoginControl extends HttpServlet {

    private Usuario usuario = null;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        try{
            
            buscaLogin(request,response);
        
        } catch (Exception e) {

            request.getSession().setAttribute("login", request.getParameter("login"));
            request.setAttribute("msg_erro", e.getMessage());
            RequestDispatcher dispatcher = 
                    request.getRequestDispatcher("eventos/erro.jsp");
            dispatcher.forward(request, response);
            
        }
        
    }
    
    protected void buscaLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException,Exception {

        usuario = UsuarioDAO.consultarLogin(request.getParameter("login"), request.getParameter("senha"));

        if(usuario != null){

            request.getSession().setAttribute("login", usuario);

            //if(usuario.getUsername().equalsIgnoreCase("administrador")){
            if(usuario.getTipo_usuario() >= -1){ //alterar aqui para verificar permissionamento de usuários no sistema, diferentes logins?
                
                RequestDispatcher dispatcher = 
                    request.getRequestDispatcher("eventos/aceite.jsp");
                dispatcher.forward(request, response);

            }
            else{
                
                RequestDispatcher dispatcher = 
                    request.getRequestDispatcher("eventos/falhaLogin.jsp");
                dispatcher.forward(request, response);

            }

        }
        else{
            
            throw new Exception("Usuário " + request.getParameter("login") + " não encontrado!");

        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("msg_erro", "Esses dados não devem ser processados com método GET.");
        RequestDispatcher dispatcher = 
            request.getRequestDispatcher("eventos/erro.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
