package br.edu.ifrs.modelo.bean;

/**
* Document : Login.java
* Created on : 21/06/2016 17:16
* Author : EvertonQuadros
* Escopo : Eventos
* Descricao : Classe para interação com login do usuário no sistema
* Observações: Pode ser editado conforme necessidade, classe teste.
*/

public class Login {
    
    private String login;
    private String senha;
    private int id;

    public Login() {
        this.login = "";
    }
    /**
     * @return the nome
     */
    public String getLogin() {
        return login;
    }
    
    /**
     * @param login
     * @throws java.lang.Exception
     */
    public void setLogin(String login) throws Exception {
        if (login == null || login.equals("")) {
            throw new Exception("O campo login é de preenchimento obrigatório.");
        }
        this.login = login;
    }
    
    public String getSenha(){
        return senha;
    }
    
    public void setSenha(String senha)throws Exception{
        
        if(senha != null && !senha.equals("")){
            
            this.senha = senha;
            
        }
        else{
            
            throw new Exception("O campo senha é de preenchimento obrigatório.");
            
        }
            
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
