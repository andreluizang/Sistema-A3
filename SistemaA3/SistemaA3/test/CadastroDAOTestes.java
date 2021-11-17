import org.junit.Test;
import static org.junit.Assert.*;
import database.CadastroDAO;
import database.ConexaoDAO;
import org.junit.Assert;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.Object;
import static org.mockito.Mockito.doReturn;
import java.sql.ResultSet;

public class CadastroDAOTestes{
    
    Mockito mock = new Mockito();
    boolean confirma = false;
    private String nome;
    private String email;
    private String senha;
    private PreparedStatement ps;
    ArrayList<Object> dados = new ArrayList<>();
    private CadastroDAO cadastrodao;
    private ConexaoDAO cdao = new ConexaoDAO();
    
    @Mock private Connection connection;

    
    @Mock private ConexaoDAO sqlMockado;
    @Mock private ResultSet rs;
    private Statement statement;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        cadastrodao = new CadastroDAO(sqlMockado);
        nome = "admin";
        email = "admin@email.com";
        senha = "admin123";
        dados.add(nome);dados.add(email);dados.add(senha);
        cadastrodao.cadastrar("admin", "admin@email.com", "admin123"); 

    }
    
    //AINDA NÃO FUNCIONA
    
    /*@Test
    public void testarQuandoEmailJaEstaCadastrado(){        
        try{
            sqlMockado.getConnection(false);
            cdao.getConnection(false);
            when(sqlMockado.getConnection(false)).thenReturn(connection);

            statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
               ResultSet.CONCUR_UPDATABLE);
            
            //System.out.println(statement.toString());
            
            
            rs = cdao.Select("SELECT email FROM ESTUDANTE", dados);
            rs.moveToInsertRow();                                 
            rs.updateString("email", "admin@email.com");   
            rs.insertRow();                                        
            rs.moveToCurrentRow();                                 

            System.out.println(rs.getString(0));
            
        }catch(SQLException ex){
            Logger.getLogger(ConexaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        boolean retorno = cadastrodao.cadastrar("admin", "admin@email.com", "admin123");
        when(sqlMockado.Select("random query", dados)).thenReturn(rs);

        //when(sqlMockado.Select(nome, dados)).thenReturn(rs.);
        //when(cadastrodao.verificarEmailNaoEstaCadastrado("admin@email.com")).thenReturn(false);
        //doReturn(false).when(cadastrodao.verificarEmailNaoEstaCadastrado("admin@email.com"));
        
        assertEquals(false, retorno);
    }*/
        
    @Test
    public void testarQuandoEmailAindaNaoEstaCadastrado() {
        
        //when(cadastroTeste.verificarEmailNaoEstaCadastrado("admin@email.com")).thenReturn(false);
        boolean resultado = cadastrodao.cadastrar("admin", "admin@email.com", "admin123");
        when(sqlMockado.Select("random query", dados)).thenReturn(rs);
        assertEquals(true, resultado);
    }
    
    @Test
    public void testarQuandoAsSenhasEstaoDiferentes(){
        confirma = cadastrodao.confirmarSenhasIguais("Correto", "Incorreto");
        Assert.assertEquals(false, confirma);
    }
    
    @Test
    public void testarQuandoAsSenhasEstaoIguais(){
        confirma = cadastrodao.confirmarSenhasIguais("Correto", "Correto");
        Assert.assertEquals(true, confirma);        
    }
    
    @Test
    public void testarSeAsSenhasDiferenciamLetrasMaiusculasEMinusculas(){
        confirma = cadastrodao.confirmarSenhasIguais("CORRETO", "correto");
        Assert.assertEquals(false, confirma);
    }
}
