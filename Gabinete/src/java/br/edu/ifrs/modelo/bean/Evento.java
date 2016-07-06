package br.edu.ifrs.modelo.bean;
import br.edu.ifrs.controle.EventosControl;
import br.edu.ifrs.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author mathias
 * Data: dia 24 / 06
 * Descricao: Classe java para objeto Evento; 
 */
public class Evento {
    private int id;
    private int id_solicitacao_evento;
    private String observacoes;
    private String cpf_servidor;
    private String solicitante;
    private String entidadeSolicitante;
    private String email;
    private String telefone;
    private String InicioEvento;
    private String fimEvento;
    private String diaSolicitacao;
    private String situacao;
    private String descricao;

    public int getId_solicitacao_evento() {
        return id_solicitacao_evento;
    }

    public void setId_solicitacao_evento(int id_solicitacao_evento) {
        this.id_solicitacao_evento = id_solicitacao_evento;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getCpf_servidor() {
        return cpf_servidor;
    }

    public void setCpf_servidor(String cpf_servidor) {
        this.cpf_servidor = cpf_servidor;
    }
    

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    public String getEntidadeSolicitante() {
        return entidadeSolicitante;
    }

    public void setEntidadeSolicitante(String entidadeSolicitante) {
        this.entidadeSolicitante = entidadeSolicitante;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getInicioEvento() {
        return InicioEvento;
    }

    public void setInicioEvento(String InicioEvento) {
        this.InicioEvento = InicioEvento;
    }

    public String getFimEvento() {
        return fimEvento;
    }

    public void setFimEvento(String fimEvento) {
        this.fimEvento = fimEvento;
    }

    public String getDiaSolicitacao() {
        return diaSolicitacao;
    }

    public void setDiaSolicitacao(String diaSolicitacao) {
        this.diaSolicitacao = diaSolicitacao;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void adicionar() throws Exception {
        String SQLInsercao = "INSERT INTO solicitacao_eventos ( solicitante, entidade_solicitante, email_contato, telefone_contato, descricao_evento, data_solicitacao, data_inicio_evento, data_termino_evento, situacao) VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement pStatement = null;
        //java.sql.Date SQLDiaSolicitacao = new java.sql.Date(this.diaSolicitacao.getTime());
        //java.sql.Date SQLInicio = new java.sql.Date(this.InicioEvento.getTime());
        //java.sql.Date SQLFim = new java.sql.Date(this.InicioEvento.getTime());
        try {
            Conexao conexao = new Conexao();
            Connection con = conexao.abrirConexao();
            pStatement = con.prepareStatement(SQLInsercao);
            pStatement.setString(1, solicitante);
            pStatement.setString(2, entidadeSolicitante);
            pStatement.setString(3, email);
            pStatement.setString(4, telefone);
            pStatement.setString(5, descricao);
            pStatement.setString(6, diaSolicitacao);
            pStatement.setString(7, InicioEvento);
            pStatement.setString(8, fimEvento);
            pStatement.setString(9, situacao);
            //pStatement.setDate(6, sqlDate);
            //pStatement.setDate(7, (java.sql.Date) InicioEvento);
            //pStatement.setDate(8, (java.sql.Date) fimEvento);
            pStatement.execute();
        } catch (Exception ex){
            System.out.println(ex.getMessage());
            Logger.getLogger(EventosControl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pStatement.close();
        }
        
    }
    
    public static ArrayList<Evento> listarEventos() throws Exception{
        ArrayList<Evento> eventos = new ArrayList<>();
        String SQLlistar = "SELECT * FROM solicitacao_eventos";
        Conexao conexao = new Conexao();
        PreparedStatement pStatement = conexao.abrirConexao().prepareStatement(SQLlistar);
        ResultSet resultado = pStatement.executeQuery();
        while (resultado.next()){
            Evento evento = new Evento();
            evento.setDescricao(resultado.getString("descricao_evento"));
            evento.setDiaSolicitacao(resultado.getString("data_solicitacao"));
            evento.setEmail(resultado.getString("email_contato"));
            evento.setEntidadeSolicitante(resultado.getString("entidade_solicitante"));
            evento.setFimEvento(resultado.getString("data_termino_evento"));
            evento.setInicioEvento(resultado.getString("data_inicio_evento"));
            evento.setSituacao(resultado.getString("situacao"));
            evento.setSolicitante(resultado.getString("solicitante"));
            evento.setTelefone(resultado.getString("telefone_contato"));
            evento.setId(resultado.getInt("id_solicitacao"));
            eventos.add(evento);
        }        
        return eventos;
    }
    
    public static void excluirEvento(int id) throws Exception{
        String SQLlistar = "DELETE FROM solicitacao_eventos WHERE id_solicitacao = ?";
        Conexao conexao = new Conexao();
        PreparedStatement pStatement = conexao.abrirConexao().prepareStatement(SQLlistar);
        pStatement.setInt(1, id);
        pStatement.execute();
    }
    
    public static void aceitarEvento(int id) throws SQLException, Exception{
        Conexao conexao = new Conexao();
        String SQLpegarEvento = "SELECT * FROM solicitacao_eventos WHERE id_solicitacao = ?";
        PreparedStatement pStatement = conexao.abrirConexao().prepareStatement(SQLpegarEvento);
        pStatement.setInt(1, id);
        ResultSet resultado = pStatement.executeQuery();
        if (resultado.next()){
            Evento evento = new Evento();
            evento.setDescricao(resultado.getString("descricao_evento"));
            evento.setDiaSolicitacao(resultado.getString("data_solicitacao"));
            evento.setEmail(resultado.getString("email_contato"));
            evento.setEntidadeSolicitante(resultado.getString("entidade_solicitante"));
            evento.setFimEvento(resultado.getString("data_termino_evento"));
            evento.setInicioEvento(resultado.getString("data_inicio_evento"));
            evento.setSituacao(resultado.getString("situacao"));
            evento.setSolicitante(resultado.getString("solicitante"));
            evento.setTelefone(resultado.getString("telefone_contato"));
            evento.setId(resultado.getInt("id_solicitacao"));
            adicionarEventoAceito(evento, id);
        }
    }
    
    public static void adicionarEventoAceito( Evento evento, int id) throws Exception{
        String SQLInsercao = "INSERT INTO eventos ( id_solicitacao_evento, solicitante, entidade_solicitante, email_contato, telefone_contato, descricao_evento, data_agendamento, data_inicio_evento, data_termino_evento, situacao, observacoes, cpf_servidor) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pStatement = null;
        try {
            Conexao conexao = new Conexao();
            Connection con = conexao.abrirConexao();
            pStatement = con.prepareStatement(SQLInsercao);
            pStatement.setInt(1, id);
            pStatement.setString(2, evento.solicitante);
            pStatement.setString(3, evento.entidadeSolicitante);
            pStatement.setString(4, evento.email);
            pStatement.setString(5, evento.telefone);
            pStatement.setString(6, evento.descricao);
            pStatement.setString(7, evento.diaSolicitacao);
            pStatement.setString(8, evento.InicioEvento);
            pStatement.setString(9, evento.fimEvento);
            pStatement.setString(10, evento.situacao);
            pStatement.setString(11, "");
            pStatement.setString(12, "12345678906");
            pStatement.execute();
        } catch (Exception ex){
            System.out.println(ex.getMessage());
            Logger.getLogger(EventosControl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pStatement.close();
        }
    }
    
    public static ArrayList<Evento> listarEventosAceitos() throws Exception{
        ArrayList<Evento> eventos = new ArrayList<>();
        String SQLlistar = "SELECT * FROM eventos";
        System.out.println("SELEC fom...");
        Conexao conexao = new Conexao();
        PreparedStatement pStatement = conexao.abrirConexao().prepareStatement(SQLlistar);
        ResultSet resultado = pStatement.executeQuery();
        while (resultado.next()){
                System.out.println("Dentro do While");
            Evento evento = new Evento();
            evento.setDescricao(resultado.getString("descricao_evento"));
                System.out.println(resultado.getString("descricao_evento"));
            evento.setDiaSolicitacao(resultado.getString("data_agendamento"));
                resultado.getString(resultado.getString("data_agendamento"));
            evento.setEmail(resultado.getString("email_contato"));
                resultado.getString(resultado.getString("email_contato"));
            evento.setEntidadeSolicitante(resultado.getString("entidade_solicitante"));
                resultado.getString(resultado.getString("entidade_solicitante"));
            evento.setFimEvento(resultado.getString("data_termino_evento"));
                resultado.getString(resultado.getString("data_termino_evento"));
            evento.setInicioEvento(resultado.getString("data_inicio_evento"));
                resultado.getString(resultado.getString("data_inicio_evento"));
            evento.setSituacao(resultado.getString("situacao"));
                resultado.getString(resultado.getString("situacao"));
            evento.setSolicitante(resultado.getString("solicitante"));
                resultado.getString(resultado.getString("solicitante"));
            evento.setTelefone(resultado.getString("telefone_contato"));
                resultado.getString(resultado.getString("telefone_contato"));
            evento.setId(resultado.getInt("id_evento"));
                resultado.getString(resultado.getString("telefone_contato"));
            evento.setCpf_servidor(resultado.getString("cpf_servidor"));
                resultado.getString(resultado.getString("cpf_servidor"));
            evento.setObservacoes(resultado.getString("observacoes"));
                resultado.getString(resultado.getString("observacoes"));
            evento.setId_solicitacao_evento(resultado.getInt("id_solicitacao_evento"));
                resultado.getString(resultado.getInt("id_solicitacao_evento"));
            eventos.add(evento);
        }
        System.out.println("Fora do While");
        return eventos;
    }
    
    public static ArrayList<Evento> listarComParametros(String nome, String dataInicio, String dataLimite, String situacao) throws Exception{
        ArrayList<Evento> eventos = new ArrayList<>();
        String SQLlistar = "SELECT * FROM solicitacao_eventos WHERE solicitante LIKE ? OR situacao LIKE ? OR data_inicio_evento BETWEEN ? AND ? ";
        Conexao conexao = new Conexao();
        PreparedStatement pStatement = conexao.abrirConexao().prepareStatement(SQLlistar);
        pStatement.setString(1, '%' + nome + '%');
        pStatement.setString(2, '%' + situacao + '%');
        pStatement.setString(3, '%' + dataInicio + '%');
        pStatement.setString(4, '%' + dataLimite + '%');
        ResultSet resultado = pStatement.executeQuery();
        while (resultado.next()){
            Evento evento = new Evento();
            evento.setDescricao(resultado.getString("descricao_evento"));
            evento.setDiaSolicitacao(resultado.getString("data_solicitacao"));
            evento.setEmail(resultado.getString("email_contato"));
            evento.setEntidadeSolicitante(resultado.getString("entidade_solicitante"));
            evento.setFimEvento(resultado.getString("data_termino_evento"));
            evento.setInicioEvento(resultado.getString("data_inicio_evento"));
            evento.setSituacao(resultado.getString("situacao"));
            evento.setSolicitante(resultado.getString("solicitante"));
            evento.setTelefone(resultado.getString("telefone_contato"));
            evento.setId(resultado.getInt("id_solicitacao"));
            eventos.add(evento);
        }        
        return eventos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
