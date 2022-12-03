
public class Furgao extends Veiculo {
    private final int TANQUE_COMPLETO = 80;

    /**
     * Método construtor da classe Furgao.
     * @param placa String constendo a placa do veículo
     * @param valorVenda double contendo o valor de venda do veículo
     */
    public Furgao(String placa, double valorVenda) {
        super(placa, valorVenda);
        this.tiposCombustivel.add(Combustivel.GASOLINA);
        this.tanque = new Tanque(TANQUE_COMPLETO);
        this.tanque.completarTanque(Combustivel.GASOLINA);
        this.autonomiaMaxima = getAutonomiaMaxima();
        this.autonomiaAtual = this.autonomiaMaxima;
    }

    @Override
    public void calculaCustoFixo() {
        double ipva = this.valorVenda * Tarifas.IPVA_FURGAO.getValor();
        double seguro = (this.valorVenda * Tarifas.SEGURO_FURGAO.getValor());
        this.custoFixo = ipva + seguro;
    }

    @Override
    public void calculaCustoVariavel() {
        double alinhamento = ((int)(this.kilometragemTotal/Tarifas.DIST_ALINHAMENTO_FURGAO.getValor())* Tarifas.PRECO_ALINHAMENTO_FURGAO.getValor());
        double vistoria = ((int)(this.kilometragemTotal/Tarifas.DIST_ALINHAMENTO_FURGAO.getValor())* Tarifas.PRECO_VISTORIA_FURGAO.getValor());
        this.custoVariavel = alinhamento + vistoria + this.custosExtra;
    }
}
