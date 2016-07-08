package br.edu.ifrs.controle;

import br.edu.ifrs.modelo.bean.Perfil;
import br.edu.ifrs.modelo.bean.Usuario;
import br.edu.ifrs.modelo.dao.PerfilDAO;
import br.edu.ifrs.modelo.dao.UsuarioDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 
 * Document   : UsuarioControl.java
 * Created on : 21/06/2016, 17:27:07 (Revisão | EvertonQuadros)
 * Author     : Gleison/Projeto
 * Escopo     : Usuario/Projeto
 * Descricao  : Arquivo de controle da classe Usuário
 * Observações: Alterar conforme necessidade.
 */

@WebServlet(name = "UsuarioControl", urlPatterns = {"/UsuarioControl"})
public class UsuarioControl extends HttpServlet {

    protected void carregarPerfil(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Perfil[] perfis = PerfilDAO.consultar("%");
            request.setAttribute("perfis", perfis);
        } catch (Exception e) {
            request.setAttribute("perfis", new Perfil[0]);
        }
    }
    
    protected void inserir(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Usuario usu = new Usuario();
        
        try {
            usu.setCpf(request.getParameter("cpf"));
            usu.setMatricula(Integer.parseInt(request.getParameter("matricula")));
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
            
            UsuarioDAO.adicionar(usu);
            
            consultar(request, response, "CONSULTA");
        } catch (Exception e) {
            request.setAttribute("msg_erro", e.getMessage());
            RequestDispatcher dispatcher = 
                request.getRequestDispatcher("cadastros/erro.jsp");
            dispatcher.forward(request, response);
        }
        
    }
    
    protected void consultar(HttpServletRequest request, HttpServletResponse response, String op)
            throws ServletException, IOException {
        try {           
            String pagina;
            if (op.equals("CONSULTA")) {
                Usuario[] usuarios;
                usuarios = UsuarioDAO.consultar(request.getParameter("nome"),"");
                pagina = "cadastros/consultaUsuarios.jsp";
                request.setAttribute("usuarios", usuarios);
            } else { 
                Usuario[] usuario;
                usuario = UsuarioDAO.consultar(request.getParameter("cpf"),"cpf");
                pagina = "cadastros/formUsuarios.jsp";
                request.getSession().setAttribute("usuario", usuario[0]);
                carregarPerfil(request, response);
                //request.setAttribute("perfil", perfil);
            }
            
            
            RequestDispatcher dispatcher = 
                    request.getRequestDispatcher(pagina);
            dispatcher.forward(request, response);
        } catch (Exception e) {
            request.setAttribute("msg_erro", e.getMessage());
            RequestDispatcher dispatcher = 
                    request.getRequestDispatcher("cadastros/erro.jsp");
            dispatcher.forward(request, response);
        }   
    }
    
    protected void atualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Usuario usu = new Usuario();
        
        try {   
            usu.setCpf(request.getParameter("cpf"));
            usu.setMatricula(Integer.parseInt(request.getParameter("matricula")));
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
            
            UsuarioDAO.atualizar(usu);

            consultar(request, response, "CONSULTA");
        } catch (Exception e) {
            request.setAttribute("msg_erro", e.getMessage());
            RequestDispatcher dispatcher = 
                    request.getRequestDispatcher("cadastros/erro.jsp");
            dispatcher.forward(request, response);
        }
    }
    
    protected void excluir(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Usuario u = new Usuario();
        
        try {
            u.setCpf(request.getParameter("cpf"));
            
            UsuarioDAO.deletar(u);

            consultar(request, response, "CONSULTA");
        } catch (Exception e) {
            request.setAttribute("msg_erro", e.getMessage());
            RequestDispatcher dispatcher = 
                    request.getRequestDispatcher("cadastros/erro.jsp");
            dispatcher.forward(request, response);
        }        
    }
    
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
        
        try {
            
            String op = request.getParameter("op");
            
            if (op.equals("CONSULTA") || op.equals("CONSATUALIZAR")){ 
                consultar(request, response, op);
            } else {
                if(op.equals("EXCLUIR")){
                    excluir(request, response);
                } else {
                    if(op.equals("ABRIRFORM")){
                        carregarPerfil(request, response);
                        RequestDispatcher dispatcher = 
                            request.getRequestDispatcher("cadastros/formUsuarios.jsp");
                        dispatcher.forward(request, response);
                    } else {
                        throw new Exception("Esses dados não devem ser processados com método GET.");
                    }
                }
            }
        } catch (Exception e) {
            request.setAttribute("msg_erro", e.getMessage());
            RequestDispatcher dispatcher = 
                    request.getRequestDispatcher("cadastros/erro.jsp");
            dispatcher.forward(request, response);
        }
        
        
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
        
        try {
            
            String op = request.getParameter("op");
            
            if(op.equals("INSERIR")){
                inserir(request, response);
            } else {
                if(op.equals("ATUALIZAR")){
                    atualizar(request, response);
                } else {
                    throw new Exception("Operação inválida.");
                }
            }
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
