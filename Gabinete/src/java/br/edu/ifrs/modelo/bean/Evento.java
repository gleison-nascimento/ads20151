package br.edu.ifrs.modelo.bean;
import java.util.*;
/**
 *
 * @author mathias
 * Data: dia 24 / 06
 * Descricao: Classe java para objeto Evento; 
 */
public class Evento {
    private String solicitante;
    private String entidadeSolicitante;
    private String email;
    private String telefone;
    private Date InicioEvento;
    private Date fimEvento;
    private Date diaSolicitacao;
    private String situacao;
    private String descricao;

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

    public Date getInicioEvento() {
        return InicioEvento;
    }

    public void setInicioEvento(Date InicioEvento) {
        this.InicioEvento = InicioEvento;
    }

    public Date getFimEvento() {
        return fimEvento;
    }

    public void setFimEvento(Date fimEvento) {
        this.fimEvento = fimEvento;
    }

    public Date getDiaSolicitacao() {
        return diaSolicitacao;
    }

    public void setDiaSolicitacao(Date diaSolicitacao) {
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

    public void adicionar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
