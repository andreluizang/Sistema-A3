package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Estudante;

public class EstudanteDAO {
    
    private ConexaoDAO conexao = new ConexaoDAO();
    public Estudante estudante = new Estudante();
    
    public Estudante criarObjetoEstudante(String email){
        ConexaoDAO.getConnection();
        Estudante estudante = new Estudante();
        String query = "SELECT nome, email, senha FROM ESTUDANTE WHERE email = ?";
        ArrayList<Object> dadosSelect = new ArrayList<>();
        dadosSelect.add(email);
        ResultSet rs = conexao.Select(query, dadosSelect);
        try{
            if(rs!=null & rs.next()){
                estudante.setNome(rs.getString("nome"));
                estudante.setEmail(rs.getString("email"));
                estudante.setSenha(rs.getString("senha"));
                ConexaoDAO.closeConnection();
            }
        }catch(SQLException ex){
            Logger.getLogger(ConexaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            ConexaoDAO.closeConnection();            
        }
        return estudante;
    }
    
}
