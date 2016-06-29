/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.controle;

import br.edu.ifrs.modelo.bean.Recepcao;
import br.edu.ifrs.modelo.dao.RecepcaoDAO;
import br.edu.ifrs.util.Util;
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
 * @author 10070160
 */
@WebServlet(name = "RecepcaoControl", urlPatterns = {"/RecepcaoControl"})
public class RecepcaoControl extends HttpServlet {

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
            throws ServletException, IOException 
    {
        try 
        {           
            String op = request.getParameter("op");
            
            if (op.equals("CONSULTA") || op.equals("CONSATUALIZAR")) consultar(request, response, op);
            else if(op.equals("INSERIR")) inserir(request, response);
            else if(op.equals("EXCLUIR")) excluir(request, response);
            else if(op.equals("ATUALIZAR")) atualizar(request, response);
            
        } catch (Exception e) {
            request.setAttribute("msg_erro", e.getMessage());
            RequestDispatcher dispatcher = 
                    request.getRequestDispatcher("erro.jsp");
            dispatcher.forward(request, response);
        }
    }

    protected void inserir(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Recepcao p = new Recepcao();
        
        try 
        {    
            p.setAnexos(request.getParameter("anexos"));
            p.setCpf_recepcionista(request.getParameter("cpf_recepcionista"));
            p.setCpf_servidor(request.getParameter("cpf_servidor"));
            p.setData_abertura(Util.formataStringToCalendar(request.getParameter("data_abertura")));
            p.setDescricao_solicitacao(request.getParameter("descricao_solicitacao"));
            p.setEmail_contato(request.getParameter("email_contato"));
            p.setNome_solicitante(request.getParameter("nome_solicitante"));
            p.setPerfil_solicitante(request.getParameter("perfil_solicitante"));
            p.setSituacao(request.getParameter("situacao"));
            p.setTelefone_contato(request.getParameter("telefone_contato"));

            RecepcaoDAO.adicionar(p);

            //RequestDispatcher dispatcher = 
              //      request.getRequestDispatcher("index.html");
            //dispatcher.forward(request, response);
            consultar(request, response, "CONSULTA");
        } catch (Exception e) {
            request.setAttribute("msg_erro", e.getMessage());
            RequestDispatcher dispatcher = 
                    request.getRequestDispatcher("erro.jsp");
            dispatcher.forward(request, response);
        }
        
    }

    protected void atualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Recepcao p = new Recepcao();
        
        try 
        {
            p.setId(Integer.parseInt(request.getParameter("id")));           
            p.setAnexos(request.getParameter("anexos"));
            p.setCpf_recepcionista(request.getParameter("cpf_recepcionista"));
            p.setCpf_servidor(request.getParameter("cpf_servidor"));
            p.setData_abertura(Util.formataStringToCalendar(request.getParameter("data_abertura")));
            p.setDescricao_solicitacao(request.getParameter("descricao_solicitacao"));
            p.setEmail_contato(request.getParameter("email_contato"));
            p.setNome_solicitante(request.getParameter("nome_solicitante"));
            p.setPerfil_solicitante(request.getParameter("perfil_solicitante"));
            p.setSituacao(request.getParameter("situacao"));
            p.setTelefone_contato(request.getParameter("telefone_contato"));

            RecepcaoDAO.adicionar(p);

            //RequestDispatcher dispatcher = 
              //      request.getRequestDispatcher("index.html");
            //dispatcher.forward(request, response);
            consultar(request, response, "CONSULTA");
        } catch (Exception e) {
            request.setAttribute("msg_erro", e.getMessage());
            RequestDispatcher dispatcher = 
                    request.getRequestDispatcher("erro.jsp");
            dispatcher.forward(request, response);
        }
        
    }
    
    protected void consultar(HttpServletRequest request, HttpServletResponse response, String op)
            throws ServletException, IOException {
        try {           
            String pagina = "";
            if (op.equals("CONSULTA")) 
            {
                Recepcao recepcao = null;
                recepcao = RecepcaoDAO.consultar(Integer.parseInt(request.getParameter("id")));
                pagina = "PesquisaChamado.jsp";
                request.setAttribute("recepcao", recepcao);
            } 
//            else { 
//                Recepcao recepcao = null;
//                perfil = PerfilDAO.consultar(Integer.parseInt(request.getParameter("id")));
//                pagina = "formPerfil.jsp";
//                request.getSession().setAttribute("perfil", perfil);
//                //request.setAttribute("perfil", perfil);
//            }
            
            
            RequestDispatcher dispatcher = 
                    request.getRequestDispatcher(pagina);
            dispatcher.forward(request, response);
        } catch (Exception e) {
            request.setAttribute("msg_erro", e.getMessage());
            RequestDispatcher dispatcher = 
                    request.getRequestDispatcher("erro.jsp");
            dispatcher.forward(request, response);
        }
        
    }
    
    protected void excluir(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Recepcao p = new Recepcao();
        
        try {
            
            p.setId(Integer.parseInt(request.getParameter("id")));
            
            RecepcaoDAO.deletar(p);

            //RequestDispatcher dispatcher = 
              //      request.getRequestDispatcher("index.html");
            //dispatcher.forward(request, response);
            consultar(request, response, "CONSULTA");
        } catch (Exception e) {
            request.setAttribute("msg_erro", e.getMessage());
            RequestDispatcher dispatcher = 
                    request.getRequestDispatcher("erro.jsp");
            dispatcher.forward(request, response);
        }
        
    }

}
