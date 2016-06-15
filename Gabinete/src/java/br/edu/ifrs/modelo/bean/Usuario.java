/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.modelo.bean;

import br.edu.ifrs.modelo.bean.Perfil;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author DTI
 */
public class Usuario {
    private String cpf;
    private String nome;
    private String matricula;
    private String sexo;
    private String endereco;
    private String email; 
    private String telefoneResidencial; 
    private String telefoneProfissional;
    private String telefoneCelular;
    private Perfil perfil;
    private String username;
    private String senha; 
    private String situacao;
    private String observacoes;

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
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
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the matricula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the telefoneResidencial
     */
    public String getTelefoneResidencial() {
        return telefoneResidencial;
    }

    /**
     * @param telefoneResidencial the telefoneResidencial to set
     */
    public void setTelefoneResidencial(String telefoneResidencial) {
        this.telefoneResidencial = telefoneResidencial;
    }

    /**
     * @return the telefoneProfissional
     */
    public String getTelefoneProfissional() {
        return telefoneProfissional;
    }

    /**
     * @param telefoneProfissional the telefoneProfissional to set
     */
    public void setTelefoneProfissional(String telefoneProfissional) {
        this.telefoneProfissional = telefoneProfissional;
    }

    /**
     * @return the telefoneCelular
     */
    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    /**
     * @param telefoneCelular the telefoneCelular to set
     */
    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    /**
     * @return the perfil
     */
    public Perfil getPerfil() {
        return perfil;
    }

    /**
     * @param perfil the perfil to set
     */
    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public void setSenha(String s, String cs) throws Exception {
        if (s == null || s.equals("")) {
            throw new Exception ("Senha deve ser preenchida com um valor numérico.");
        }
        if (!s.equals(cs)) {
            throw new Exception ("Os campos senha e confirmação de senha devem ser idênticos.");
        }
    
        setSenha(s);
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
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    /**
     * @return the observacoes
     */
    public String getObservacoes() {
        return observacoes;
    }

    /**
     * @param observacoes the observacoes to set
     */
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    
    public void adicionar() throws Exception {
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
            try {
                /* Conectar no banco de dados */
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gabinete", "root", "connect");

                /* Preprar a sentença SQL */
                pstmt = con.prepareStatement("insert into usuarios (cpf, siape, nome, sexo, endereco, email, telefone, username, senha, situacao, observacoes, id_perfil) values (?, ?, ?, ?, ?, ?, ?, ?, MD5(?), ?, ?, ?)");
                pstmt.setString(1, this.cpf);
                pstmt.setString(2, this.matricula);
                pstmt.setString(3, this.nome);
                pstmt.setString(4, this.sexo);
                pstmt.setString(5, this.endereco);
                pstmt.setString(6, this.email);
                pstmt.setString(7, this.telefoneResidencial);
                pstmt.setString(8, this.username);
                pstmt.setString(9, this.senha);
                pstmt.setString(10, this.situacao);
                pstmt.setString(11, this.observacoes);
                pstmt.setInt(12, this.perfil.getId());

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
