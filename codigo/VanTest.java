import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class VanTest {

    @Test
    public void name() {
        Veiculo van = new Van("VAN-01", 131313);
        van.abastecer(1);
        assertEquals("Gasolina", van.combustivelAtual.toString());
    }
    
}
