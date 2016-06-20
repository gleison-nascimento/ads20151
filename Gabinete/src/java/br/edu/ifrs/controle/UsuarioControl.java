/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.controle;

import br.edu.ifrs.modelo.bean.Perfil;
import br.edu.ifrs.modelo.bean.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DTI
 */
@WebServlet(name = "UsuarioControl", urlPatterns = {"/UsuarioControl"})
public class UsuarioControl extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
            request.getRequestDispatcher("erro.jsp");
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
        
        Usuario usu = new Usuario();
        
        try {
            usu.setCpf(request.getParameter("cpf"));
            usu.setMatricula(request.getParameter("matricula"));
            usu.setNome(request.getParameter("nome"));
            usu.setSexo(request.getParameter("sexo"));
            usu.setEndereco(request.getParameter("endereco"));
            usu.setEmail(request.getParameter("email"));
            usu.setTelefoneResidencial(request.getParameter("telefone"));

            Perfil pf = new Perfil();
            pf.setId(Integer.parseInt(request.getParameter("perfil")));
            usu.setPerfil(pf);

            usu.setUsername(request.getParameter("username"));
            usu.setSenha(request.getParameter("senha"), request.getParameter("confsenha"));
            usu.setSituacao(request.getParameter("situacao"));
            
//            usu.adicionar();
            
            RequestDispatcher dispatcher = 
                request.getRequestDispatcher("index.html");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            request.setAttribute("msg_erro", e.getMessage());
            RequestDispatcher dispatcher = 
                request.getRequestDispatcher("cadastros/erro.jsp");
            dispatcher.forward(request, response);
        }
        
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
