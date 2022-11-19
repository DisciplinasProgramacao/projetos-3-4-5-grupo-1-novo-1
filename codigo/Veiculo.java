import java.util.ArrayList;


public abstract class Veiculo {
    protected String placa;
    protected double valorVenda;
    protected double custoFixo;
    protected double custoVariavel;
    protected double kilometragemTotal;
    protected double autonomiaAtual;
    protected double autonomiaMaxima;
    protected double custosExtra = 0;
    protected ArrayList<Combustivel> tiposCombustivel = new ArrayList<Combustivel>();

    public Veiculo() {};

    /**
     * Construtor da classe abstrata Veiculo, recebe a placa identificadora do carro e o seu valor de venda por parâmetro 
     * @param placa String contendo a placa do carro
     * @param valorVenda Double com o valor de venda paga na aquisição do carro
     */
    public Veiculo(String placa, double valorVenda) {
        this.placa = placa;
        this.valorVenda = valorVenda;
        this.kilometragemTotal = 0;
    }


   
    /**
     * Método exibe todos os combustíveis suportados pelo veículo
     */
    public void exibirTiposCombustivel() {
        tiposCombustivel.forEach(combustivel -> {System.out.printf("\n" + combustivel.getDescricao());});
    }

    public String getPlaca() {
        return this.placa;
    }
    public double getAutonomiaAtual() {
        return autonomiaAtual;
    }

    public double getAutonomiaMaxima() {
        return this.autonomiaMaxima;
    }

    public abstract void atualizaCustos();

    public double retornaCustoTotal() {
        return this.custoFixo + this.custoVariavel;
    }

    /**
     * Método adiciona um valor double para compor o total gasto em custos extras
     * @param valor Double com o valor do novo gasto esporadico
     * @return Retorna um valor double com o total de gastos esporadicos até o momento
     */
    public double addCustosExtra(double valor){
        this.custosExtra += valor;
        return this.custosExtra;
    }
    public void imprimeVeiculoCustos() {
        System.out.println("Veículo  : Placa: " + this.placa + " - "
                + " Custo Fixo: " + String.format("%.2f", this.custoFixo) + " - "
                + " Custo Variavel: " + String.format("%.2f", this.custoVariavel) + " = "
                + " Custo Total: " + String.format("%.2f", this.retornaCustoTotal()));
    }





    
    /**
     * Método abstrato implementado nas classes filhas de veículo booleano para verificar se foi possível abastecer o tanque do veículo com o combustível informado. O tanque é abastecido
     * até sua capacidade máxima
     * @param tipoCombustivel Inteiro relacionado ao identificador do combustível, sendo 1 para gasolina, 2 para etanol e 3 para diesel
     * @return Retorna TRUE caso tenha abastecido, retorna FALSE caso contrário
     */
    public abstract boolean abastecer(int tipoCombustivel);
    public abstract Double calculaCustoVariavel() ;
    public abstract Double calculaCustoFixo() ;
    /**
     * Método abstrato implementado nas classes filhas de veículo retorna um valor double com o total pago anualmente de IPVA
     * @return Valor total IPVA
     */
    public abstract double calculaIPVA();

    /**
     * Método abstrato implementado nas classes filhas de veículo que imprime dados básicos do veículo no console
     */
    public abstract void imprimeVeiculoConsole();

    /**
     * Método abstrato implementado nas classes filhas de veículo que imprime dados do veículo no console, incluindo os custos
     */
    public abstract void imprimeDadosVeiculoConsole();

    /**
     * Método abstrato implementado nas classes filhas de veículo que escreve os dados referentes ao veículo em um arquivo, sendo estes a placa e o valor de venda
     * @return
     */
    public abstract String escreveVeiculoArquivo();

    /**
     * Método abstrato implementado nas classes filhas de veículo que imprime a placa do veículo e capacidade atual do tanque
     */
    public void imprimeVeiculoPlaca() {
    }
}
