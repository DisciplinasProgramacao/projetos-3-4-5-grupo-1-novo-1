public class Rota {
    private static int sequencia = 0;
    private int idRota = 0;
    private Data DtProducao;
    private double distancia = 0;
    private Veiculo veiculoRota;

    public Rota() {
    }

    public Rota(double distancia, Data DtProducao, Veiculo veiculo) {
        this.idRota = sequencia++;
        this.distancia = distancia;
        this.DtProducao = DtProducao;
    }

    public void imprimeRota() {
        System.out.println("Rota número: " + this.idRota + "Data Produção da rota" +
                this.DtProducao.getDiaSemana() + "-" + this.DtProducao.getDiaAno() + "/" + this.DtProducao.getMes()
                + "/" + this.DtProducao.getAno());
    }

    public double getDistancia() {
        return distancia;
    }
}
