/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.controle;

import br.edu.ifrs.modelo.bean.ReservaEspaco;
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
 * @author 10070174
 */
@WebServlet(name = "ReservaControl", urlPatterns = {"/ReservaControl"})
public class ReservaControl extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
                ReservaEspaco r = new ReservaEspaco();
                
                try {
                    try{
                        r.setNome(request.getParameter("nome"));
                        r.setNumero(Integer.parseInt(request.getParameter("numero")));
                        r.setDescricao(request.getParameter("descricao"));
                        r.setLotacao(Integer.parseInt(request.getParameter("lotacao")));
                        r.setTipo_lab(request.getParameter("tipo"));
                        r.setProjetor(Boolean.parseBoolean(request.getParameter("projetor")));
                        r.setInternet(Boolean.parseBoolean(request.getParameter("internet")));
                        r.setQuadro(Boolean.parseBoolean(request.getParameter("quadro")));
                        r.setEspecialidade(request.getParameter("especialidade"));
                        r.setEquipamentos(request.getParameter("equipamentos"));
                        r.setSituacao(request.getParameter("situacao"));
                    }catch(Exception X){
                        throw new Exception ("erro ao obter parametro");
                    }
                
                    try{
                        r.adicionar();   
                    }catch(Exception X){
                        throw new Exception (X.getMessage());
                    }
                    
      

                    RequestDispatcher dispatcher = 
                        request.getRequestDispatcher("Reserva_Salas/sucesso.html");
                    dispatcher.forward(request, response);
                    
                } catch (Exception e) {
                    request.setAttribute("msg_erro", e.getMessage());
                    RequestDispatcher dispatcher = 
                        request.getRequestDispatcher("Reserva_Salas/erro.jsp");
                    dispatcher.forward(request, response);
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
        processRequest(request, response);
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
