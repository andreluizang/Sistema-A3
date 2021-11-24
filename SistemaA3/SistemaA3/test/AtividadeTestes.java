import org.junit.Test;
import static org.junit.Assert.*;
import database.AtividadeDAO;
import java.time.LocalDate;

public class AtividadeTestes {
    
    AtividadeDAO atividadedao = new AtividadeDAO();
    
    public AtividadeTestes() {
    }

    @Test
    public void testarCadastrarAtividadeComPrazoInvalido() {
        boolean retorno = atividadedao.verificarPrazo(LocalDate.of(2020, 12, 6));
        assertEquals(false, retorno);
    }  
    
    @Test
    public void testarCadastrarAtividadeComPrazoValido() {
        boolean retorno = atividadedao.verificarPrazo(LocalDate.of(2022, 12, 6));
        assertEquals(true, retorno);
    }
    
    @Test
    public void testarCadastrarAtividadeComPrazoNoMesmoDia(){
        boolean retorno = atividadedao.verificarPrazo(LocalDate.now());
        assertEquals(true, retorno);
    }
}
