package br.edu.ifrs.modelo.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class espacoModelo {
    private String solicitante;
    private String entidade;
    private String email;
    private String tel;
    private String objetivo;
    private String data;
    private String dataInicio;
    private String horaInicio;
    private String dataTermino;
    private String horaTermino;

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) throws Exception {
        if(solicitante == null || solicitante.equals("")) {
            throw new Exception("O campo `Solicitante´ é de preenchimento obrigatório.");
        }
        this.solicitante = solicitante;
    }

    public String getEntidade() {
        return entidade;
    }

    public void setEntidade(String entidade) {
        this.entidade = entidade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws Exception {
        if(email == null || email.equals("")) {
            throw new Exception("O campo `Email de contato´ é de preenchimento obrigatório.");
        }
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) throws Exception {
        if(tel == null || tel.equals("")) {
            throw new Exception("O campo `Telefone de contato´ é de preenchimento obrigatório.");
        }
        this.tel = tel;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) throws Exception {
        if(objetivo == null || objetivo.equals("")) {
            throw new Exception("O campo `Objetivo da reserva do espaço´ é de preenchimento obrigatório.");
        }
        this.objetivo = objetivo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) throws Exception {
        if(dataInicio == null || dataInicio.equals("")) {
            throw new Exception("O campo `Data de início da reserva´ é de preenchimento obrigatório.");
        }
        this.dataInicio = dataInicio;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) throws Exception {
        if(horaInicio == null || horaInicio.equals("")) {
            throw new Exception("O campo `Hora de início da reserva´ é de preenchimento obrigatório.");
        }
        this.horaInicio = horaInicio;
    }

    public String getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(String dataTermino) throws Exception {
        if(dataTermino == null || dataTermino.equals("")) {
            throw new Exception("O campo `Data de término da reserva´ é de preenchimento obrigatório.");
        }
        this.dataTermino = dataTermino;
    }

    public String getHoraTermino() {
        return horaTermino;
    }

    public void setHoraTermino(String horaTermino) throws Exception {
        if(horaTermino == null || horaTermino.equals("")) {
            throw new Exception("O campo `Hora de término da reserva´ é de preenchimento obrigatório.");
        }
        this.horaTermino = horaTermino;
    }
    
    public void adicionar() throws Exception {
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
            try {
                /* Conectar no banco de dados */
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gabinete", "root", "");

                /* Preprar a sentença SQL */
                pstmt = con.prepareStatement("insert into solicitacao_reserva (solicitante, entidade_solicitante, email_contato, telefone_contato, objetivo_reserva, data_solicitacao, data_inicio_reserva,"
                        + "hora_inicio, data_termino_reserva, hora_termino, situacao) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 'pendente')");
                pstmt.setString(1, this.solicitante);
                pstmt.setString(2, this.entidade);
                pstmt.setString(3, this.email);
                pstmt.setString(4, this.tel);
                pstmt.setString(5, this.objetivo);
                pstmt.setString(6, this.data);
                pstmt.setString(7, this.dataInicio);
                pstmt.setString(8, this.horaInicio);
                pstmt.setString(9, this.dataTermino);
                pstmt.setString(10, this.horaTermino);
                
                /* Executar a sentença no banco de dados */
                pstmt.execute();
            } catch (Exception e) {
                throw new Exception("Falha ao inserir solicitação no Banco de Dados.<br>" + e.getMessage());
            } finally {
                pstmt.close();
                con.close();
            }
        } catch (Exception ex) {
            throw ex;
        }
    }
}