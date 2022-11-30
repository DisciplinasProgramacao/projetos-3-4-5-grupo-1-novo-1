
public class Carro extends Veiculo {
    private final int TANQUE_COMPLETO = 50;

    /**
     * Método construtor da classe Carro.
     * @param placa String constendo a placa do veículo
     * @param valorVenda double contendo o valor de venda do veículo
     */
    public Carro(String placa, double valorVenda) {
        super(placa, valorVenda);
        this.tiposCombustivel.add(Combustivel.GASOLINA);
        this.tiposCombustivel.add(Combustivel.ALCOOL);
        this.autonomiaMaxima = getAutonomiaMaxima();
        this.autonomiaAtual = autonomiaMaxima;
    }

    @Override
    public void calculaCustoFixo() {
        double ipva = this.valorVenda * Tarifas.IPVA_CARRO.getValor();
        double seguro = (this.valorVenda * Tarifas.SEGURO_CARRO.getValor()) + Tarifas.TAXA_CARRO.getValor();
        this.custoFixo = ipva + seguro;
    }

    @Override
    public void calculaCustoVariavel() {
        double alinhamento = ((int)(this.kilometragemTotal/Tarifas.DIST_ALINHAMENTO_CARRO.getValor())* Tarifas.PRECO_ALINHAMENTO_CARRO.getValor());
        this.custoVariavel = alinhamento + this.custosExtra;
    }

    @Override
    public boolean abastecer(int tipoCombustivel) {
        if (tipoCombustivel == 1) {
            autonomiaAtual = TANQUE_COMPLETO * tiposCombustivel.get(1).consumo;
            return true;
        }
        if (tipoCombustivel == 2) {
            autonomiaAtual = TANQUE_COMPLETO * tiposCombustivel.get(2).consumo;
            return true;
        } else {
            return false;
        }
    }
}
