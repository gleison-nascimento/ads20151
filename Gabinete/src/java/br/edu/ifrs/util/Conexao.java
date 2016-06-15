/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author DTI
 */
public class Conexao {
    
    public static Connection abrirConexao() throws Exception {
        Connection con = null;
        
        /* Conectar no banco de dados */
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gabinete", "root", "connect");
        
        return con;
    }
    
}
