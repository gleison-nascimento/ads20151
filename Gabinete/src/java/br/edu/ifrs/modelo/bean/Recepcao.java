/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.modelo.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Rodrigo
 */
public class Recepcao 
{
    private int id;
    private String nome_solicitante;
    private String perfil_solicitante;
    private String email_contato;
    private String telefone_contato;
    private String descricao_solicitacao;
    private String situacao;
    private Calendar data_abertura;
    private String anexos;
    private String cpf_recepcionista;
    private String cpf_servidor;
    
    public Recepcao()
    {
        this.id = 0;
        this.nome_solicitante = "";
        this.perfil_solicitante = "";
        this.email_contato = "";
        this.telefone_contato = "";
        this.descricao_solicitacao = "";
        this.situacao = "";
        this.data_abertura = Calendar.getInstance();
        this.anexos = "";
        this.cpf_recepcionista = "";
        this.cpf_servidor = "";        
    }

    public int getId() {
        return id;
    }

    public String getNome_solicitante() {
        return nome_solicitante;
    }

    public String getPerfil_solicitante() {
        return perfil_solicitante;
    }

    public String getEmail_contato() {
        return email_contato;
    }

    public String getTelefone_contato() {
        return telefone_contato;
    }

    public String getDescricao_solicitacao() {
        return descricao_solicitacao;
    }

    public String getSituacao() {
        return situacao;
    }

    public Calendar getData_abertura() {
        return data_abertura;
    }

    public String getAnexos() {
        return anexos;
    }

    public String getCpf_recepcionista() {
        return cpf_recepcionista;
    }

    public String getCpf_servidor() {
        return cpf_servidor;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome_solicitante(String nome_solicitante) {
        this.nome_solicitante = nome_solicitante;
    }

    public void setPerfil_solicitante(String perfil_solicitante) {
        this.perfil_solicitante = perfil_solicitante;
    }

    public void setEmail_contato(String email_contato) {
        this.email_contato = email_contato;
    }

    public void setTelefone_contato(String telefone_contato) {
        this.telefone_contato = telefone_contato;
    }

    public void setDescricao_solicitacao(String descricao_solicitacao) {
        this.descricao_solicitacao = descricao_solicitacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public void setData_abertura(Calendar data_abertura) {
        this.data_abertura = data_abertura;
    }

    public void setAnexos(String anexos) {
        this.anexos = anexos;
    }

    public void setCpf_recepcionista(String cpf_recepcionista) {
        this.cpf_recepcionista = cpf_recepcionista;
    }

    public void setCpf_servidor(String cpf_servidor) {
        this.cpf_servidor = cpf_servidor;
    }
}
