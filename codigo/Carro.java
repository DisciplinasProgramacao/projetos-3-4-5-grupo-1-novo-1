
public class Carro extends Veiculo {
<<<<<<< HEAD
    protected double alinhamento =  80.0/ 10000.0; //0.008;  //80/10000;
    int tanque = 50;
    double ipva = 0.04;
    double taxa = 300;
    double seguro = 0.05;
    double precoCombustivel = 5;
    double kmPorLitro = 12;


    public Carro(String placa, double valorVenda) {
        super(placa, valorVenda);
    }
=======
    private static final double ALINHAMENTO = 0.008;
    private static final int TANQUE = 50;
    private static final double IPVA = 0.04;
    private static final double TAXA = 300;
    private static final double SEGURO = 0.05;
    private static final double PRECO_COMBUSTIVEL = 5;
    private static final double KM_POR_LITRO = 12;
>>>>>>> cea9c9b8fdf26b480862ef6d7da0d87423cf065a

    public Carro() {
    }

    public Carro(String placa, double valorVenda) {
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
        return ALINHAMENTO + PRECO_COMBUSTIVEL / KM_POR_LITRO;
    }

    @Override
    public double calculaIPVA() {
        return this.valorVenda * IPVA; // usar valorVenda local?
    }

    @Override
    public double calculaSeguro() {
        return this.valorVenda * SEGURO + TAXA; // usar valorVenda local?;
    }


    @Override
    public void imprimeVeiculoConsole() {
        System.out.println("Carro    : Placa: " + this.placa + " - "
                + " Valor de venda: " + String.format("%.2f", this.valorVenda) + "\n"
                + " Capacidade Tanque: " + this.tanque  + "\n"
                + " IPVA: " + String.format("%.2f", this.calculaIPVA())  + "\n"
                + " Seguro + Taxa: " + String.format("%.2f", this.calculaSeguro() )  + "\n"
                + " Preço combustivel: " + String.format("%.2f", PRECO_COMBUSTIVEL)  + "\n"
                + " Km por litro: " + String.format("%.2f", KM_POR_LITRO)  + "\n");
    }

    @Override
    public void imprimeDadosVeiculoConsole() {
        System.out.println("Carro    : Placa: " + this.placa + " - "
                + "\nValor de venda: " + String.format("%.2f", this.valorVenda) + ";"
                + "\nGasto Fixo Anual: " + String.format("%.2f",  custoFixoAnual() ) + " - "
                + "\n   Kilometros rodados: " + String.format("%.2f",  kmRodados() ) + " - "
                + "\n   alinhamento: " + String.format("%.2f",  ALINHAMENTO ) + " - "
                + "\n   Gasto alinhamento: " + String.format("%.2f",  ALINHAMENTO *   kmRodados()  ) + " - "
                + "\n   Gasto combustivel: " + String.format("%.2f",  (PRECO_COMBUSTIVEL / KM_POR_LITRO) *   kmRodados() ) + " - "
                + "\nGastos Variáveis Total: " + String.format("%.2f",  gastoVariavelTotal() ) + " - "
                + "\nTotal gastos: " + String.format("%.2f",  gastoTotalacumulado() ));

    }

    @Override
    public String escreveVeiculoArquivo() {
        String salvaParaArquivo = "Carro;"
                + this.placa + ";"
                + this.valorVenda;
        return salvaParaArquivo;
    }

}
