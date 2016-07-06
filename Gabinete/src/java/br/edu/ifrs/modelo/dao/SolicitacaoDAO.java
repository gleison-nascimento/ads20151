package br.edu.ifrs.modelo.dao;

import br.edu.ifrs.modelo.bean.Solicitacoes;
import br.edu.ifrs.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SolicitacaoDAO {
    public static Solicitacoes[] consultar (String solicitante, String situacao) throws Exception {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Solicitacoes> lista = new ArrayList();
        
        try {
            try {
                con = Conexao.abrirConexao();

                /* Preprar a sentença SQL */
                pstmt = con.prepareStatement("select * from solicitacoes where solicitante like ? or situacao like ?");
                pstmt.setString(1, ((solicitante == null || solicitante.equals("")) ? "":"%"+solicitante+"%"));
                pstmt.setString(2, ((situacao == null || situacao.equals("")) ? "":"%"+situacao+"%"));
                
                /* Executar a sentença no banco de dados */
                rs = pstmt.executeQuery();
                while (rs.next() == true) {
                    Solicitacoes s = new Solicitacoes();
                    s.setId(rs.getInt("id"));
                    s.setSolicitante(rs.getString("solicitante"));
                    s.setEntidade(rs.getString("entidade"));
                    s.setEmail(rs.getString("email"));
                    s.setTel(rs.getString("telefone"));
                    s.setObjetivo(rs.getString("objetivo"));
                    s.setData(rs.getString("data_"));
                    s.setDataInicio(rs.getString("data_inicio"));
                    s.setHoraInicio(rs.getString("hora_inicio"));
                    s.setDataTermino(rs.getString("data_termino"));
                    s.setHoraTermino(rs.getString("hora_termino"));
                    s.setSituacao(rs.getString("situacao"));
                    
                    lista.add(s);                    
                }
            } catch (Exception ex) {
                throw new Exception("Falha ao consultar o BD.<br>" + ex.getMessage());
            } finally {
                pstmt.close();
                con.close();
            }
        } catch (Exception ex) {
            throw ex;
        }
        
        return lista.toArray(new Solicitacoes[0]);
    }
    
    public static Solicitacoes consultar (int id) throws Exception {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Solicitacoes s = new Solicitacoes();
        
        try {
            try {
                con = Conexao.abrirConexao();

                /* Preprar a sentença SQL */
                pstmt = con.prepareStatement("select * from solicitacoes where id = ?");
                pstmt.setInt(1, id);
                
                /* Executar a sentença no banco de dados */
                rs = pstmt.executeQuery();
                if (rs.next() == true) {
                    s.setId(rs.getInt("id"));
                    s.setSolicitante(rs.getString("solicitante"));
                    s.setEntidade(rs.getString("entidade"));
                    s.setEmail(rs.getString("email"));
                    s.setTel(rs.getString("telefone"));
                    s.setObjetivo(rs.getString("objetivo"));
                    s.setData(rs.getString("data_"));
                    s.setDataInicio(rs.getString("data_inicio"));
                    s.setHoraInicio(rs.getString("hora_inicio"));
                    s.setDataTermino(rs.getString("data_termino"));
                    s.setHoraTermino(rs.getString("hora_termino"));
                    s.setSituacao(rs.getString("situacao"));
                }
            } catch (Exception ex) {
                throw new Exception("Falha ao inserir o perfil no Banco de Dados.<br>" + ex.getMessage());
            } finally {
                pstmt.close();
                con.close();
            }
        } catch (Exception ex) {
            throw ex;
        }
        
        return s;
    }
    
    public static void atualizar(Solicitacoes s) throws Exception {
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
            try {
                /* Conectar no banco de dados */
                con = Conexao.abrirConexao();

                /* Preprar a sentença SQL */
                pstmt = con.prepareStatement("update solicitacoes set data_reserva = ?, observacoes = ?, espaco_reservado = ? where id = ?");
                pstmt.setString(1, s.getDataReserva());
                pstmt.setString(2, s.getObs());
                pstmt.setString(3, s.getEspacoReservado());
                pstmt.setInt(4, s.getId());

                /* Executar a sentença no banco de dados */
                pstmt.execute();
            } catch (Exception ex) {
                throw new Exception("Falha ao atualizar Banco de Dados.<br>" + ex.getMessage());
            } finally {
                pstmt.close();
                con.close();
            }
        } catch (Exception ex) {
            throw ex;
        }
    }
}