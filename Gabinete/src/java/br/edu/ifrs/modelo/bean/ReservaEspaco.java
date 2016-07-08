/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.modelo.bean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ReservaEspaco {
    private String nome;
    private int numero;
    private String descricao;
    private int lotacao;
    private String tipo_lab;
    private boolean projetor;
    private boolean internet;
    private boolean quadro;
    private String especialidade;
    private String equipamentos;
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

    public String getTipo_lab() {
        return tipo_lab;
    }

    public void setTipo_lab(String tipo_lab) {
        this.tipo_lab = tipo_lab;
    }

    
    public String getEquipamentos() {
        return equipamentos;
    }

    public void setEquipamentos(String lista_Equipamentos) {
        this.equipamentos = lista_Equipamentos;
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
    
    
    
    public void adicionar() throws Exception {
        
        Connection con = null;
        PreparedStatement pstmt = null;
        
        
        try {
            try{
            /* Conectar no banco de dados */
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gabinete", "root", "");
            }catch(Exception X){
                throw new Exception ("Erro ao conectar ao banco");
            }

            try{

                /* Preprar a sentença SQL */
                pstmt = con.prepareStatement("insert into espacos (numero,nome,descricao,lotacao,tipo,projetor,internet,quadro,especialidade,equipamentos,situacao) values(?,?,?,?,?,?,?,?,?,?,?)");
                pstmt.setInt(1, this.numero);
                pstmt.setString(2, this.nome);
                pstmt.setString(3, this.descricao); 
                pstmt.setInt(4, this.lotacao);
                pstmt.setString(5, this.tipo_lab);
                pstmt.setBoolean(6, this.projetor);
                pstmt.setBoolean(7, this.internet);
                pstmt.setBoolean(8, this.quadro);
                pstmt.setString(9, this.especialidade);
                pstmt.setString(10, this.equipamentos);
                pstmt.setString(11, this.situacao);

                pstmt.execute();

            }catch(Exception X){
                throw new Exception ("erro ao executar query");
            }

        } catch (Exception e) {

            throw new Exception(e.getMessage());

        }finally {
            pstmt.close();
            con.close();
        }
    }
}

