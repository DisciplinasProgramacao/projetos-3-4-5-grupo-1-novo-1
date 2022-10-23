public class Van extends Veiculo {
    private double alinhamento = 0.012; //120/10000; 
    private double vistoria = 0.05; //500/10000; 
    int tanque = 60; 
    double ipva = 0.03; 
    double seguro = 0.03; 
    double precoCombustivel = 6.5;
    double kmPorLitro = 9;
      
    public Van(String placa, double valorVenda) {
        super(placa, valorVenda);
    }

    public Van() {
    }

    public double kmRodados() {
        double kmRodados = 0;
        for (Rota rota : rotas) {
            kmRodados += rota.distancia;
        }
        return kmRodados;
    }

    public double gastoVariavelTotal() {
        double gastoPorKM = kmRodados() * getCustoPorKm();
        return gastoPorKM;
    }

    public double custoFixoAnual() {
        return getIPVA() + getSeguro();
    }

    public double gastoTotalacumulado() {
        return gastoVariavelTotal() + custoFixoAnual();

    }


    public double getCustoPorKm() {
        return this.alinhamento + this.precoCombustivel/this.kmPorLitro;
    }

    @Override
    public int getTanque() {
        return this.tanque;
    }

    @Override
    public double getIPVA() {
        return super.valorVenda * this.ipva; // usar valorVenda local?
    }

    @Override
    public double getSeguro() {
        return super.valorVenda * this.seguro; // usar valorVenda local?;
    }


    @Override
    public void imprimeVeiculoConsole() {
        System.out.println("Van    : Placa: " + super.getPlaca() + " - "
                + " Valor de venda: " + String.format("%.2f", super.valorVenda) + "\n"
                + " Capacidade Tanque: " + this.tanque  + "\n"
                + " IPVA: " + String.format("%.2f", this.getIPVA())  + "\n"
                + " Seguro: " + String.format("%.2f", this.getSeguro() )  + "\n"
                + " Preço combustivel: " + String.format("%.2f", this.precoCombustivel)  + "\n"
                + " Km por litro: " + String.format("%.2f", this.kmPorLitro)  + "\n");

    }

    @Override
    public void imprimeDadosVeiculoConsole() {
        System.out.println("Van    : Placa: " + super.getPlaca() + " - "
                + "\nValor de venda: " + String.format("%.2f", super.valorVenda) + ";"
                + "\nGasto Fixo Anual: " + String.format("%.2f",  custoFixoAnual() ) + " - "
                + "\n   Kilometros rodados: " + String.format("%.2f",  kmRodados() ) + " - "
                + "\n   Gasto alinhamento: " + String.format("%.2f",  this.alinhamento *  kmRodados()  ) + " - "
                + "\n   Gasto vistoria: " + String.format("%.2f",  this.vistoria *  kmRodados() ) + " - "
                + "\n   Gasto combustivel: " + String.format("%.2f",  (this.precoCombustivel/this.kmPorLitro) *  kmRodados() ) + " - "
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

}
