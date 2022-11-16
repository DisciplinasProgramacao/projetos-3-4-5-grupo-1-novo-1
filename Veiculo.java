import java.util.ArrayList;

public abstract class Veiculo {
    protected String placa;
    protected double valorVenda;
    protected double custoFixo;
    protected double custoVariavel;
    protected double kilometragemTotal;
    protected double autonomiaAtual;
    protected double autonomiaMaxima;
    protected ArrayList<Combustivel> tiposCombustivel = new ArrayList<Combustivel>();

    public Veiculo() {
    };

    /**
     * Construtor da classe abstrata Veiculo, recebe a placa identificadora do carro
     * e o seu valor de venda por parâmetro
     * 
     * @param placa      String contendo a placa do carro
     * @param valorVenda Double com o valor de venda paga na aquisição do carro
     */
    public Veiculo(String placa, double valorVenda) {
        this.placa = placa;
        this.valorVenda = valorVenda;
    }

    public double getAutonomiaAtual() {
        return autonomiaAtual;
    }

    public double getAutonomiaMaxima() {
        return this.autonomiaMaxima;
    }

    public String getPlaca() {
        return this.placa;
    }

    public double retornaCustoTotal() {
        return this.custoFixo + this.custoVariavel;
    }

    public void exibirTiposCombustivel() {
        int i = 1;
        System.out.println("Entre com o tipo de combustível para abastecer:");
        for (Combustivel combustivel : tiposCombustivel) {
            System.out.printf("\n" + i + " - " + combustivel.getDescricao());
            i++;
        }

    }

    public abstract void atualizaCustos();

    public abstract boolean abastecer(int tipoCombustivel);

    /**
     * Método abstrato implementado nas classes filhas de veículo que imprime dados
     * básicos do veículo no console
     */
    public abstract void imprimeVeiculoConsole();

    /**
     * Método abstrato implementado nas classes filhas de veículo que imprime dados
     * do veículo no console, incluindo os custos
     */
    public abstract void imprimeDadosVeiculoConsole();

    /**
     * Método abstrato implementado nas classes filhas de veículo que escreve os
     * dados referentes ao veículo em um arquivo, sendo estes a placa e o valor de
     * venda
     * 
     * @return
     */
    public abstract String escreveVeiculoArquivo();

    /**
     * Método abstrato implementado nas classes filhas de veículo que imprime a
     * placa do veículo e capacidade atual do tanque
     */
    public void imprimeVeiculoPlaca() {
    }

    /**
     * Método abstrato implementado nas classes filhas de veículo que imprime a
     * placa do veículo com autonomia maior que distancia da rota
     */

    public void imprimeVeiculoCustos() {
        System.out.println("Veículo  : Placa: " + this.placa + " - "
                + " Custo Fixo: " + String.format("%.2f", this.custoFixo) + " - "
                + " Custo Variavel: " + String.format("%.2f", this.custoVariavel) + " = "
                + " Custo Total: " + String.format("%.2f", this.retornaCustoTotal()));
    }

}
