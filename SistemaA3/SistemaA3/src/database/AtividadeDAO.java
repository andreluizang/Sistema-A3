package database;

import static database.DisciplinaDAO.disciplina;
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
    private static boolean objetosCriados = false;
    
    public static ArrayList<Atividade> atividades = new ArrayList<>();
    
    public Object[][] formatarTabela(){
        conexao.getConnection();
        ResultSet rs;
        ArrayList<Object> dados = new ArrayList<>();
        dados.add(EstudanteDAO.estudante.getId());
        rs = conexao.Select("SELECT ATIVIDADE.nome, DISCIPLINA.nome, ATIVIDADE.descricao, ATIVIDADE.prazo, ATIVIDADE.concluida,"
                + " ATIVIDADE.id,  DISCIPLINA.id, ATIVIDADE.nota, ATIVIDADE.notaMaxima, ATIVIDADE.dataConclusao"
                + " FROM ATIVIDADE INNER JOIN DISCIPLINA ON ATIVIDADE.fk_disciplina = DISCIPLINA.id"
                + " WHERE ATIVIDADE.fk_estudante = ? ORDER BY ATIVIDADE.id ASC", dados);
        String[] colunas = {"Nome", "Disciplina", "Descrição", "Prazo", "Concluída"};
        Object[][] tabela ={};

        try{
            rs.last();
            tabela = new Object[rs.getRow()][rs.getMetaData().getColumnCount()];
            int i = 0;
            rs.beforeFirst();
            for(int contador = 0; rs!=null && rs.next(); contador++){
                if(!objetosCriados){
                    criarObjetoAtividade(rs.getInt(6), rs.getString(1), rs.getString(3), rs.getInt(7), rs.getString(2),
                                    rs.getDouble(8), rs.getDouble(9), rs.getDate(4).toLocalDate(), rs.getBoolean(5),
                                    rs.getDate(10).toLocalDate());
                }
                for (int j = 0; j < rs.getMetaData().getColumnCount(); j++) {
                    tabela[i][j] = rs.getObject(j+1);
                }
                i++;
            }
            objetosCriados = true;

            conexao.closeConnection();
        }catch(SQLException ex){
            Logger.getLogger(ConexaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            conexao.closeConnection();
        }
        System.out.println("Tamanho do array:" + atividades.size());
        return tabela;
    }
    
    public void cadastrarAtividade(String nome, String descricao, int idDisciplina, double nota, double notaMaxima,
            LocalDate prazo, boolean concluida, LocalDate dataConclusao, int idEstudante){
        int c = concluida ? 1 : 0;
        conexao.getConnection();
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
            if(rs!= null && rs.next()){
                criarObjetoAtividade(rs.getInt(1), nome, descricao, idDisciplina, rs.getString(2), nota, notaMaxima,
                        prazo, concluida, dataConclusao);
            }
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
    
    public void atualizarAtividade(int id, String nome, String descricao, double nota, double notaMaxima,
            boolean concluida, LocalDate prazo, LocalDate dataConclusao, int localId){
        conexao.getConnection();
        String query = "UPDATE ATIVIDADE SET nome = ?, descricao = ?, prazo = ?, concluida = ?, dataConclusao = ?, nota = ?,"
                + " notaMaxima = ?"
                + " WHERE id = ?";
        ArrayList<Object> dados = new ArrayList<>();
        int c = concluida ? 1 : 0;
        dados.add(nome); dados.add(descricao); dados.add(prazo); dados.add(c);
        dados.add(dataConclusao); dados.add(nota); dados.add(notaMaxima);
        dados.add(id);
        conexao.Update(query, dados);
        JOptionPane.showMessageDialog(null, "Atualizado com sucesso!", "Parabéns!", 1);
        conexao.closeConnection();
        atividades.get(localId).setNome(nome);
        atividades.get(localId).setDescricao(descricao);
        atividades.get(localId).setConcluida(concluida);
        atividades.get(localId).setDataconclusao(dataConclusao);
        atividades.get(localId).setPrazo(prazo);
        atividades.get(localId).setNota(nota);
        atividades.get(localId).setNotaMax(notaMaxima);     
    }
    
    public void deletarAtividade(int id, int localId){
        conexao.getConnection();
        String query = "DELETE FROM ATIVIDADE WHERE id = ?";
        ArrayList<Object> dados = new ArrayList<>();
        dados.add(id);
        conexao.Delete(query, dados);
        JOptionPane.showMessageDialog(null, "Deletado com sucesso!", "Parabéns!", 1);
        conexao.closeConnection();
        atividades.remove(localId);        
    }

}
