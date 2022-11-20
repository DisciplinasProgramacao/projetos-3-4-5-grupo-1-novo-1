public class Rota {
    private static int sequencia = 1;
    private int idRota = 0;
    private String descHash;
    private Data dtProducao;
    private double distancia = 0;
    private Veiculo veiculoRota;

    public Rota() {
    }

    public Rota(double distancia, Data dtProducao, Veiculo veiculoParaRota) {
        this.idRota = sequencia++;
        this.distancia = distancia;
        this.dtProducao = dtProducao;
        this.veiculoRota = veiculoParaRota;
        this.veiculoRota.kilometragemTotal += distancia;
        this.veiculoRota.calculaCustoVariavel();
        concatenarHash();
    }

    private void concatenarHash(){
        String data, placa, dist;
        int intAno;

        intAno = Data.diaAno(this.dtProducao.getDia(), this.dtProducao.getMes(), this.dtProducao.getAno());
        data = String.valueOf(intAno);
        placa = this.veiculoRota.getPlaca();
        dist = String.valueOf(this.getDistancia());
        this.descHash = data.concat(dist).concat(placa).concat(data);
    }

    public String getDescHash() {
        return descHash;
    }

    public boolean verificaDataPeriodo(Data dtInicio, Data dtFinal) {
        return  Data.verificaDataPeriodo(dtProducao, dtInicio,  dtFinal);
    }

    public void imprimeRota() {
        System.out.println("Rota número: " + this.idRota + " Data Produção da rota: " +
            this.dtProducao.getDiaSemana() + " " + this.dtProducao.getDia() + "/" + this.dtProducao.getMes()
            + "/" + this.dtProducao.getAno());
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
     * @return Data return the dtProducao
     */
    public Data getdtProducao() {
        return dtProducao;
    }

    /**
     * @param dtProducao the dtProducao to set
     */
    public void setdtProducao(Data dtProducao) {
        this.dtProducao = dtProducao;
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

    @Override
    public boolean equals(Object obj) {
        Rota outro = (Rota)obj;
        return this.descHash.equals(outro.descHash);
    }

    @Override
    public int hashCode() {
        return this.descHash.hashCode();
    }


    public String escreveRotaArquivo() {
        String salvaParaArquivo = 
                + this.distancia + ";"
                + this.dtProducao.getDia() + "/" + this.dtProducao.getMes() + "/" + this.dtProducao.getAno()+ ";"
                + this.veiculoRota.getPlaca();
        return salvaParaArquivo;
    }
}