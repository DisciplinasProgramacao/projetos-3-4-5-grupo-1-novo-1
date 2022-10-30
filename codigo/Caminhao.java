
public class Caminhao extends Veiculo {
    private static final double MANUTENCAO = 1000.0 / 20000.0;
    private static final int TANQUE_COMPLETO = 250;
    private static final double IPVA = 0.01;
    private static final double VISTORIA = 1000.0 / 30000.0;
    private static final double SEGURO = 0.02;

    public Caminhao(String placa, double valorVenda) {
        
        super(placa, valorVenda);
        this.tanque = TANQUE_COMPLETO;

        Combustivel diesel = new Diesel();
        this.tiposCombustivel.add(diesel);
    }

    public Caminhao() {
    }

    @Override
    public boolean abastecer(int tipoCombustivel){

        if (tipoCombustivel == 3) {
            this.combustivelAtual = this.tiposCombustivel.get(0);
            this.tanque = TANQUE_COMPLETO;
            return true;
        }
        else{return false;}
    }

    @Override
    public double custoPorKm() {
        return MANUTENCAO + VISTORIA + this.combustivelAtual.getPreco()/this.combustivelAtual.getConsumo();
    }

    @Override
    public double calculaIPVA() {
        return this.valorVenda * IPVA;
    }

    @Override
    public double calculaSeguro() {
        return this.valorVenda * SEGURO;
    }

    @Override
    public void imprimeVeiculoConsole() {
        System.out.println("Caminhão    : Placa: " + this.placa + " - "
                + " Valor de venda: " + String.format("%.2f", this.valorVenda) + "\n"
                + " Capacidade Tanque: " + this.tanque  + "\n"
                + " IPVA: " + String.format("%.2f", this.calculaIPVA())  + "\n"
                + " Seguro + Taxa: " + String.format("%.2f", this.calculaSeguro() )  + "\n"
                + " Combustíveis compatíveis: Diesel"  + "\n");
    }

    @Override
    public void imprimeDadosVeiculoConsole() {
        System.out.println("Caminhão    : Placa: " + this.placa + " - "
                + "\nValor de venda: " + String.format("%.2f", this.valorVenda) + ";"
                + "\nGasto Fixo Anual: " + String.format("%.2f",  custoFixoAnual() ) + " - "
                + "\n   Kilometros rodados: " + String.format("%.2f",  kmRodados() ) + " - "
                + "\n   Gasto manutenção: " + String.format("%.2f",  MANUTENCAO *  kmRodados()  ) + " - "
                + "\n   Gasto vistoria: " + String.format("%.2f",  VISTORIA *  kmRodados() ) + " - "
                + "\n   Gasto combustivel: " + String.format("%.2f",  (this.combustivelAtual.getPreco() / this.combustivelAtual.getConsumo()) *  kmRodados() ) + " - "
                + "\nGastos Variáveis Total: " + String.format("%.2f",  gastoVariavelTotal() ) + " - "
                + "\nTotal gastos: " + String.format("%.2f",  gastoTotalacumulado() ));
    }

    @Override
    public String escreveVeiculoArquivo() {
        String salvaParaArquivo = "Caminhão;"
                + this.placa + ";"
                + this.valorVenda;
        return salvaParaArquivo;
    }

    @Override
    public void imprimeVeiculoPlaca() {
        System.out.println("Caminhão       : Placa: " + this.placa + " - "
        + " Capacidade Tanque: " + this.tanque + " - "
        + " Km por litro: " + String.format("%.2f", this.combustivelAtual.getConsumo()));
    }
}
