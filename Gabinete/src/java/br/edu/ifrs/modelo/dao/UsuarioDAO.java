/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.modelo.dao;

import br.edu.ifrs.modelo.bean.Login;
import br.edu.ifrs.modelo.bean.Usuario;
import br.edu.ifrs.util.Conexao;
import static br.edu.ifrs.util.Conexao.finalizarConexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author DTI
 */
public class UsuarioDAO {
    
    public static void adicionar(Usuario usu) throws Exception {
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
            try {
                con = Conexao.abrirConexao();

                /* Preprar a sentença SQL */
//                pstmt = con.prepareStatement("insert into usuarios (cpf, siape, nome, sexo, endereco, email, telefone, username, senha, situacao, observacoes, id_perfil) values (?, ?, ?, ?, ?, ?, ?, ?, MD5(?), ?, ?, ?)");
//                pstmt.setString(1, usu.getCpf());
//                pstmt.setString(2, usu.getMatricula());
//                pstmt.setString(3, usu.getNome());
//                pstmt.setString(4, usu.getSexo());
//                pstmt.setString(5, usu.getEndereco());
//                pstmt.setString(6, usu.getEmail());
//                pstmt.setString(7, usu.getTelefoneResidencial());
//                pstmt.setString(8, usu.getUsername());
//                pstmt.setString(9, usu.getSenha());
//                pstmt.setString(10, usu.getSituacao());
//                pstmt.setString(11, usu.getObservacoes());
//                pstmt.setInt(12, usu.getPerfil().getId());
                  pstmt = con.prepareStatement("insert into usuarios values (?, ?, ?, ?, ?, ?, ?, ?, MD5(?), ?, ?, ?)");
                  pstmt.setString(1, usu.getUsername());
                  pstmt.setString(1, usu.getSenha());
                  pstmt.setString(1, usu.getCpf());
                  pstmt.setString(1, usu.getNome());
                  pstmt.setString(1, usu.getTelefoneCelular());
                  pstmt.setString(1, usu.getEmail());
                  pstmt.setInt(0, usu.getTipo_usuario());
                  pstmt.setInt(0, usu.getMatricula());
                  pstmt.setString(1, "IFRS RESTINGA");
                  pstmt.setInt(1, 48);
                  pstmt.setInt(0, usu.getSetor_id());

                /* Executar a sentença no banco de dados */
                pstmt.execute();
            } catch (Exception e) {
                throw new Exception("Falha ao inserir o usuário no Banco de Dados.<br><!--" + e.getMessage() + "-->");
            } finally {
                finalizarConexao(con,pstmt);
            }
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    public static Usuario consultar(String login, String senha) throws Exception {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Usuario usuario = new Usuario();
        try {
          
                
                con = Conexao.abrirConexao();
                /* Preprar a sentença SQL */
                pstmt = con.prepareStatement("select * from usuarios where login = ? and senha = ?");
                pstmt.setString(1, login);
                pstmt.setString(2, senha);
                /* Executar a sentença no banco de dados */
                rs = pstmt.executeQuery();
  
                if (rs.next() == true) {
                 
                    usuario.setCpf(rs.getString("cpf"));
                    usuario.setUsername(rs.getString("login"));
                    usuario.setSenha(rs.getString("senha"));
                    usuario.setNome(rs.getString("nome"));
                    usuario.setTipo_usuario(rs.getInt("tipo_usuario"));
                    //adicionar os demais campos caso seja necessário possível nullpointer se acessar campos extras;
                }
                
                if(usuario.getUsername() != null && !usuario.getUsername().equals("")){
                    return usuario;
                }
                
          
        } catch (Exception ex) {
            
            throw ex;
            
        }
        finally {
                
            finalizarConexao(con, pstmt);

        }

        return null;
        
    }
    
}
