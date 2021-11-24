package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.dnd.DropTarget;
import java.sql.Statement;

public class ConexaoDAO {
    
    private static Connection conexao = null;
    private Statement stm;
    
    public ConexaoDAO(){
        
    }

    public java.sql.Connection getConnection(){
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/SistemaA3DataBase?useTimezone=true&serverTimezone=America/Sao_Paulo", "root", "1234");
            System.out.println("Conectado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Falha ao conectar!");
        }
        return conexao;
    }
    
    public boolean closeConnection(){
        try {
            getConnection().close();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    //Método de Insert, aceita de parâmetros uma String, que vai ser a query para formatar e um array de Object
    //que aceita qualquer tipo de variável ou objeto. Dessa forma, o método pode ser chamado em qualquer outra classe
    public boolean Insert(String query, ArrayList<Object> parametros){
        PreparedStatement ps;
        boolean retorno = false;
        try {
            ps = conexao.prepareStatement(query,  ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            for(int i = 0; i < parametros.size(); i++){
                ps.setString(i+1, (parametros.get(i)).toString());
            }
            System.out.println(ps.toString());
            ps.execute();
            retorno = true;
        }catch (SQLException ex){
            Logger.getLogger(ConexaoDAO.class.getName()).log(Level.SEVERE, null, ex);    
            retorno = false;
        }
        return retorno;
    }
    
    //Método de Select, aceita de parâmetros uma String, que vai ser a query para formatar e um array de Object
    //que aceita qualquer tipo de variável ou objeto. Dessa forma, o método pode ser chamado em qualquer outra classe

    public ResultSet Select(String query, ArrayList<Object> parametros){
        try{
            ResultSet rs;
            PreparedStatement ps = conexao.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            for(int i = 0; i < parametros.size(); i++){
                ps.setString(i+1, (parametros.get(i)).toString());
            }
            System.out.println(ps.toString());
            rs = ps.executeQuery();
            return rs;
        }catch(SQLException ex){
            Logger.getLogger(ConexaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public void Update(String query, ArrayList<Object> parametros){
        try{
            PreparedStatement ps = conexao.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            for(int i = 0; i < parametros.size(); i++){
                ps.setString(i+1, (parametros.get(i)).toString());
            }
            System.out.println(ps.toString());
            ps.execute();
        }catch(SQLException ex){
            Logger.getLogger(ConexaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Delete(String query, ArrayList<Object> parametros){
        try{
            PreparedStatement ps = conexao.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            for(int i = 0; i < parametros.size(); i++){
                ps.setString(i+1, (parametros.get(i)).toString());
            }
            System.out.println(ps.toString());
            ps.execute();
        }catch(SQLException ex){
            Logger.getLogger(ConexaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
}
