
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
    }

    @Override
    public double getAutonomiaMaxima() {
        double maiorAutonomia = 0;
        for (Combustivel consumo : tiposCombustivel) {
            if (consumo.getConsumo() > maiorAutonomia) {
                maiorAutonomia = consumo.getConsumo();
            }
        }
        return maiorAutonomia * TANQUE_COMPLETO;
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

    @Override
    public String escreveVeiculoArquivo() {
        String salvaParaArquivo = "Caminhao;"
                + this.placa + ";"
                + this.valorVenda;
        return salvaParaArquivo;
    }
    @Override
    public String escreveVeiculoFrota() {
        String veiculoRota = "Caminhão: "
                + this.placa + " Qtde rotas: ";
        return veiculoRota;
    }

    @Override
    public void imprimeVeiculoPlaca() {
        System.out.print("Caminhão: Placa: " + this.placa + " - "
                + " Autonomia atual: " + this.autonomiaAtual + " - "
                + " Autonomia Máxima:");
        for (Combustivel combustivel : tiposCombustivel) {
            System.out.print(" " + combustivel.getDescricao() + "=" + this.TANQUE_COMPLETO * combustivel.getConsumo());
        }
        System.out.println();
    }
}
