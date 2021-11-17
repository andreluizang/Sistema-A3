package database;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.Disciplina;
import models.Estudante;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DisciplinaDAO {
    
    public static int countDisciplinas = 0;
    public static ArrayList<Disciplina> disciplina = new ArrayList<>();
    
    ConexaoDAO conexao = new ConexaoDAO();
    
    public void criarObjetoDisciplina(int id, String nome){
        //Disciplina d = new Disciplina(id, nome);
        disciplina.add(new Disciplina(id, nome));
        countDisciplinas++;
    }
    
    
    public void cadastrarDisciplina(String nome){
        conexao.getConnection(false);
        String queryInsert = "INSERT INTO DISCIPLINA (nome, fk_estudante) VALUES (?, ?)";
        ArrayList<Object> dadosInsert = new ArrayList<>();
        dadosInsert.add(nome); dadosInsert.add(EstudanteDAO.estudante.getId());
        conexao.Insert(queryInsert, dadosInsert);
        JOptionPane.showMessageDialog(null, "Disciplina cadastrada com sucesso!", "Parabéns!", 1);
        
        String querySelect = "SELECT id FROM DISCIPLINA WHERE nome = ? AND fk_estudante = ?";
        ArrayList<Object> dadosSelect = new ArrayList<>();
        dadosSelect.add(nome); dadosSelect.add(EstudanteDAO.estudante.getId());
        ResultSet rs = conexao.Select(querySelect, dadosSelect);
        try{
            if(rs!= null && rs.next())
                criarObjetoDisciplina(rs.getInt(1), nome);
        }catch(SQLException ex){
            Logger.getLogger(ConexaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        conexao.closeConnection();
    }
    
    public void carregarDisciplinas(int id){
        conexao.getConnection(false);
        String querySelect = "SELECT id, nome FROM DISCIPLINA WHERE fk_estudante = ?";
        ArrayList<Object> dadosSelect = new ArrayList<>();
        dadosSelect.add(id);
        ResultSet rs = conexao.Select(querySelect, dadosSelect);
        try{
            while(rs!=null && rs.next()){
                criarObjetoDisciplina(rs.getInt(1), rs.getString(2));                
            }
            
        }catch(SQLException ex){
            Logger.getLogger(ConexaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        conexao.closeConnection();

    }
    
    public String[] formatarComboBox(){
        conexao.getConnection(false);
        
        String querySelect = "SELECT id, nome FROM DISCIPLINA WHERE fk_estudante = ? AND id > ?";
        ArrayList<Object> dadosSelect = new ArrayList<>();
        dadosSelect.add(EstudanteDAO.estudante.getId());
        int lastId = 0;
        if(!disciplina.isEmpty())
            lastId = disciplina.get(disciplina.size() - 1).getId();
        
        dadosSelect.add(lastId);
        ResultSet rs = conexao.Select(querySelect, dadosSelect);
        
        try{
            while(rs != null && rs.next()){
                criarObjetoDisciplina(rs.getInt(1), rs.getString(2));
            }
        }catch(SQLException ex){
            Logger.getLogger(ConexaoDAO.class.getName()).log(Level.SEVERE, null, ex);            
        }
        
        String[] disciplinas = new String[disciplina.size()];
        
        for(int i = 0; i < disciplina.size();i++){
            disciplinas[i] = disciplina.get(i).getNome();
        }
        
        
        conexao.closeConnection();
        
        return disciplinas;

    }
}
