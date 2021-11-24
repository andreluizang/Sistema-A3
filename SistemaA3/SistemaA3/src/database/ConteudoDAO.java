package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Atividade;
import models.Conteudo;
import models.Disciplina;

public class ConteudoDAO {
    ConexaoDAO conexao = new ConexaoDAO();
    private static boolean objetosCriados = false;
    public static ArrayList<Conteudo> conteudos = new ArrayList<>();
    
    public Object[][] formatarTabela(){
        conexao.getConnection();
        ResultSet rs;
        ArrayList<Object> dados = new ArrayList<>();
        dados.add(EstudanteDAO.estudante.getId());
        rs = conexao.Select("SELECT CONTEUDO.nome, DISCIPLINA.nome, ANOTACOES.anotacao, CONTEUDO.aprendizado,"
                + " CONTEUDO.id, DISCIPLINA.id"
                + " FROM ANOTACOES INNER JOIN CONTEUDO ON ANOTACOES.fk_conteudo = CONTEUDO.id" 
                + " INNER JOIN DISCIPLINA ON CONTEUDO.fk_disciplina = DISCIPLINA.id"
                + " WHERE ANOTACOES.fk_estudante = ? ORDER BY ANOTACOES.id ASC", dados);
        String[] colunas = {"Conteúdo", "Disciplina", "Anotações", "Aprendizado"};
        Object[][] tabela ={};

        try{
            rs.last();
            tabela = new Object[rs.getRow()][rs.getMetaData().getColumnCount()];
            int i = 0;
            rs.beforeFirst();
            for(int contador = 0; rs!=null && rs.next(); contador++){
                if(!objetosCriados){
                    criarObjetoConteudo(rs.getInt(5), rs.getString(1), rs.getInt(4), rs.getString(3),
                            rs.getInt(6), rs.getString(2));
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
        return tabela;
    }
    
        public void criarObjetoConteudo(int id, String nome, int aprendizado, String anotacao,
                int idDisciplina, String disciplina) {
            conteudos.add(new Conteudo(id, nome, aprendizado, anotacao, new Disciplina(idDisciplina, disciplina)));        
    }

}
