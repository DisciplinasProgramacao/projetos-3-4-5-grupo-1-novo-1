import java.util.ArrayList;
import java.util.List;

public abstract class Veiculo implements ICustos{
    protected String placa;
    protected double valorVenda;
    protected double custoFixo;
    protected double custoVariavel;
    protected double kilometragemTotal;
    protected double autonomiaAtual;
    protected Tanque tanque;
    protected double autonomiaMaxima;
    protected double custosExtra = 0;
    protected List<Combustivel> tiposCombustivel = new ArrayList<Combustivel>();
    protected List<Rota> rotas = new ArrayList<Rota>();
    
    /**
     * Construtor da classe abstrata Veiculo, recebe a placa identificadora do carro e o seu valor de venda por parâmetro 
     * @param placa String contendo a placa do carro
     * @param valorVenda Double com o valor de venda paga na aquisição do carro
     */
    public Veiculo(String placa, double valorVenda) {
        this.placa = placa;
        this.valorVenda = valorVenda;
        this.kilometragemTotal = 0;
        calculaCustoFixo();
    }

    /**
     * Método adiciona um valor double para compor o total gasto em custos extras
     * @param valor Double com o valor do novo gasto esporadico
     * @return Retorna um valor double com o total de gastos esporadicos até o momento
     */
    public void addCustosExtra(double valor){
        this.custosExtra += valor;
    }

    /**
     * Método retorna o custo total de um veículo, somando os custos fixos com os custos
     * variáveis
     * @return Retorna o custo total do veículo
     */
    public double retornaCustoTotal() {
        return this.custoFixo + this.custoVariavel;
    }

    public void abastecer(Combustivel combustivel) throws Exception {
        if(!this.tiposCombustivel.contains(combustivel)){throw new Exception();}
        else{
            calculaCustoCombustivel(this.tanque.completarTanque(combustivel));
        }
    }

    /**
     * Método exibe todos os combustíveis suportados pelo veículo
     */
    public void exibirTiposCombustivel() {
        tiposCombustivel.forEach(combustivel -> {System.out.printf("\n" + combustivel.getDescricao());});
    }

    public abstract void calculaCustoFixo();
    public abstract void calculaCustoVariavel();

    public void calculaCustoCombustivel(double litros){
        this.custoVariavel += (litros * this.tanque.getCombustivel().getPreco());
    }

    
    public String gastosVeiculo() {
        StringBuilder veiculo = new StringBuilder("\n(" + getClass().getName());
        veiculo.append(") Placa: " + placa
        + "\n  Valor de venda: " + String.format("%.2f", this.valorVenda)
        + "\n  Quilometros rodados: " + String.format("%.2f", this.kilometragemTotal)
        + "\n  Gastos Fixos: " + String.format("%.2f", this.custoFixo)
        + "\n  Gastos Variáveis: " + String.format("%.2f", this.custoVariavel)
        + "\n  Custo Total: " + String.format("%.2f", retornaCustoTotal()));
        return veiculo.toString();
    }

    public String autonomiaVeiculo() {
        StringBuilder veiculo = new StringBuilder("\n(" + getClass().getName());
        veiculo.append(") Placa: " + placa + " - "
                + " Autonomia atual: " + getAutonomiaAtual() + " - "
                + " Autonomia Máxima:");
        for (Combustivel combustivel : tiposCombustivel) {
            veiculo.append(" " + combustivel.getDescricao() + "=" + combustivel.getConsumo() * this.tanque.getCapacidade());
        }
        return veiculo.toString();
    }

    public String escreveVeiculoArquivo() {
        String salvaParaArquivo = getClass().getName() +";"
                + this.placa + ";"
                + this.valorVenda;
        return salvaParaArquivo;
    }

    public String escreveVeiculoFrota() {
        String veiculoRota = getClass().getName() +": "
                + this.placa + " Qtde rotas: ";
        return veiculoRota;
    }

    public String getPlaca() {
        return this.placa;
    }
    public double getAutonomiaAtual() {
        return autonomiaAtual;
    }

    public double getAutonomiaMaxima() {
        double maiorAutonomia = 0;
        for (Combustivel consumo : tiposCombustivel) {
            if (consumo.getConsumo() > maiorAutonomia) {
                maiorAutonomia = consumo.getConsumo();
            }
        }
        return maiorAutonomia * this.tanque.getCapacidade();
    }

    public int quantRotas(){
        return this.rotas.size();
    }

    @Override
    public boolean equals(Object obj) {
        Veiculo outro = (Veiculo)obj;
        return this.placa.equals(outro.placa);
    }

    @Override
    public int hashCode() {
        return this.placa.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder veiculo = new StringBuilder("\n(" + getClass().getName());
        veiculo.append(") Placa: " + this.placa + " - "
        + " Valor de venda: " + String.format("%.2f", this.valorVenda) + "\n"
        + " IPVA, Seguro + Taxa: " + String.format("%.2f", this.custoFixo) + "\n"
        + " Combustíveis compatíveis: Gasolina e Etanol" + "\n");
        return veiculo.toString();
    }

    public void addRota(Rota rota) {
        this.autonomiaAtual -= rota.getDistancia();
        this.kilometragemTotal += rota.getDistancia();
        calculaCustoVariavel();
        this.rotas.add(rota);
    }
}