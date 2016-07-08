/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.modelo.dao;

import br.edu.ifrs.modelo.bean.Perfil;
import br.edu.ifrs.modelo.bean.Usuario;
import br.edu.ifrs.util.Conexao;
import static br.edu.ifrs.util.Conexao.finalizarConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

//                /* Preprar a sentença SQL */
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
                  pstmt.setString(2, usu.getSenha());
                  pstmt.setString(3, usu.getCpf());
                  pstmt.setString(4, usu.getNome());
                  pstmt.setString(5, usu.getTelefoneCelular());
                  pstmt.setString(6, usu.getEmail());
                  pstmt.setInt(7, usu.getTipo_usuario());
                  pstmt.setInt(8, usu.getMatricula());
                  pstmt.setString(9, "IFRS RESTINGA");
                  pstmt.setInt(10, 48);
                  pstmt.setInt(11, usu.getSetor_id());

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
    
    public static void atualizar(Usuario usu) throws Exception {
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
            try {
                /* Conectar no banco de dados */
                con = Conexao.abrirConexao();

                /* Preprar a sentença SQL */
                pstmt = con.prepareStatement("update usuarios set siape = ?, nome = ?, endereco = ?, email = ?, telefone = ?, username = ?, senha = MD5(?), situacao = ?, observacoes = ?, id_perfil = ? where cpf = ?");
                pstmt.setInt(1, usu.getMatricula());
                pstmt.setString(2, usu.getNome());
                pstmt.setString(3, usu.getEndereco());
                pstmt.setString(4, usu.getEmail());
                pstmt.setString(5, usu.getTelefoneResidencial());
                pstmt.setString(6, usu.getUsername());
                pstmt.setString(7, usu.getSenha());
                pstmt.setString(8, usu.getSituacao());
                pstmt.setString(9, usu.getObservacoes());
                pstmt.setInt(10, usu.getPerfil().getId());
                pstmt.setString(11, usu.getCpf());

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
    
    public static void deletar(Usuario usu) throws Exception {
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
            try {
                /* Conectar no banco de dados */
                con = Conexao.abrirConexao();

                /* Preprar a sentença SQL */
                pstmt = con.prepareStatement("delete from usuarios where cpf = ?");
                pstmt.setString(1, usu.getCpf());

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
        
    public static Usuario[] consultar (String parametro, String tipo) throws Exception {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Usuario> lista = new ArrayList();
        
        try {
            try {
                con = Conexao.abrirConexao();

                /* Preprar a sentença SQL */
                pstmt = con.prepareStatement("select u.*, p.id, p.nome as nome_perfil from usuarios u, perfil p where u.cpf like ? and u.nome like ? and u.id_perfil = p.id");
                if (tipo != null && tipo.equals("cpf")) {
                    pstmt.setString(1, parametro);
                    pstmt.setString(2, "%");
                } else {
                    pstmt.setString(1, "%");
                    pstmt.setString(2, (parametro == null ? "%":"%"+parametro+"%"));
                }
                
                /* Executar a sentença no banco de dados */
                rs = pstmt.executeQuery();
                while (rs.next() == true) {
                    Usuario u = new Usuario();
                    u.setCpf(rs.getString("cpf"));
                    u.setMatricula(Integer.parseInt("siape"));
                    u.setNome(rs.getString("nome"));
                    u.setEndereco(rs.getString("endereco"));
                    u.setEmail(rs.getString("email"));
                    u.setTelefoneResidencial(rs.getString("telefone"));
                    u.setUsername(rs.getString("username"));
                    u.setSituacao(rs.getString("situacao"));
                    u.setObservacoes(rs.getString("observacoes"));
                    
                    Perfil p = new Perfil();
                    p.setId(rs.getInt("id"));
                    p.setNome(rs.getString("nome_perfil"));
                    u.setPerfil(p);
                    
                    lista.add(u);                    
                }
            } catch (Exception e) {
                throw new Exception("Falha ao consultar o usuário no Banco de Dados.<br><!--" + e.getMessage() + "-->");
            } finally {
                finalizarConexao(con,pstmt);
            }
        } catch (Exception ex) {
            throw ex;
        }
        
        return lista.toArray(new Usuario[0]);
    }
    
    public static Usuario consultarLogin(String login, String senha) throws Exception {
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
