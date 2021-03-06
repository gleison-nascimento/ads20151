package br.edu.ifrs.controle;

import br.edu.ifrs.modelo.bean.Perfil;
import br.edu.ifrs.modelo.dao.PerfilDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 
 * Document   : PerfilControl.java
 * Created on : 21/06/2016, 17:30 (Revisão | EvertonQuadros)
 * Author     : Gleison/Projeto
 * Escopo     : Usuario/Projeto
 * Descricao  : Arquivo de controle da classe Perfil
 * Observações: Alterar conforme necessidade.
 */

@WebServlet(name = "PerfilControl", urlPatterns = {"/PerfilControl"})
public class PerfilControl extends HttpServlet {

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
        try {
            
            String op = request.getParameter("op");
            
            if (op.equals("CONSULTA") || op.equals("CONSATUALIZAR")){ 
                consultar(request, response, op);
            }
            else if(op.equals("INSERIR")){
                inserir(request, response);
            }
            else if(op.equals("EXCLUIR")){
                excluir(request, response);
            }
            else if(op.equals("ATUALIZAR")){
                atualizar(request, response);
            }
            
        } catch (ServletException | IOException e) {
            request.setAttribute("msg_erro", e.getMessage());
            RequestDispatcher dispatcher = 
                    request.getRequestDispatcher("cadastros/erro.jsp");
            dispatcher.forward(request, response);
        }
        
    }
    
    protected void inserir(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Perfil p = new Perfil();
        
        try {
            
            p.setNome(request.getParameter("nome"));
            p.setDescricao(request.getParameter("descricao"));
            p.setSituacao(request.getParameter("situacao"));

            PerfilDAO.adicionar(p);

            //RequestDispatcher dispatcher = 
              //      request.getRequestDispatcher("index.html");
            //dispatcher.forward(request, response);
            consultar(request, response, "CONSULTA");
        } catch (Exception e) {
            request.setAttribute("msg_erro", e.getMessage());
            RequestDispatcher dispatcher = 
                    request.getRequestDispatcher("eventos/erro.jsp");
            dispatcher.forward(request, response);
        }
        
    }

    protected void atualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Perfil p = new Perfil();
        
        try {
            
            p.setId(Integer.parseInt(request.getParameter("id")));
            p.setNome(request.getParameter("nome"));
            p.setDescricao(request.getParameter("descricao"));
            p.setSituacao(request.getParameter("situacao"));

            PerfilDAO.atualizar(p);

            //RequestDispatcher dispatcher = 
              //      request.getRequestDispatcher("index.html");
            //dispatcher.forward(request, response);
            consultar(request, response, "CONSULTA");
        } catch (Exception e) {
            request.setAttribute("msg_erro", e.getMessage());
            RequestDispatcher dispatcher = 
                    request.getRequestDispatcher("eventos/erro.jsp");
            dispatcher.forward(request, response);
        }
        
    }
    
    protected void consultar(HttpServletRequest request, HttpServletResponse response, String op)
            throws ServletException, IOException {
        try {           
            String pagina;
            if (op.equals("CONSULTA")) {
                Perfil[] perfis;
                perfis = PerfilDAO.consultar(request.getParameter("nome"));
                pagina = "cadastros/consultaPerfil.jsp";
                request.setAttribute("perfis", perfis);
            } else { 
                Perfil perfil;
                perfil = PerfilDAO.consultar(Integer.parseInt(request.getParameter("id")));
                pagina = "cadastros/formPerfil.jsp";
                request.getSession().setAttribute("perfil", perfil);
                //request.setAttribute("perfil", perfil);
            }
            
            
            RequestDispatcher dispatcher = 
                    request.getRequestDispatcher(pagina);
            dispatcher.forward(request, response);
        } catch (Exception e) {
            request.setAttribute("msg_erro", e.getMessage());
            RequestDispatcher dispatcher = 
                    request.getRequestDispatcher("eventos/erro.jsp");
            dispatcher.forward(request, response);
        }
        
    }
    
    protected void excluir(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Perfil p = new Perfil();
        
        try {
            
            p.setId(Integer.parseInt(request.getParameter("id")));
            
            PerfilDAO.deletar(p);

            //RequestDispatcher dispatcher = 
              //      request.getRequestDispatcher("index.html");
            //dispatcher.forward(request, response);
            consultar(request, response, "CONSULTA");
        } catch (Exception e) {
            request.setAttribute("msg_erro", e.getMessage());
            RequestDispatcher dispatcher = 
                    request.getRequestDispatcher("eventos/erro.jsp");
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
        request.setAttribute("msg_erro", "Esses dados não devem ser processados com método GET.");
        RequestDispatcher dispatcher = 
            request.getRequestDispatcher("cadastros/erro.jsp");
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
