import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class VeiculoTest {

    static Veiculo veiculo;

    @BeforeAll
    public static void Testinit() {
        veiculo = new Carro("CAR-001", 180);
    }
    
   
    @Test
    public void name() {
        veiculo.imprimeDadosVeiculoConsole();
    }
}