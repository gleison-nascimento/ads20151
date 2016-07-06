package br.edu.ifrs.modelo.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import br.edu.ifrs.modelo.bean.Espaco;

public class espacosDAO {
    
    public Espaco [] consultar(int numero, String nome, String tipo) throws Exception{
        
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;  
        
        ArrayList <Espaco> espacos = new ArrayList();
        
        
        try {
            try{
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gabinete", "root", "");
            }catch(Exception X){
                throw new Exception("Erro ao conectar no banco.");
            }
           
            
            try{
                
                if(numero == 0 && nome.equals("0") && tipo.equals("0")){
                    pstmt = connection.prepareStatement("select * from espacos");
                     
                }
                if(numero == 0 && nome.equals("0") && !tipo.equals("0")){
                    pstmt = connection.prepareStatement("select * from espacos where tipo like ? ");
                    pstmt.setString(1, '%'+tipo+'%');
                    
                }
                if(numero == 0 && !nome.equals("0") && tipo.equals("0")){
                    pstmt = connection.prepareStatement("select * from espacos where nome like ? ");
                    pstmt.setString(1, '%'+nome+'%');
                
                }
                if(numero == 0 && !nome.equals("0") && !tipo.equals("0")){
                    pstmt = connection.prepareStatement("select * from espacos where nome like ? and tipo like ?");
                    pstmt.setString(1, '%'+nome+'%');
                    pstmt.setString(2, '%'+tipo+'%');
                      
                }
                if(numero != 0 && nome.equals("0") && tipo.equals("0")){
                    pstmt = connection.prepareStatement("select * from espacos where numero like ? ");
                    pstmt.setInt(1, numero);
                }
                if(numero != 0 && nome.equals("0") && !tipo.equals("0")){
                    pstmt = connection.prepareStatement("select * from espacos where numero like ? and tipo like ?");
                    pstmt.setInt(1, numero);
                    pstmt.setString(2, '%'+tipo+'%');
                }
                if(numero != 0 && !nome.equals("0") && tipo.equals("0")){
                    pstmt = connection.prepareStatement("select * from espacos where numero like ? and nome like ?");
                    pstmt.setInt(1,numero);
                    pstmt.setString(2, '%'+nome+'%');
                }
                if(numero != 0 && !nome.equals("0") && !tipo.equals("0")){
                    pstmt = connection.prepareStatement("select * from espacos where numero like ? and nome like ? and tipo like ? ");
                    pstmt.setInt(1, numero);
                    pstmt.setString(2, '%'+nome+'%');
                    pstmt.setString(3, '%'+tipo+'%');
                }
                
                
                
                rs = pstmt.executeQuery();
                
            }catch(Exception X){
                //throw new Exception("Erro ao executar a query");
                throw new Exception("erro ao executar a query");
            }
            
            try{
                while (rs.next() == true){

                    Espaco espaco = new Espaco();
                        
                        espaco.setNumero(rs.getInt("numero"));
                        espaco.setNome(rs.getString("nome"));
                        espaco.setDescricao(rs.getString("descricao"));
                        espaco.setLotacao(rs.getInt("lotacao"));
                        espaco.setTipo(rs.getString("tipo"));
                        espaco.setProjetor(rs.getBoolean("projetor"));
                        espaco.setInternet(rs.getBoolean("internet"));
                        espaco.setQuadro(rs.getBoolean("quadro"));
                        espaco.setEspecialidade(rs.getString("especialidade"));
                        espaco.setLista_Equipamentos(rs.getString("equipamentos"));
                        espaco.setSituacao(rs.getString("situacao"));
                        
                    espacos.add(espaco);

                }    
            }catch(Exception X){
                throw new Exception("Erro ao adicionar");
            }

        } catch (Exception e) {
            throw new Exception(e.getMessage());
            
        }finally {
            pstmt.close();
            connection.close();
        }
        
        String[] S = new String[3];

       return espacos.toArray(new Espaco[0]);
       
    }
    
    
    public void desativar(int numero) throws Exception{
        
        Connection connection = null;
        PreparedStatement pstmt = null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gabinete", "root", "");
            
        }catch(Exception X){
            throw new Exception("Erro ao conectar no banco.");
        }
        try{
            pstmt = connection.prepareStatement("update espacos situacao set situacao = 'Inativo'  where numero = ?; ");
            pstmt.setInt(1, numero);

            pstmt.executeUpdate();

        }catch(Exception X){
            throw X;
        }finally{
            pstmt.close();
            connection.close();
        }
    }
    
    public void ativar(int numero) throws Exception{
        
        Connection connection = null;
        PreparedStatement pstmt = null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gabinete", "root", "");
            
        }catch(Exception X){
            throw new Exception("Erro ao conectar no banco.");
        }
        try{
            pstmt = connection.prepareStatement("update espacos situacao set situacao = 'Ativo'  where numero = ?; ");
            pstmt.setInt(1, numero);

            pstmt.executeUpdate();

        }catch(Exception X){
            throw X;
        }finally{
            pstmt.close();
            connection.close();
        }
    }
    
    public Espaco consultar(int numero) throws Exception{
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Espaco espaco = new Espaco();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gabinete", "root", "");
            
        }catch(Exception X){
            throw new Exception("Erro ao conectar no banco.");
        }
        try{
            
            pstmt = connection.prepareStatement("select * from espacos where numero = ?;");
            pstmt.setInt(1, numero);

            rs = pstmt.executeQuery();

            rs.next();
            
            espaco.setNumero(rs.getInt("numero"));
            espaco.setNome(rs.getString("nome"));
            espaco.setDescricao(rs.getString("descricao"));
            espaco.setLotacao(rs.getInt("lotacao"));
            espaco.setTipo(rs.getString("tipo"));
            espaco.setProjetor(rs.getBoolean("projetor"));
            espaco.setInternet(rs.getBoolean("internet"));
            espaco.setQuadro(rs.getBoolean("quadro"));
            espaco.setEspecialidade(rs.getString("especialidade"));
            espaco.setLista_Equipamentos(rs.getString("equipamentos"));
            espaco.setSituacao(rs.getString("situacao"));
            
        }catch(Exception X){
            throw X;
        }finally{
            pstmt.close();
            connection.close();
        }
        
        return espaco;
        
    }
    
    public void editar(Espaco espaco) throws Exception{
        
        Connection connection = null;
        PreparedStatement pstmt = null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gabinete", "root", "");
            
        }catch(Exception X){
            throw new Exception("Erro ao conectar no banco.");
        }
        
        try{
            pstmt = connection.prepareStatement("update espacos set numero=? ,nome=? ,descricao=? ,lotacao=? ,tipo=? ,projetor=? ,internet=? ,quadro=? ,especialidade=? ,equipamentos=? ,situacao=?  where numero = ?; ");
            pstmt.setInt(1, espaco.getNumero());
            pstmt.setString(2, espaco.getNome());
            pstmt.setString(3, espaco.getDescricao());
            pstmt.setInt(4, espaco.getLotacao());
            pstmt.setString(5, espaco.getTipo());
            pstmt.setBoolean(6,espaco.isProjetor());
            pstmt.setBoolean(7,espaco.isInternet());
            pstmt.setBoolean(8,espaco.isQuadro());
            pstmt.setString(9,espaco.getEspecialidade());
            pstmt.setString(10,espaco.getLista_Equipamentos());
            pstmt.setString(11,espaco.getSituacao());
            pstmt.setInt(12, espaco.getNumero());

            pstmt.executeUpdate();

        }catch(Exception X){
            throw X;
        }finally{
            pstmt.close();
            connection.close();
        }
        
    }
    
}
