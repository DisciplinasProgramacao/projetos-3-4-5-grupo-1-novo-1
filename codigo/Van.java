
public class Van extends Veiculo{
    private final int TANQUE_COMPLETO = 60;

    /**
     * Método construtor da classe Van.
     * @param placa String constendo a placa do veículo
     * @param valorVenda double contendo o valor de venda do veículo
     */
    public Van(String placa, double valorVenda) {
        super(placa, valorVenda);
        this.tiposCombustivel.add(Combustivel.GASOLINA);
        this.tiposCombustivel.add(Combustivel.DIESEL);
        this.autonomiaMaxima = getAutonomiaMaxima();
        this.autonomiaAtual =  this.autonomiaMaxima;
    }

    @Override
    public void calculaCustoFixo() {
        double ipva = this.valorVenda * Tarifas.IPVA_VAN.getValor();
        double seguro = (this.valorVenda * Tarifas.SEGURO_VAN.getValor());
        this.custoFixo = ipva + seguro;
    }

    @Override
    public void calculaCustoVariavel() {
        double alinhamento = ((int)(this.kilometragemTotal/Tarifas.DIST_ALINHAMENTO_VAN.getValor())* Tarifas.PRECO_ALINHAMENTO_VAN.getValor());
        double vistoria = ((int)(this.kilometragemTotal/Tarifas.DIST_ALINHAMENTO_VAN.getValor())* Tarifas.PRECO_VISTORIA_VAN.getValor());
        this.custoVariavel = alinhamento + vistoria + this.custosExtra;
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
