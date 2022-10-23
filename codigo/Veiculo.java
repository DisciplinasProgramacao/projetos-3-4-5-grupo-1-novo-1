import java.util.ArrayList;

public abstract class Veiculo {
    protected String placa;
    protected double valorVenda;
    protected int tanque;
    protected double custoFixoAnual;
    protected double custoVarKm;
    protected ArrayList<Rota> rotas = new ArrayList<Rota>();

    public Veiculo() {
    };

    public Veiculo(String placa, double valorVenda) {
        this.placa = placa;
        this.valorVenda = valorVenda;
        this.tanque = getTanque();
        this.custoFixoAnual = getIPVA() + getSeguro();
    }

    public void addRota(Rota rota) {
        this.rotas.add(rota);
    }

    public String getPlaca() {
        return this.placa;

    }

    public double kmRodados() {
        double kmRodados = 0;
        for (Rota rota : rotas) {

            kmRodados += rota.distancia;
        }
        return kmRodados;
    }

    public abstract int getTanque();

    public abstract double getIPVA();

    public abstract double getSeguro();

    public abstract void imprimeVeiculoConsole();

    public abstract void imprimeDadosVeiculoConsole();

    public abstract String escreveVeiculoArquivo();

}
