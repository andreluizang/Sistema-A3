import org.junit.Test;
import static org.junit.Assert.*;
import models.Conteudo;
import org.mockito.Mockito;

public class ConteudoTestes {
    
    private Conteudo conteudo;
    
    public ConteudoTestes() {
    }

    @Test
    public void testarCalculoDeMetasQuandoAprendizadoForIgualAZero() {
        conteudo = new Conteudo(Mockito.anyInt(), Mockito.anyString(), 0, Mockito.anyString(), Mockito.anyObject());
        int meta = conteudo.getMeta();
        assertEquals(meta, 5);
    }
    @Test
    public void testarCalculoDeMetasQuandoAprendizadoEstiverEntre1e3() {
        conteudo = new Conteudo(Mockito.anyInt(), Mockito.anyString(), 2, Mockito.anyString(), Mockito.anyObject());
        int meta = conteudo.getMeta();
        assertEquals(meta, 4);
    }
    
    @Test
    public void testarCalculoDeMetasQuandoAprendizadoEstiverEntre4e6() {
        conteudo = new Conteudo(Mockito.anyInt(), Mockito.anyString(), 5, Mockito.anyString(), Mockito.anyObject());
        int meta = conteudo.getMeta();
        assertEquals(meta, 3);
    }
    
    @Test
    public void testarCalculoDeMetasQuandoAprendizadoEstiverEntre7e9() {
        conteudo = new Conteudo(Mockito.anyInt(), Mockito.anyString(), 8, Mockito.anyString(), Mockito.anyObject());
        int meta = conteudo.getMeta();
        assertEquals(meta, 2);
    }
    
    @Test
    public void testarCalculoDeMetasQuandoAprendizadoForIgualA10() {
        conteudo = new Conteudo(Mockito.anyInt(), Mockito.anyString(), 10, Mockito.anyString(), Mockito.anyObject());
        int meta = conteudo.getMeta();
        assertEquals(meta, 1);
    }

}
