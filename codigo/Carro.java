import java.util.ArrayList;

public class Carro extends Veiculo {
    private static final double ALINHAMENTO = 80.0 / 10000.0;
    private static final int TANQUE_COMPLETO = 50;
    private static final double IPVA = 0.04;
    private static final double TAXA = 300;
    private static final double SEGURO = 0.05;
    protected static final ArrayList<Combustivel> TIPOS_COMBUSTIVEL = new ArrayList<Combustivel>();

    public Carro(String placa, double valorVenda) {
        
        super(placa, valorVenda);
        this.tanque = TANQUE_COMPLETO;
        
        Combustivel gasolina = new Gasolina();
        Combustivel etanol = new Etanol();
        this.tiposCombustivel.add(gasolina);
        this.tiposCombustivel.add(etanol);
    }

    public Carro() {
    }

    @Override
    public boolean abastecer(int tipoCombustivel){

        if (tipoCombustivel == 1) {
            this.combustivelAtual = this.tiposCombustivel.get(0);
            this.tanque = TANQUE_COMPLETO;
            return true;
        }
        if (tipoCombustivel == 2) {
            this.combustivelAtual = this.tiposCombustivel.get(1);
            this.tanque = TANQUE_COMPLETO;
            return true;
        }
        else{return false;}
    }

    @Override
    public double custoPorKm() {
        return ALINHAMENTO + this.combustivelAtual.getPreco()/this.combustivelAtual.getConsumo();
    }

    @Override
    public double calculaIPVA() {
        return this.valorVenda * IPVA; 
    }

    @Override
    public double calculaSeguro() {
        return this.valorVenda * SEGURO + TAXA; 
    }

    @Override
    public void imprimeVeiculoConsole() {
        System.out.println("Carro    : Placa: " + this.placa + " - "
                + " Valor de venda: " + String.format("%.2f", this.valorVenda) + "\n"
                + " Capacidade Tanque: " + this.tanque  + "\n"
                + " IPVA: " + String.format("%.2f", this.calculaIPVA())  + "\n"
                + " Seguro + Taxa: " + String.format("%.2f", this.calculaSeguro() )  + "\n"
                + " Preço combustivel: " + String.format("%.2f", this.combustivelAtual.getPreco())  + "\n"
                + " Km por litro: " + String.format("%.2f", this.combustivelAtual.getConsumo())  + "\n");
    }

    @Override
    public void imprimeDadosVeiculoConsole() {
        System.out.println("Carro    : Placa: " + this.placa + " - "
                + "\nValor de venda: " + String.format("%.2f", this.valorVenda) + ";"
                + "\nGasto Fixo Anual: " + String.format("%.2f",  custoFixoAnual() ) + " - "
                + "\n   Kilometros rodados: " + String.format("%.2f",  kmRodados() ) + " - "
                + "\n   alinhamento: " + String.format("%.2f",  ALINHAMENTO ) + " - "
                + "\n   Gasto alinhamento: " + String.format("%.2f",  ALINHAMENTO *   kmRodados()  ) + " - "
                + "\n   Gasto combustivel: " + String.format("%.2f",  (this.combustivelAtual.getPreco() / this.combustivelAtual.getConsumo()) *   kmRodados() ) + " - "
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

    @Override
    public void imprimeVeiculoPlaca() {
        System.out.println("Carro       : Placa: " + this.placa + " - "
                + " Capacidade Tanque: " + this.tanque + " - "
                + " Km por litro: " + String.format("%.2f", this.combustivelAtual.getConsumo()));
    }
}
