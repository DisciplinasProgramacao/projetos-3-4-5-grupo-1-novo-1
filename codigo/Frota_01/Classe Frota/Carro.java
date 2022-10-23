
public class Carro extends Veiculo {
    protected double alinhamento =  0.008;  //80/10000;
    int tanque = 50;
    double ipva = 0.04;
    double taxa = 300;
    double seguro = 0.05;
    double precoCombustivel = 5;
    double kmPorLitro = 12;


    public Carro(String placa, double valorVenda) {
        super(placa, valorVenda);
    }

    public Carro() {
    }
/* 
    public double kmRodados() {
        double kmRodados = 0;
        for (Rota rota : rotas) {
            kmRodados += rota.distancia;
        }
        return kmRodados;
    }
*/
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
        return super.valorVenda * this.seguro + this.taxa; // usar valorVenda local?;
    }


    @Override
    public void imprimeVeiculoConsole() {
        System.out.println("Carro    : Placa: " + super.getPlaca() + " - "
                + " Valor de venda: " + String.format("%.2f", super.valorVenda) + "\n"
                + " Capacidade Tanque: " + this.tanque  + "\n"
                + " IPVA: " + String.format("%.2f", this.getIPVA())  + "\n"
                + " Seguro + Taxa: " + String.format("%.2f", this.getSeguro() )  + "\n"
                + " Preço combustivel: " + String.format("%.2f", this.precoCombustivel)  + "\n"
                + " Km por litro: " + String.format("%.2f", this.kmPorLitro)  + "\n");

    }

    @Override
    public void imprimeDadosVeiculoConsole() {
        System.out.println("Carro    : Placa: " + super.getPlaca() + " - "
                + "\nValor de venda: " + String.format("%.2f", super.valorVenda) + ";"
                + "\nGasto Fixo Anual: " + String.format("%.2f",  custoFixoAnual() ) + " - "
                + "\n   Kilometros rodados: " + String.format("%.2f",  super.kmRodados() ) + " - "
                + "\n   alinhamento: " + String.format("%.2f",  this.alinhamento ) + " - "
                + "\n   Gasto alinhamento: " + String.format("%.2f",  this.alinhamento *   super.kmRodados()  ) + " - "
                + "\n   Gasto combustivel: " + String.format("%.2f",  (this.precoCombustivel/this.kmPorLitro) *   super.kmRodados() ) + " - "
                + "\nGastos Variáveis Total: " + String.format("%.2f",  gastoVariavelTotal() ) + " - "
                + "\nTotal gastos: " + String.format("%.2f",  gastoTotalacumulado() ));

    }

    @Override
    public String escreveVeiculoArquivo() {
        String salvaParaArquivo = "Carro;"
                + super.placa + ";"
                + super.valorVenda;
           return salvaParaArquivo;

    }

}
