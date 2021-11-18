package database;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.Atividade;
import models.Disciplina;
import java.sql.Date;

public class AtividadeDAO {

    private ConexaoDAO conexao = new ConexaoDAO();
    
    public ArrayList<Atividade> atividades = new ArrayList<>();
    
    public Object[][] formatarTabela(){
        conexao.getConnection(false);
        ResultSet rs;
        ArrayList<Object> dados = new ArrayList<>();
        dados.add(EstudanteDAO.estudante.getId());
        rs = conexao.Select("SELECT ATIVIDADE.nome, DISCIPLINA.nome, ATIVIDADE.descricao, ATIVIDADE.prazo, ATIVIDADE.concluida"
                + " FROM ATIVIDADE INNER JOIN DISCIPLINA ON ATIVIDADE.fk_disciplina = DISCIPLINA.id"
                + " WHERE ATIVIDADE.fk_estudante = ?", dados);
        String[] colunas = {"Nome", "Disciplina", "Descrição", "Prazo", "Concluída"};
        Object[][] tabela ={};

        try{
            rs.last();
            tabela = new Object[rs.getRow()][rs.getMetaData().getColumnCount()];
            int i = 0;
            rs.beforeFirst();
            while(rs.next()){
                for (int j = 0; j < rs.getMetaData().getColumnCount(); j++) {
                    tabela[i][j] = rs.getObject(j+1);
                }
                i++;
            }

            conexao.closeConnection();
        }catch(SQLException ex){
            Logger.getLogger(ConexaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            conexao.closeConnection();
        }
        return tabela;
    }
    
    public void cadastrarAtividade(String nome, String descricao, int idDisciplina, double nota, double notaMaxima,
            LocalDate prazo, boolean concluida, LocalDate dataConclusao, int idEstudante){
        int c = concluida ? 1 : 0;
        conexao.getConnection(false);
        String queryInsert = "INSERT INTO ATIVIDADE (nome, descricao, fk_disciplina, nota, notaMaxima,"
                + " prazo, concluida, dataConclusao, fk_estudante) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        ArrayList<Object> dadosInsert = new ArrayList<>();
        dadosInsert.add(nome); dadosInsert.add(descricao); dadosInsert.add(idDisciplina);
        dadosInsert.add(nota); dadosInsert.add(notaMaxima); dadosInsert.add(Date.valueOf(prazo));
        dadosInsert.add(c); dadosInsert.add(Date.valueOf(dataConclusao)); dadosInsert.add(idEstudante);
        conexao.Insert(queryInsert, dadosInsert);
        
        JOptionPane.showMessageDialog(null, "Atividade cadastrada com sucesso!", "Parabéns!", 1);
        
        String querySelect = "SELECT ATIVIDADE.id, DISCIPLINA.nome FROM ATIVIDADE INNER JOIN DISCIPLINA"
                + " ON ATIVIDADE.fk_disciplina = DISCIPLINA.id WHERE DISCIPLINA.fk_estudante = ?";
        ArrayList<Object> dadosSelect = new ArrayList<>();
        dadosSelect.add(idEstudante);
        ResultSet rs = conexao.Select(querySelect, dadosSelect);
        
        try{
            DisciplinaDAO.disciplina.get(0);
            if(rs!= null && rs.next())
                criarObjetoAtividade(rs.getInt(1), nome, descricao, idDisciplina, rs.getString(2), nota, notaMaxima,
                        prazo, concluida, dataConclusao);
        }catch(SQLException ex){
            Logger.getLogger(ConexaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        conexao.closeConnection();
    }
    
    public void criarObjetoAtividade(int id, String nome, String descricao, int idDisciplina, String disciplina,
            double nota, double notaMaxima, LocalDate prazo, boolean concluida, LocalDate dataConclusao){
        atividades.add(new Atividade(id, nome, descricao, new Disciplina(idDisciplina, disciplina), prazo, dataConclusao,
                concluida, nota, notaMaxima));
        
    }
}
