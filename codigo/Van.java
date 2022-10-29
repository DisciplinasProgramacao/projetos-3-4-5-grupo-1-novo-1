public class Van extends Veiculo {
    private static final double ALINHAMENTO = 120.0 / 10000.0;
    private static final int TANQUE = 60;
    private static final double IPVA = 0.03;
    private static final double VISTORIA = 500.0 / 10000.0;
    private static final double SEGURO = 0.03; 
    private static final double PRECO_COMBUSTIVEL = 6.5;
    private static final double KM_POR_LITRO = 9;

    public Van(String placa, double valorVenda) {
        super(placa, valorVenda);
        this.tanque = TANQUE;
    }

    public Van() {
    }

    @Override
    public double custoPorKm() {
        return ALINHAMENTO + PRECO_COMBUSTIVEL/KM_POR_LITRO;
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
        System.out.println("Van    : Placa: " + this.placa + " - "
                + " Valor de venda: " + String.format("%.2f", this.valorVenda) + "\n"
                + " Capacidade Tanque: " + this.tanque  + "\n"
                + " IPVA: " + String.format("%.2f", this.calculaIPVA())  + "\n"
                + " Seguro: " + String.format("%.2f", this.calculaSeguro() )  + "\n"
                + " Preço combustivel: " + String.format("%.2f", PRECO_COMBUSTIVEL)  + "\n"
                + " Km por litro: " + String.format("%.2f", KM_POR_LITRO)  + "\n");
    }

    @Override
    public void imprimeDadosVeiculoConsole() {
        System.out.println("Van    : Placa: " + this.placa + " - "
                + "\nValor de venda: " + String.format("%.2f", this.valorVenda) + ";"
                + "\nGasto Fixo Anual: " + String.format("%.2f",  custoFixoAnual() ) + " - "
                + "\n   Kilometros rodados: " + String.format("%.2f",  kmRodados() ) + " - "
                + "\n   alinhamento: " + String.format("%.2f",  ALINHAMENTO ) + " - "
                + "\n   Gasto alinhamento: " + String.format("%.2f",  ALINHAMENTO *   kmRodados()  ) + " - "
                + "\n   Gasto vistoria: " + String.format("%.2f",  VISTORIA *  kmRodados() ) + " - "
                + "\n   Gasto combustivel: " + String.format("%.2f",  (PRECO_COMBUSTIVEL / KM_POR_LITRO) *   kmRodados() ) + " - "
                + "\nGastos Variáveis Total: " + String.format("%.2f",  gastoVariavelTotal() ) + " - "
                + "\nTotal gastos: " + String.format("%.2f",  gastoTotalacumulado() ));
    }

    @Override
    public String escreveVeiculoArquivo() {
        String salvaParaArquivo = "Van;"
                + super.placa + ";"
                + super.valorVenda;
        return salvaParaArquivo;
    }

    @Override
    public void imprimeVeiculoPlaca() {
        System.out.println("Van       : Placa: " + this.placa + " - "
        + " Capacidade Tanque: " + this.tanque + " - "
        + " Km por litro: " + String.format("%.2f", KM_POR_LITRO));
    }
}
