package database;

import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.Estudante;

public class LoginDAO {
    
    private ConexaoDAO conexao = new ConexaoDAO();
    
    public boolean fazerLogin(String email, String senha){
        ConexaoDAO.getConnection();
        boolean retorno = false;
        String query = "SELECT email FROM ESTUDANTE WHERE email = ?";
        ArrayList<Object> dadosSelect = new ArrayList<>();
        dadosSelect.add(email);
        ResultSet rs = conexao.Select(query, dadosSelect);
        try{
            if(rs!=null && rs.next()){ //encontrou e-mail
                query = "SELECT senha FROM ESTUDANTE WHERE email = ?";
                rs = conexao.Select(query, dadosSelect);
                if(rs!=null && rs.next()){ //procurando senha
                    String compararSenha = rs.getString("senha");
                    System.out.println("Chegou aqui!");
                    if(compararSenha.equals(senha)){ //senha correta
                        JOptionPane.showMessageDialog(null, "Login efetuado com sucesso!", "ERRO!", 1);
                        ConexaoDAO.closeConnection();
                        retorno = true;
                    }else{ //senha incorreta
                        JOptionPane.showMessageDialog(null, "Senha incorreta!", "ERRO!", 0);
                        ConexaoDAO.closeConnection();
                        retorno = false;
                    }
                }
            }else{ //não encontrou e-mail
                JOptionPane.showMessageDialog(null, "E-mail não cadastrado!", "ERRO!", 0);
                ConexaoDAO.closeConnection();
                retorno = false;
            }
        }catch(SQLException ex){
            Logger.getLogger(ConexaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            ConexaoDAO.closeConnection();
            retorno = false;
        }
        return retorno;
    }
    
}
