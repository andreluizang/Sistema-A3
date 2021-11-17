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

    public java.sql.Connection getConnection(boolean dropTables){
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/SistemaA3DataBase?useTimezone=true&serverTimezone=America/Sao_Paulo", "root", "1234");
            initdb(dropTables);
            System.out.println("Conectado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Falha ao conectar!");
        }
        return conexao;
    }
    
    public boolean closeConnection(){
        try {
            getConnection(false).close();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public void initdb(boolean dropTable){
    //    try {
            //if(dropTable)
                //this.stm.executeUpdate("DROP TABLE IF EXISTS ESUTDANTE");
            
            
            //this.stm.execute("CREATE TABLE IF NOT EXISTS ESTUDANTE("
              //      + "id int primary key not null, nome varchar(30), "
                //    + "email varchar(30), senha varchar(30)"
                  //  + ")");
        //} catch (SQLException ex) {
         //   Logger.getLogger(ConexaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        //}        
    }
    
    //Método de Insert, aceita de parâmetros uma String, que vai ser a query para formatar e um array de Object
    //que aceita qualquer tipo de variável ou objeto. Dessa forma, o método pode ser chamado em qualquer outra classe
    protected void Insert(String query, ArrayList<Object> parametros){
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
            System.out.println(ps.toString());
            rs = ps.executeQuery();
            return rs;
        }catch(SQLException ex){
            Logger.getLogger(ConexaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
        
}
