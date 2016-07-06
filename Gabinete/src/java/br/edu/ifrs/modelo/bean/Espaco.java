package br.edu.ifrs.modelo.bean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Espaco {
    private String nome;
    private int numero;
    private String descricao;
    private int lotacao;
    private String tipo;
    private boolean projetor;
    private boolean internet;
    private boolean quadro;
    private String especialidade;
    private String lista_Equipamentos;
    private String situacao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getLotacao() {
        return lotacao;
    }

    public void setLotacao(int lotacao) {
        this.lotacao = lotacao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
    public String getLista_Equipamentos() {
        return lista_Equipamentos;
    }

    public void setLista_Equipamentos(String lista_Equipamentos) {
        this.lista_Equipamentos = lista_Equipamentos;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public boolean isProjetor() {
        return projetor;
    }

    public void setProjetor(boolean projetor) {
        this.projetor = projetor;
    }

    public boolean isInternet() {
        return internet;
    }

    public void setInternet(boolean internet) {
        this.internet = internet;
    }

    public boolean isQuadro() {
        return quadro;
    }

    public void setQuadro(boolean quadro) {
        this.quadro = quadro;
    }
    
    
    
}