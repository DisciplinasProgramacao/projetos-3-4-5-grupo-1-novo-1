import java.util.ArrayList;

public abstract class Veiculo {
    protected String placa;
    protected double valorVenda;
    protected int tanque;
    protected double custosEsporadicos;
    protected double kilometragemTotal;
    protected Combustivel combustivelAtual;
    protected ArrayList<Combustivel> tiposCombustivel = new ArrayList<Combustivel>();
    protected ArrayList<Rota> rotas = new ArrayList<Rota>();

    public Veiculo() {};

    public Veiculo(String placa, double valorVenda) {
        this.placa = placa;
        this.valorVenda = valorVenda;
        this.kilometragemTotal = 0;
    }

    public boolean addRota(Rota rota) {
        if((rota.getDistancia() > autonomiaMaxima()) && tanqueSuficiente(rota.getDistancia())){
            this.rotas.add(rota);
            this.tanque -= (rota.getDistancia() / this.combustivelAtual.getConsumo());
            kmRodados();
            return true;
        }
        else{return false;}
    }

    public double kmRodados() {
        double kmRodados = 0;
        for (Rota rota : rotas) {
            kmRodados += rota.getDistancia();
        }
        this.kilometragemTotal = kmRodados;
        return this.kilometragemTotal;
    }

    public boolean tanqueSuficiente(double distanciaRota){
        double autonomiaAtual = this.combustivelAtual.getConsumo() * this.tanque;
        if(autonomiaAtual < distanciaRota){
            return false;
        }
        else{return true;}
    }

    public double custosEsporadicos(double valor){
        this.custosEsporadicos += valor;
        return this.custosEsporadicos;
    }

    public double gastoVariavelTotal() {
        double gastoPorKM = gastoCombustivel() + outrosCustos() + this.custosEsporadicos;
        return gastoPorKM;
    }

    public double gastoCombustivel(){
        return (this.combustivelAtual.getPreco() * ( kmRodados() / this.combustivelAtual.getConsumo()));
    }

    public double custoFixoAnual() {
        return calculaIPVA() + calculaSeguro();
    }

    public double gastoTotalacumulado() {
        return gastoVariavelTotal() + custoFixoAnual();

    }

    public void exibirTiposCombustivel() {
        for ( Combustivel combustivel : tiposCombustivel) {
            System.out.printf("\n" + combustivel.getIdentificador() +") " + combustivel.descricao);
        } 
    }

    public String getPlaca() {
        return this.placa;
    }

    public int getTanque(){
        return this.tanque;
    }

    public abstract double autonomiaMaxima();
    
    public abstract boolean abastecer(int tipoCombustivel);

    public abstract double calculaIPVA();

    public abstract double calculaSeguro();
    
    public abstract double outrosCustos();

    public abstract void imprimeVeiculoConsole();

    public abstract void imprimeDadosVeiculoConsole();

    public abstract String escreveVeiculoArquivo();

    public void imprimeVeiculoPlaca() {
    }

}
