
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
        this.tanque = new Tanque(TANQUE_COMPLETO);
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
}
