import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CaminhaoTest {

    //Para executar o teste é necessário alterar o tanque do caminhão para 25000
    @Test
    public void TesteCalcularManutencao() {
        Caminhao caminhao = new Caminhao("CAM-13", 131313);
        Data dt = new Data(22, 10, 2022);
        Rota rota = new Rota(22000, dt, caminhao);
        caminhao.abastecer(3);
        caminhao.addRota(rota);
        caminhao.kmRodados();
        assertEquals(1000, caminhao.calculaManutecao());
    }    

    //Para executar o teste é necessário alterar o tanque do caminhão para 25000
    @Test
    public void TesteCalcularVistoria() {
        Caminhao caminhao = new Caminhao("CAM-13", 131313);
        Data dt = new Data(22, 10, 2022);
        Rota rota = new Rota(36000, dt, caminhao);
        caminhao.abastecer(3);
        caminhao.addRota(rota);
        caminhao.kmRodados();
        assertEquals(1000, caminhao.calculaVistoria());
    }   
}
