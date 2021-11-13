package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoDAO {
    
    private Connection conexao = null;
    
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
}
