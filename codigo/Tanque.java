public class Tanque {
    private Combustivel combustivel;
    private double capacidade;
    private double litragemAtual;

    public Tanque(double capacidade) {
        this.capacidade = capacidade;
        this.litragemAtual = 0;
    }   

    public double completarTanque(Combustivel combustivel) {
        double litrosAdicionados = (this.capacidade - this.litragemAtual);
        this.litragemAtual = capacidade;
        this.combustivel = combustivel;
        return litrosAdicionados;
    }

    public void reduzirTanque(double distancia) {
        this.litragemAtual -= (distancia / combustivel.consumo);
    }

    public Combustivel getCombustivel() {
        return combustivel;
    }

    public double getCapacidade() {
        return capacidade;
    }
}
