import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class VeiculoTest {

    static Veiculo veiculo;

    @BeforeAll
    public static void Testinit() {
        veiculo = new Carro("CAR-001", 180);
    }
    
    @Test
    public void TesteConstrutorVeiculo() {
        assertEquals(50, veiculo.getTanque());
    }

    @Test
    public void name() {
        veiculo.imprimeDadosVeiculoConsole();
    }
}