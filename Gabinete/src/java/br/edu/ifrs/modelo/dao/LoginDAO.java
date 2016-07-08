package br.edu.ifrs.modelo.dao;

import br.edu.ifrs.modelo.bean.Login;
import br.edu.ifrs.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/** 
 * Document   : LoginDAO.java
 * Created on : 21/06/2016, 17:43
 * Author     : EvertonQuadros
 * Escopo     : Eventos/Projeto
 * Descricao  : Classe DAO que busca dados do login.
 * Observações: Alterar com aviso prévio, comentar revisões.
 */

public class LoginDAO {
    
    public static Login consultar(String login, String senha) throws Exception {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Login p = new Login();
        try {
            try {
                
                con = Conexao.abrirConexao();
                /* Preprar a sentença SQL */
                pstmt = con.prepareStatement("select * from perfis where login = ? and senha = ?");
                pstmt.setString(1, login);
                pstmt.setString(2, senha);
                /* Executar a sentença no banco de dados */
                rs = pstmt.executeQuery();
                if (rs.next() == true) {
                    
                    p.setId(rs.getInt("id"));
                    p.setLogin(rs.getString("login"));
                    p.setSenha(rs.getString("senha"));
                //    p.setCpf(rs.getString("cpf"));
                    
                }
                
                if(!p.getLogin().equals("")){
                    return p;
                }
                
            } catch (Exception e) {
                
                throw new Exception(e.getMessage());
                
            } finally {
                
                if(pstmt != null){
                    
                    pstmt.close();
                
                }
                
                if(con != null){
                    
                    con.close(); 
                
                }
                
            }
        } catch (Exception ex) {
            throw ex;
        }
        
        return null;
    }
    
}
