
public class Furgao extends Veiculo {
    private static final int ALINHAMENTO = 10000;
    private static final int PRECO_ALINHAMENTO = 120;
    private static final int PRECO_VISTORIA = 500;
    private static final int TANQUE_COMPLETO = 80;
    private static final double IPVA = 0.03;
    private static final double VISTORIA = 10000;
    private static final double SEGURO = 0.03; 

    public Furgao(String placa, double valorVenda) {
        
        super(placa, valorVenda);
        this.tanque = TANQUE_COMPLETO;
        
        Combustivel gasolina = new Gasolina();
        this.tiposCombustivel.add(gasolina);
    }

    public Furgao() {
    }

    @Override
    public double autonomiaMaxima(){
        return this.combustivelAtual.getConsumo() * TANQUE_COMPLETO;
    }

    @Override
    public boolean abastecer(int tipoCombustivel){
        if (tipoCombustivel == 1) {
            this.combustivelAtual = this.tiposCombustivel.get(0);
            this.tanque = TANQUE_COMPLETO;
            return true;
        }
        else{return false;}
    }

    public int calculaAlinhamento() {
        int alinhamento = (int)(this.kilometragemTotal/ALINHAMENTO);
        return (alinhamento * PRECO_ALINHAMENTO);
    }

    public int calculaVistoria() {
        int vistoria = (int)(this.kilometragemTotal/VISTORIA);
        return (vistoria * PRECO_VISTORIA);
    }

    @Override
    public double outrosCustos() {
        return calculaAlinhamento() + calculaVistoria() + this.combustivelAtual.getPreco()/this.combustivelAtual.getConsumo();
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
        System.out.println("Furgão    : Placa: " + this.placa + " - "
                + " Valor de venda: " + String.format("%.2f", this.valorVenda) + "\n"
                + " Capacidade Tanque: " + this.tanque  + "\n"
                + " IPVA: " + String.format("%.2f", this.calculaIPVA())  + "\n"
                + " Seguro" + String.format("%.2f", this.calculaSeguro() )
                + " Combustíveis compatíveis: Gasolina"  + "\n");
    }

    @Override
    public void imprimeDadosVeiculoConsole() {
        System.out.println("Furgão    : Placa: " + this.placa + " - "
                + "\nValor de venda: " + String.format("%.2f", this.valorVenda) + ";"
                + "\n   Kilometros rodados: " + String.format("%.2f",  kmRodados() ) + " - "
                + "\n   Gasto alinhamento: " + (calculaAlinhamento()) + " - "
                + "\n   Gasto vistoria: " + (calculaVistoria()) + " - "
                + "\n   Gasto combustivel: " + String.format("%.2f",  gastoCombustivel()) + " - "
                + "\nGastos Variáveis Total: " + String.format("%.2f",  gastoVariavelTotal() ) + " - "
                + "\nTotal gastos: " + String.format("%.2f",  gastoTotalacumulado()));
    }

    @Override
    public String escreveVeiculoArquivo() {
        String salvaParaArquivo = "Furgao;"
                + this.placa + ";"
                + this.valorVenda;
        return salvaParaArquivo;
    }

    @Override
    public void imprimeVeiculoPlaca() {
        System.out.println("Furgão       : Placa: " + this.placa + " - "
        + " Capacidade Tanque: " + this.tanque + " - ");
    }

}
