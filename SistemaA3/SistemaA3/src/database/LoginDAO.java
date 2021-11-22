package database;

import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class LoginDAO {
    
    private ConexaoDAO conexao = new ConexaoDAO();
    
    public LoginDAO(ConexaoDAO conexao){
        this.conexao = conexao;
    }
    
    public boolean fazerLogin(String email, String senha){
        conexao.getConnection();
        boolean retorno = false;
        if(emailExiste(email)){
            if(verificarSenha(email, senha)){
                conexao.closeConnection();
                retorno = true;
            }else{ //senha incorreta
                conexao.closeConnection();
                retorno = false;
            }
        }else{ //não encontrou e-mail
            JOptionPane.showMessageDialog(null, "E-mail não cadastrado!", "ERRO!", 0);
            conexao.closeConnection();
            retorno = false;
        }
        return retorno;
    }
    
    
    public boolean emailExiste(String email){
        boolean retorno = false;
        String query = "SELECT email FROM ESTUDANTE WHERE email = ?";
        ArrayList<Object> dadosSelect = new ArrayList<>();
        dadosSelect.add(email);
        ResultSet rs = conexao.Select(query, dadosSelect);
        try{
            retorno = (rs != null && rs.next());
        }catch(SQLException ex){
            Logger.getLogger(ConexaoDAO.class.getName()).log(Level.SEVERE, null, ex);            
        }
        System.out.println(retorno);
        return retorno;
    }
    
    public boolean verificarSenha(String email, String senha){
        String query = "SELECT senha FROM ESTUDANTE WHERE email = ?";
        ArrayList<Object> dadosSelect = new ArrayList<>();
        dadosSelect.add(email);
        ResultSet rs = conexao.Select(query, dadosSelect);
        boolean retorno = false;
        try {
            if (rs != null && rs.next()) { //procurando senha
                String compararSenha = rs.getString("senha");
                if (compararSenha.equals(senha)) { //senha correta
                    JOptionPane.showMessageDialog(null, "Login efetuado com sucesso!", "Parabéns!", 1);
                    retorno = true;
                }else{ //senha incorreta
                    JOptionPane.showMessageDialog(null, "Senha incorreta!", "ERRO!", 0);
                    retorno = false;
                }                
            }else{
                System.out.println("Passou aqui nesse else!");
            }   
        }catch(SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }
        return retorno;
    }
}