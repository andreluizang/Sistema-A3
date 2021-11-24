package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
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
        //carregarMetas();
        return tabela;
    }
    
    public void criarObjetoConteudo(int id, String nome, int aprendizado, String anotacao,
            int idDisciplina, String disciplina) {
        conteudos.add(new Conteudo(id, nome, aprendizado, anotacao, new Disciplina(idDisciplina, disciplina)));
        //criarMetas(conteudos.size() - 1);
    }
    
    public void carregarMetas(){
        conexao.getConnection();
        String query = "SELECT revisoes FROM METAS WHERE fk_conteudo = ? AND fk_estudante = ?";
        ArrayList<Object> dados = new ArrayList<>();
        for(int i = 0; i < conteudos.size(); i ++){
            dados.add(conteudos.get(i).getId()); dados.add(EstudanteDAO.estudante.getId());
            ResultSet rs = conexao.Select(query, dados);
            try{
                if(rs!=null && rs.next())
                    conteudos.get(i).setMeta(rs.getInt(1));
            }catch(SQLException ex){
                Logger.getLogger(ConexaoDAO.class.getName()).log(Level.SEVERE, null, ex);            
            }
            dados.clear();
        }
    }
    
    public void criarMetas(int index){
        conexao.getConnection();
        String query = "INSERT INTO METAS (revisoes, concluida, dataConclusao, fk_conteudo, fk_estudante)"
                + " VALUES (?, ?, ?, ?, ?)";
        ArrayList<Object> dados = new ArrayList<>();
        dados.add(conteudos.get(index).getMeta());
        dados.add(0);
        dados.add(LocalDate.of(1970, 1, 1));
        dados.add(conteudos.get(index).getId());
        dados.add(EstudanteDAO.estudante.getId());
        
        conexao.Insert(query, dados);
        conexao.closeConnection();
       
    }
    
    public void atualizarMetas(int revisoes, int index){
        conexao.getConnection();
        String query = "UPDATE METAS SET revisoes = ?, concluida = ?, dataConclusao = ?"
                + " WHERE fk_estudante = ? AND fk_conteudo = ?";
        ArrayList<Object> dados = new ArrayList<>();
        dados.add(revisoes);
        if(revisoes == 0){
            dados.add(1);
            dados.add(LocalDate.now());
        }else{
            dados.add(0);
            dados.add(LocalDate.of(1970, 1, 1));
        }
        dados.add(EstudanteDAO.estudante.getId());
        dados.add(conteudos.get(index).getId());
        
        conexao.Insert(query, dados);
        conteudos.get(index).setMeta(revisoes);
        conexao.closeConnection();
    }
    
}
