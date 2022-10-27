public class Caminhao extends Veiculo {

    private static final double MANUTENCAO = 1000.0/20000.0;
    private static final int TANQUE = 250;
    private static final double IPVA = 0.01;
    private static final double VISTORIA = 1000.0/30000.0;
    private static final double SEGURO = 0.02;
    private static final double TAXA = 2000;
    private static final double PRECO_COMBUSTIVEL = 6.5;
    private static final double KM_POR_LITRO = 10;

    public Caminhao() {
    }
    
    public Caminhao(String placa, double valorVenda) {
        super(placa, valorVenda);
        this.tanque = TANQUE;
    }

    public double kmRodados() {
        double kmRodados = 0;
        for (Rota rota : rotas) {
            kmRodados += rota.distancia;
        }
        return kmRodados;
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
        return MANUTENCAO + VISTORIA + PRECO_COMBUSTIVEL / KM_POR_LITRO;
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
        System.out.println("Caminhão    : Placa: " + this.placa + " - "
                + " Valor de venda: " + String.format("%.2f", this.valorVenda) + "\n"
                + " Capacidade Tanque: " + this.tanque  + "\n"
                + " IPVA: " + String.format("%.2f", this.calculaIPVA())  + "\n"
                + " Seguro + Taxa: " + String.format("%.2f", this.calculaSeguro() )  + "\n"
                + " Preço combustivel: " + String.format("%.2f", PRECO_COMBUSTIVEL)  + "\n"
                + " Km por litro: " + String.format("%.2f", KM_POR_LITRO)  + "\n");
    }


    @Override
    public void imprimeDadosVeiculoConsole() {
        System.out.println("Caminhão    : Placa: " + this.placa + " - "
                + "\nValor de venda: " + String.format("%.2f", this.valorVenda) + ";"
                + "\nGasto Fixo Anual: " + String.format("%.2f",  custoFixoAnual() ) + " - "
                + "\n   Kilometros rodados: " + String.format("%.2f",  kmRodados() ) + " - "
                + "\n   Gasto manutenção: " + String.format("%.2f",  MANUTENCAO *  kmRodados()  ) + " - "
                + "\n   Gasto vistoria: " + String.format("%.2f",  VISTORIA *  kmRodados() ) + " - "
                + "\n   Gasto combustivel: " + String.format("%.2f",  (PRECO_COMBUSTIVEL / KM_POR_LITRO) *  kmRodados() ) + " - "
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

}
