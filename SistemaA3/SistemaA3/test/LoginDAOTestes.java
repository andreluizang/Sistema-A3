import database.ConexaoDAO;
import database.LoginDAO;
import org.junit.Test;
import static org.junit.Assert.*;


public class LoginDAOTestes {
    
    ConexaoDAO conexao = new ConexaoDAO();
    LoginDAO logindao = new LoginDAO(conexao);
    
    public LoginDAOTestes() {
    }
    
    @Test
    public void testarCasoEmailEstejaIncorreto(){
        conexao.getConnection();
        boolean retorno = logindao.fazerLogin("anyEmail", "anySenha");
        assertEquals(false, retorno);
    }
    
    @Test
    public void testarCasoEmailEstejaCorretoESenhaIncorreta(){
        conexao.getConnection();
        boolean retorno = logindao.fazerLogin("admin@email.com", "anySenha");
        assertEquals(false, retorno);
    }
    
    @Test
    public void testarCasoEmailESenhaEstejamCorretos(){
        conexao.getConnection();
        boolean retorno = logindao.fazerLogin("admin@email.com", "admin123");
        assertEquals(true, retorno);
    }
}
