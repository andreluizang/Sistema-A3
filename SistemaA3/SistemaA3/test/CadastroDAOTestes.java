import org.junit.Test;
import static org.junit.Assert.*;
import database.CadastroDAO;
import database.ConexaoDAO;
import org.junit.Assert;
import org.junit.Before;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
import org.mockito.Spy;

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
    

    @Spy private ConexaoDAO connSpy;
    @Mock private ConexaoDAO sqlMockado;
    //@Mock private ResultSet rs;
    private Statement statement;
    private ResultSet rs;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        cadastrodao = new CadastroDAO(sqlMockado);
        nome = "admin";
        email = "admin@email.com";
        senha = "admin123";
    }

    @Test
    public void testarQuandoEmailJaEstaCadastrado(){
        connSpy.getConnection();
        sqlMockado.getConnection();
        cadastrodao = new CadastroDAO(sqlMockado);
        dados.add("admin@email.com");
        System.out.println(dados.get(0));
        rs = connSpy.Select("SELECT email FROM ESTUDANTE WHERE email = ?", dados);
        boolean retorno = cadastrodao.cadastrar("anyNome", "admin@email.com", "anySenha");
        when(connSpy.Select("anyString", dados)).thenReturn(rs);
        assertEquals(false, retorno);
    }
    
    //AINDA NÃO FUNCIONA
    /*@Test
    public void testarQuandoEmailAindaNaoEstaCadastrado(){
        connSpy.getConnection();
        sqlMockado.getConnection();
        cadastrodao = new CadastroDAO(sqlMockado);
        dados.add("outroEmail");
        System.out.println(dados.get(0));
        rs = connSpy.Select("SELECT email FROM ESTUDANTE WHERE email = ?", dados);
        ArrayList<Object> dadosInsert = new ArrayList<>();
        dadosInsert.add("anyNome"); dadosInsert.add("anyEmail"); dadosInsert.add("anySenha");
        cadastrodao.cadastrar("anyNome", "anyEmail", "anySenha");
        when(connSpy.Select("anyString", dados)).thenReturn(rs);
        boolean Insert = verify(sqlMockado).Insert("INSERT INTO ESTUDANTE (nome, email, senha) VALUES (?, ?, ?)", dadosInsert);
        assertEquals(true, Insert);
    }*/
    
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
