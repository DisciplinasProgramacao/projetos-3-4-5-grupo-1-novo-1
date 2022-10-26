import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class VeiculoTest {

    static Veiculo veiculo;
    static Veiculo caminhao = new Caminhao("CAM-001", 180);
    static Veiculo furgao = new Furgao("FUR-001", 180);
    static Veiculo van = new Van("VAN-001", 180);

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

    @Test
    public void ipvaCarro(){
        assertEquals(7.2, veiculo.calculaIPVA());
    }

    @Test
    public void seguroCarro(){
        assertEquals(309, veiculo.calculaSeguro());
    }

    @Test
    public void ipvaCaminhao(){
        assertEquals(1.8, caminhao.calculaIPVA());
    }

    @Test
    public void seguroCaminhao(){
        assertEquals(2003.6, caminhao.calculaSeguro());
    }

    @Test
    public void ipvaFurgao(){
        assertEquals(5.4, furgao.calculaIPVA());
    }

    @Test
    public void seguroFurgao(){
        assertEquals(5.4, furgao.calculaSeguro());
    }

    @Test
    public void ipvaVan(){
        assertEquals(5.4, van.calculaIPVA());
    }

    @Test
    public void seguroVan(){
        assertEquals(5.4, van.calculaSeguro());
    }
}