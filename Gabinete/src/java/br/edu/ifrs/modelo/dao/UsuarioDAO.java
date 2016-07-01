/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.modelo.dao;

import br.edu.ifrs.modelo.bean.Perfil;
import br.edu.ifrs.modelo.bean.Usuario;
import br.edu.ifrs.util.Conexao;
import java.sql.Connection;
import java.sql.DriverManager;
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

                /* Preprar a sentença SQL */
                pstmt = con.prepareStatement("insert into usuarios (cpf, siape, nome, sexo, endereco, email, telefone, username, senha, situacao, observacoes, id_perfil) values (?, ?, ?, ?, ?, ?, ?, ?, MD5(?), ?, ?, ?)");
                pstmt.setString(1, usu.getCpf());
                pstmt.setString(2, usu.getMatricula());
                pstmt.setString(3, usu.getNome());
                pstmt.setString(4, usu.getSexo());
                pstmt.setString(5, usu.getEndereco());
                pstmt.setString(6, usu.getEmail());
                pstmt.setString(7, usu.getTelefoneResidencial());
                pstmt.setString(8, usu.getUsername());
                pstmt.setString(9, usu.getSenha());
                pstmt.setString(10, usu.getSituacao());
                pstmt.setString(11, usu.getObservacoes());
                pstmt.setInt(12, usu.getPerfil().getId());

                /* Executar a sentença no banco de dados */
                pstmt.execute();
            } catch (Exception e) {
                throw new Exception("Falha ao inserir o usuário no Banco de Dados.<br><!--" + e.getMessage() + "-->");
            } finally {
                pstmt.close();
                con.close();
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
                pstmt = con.prepareStatement("update usuarios set siape = ?, nome = ?, sexo = ?, endereco = ?, email = ?, telefone = ?, username = ?, senha = MD5(?), situacao = ?, observacoes = ?, id_perfil = ? where cpf = ?");
                pstmt.setString(1, usu.getMatricula());
                pstmt.setString(2, usu.getNome());
                pstmt.setString(3, usu.getSexo());
                pstmt.setString(4, usu.getEndereco());
                pstmt.setString(5, usu.getEmail());
                pstmt.setString(6, usu.getTelefoneResidencial());
                pstmt.setString(7, usu.getUsername());
                pstmt.setString(8, usu.getSenha());
                pstmt.setString(9, usu.getSituacao());
                pstmt.setString(10, usu.getObservacoes());
                pstmt.setInt(11, usu.getPerfil().getId());
                pstmt.setString(12, usu.getCpf());

                /* Executar a sentença no banco de dados */
                pstmt.execute();
            } catch (Exception e) {
                throw new Exception("Falha ao atualizar o usuário no Banco de Dados.<br><!--" + e.getMessage() + "-->");
            } finally {
                pstmt.close();
                con.close();
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
                throw new Exception("Falha ao atualizar o usuário no Banco de Dados.<br><!--" + e.getMessage() + "-->");
            } finally {
                pstmt.close();
                con.close();
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
                    u.setMatricula(rs.getString("siape"));
                    u.setNome(rs.getString("nome"));
                    u.setSexo(rs.getString("sexo"));
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
                pstmt.close();
                con.close();
            }
        } catch (Exception ex) {
            throw ex;
        }
        
        return lista.toArray(new Usuario[0]);
    }
    
}
