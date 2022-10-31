
public class Caminhao extends Veiculo {
    private static final int MANUTENCAO = 20000;
    private static final int TANQUE_COMPLETO = 250;
    private static final double IPVA = 0.01;
    private static final int VISTORIA = 30000;
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
    public double autonomiaMaxima(){
        return this.combustivelAtual.getConsumo() * TANQUE_COMPLETO;
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

    public int calculaManutecao() {
        int manutencao = (int)(this.kilometragemTotal/MANUTENCAO);
        return (manutencao * 1000);
    }

    public int calculaVistoria() {
        int vistoria = (int)(this.kilometragemTotal/VISTORIA);
        return (vistoria * 1000);
    }

    @Override
    public double outrosCustos() {
        return calculaManutecao() + calculaVistoria() + this.combustivelAtual.getPreco()/this.combustivelAtual.getConsumo();
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
                + "\n   Gasto manutenção: " + (calculaManutecao()) + " - "
                + "\n   Gasto vistoria: " + (calculaVistoria()) + " - "
                + "\n   Gasto combustivel: " + String.format("%.2f",  gastoCombustivel()) + " - "
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
        + " Capacidade Tanque: " + this.tanque + " - ");
    }
}
