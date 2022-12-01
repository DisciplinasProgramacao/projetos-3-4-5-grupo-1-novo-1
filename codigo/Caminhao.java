
public class Caminhao extends Veiculo{
    private final int TANQUE_COMPLETO = 250;

    /**
     * Método construtor da classe Caminhao.
     * @param placa String constendo a placa do veículo
     * @param valorVenda double contendo o valor de venda do veículo
     */
    public Caminhao(String placa, double valorVenda) {
        super(placa, valorVenda);
        this.tiposCombustivel.add(Combustivel.DIESEL);
        this.autonomiaMaxima = getAutonomiaMaxima();
        this.autonomiaAtual =  this.autonomiaMaxima;
        this.tanque = new Tanque(TANQUE_COMPLETO);
    }

    @Override
    public void calculaCustoFixo() {
        double ipva = this.valorVenda * Tarifas.IPVA_CAMINHAO.getValor();
        double seguro = (this.valorVenda * Tarifas.SEGURO_CAMINHAO.getValor()) + Tarifas.TAXA_CAMINHAO.getValor();
        this.custoFixo = ipva + seguro;
    }

    @Override
    public void calculaCustoVariavel() {
        double manutencao = ((int)(this.kilometragemTotal/Tarifas.DIST_MANUTENCAO_CAMINHAO.getValor())* Tarifas.PRECO_MANUTENCAO_CAMINHAO.getValor());
        double vistoria = ((int)(this.kilometragemTotal/Tarifas.DIST_VISTORIA_CAMINHAO.getValor())* Tarifas.PRECO_VISTORIA_CAMINHAO.getValor());
        this.custoVariavel = manutencao + vistoria + this.custosExtra;
    }
}
