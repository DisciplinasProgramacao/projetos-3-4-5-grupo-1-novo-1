import java.util.ArrayList;

public abstract class Veiculo {
    protected String placa;
    protected double valorVenda;
    protected int tanque;
    protected double custoFixoAnual;
    protected double custoVariavel;
    protected double outrosCustos;
    protected double kilometragemTotal;
    protected Combustivel combustivelAtual;
    protected ArrayList<Combustivel> tiposCombustivel = new ArrayList<Combustivel>();
    protected ArrayList<Rota> rotas = new ArrayList<Rota>();

    public Veiculo() {};

    public Veiculo(String placa, double valorVenda) {
        this.placa = placa;
        this.valorVenda = valorVenda;
        this.custoFixoAnual = custoFixoAnual();
        this.kilometragemTotal = 0;
    }

    public void addRota(Rota rota) {
        this.rotas.add(rota);
    }

    public double kmRodados() {
        double kmRodados = 0;
        for (Rota rota : rotas) {
            kmRodados += rota.distancia;
        }
        this.kilometragemTotal = kmRodados;

        return this.kilometragemTotal;
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

    public String getPlaca() {
        return this.placa;
    }

    public int getTanque(){
        return this.tanque;
    }

    public boolean tanqueSuficiente(double distanciaRota){

        double autonomiaAtual = this.combustivelAtual.getConsumo() * this.tanque;

        if(autonomiaAtual < distanciaRota){
            return false;
        }
        else{return true;}
    }

    public abstract boolean abastecer(int tipoCombustivel);

    public abstract double calculaIPVA();

    public abstract double calculaSeguro();
    
    public abstract double custoPorKm();

    public abstract void imprimeVeiculoConsole();

    public abstract void imprimeDadosVeiculoConsole();

    public abstract String escreveVeiculoArquivo();

    public void imprimeVeiculoPlaca() {
    }

}
