/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.modelo.dao;

import br.edu.ifrs.modelo.bean.Recepcao;
import br.edu.ifrs.util.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author Rodrigo
 */
public class RecepcaoDAO 
{
    public static void adicionar(Recepcao p) throws Exception {
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
            try {
                /* Conectar no banco de dados */
                con = Conexao.abrirConexao();
                SimpleDateFormat s = new SimpleDateFormat("yyyy-mm-dd");
                Calendar c = Calendar.getInstance();
                String data;
                c = p.getData_abertura();
                data = s.format(c);

                /* Preprar a sentença SQL */
                pstmt = con.prepareStatement("insert into chamado(nome_solicitante,"
                                                               + "perfil_solicitante,"
                                                               + "email_contato,"
                                                               + "telefone_contato,"
                                                               + "descricao_solicitacao,"
                                                               + "situacao,"
                                                               + "data_abertura,"
                                                               + "anexos,"
                                                               + "cpf_recepcionista,"
                                                               + "cpf_servidor) values (?,?,?,?,?,?,?,?,?,?)");
                pstmt.setString(1, p.getNome_solicitante());
                pstmt.setString(2, p.getPerfil_solicitante());
                pstmt.setString(3, p.getEmail_contato());
                pstmt.setString(4, p.getTelefone_contato());
                pstmt.setString(5, p.getDescricao_solicitacao());
                pstmt.setString(6, p.getSituacao());
                pstmt.setString(7, data);
                pstmt.setString(8, p.getAnexos());
                pstmt.setString(9, p.getCpf_recepcionista());
                pstmt.setString(10, p.getCpf_servidor());

                /* Executar a sentença no banco de dados */
                pstmt.execute();
            } catch (Exception e) {
                throw new Exception("Falha ao inserir o chamado no Banco de Dados.<br><!--" + e.getMessage() + "-->");
            } finally {
                pstmt.close();
                con.close();
            }
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    public static void atualizar(Recepcao p) throws Exception {
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
            try {
                /* Conectar no banco de dados */
                con = Conexao.abrirConexao();
                SimpleDateFormat s = new SimpleDateFormat("yyyy-mm-dd");
                Calendar c = Calendar.getInstance();
                String data;
                c = p.getData_abertura();
                data = s.format(c);

                /* Preprar a sentença SQL */
                pstmt = con.prepareStatement("update chamado set " +
                                             "nome_solicitante = ? " +
                                             "Perfil_solicitante = ? " +
                                             "email_contato = ? " +
                                             "telefone_contato = ? " +
                                             "descricao_solicitacao = ? " +
                                             "situacao = ? " +
                                             "data_abertura = ? " +
                                             "anexos = ? " +
                                             "cpf_recepcionista = ? " +
                                             "cpf_servidor = ? " +
                                             "where id = ?");
                pstmt.setString(1, p.getNome_solicitante());
                pstmt.setString(2, p.getPerfil_solicitante());
                pstmt.setString(3, p.getEmail_contato());
                pstmt.setString(4, p.getTelefone_contato());
                pstmt.setString(5, p.getDescricao_solicitacao());
                pstmt.setString(6, p.getSituacao());
                pstmt.setString(7, data);
                pstmt.setString(8, p.getAnexos());
                pstmt.setString(9, p.getCpf_recepcionista());
                pstmt.setString(10, p.getCpf_servidor());
                pstmt.setInt(11, p.getId());

                /* Executar a sentença no banco de dados */
                pstmt.execute();
            } catch (Exception e) {
                throw new Exception("Falha ao inserir o chamado no Banco de Dados.<br><!--" + e.getMessage() + "-->");
            } finally {
                pstmt.close();
                con.close();
            }
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    public static Recepcao consultar (int id) throws Exception {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Recepcao p = new Recepcao();
        
        try {
            try {
                con = Conexao.abrirConexao();
                Calendar c = Calendar.getInstance();

                /* Preprar a sentença SQL */
                pstmt = con.prepareStatement("select * from perfil where id = ?");
                pstmt.setInt(1, id);
                
                /* Executar a sentença no banco de dados */
                rs = pstmt.executeQuery();              
                if (rs.next() == true) {
                    p.setNome_solicitante(rs.getString("nome_solicitante"));
                    p.setPerfil_solicitante(rs.getString("Perfil_solicitante"));
                    p.setEmail_contato(rs.getString("Email_contato"));
                    p.setTelefone_contato(rs.getString("Telefone_contato"));
                    p.setDescricao_solicitacao(rs.getString("Descricao_solicitacao"));
                    p.setSituacao(rs.getString("Situacao"));
                    p.setData_abertura(formataStringToCalendar(rs.getString("Data_abertura")));
                    p.setAnexos(rs.getString("Anexos"));
                    p.setCpf_recepcionista(rs.getString("Cpf_recepcionista"));
                    p.setCpf_servidor(rs.getString("Cpf_servidor"));
                    p.setId(rs.getInt("id"));
                }
            } catch (Exception e) {
                throw new Exception("Falha ao inserir o perfil no Banco de Dados.<br><!--" + e.getMessage() + "-->");
            } finally {
                pstmt.close();
                con.close();
            }
        } catch (Exception ex) {
            throw ex;
        }
        
        return p;
    }
    
    public static void deletar(Recepcao p) throws Exception {
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
            try {
                /* Conectar no banco de dados */
                con = Conexao.abrirConexao();

                /* Preprar a sentença SQL */
                pstmt = con.prepareStatement("delete from chamado where id = ?");
                pstmt.setInt(1, p.getId());
                
                /* Executar a sentença no banco de dados */
                pstmt.execute();
            } catch (Exception e) {
                throw new Exception("Falha ao deletar o chamado no Banco de Dados.<br><!--" + e.getMessage() + "-->");
            } finally {
                pstmt.close();
                con.close();
            }
        } catch (Exception ex) {
            throw ex;
        }
    }
      
    public static Calendar formataStringToCalendar(String data) throws Exception 
    { 
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/mm/yyyy");
        Calendar c = Calendar.getInstance();
        if (data == null || data.equals(""))
            return null;
        try 
        {
            c.setTime(formatoData.parse(data));
        } catch (ParseException e) {            
            throw e;
        }
        return c;
    }    
    
    public static String formataCalendarToString(Calendar data) throws Exception 
    { 
        SimpleDateFormat formatoData = new SimpleDateFormat("yyyy-mm-dd");
        Calendar c = new GregorianCalendar();
        String retorno="";
        if (data == null || data.equals(""))
            return null;
        retorno = formatoData.format(c.getTime());
        return retorno;
    }    
}
