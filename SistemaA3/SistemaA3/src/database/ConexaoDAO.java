package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoDAO {
    
    private Connection conexao = null;
    
    //Método construtor que faz a conexão com o banco de dados
    public ConexaoDAO(){
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/SistemaA3DataBase?useTimezone=true&serverTimezone=America/Sao_Paulo", "root", "1234");
            System.out.println("Conectado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Falha ao conectar!");
        }
    }
    
    //Método de Insert, aceita de parâmetros uma String, que vai ser a query para formatar e um array de Object
    //que aceita qualquer tipo de variável ou objeto. Dessa forma, o método pode ser chamado em qualquer outra classe
    public void Insert(String query, ArrayList<Object> parametros){
        PreparedStatement ps;
        try {
            ps = conexao.prepareStatement(query);
            for(int i = 0; i < parametros.size(); i++){
                ps.setString(i+1, (parametros.get(i)).toString());
            }
            ps.execute();

        }catch (SQLException ex){
            Logger.getLogger(ConexaoDAO.class.getName()).log(Level.SEVERE, null, ex);            
        }
    }
    
    //Método de Select, aceita de parâmetros uma String, que vai ser a query para formatar e um array de Object
    //que aceita qualquer tipo de variável ou objeto. Dessa forma, o método pode ser chamado em qualquer outra classe

    public ResultSet Select(String query, ArrayList<Object> parametros){
        try{
            ResultSet rs;
            PreparedStatement ps = conexao.prepareStatement(query);
            for(int i = 0; i < parametros.size(); i++){
                ps.setString(i+1, (parametros.get(i)).toString());
            }
            rs = ps.executeQuery();
            return rs;
        }catch(SQLException ex){
            Logger.getLogger(ConexaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    
        
}
