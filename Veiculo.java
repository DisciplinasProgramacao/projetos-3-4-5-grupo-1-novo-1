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
        this.custoFixoAnual = calculaIPVA() + calculaSeguro();
    }

    public void addRota(Rota rota) {
        this.rotas.add(rota);
    }

    public double kmRodados() {
        double kmRodados = 0;
        for (Rota rota : rotas) {

            kmRodados += rota.distancia;
        }
        return kmRodados;
    }

    public String getPlaca() {
        return this.placa;

    }

    public int getTanque(){

        return this.tanque;
    }

    public abstract double calculaIPVA();

    public abstract double calculaSeguro();

    public abstract double custoPorKm();

    public abstract void imprimeVeiculoConsole();

    public abstract void imprimeDadosVeiculoConsole();

    public abstract String escreveVeiculoArquivo();

}
