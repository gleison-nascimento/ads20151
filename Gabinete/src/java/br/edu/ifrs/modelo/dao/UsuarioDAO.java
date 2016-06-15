/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.modelo.dao;

import br.edu.ifrs.modelo.bean.Usuario;
import br.edu.ifrs.util.Conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

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
    
}
