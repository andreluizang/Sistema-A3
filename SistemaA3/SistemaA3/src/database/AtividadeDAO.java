package database;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Atividade;
import models.Disciplina;

public class AtividadeDAO {

    private ConexaoDAO conexao = new ConexaoDAO();

    public ArrayList<Atividade> atividades = new ArrayList<>();
    
    public Object[][] formatarTabela(){
        conexao.getConnection(false);
        ResultSet rs;
        ResultSet rsd;
        ArrayList<Object> dados = new ArrayList<>();
        dados.add(EstudanteDAO.estudante.getId());
        rs = conexao.Select("SELECT nome, fk_disciplina, descricao, prazo, concluida FROM ATIVIDADE WHERE fk_estudante = ?", dados);
        String[] colunas = {"Nome", "Disciplina", "Descrição", "Prazo", "Concluída"};
        Object[][] tabela ={
            };

        try{
            tabela = new Object[2][rs.getMetaData().getColumnCount()];
            int i = 0;
            while(rs.next()){
                for (int j = 0; j < rs.getMetaData().getColumnCount(); j++) {
                    //new code
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
}
