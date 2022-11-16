public class Rota {
    private static int sequencia = 1;
    private int idRota = 0;
    private Data DtProducao;
    private double distancia = 0;
    private Veiculo veiculoRota;

    public Rota() {
    }

    public Rota(double distancia, Data DtProducao, Veiculo veiculoParaRota) {
        this.idRota = sequencia++;
        this.distancia = distancia;
        this.DtProducao = DtProducao;
        this.veiculoRota = veiculoParaRota;
    }



  //  public  double consumoRota(Combustivel combustivel) {
  //      return  distancia * combustivel.consumo;
  //  }


    public void imprimeRota() {
        System.out.println("Rota número: " + this.idRota + " Data Produção da rota: " +
                this.DtProducao.getDiaSemana() + " " + this.DtProducao.getDia() + "/" + this.DtProducao.getMes()
                + "/" + this.DtProducao.getAno());
    }

    public double getDistancia() {
        return distancia;
    }

    /**
     * @return int return the idRota
     */
    public int getIdRota() {
        return idRota;
    }

    /**
     * @param idRota the idRota to set
     */
    public void setIdRota(int idRota) {
        this.idRota = idRota;
    }

    /**
     * @return Data return the DtProducao
     */
    public Data getDtProducao() {
        return DtProducao;
    }

    /**
     * @param DtProducao the DtProducao to set
     */
    public void setDtProducao(Data DtProducao) {
        this.DtProducao = DtProducao;
    }

    /**
     * @param distancia the distancia to set
     */
    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }


    public Veiculo getVeiculoRota() {
        return veiculoRota;
    }


    public String escreveRotaArquivo() {
        String salvaParaArquivo = 
                + this.distancia + ";"
                + this.DtProducao.getDia() + "/" + this.DtProducao.getMes() + "/" + this.DtProducao.getAno()+ ";"
                + this.veiculoRota.getPlaca();
        return salvaParaArquivo;
    }
}