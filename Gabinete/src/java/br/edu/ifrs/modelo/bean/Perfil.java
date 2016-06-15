/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.modelo.bean;

/**
 *
 * @author DTI
 */
public class Perfil {
    private String nome;
    private String descricao;
    private String situacao;
    private int id;

    public Perfil() {
        this.nome = "";
        this.descricao = "";
        this.situacao = "";
    }
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) throws Exception {
        if (nome == null || nome.equals("")) {
            throw new Exception("O campo nome é de preenchimento obrigatório.");
        }
        this.nome = nome;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the situacao
     */
    public String getSituacao() {
        return situacao;
    }

    /**
     * @param situacao the situacao to set
     */
    public void setSituacao(String situacao) throws Exception {
        if (situacao == null || situacao.equals("")) {
            throw new Exception("O campo situação é de preenchimento obrigatório.");
        }
        this.situacao = situacao;
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
   
}
