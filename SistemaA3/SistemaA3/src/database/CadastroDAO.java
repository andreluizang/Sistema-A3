package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CadastroDAO {
    
    private ConexaoDAO conexao;
    
    public CadastroDAO(ConexaoDAO conexao){
        this.conexao = conexao;
    }
    
    public String cadastrar(String nome, String email, String senha){
        ConexaoDAO.getConnection();
        ResultSet rs;
        String mensagem = new String();
        //Query e array que vão ser passadas como parâmetro pro Select da classe ConexaoDAO
        String querySelect = "SELECT email FROM ESTUDANTE WHERE email = ?";
        ArrayList<Object> dadosSelect = new ArrayList<>();
        dadosSelect.add(email);
        rs = conexao.Select(querySelect, dadosSelect);
        try{
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Esse e-mail já está cadastrado!", "ERRO!", 0);
                mensagem = "Esse e-mail já está cadastrado!";
            }else{
                //Query e array de objetos que vão ser passados pro método Insert da classe ConexaoDAO
                String queryInsert = "INSERT INTO ESTUDANTE (nome, email, senha) VALUES (?, ?, ?)";
                ArrayList<Object> dadosInsert = new ArrayList<>();
                dadosInsert.add(nome); dadosInsert.add(email); dadosInsert.add(senha);
                conexao.Insert(queryInsert, dadosInsert);
                JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!", "Parabéns!", 1);
                mensagem = "Usuário cadastrado com sucesso!";
            }
        }catch(SQLException ex){
            Logger.getLogger(ConexaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConexaoDAO.closeConnection();
        return mensagem;

    }
    
    public boolean confirmarSenhasIguais(String senha, String senhaConfirma){
        return senha.equals(senhaConfirma);
    }

}