public class Furgao extends Veiculo {

    private static final double ALINHAMENTO = 120.0/10000.0;
    private static final int TANQUE = 80;
    private static final double IPVA = 0.03;
    private static final double VISTORIA = 500.0/10000.0;
    private static final double SEGURO = 0.03; 
    private static final double PRECO_COMBUSTIVEL = 5;
    private static final double KM_POR_LITRO = 11;
    
    public Furgao() {
    }
    
    public Furgao(String placa, double valorVenda) {
        super(placa, valorVenda);
        this.tanque = TANQUE;
    }

    public double gastoVariavelTotal() {
        double gastoPorKM = kmRodados() * custoPorKm();
        return gastoPorKM;
    }

    public double custoFixoAnual() {
        return calculaIPVA() + calculaSeguro();
    }

    public double gastoTotalacumulado() {
        return gastoVariavelTotal() + custoFixoAnual();

    }

    @Override
    public double custoPorKm() {
        return ALINHAMENTO + PRECO_COMBUSTIVEL/KM_POR_LITRO;
    }

    @Override
    public double calculaIPVA() {
        return this.valorVenda * IPVA; // usar valorVenda local?
    }

    @Override
    public double calculaSeguro() {
        return this.valorVenda * SEGURO; // usar valorVenda local?;
    }

    @Override
    public void imprimeVeiculoConsole() {
        System.out.println("Furgão    : Placa: " + this.placa + " - "
                + " Valor de venda: " + String.format("%.2f", this.valorVenda) + "\n"
                + " Capacidade Tanque: " + this.tanque  + "\n"
                + " IPVA: " + String.format("%.2f", this.calculaIPVA())  + "\n"
                + " Seguro" + String.format("%.2f", this.calculaSeguro() )  + "\n"
                + " Preço combustivel: " + String.format("%.2f", PRECO_COMBUSTIVEL)  + "\n"
                + " Km por litro: " + String.format("%.2f", KM_POR_LITRO)  + "\n");
    }

    @Override
    public void imprimeDadosVeiculoConsole() {
        System.out.println("Furgão    : Placa: " + this.placa + " - "
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
        String salvaParaArquivo = "Furgão;"
                + this.placa + ";"
                + this.valorVenda;
        return salvaParaArquivo;
    }

}
