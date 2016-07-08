/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.controle;

import br.edu.ifrs.modelo.dao.espacosDAO;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.edu.ifrs.modelo.bean.Espaco;

/**
 *
 * @author 10070155
 */
@WebServlet(name = "espacoControle", urlPatterns = {"/espacoControle"})
public class espacoControle extends HttpServlet {

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
        
       
       // request.getParameter("operacao");
        
        if(Integer.parseInt(request.getParameter("operacao")) == 1 ){
            
            
            try{
                int numero = Integer.parseInt(request.getParameter("select_espaco"));
                
                espacosDAO DAO = new espacosDAO();
                
                try{
                    DAO.desativar(numero);
                    
                    RequestDispatcher dispatcher = request.getRequestDispatcher("Reserva_Salas/desativado_sucesso.jsp");
                    dispatcher.forward(request, response);
                    
                }catch(Exception X){
                    throw new Exception(X.getMessage());
                }
            }catch(Exception X){
                request.setAttribute("msg_erro", X.getMessage());
                RequestDispatcher dispatcher = request.getRequestDispatcher("Reserva_Salas/erro.jsp");
                dispatcher.forward(request, response);
            }
            
        }else if(Integer.parseInt(request.getParameter("operacao")) == 2){
            
            try{
                int numero = Integer.parseInt(request.getParameter("select_espaco"));
                
                espacosDAO DAO = new espacosDAO();
                
                try{
                    DAO.ativar(numero);
                    
                    RequestDispatcher dispatcher = request.getRequestDispatcher("Reserva_Salas/ativado_sucesso.jsp");
                    dispatcher.forward(request, response);
                    
                }catch(Exception X){
                    throw new Exception(X.getMessage());
                }
            }catch(Exception X){
                request.setAttribute("msg_erro", X.getMessage());
                RequestDispatcher dispatcher = request.getRequestDispatcher("Reserva_Salas/erro.jsp");
                dispatcher.forward(request, response);
            }
            
        }else if(Integer.parseInt(request.getParameter("operacao")) == 3){
            
            int numero = Integer.parseInt(request.getParameter("select_espaco"));
            
            Espaco espaco = new Espaco();
            
            espacosDAO DAO = new espacosDAO();
            
            try{
                
                espaco = DAO.consultar(numero);
                
                request.setAttribute("R", espaco);
                RequestDispatcher dispatcher = request.getRequestDispatcher("Reserva_Salas/FormEditar.jsp");
                dispatcher.forward(request, response);
                
            }catch(Exception X){
                
                request.setAttribute("msg_erro", X.getMessage());
                RequestDispatcher dispatcher = request.getRequestDispatcher("Reserva_Salas/erro.jsp");
                dispatcher.forward(request, response);
                
            }
            
        }else if(Integer.parseInt(request.getParameter("operacao")) == 4){
            
            Espaco espaco = new Espaco();
            
            espaco.setNumero(Integer.parseInt(request.getParameter("numero")));
            espaco.setNome(request.getParameter("nome"));
            espaco.setDescricao(request.getParameter("descricao"));
            espaco.setLotacao(Integer.parseInt(request.getParameter("lotacao")));
            espaco.setTipo(request.getParameter("tipo"));
            espaco.setProjetor((request.getParameter("projetor").equals("Sim")?true:false));
            espaco.setInternet((request.getParameter("internet").equals("Sim")?true:false));
            espaco.setQuadro((request.getParameter("quadro").equals("Sim"))?true:false);
            espaco.setEspecialidade(request.getParameter("especialidade"));
            espaco.setLista_Equipamentos(request.getParameter("equipamentos"));
            espaco.setSituacao(request.getParameter("situacao"));
            
            espacosDAO DAO = new espacosDAO();
            
            try{
                DAO.editar(espaco);
                
                RequestDispatcher dispatcher = request.getRequestDispatcher("Reserva_Salas/editado_sucesso.jsp");
                dispatcher.forward(request, response);
                
            }catch(Exception X){
                
                request.setAttribute("msg_erro", X.getMessage());
                RequestDispatcher dispatcher = request.getRequestDispatcher("Reserva_Salas/erro.jsp");
                dispatcher.forward(request, response);
                
            }
                
        }else{

            try{

                int numero;
                String nome;
                String tipo;

                Espaco espaco = new Espaco();

                Espaco [] espacos = null;

                try{

                    if(request.getParameter("numero").isEmpty()){
                        numero = 0;
                    }else{
                        numero = Integer.parseInt(request.getParameter("numero"));
                    }

                    if(request.getParameter("nome_espaco").equals("")){
                        nome = "0";
                    }else{
                        nome = request.getParameter("nome_espaco");
                    }

                    if(request.getParameter("tipo_espaco").equals("-selecione-")){
                        tipo = "0";
                    }else{
                        tipo = request.getParameter("tipo_espaco");
                    }

                }catch(Exception X){
                    throw new Exception("Erro ao obter parametros");
                }

                espacosDAO DAO = new espacosDAO();

                try{

                    espacos = DAO.consultar(numero,nome,tipo);

                }catch(Exception X){
                    throw new Exception(X.getMessage());
                }

                if(espacos.length == 0){
                    RequestDispatcher dispatcher = 
                        request.getRequestDispatcher("Reserva_Salas/semResultado.jsp");
                    dispatcher.forward(request, response);
                }else{

                    request.setAttribute("espacos", espacos);

                    RequestDispatcher dispatcher = 
                            request.getRequestDispatcher("Reserva_Salas/listaEspaco.jsp");
                    dispatcher.forward(request, response);
                }
            }catch(Exception e){
                request.setAttribute("msg_erro", e.getMessage());
                RequestDispatcher dispatcher = request.getRequestDispatcher("Reserva_Salas/erro.jsp");
                dispatcher.forward(request, response);
            }  
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
