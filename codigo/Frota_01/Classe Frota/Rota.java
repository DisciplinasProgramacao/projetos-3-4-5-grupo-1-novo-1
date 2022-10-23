public class Rota {
    private static int sequencia = 0;
    int idRota = 0;
    Data DtProducao;
    double distancia = 0;
    Veiculo veiculoRota;

    public Rota() {
    }

    // public Rota(Veiculo VeiculoRota, int KmRota, Data DtProducao) {} // colocar
    // Veiculo em Frota?

    public Rota(double distancia, Data DtProducao, Veiculo veiculo) {
        this.idRota = sequencia++;
        this.distancia = distancia;
        this.DtProducao = DtProducao;
        this.veiculoRota = veiculo;
    }

    public void imprimeRota() {
        System.out.println("Rota número: " + this.idRota + "Data Produção da rota" +
                this.DtProducao.getDiaSemana() + "-" + this.DtProducao.getDiaAno() + "/" + this.DtProducao.getMes()
                + "/" + this.DtProducao.getAno());

    }

}
