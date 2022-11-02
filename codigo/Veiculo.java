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

    /**
     * Construtor da classe abstrata Veiculo, recebe a placa identificadora do carro e o seu valor de venda por parâmetro 
     * @param placa String contendo a placa do carro
     * @param valorVenda Double com o valor de venda paga na aquisição do carro
     */
    public Veiculo(String placa, double valorVenda) {
        this.placa = placa;
        this.valorVenda = valorVenda;
        this.kilometragemTotal = 0;
    }

    /**
     * Método booleano para adição de rota. Valida se a rota desejada pode ser atribuída ao veiculo com base na autonomia do 
     * combustível atual e na capacidade máxima do tanque
     * @param rota Onjeto da classe Rota
     * @return Retorna TRUE caso a rota tenha sido adicionada, retorna FALSE caso contrário
     */
    public boolean addRota(Rota rota) {
        if((rota.getDistancia() > autonomiaMaxima()) && tanqueSuficiente(rota.getDistancia())){
            this.rotas.add(rota);
            this.tanque -= (rota.getDistancia() / this.combustivelAtual.getConsumo());
            kmRodados();
            return true;
        }
        else{return false;}
    }

    /**
     * Método retorna um valor double com a quilometragem total percorrida pelo veiculo
     * @return
     */
    public double kmRodados() {
        double kmRodados = 0;
        for (Rota rota : rotas) {
            kmRodados += rota.getDistancia();
        }
        this.kilometragemTotal = kmRodados;
        return this.kilometragemTotal;
    }

    /**
     * Método booleano para verificar se a quantidade de combustível prensente no tanque é suficiente para uma rota
     * @param distanciaRota Double com a distância da rota que deseja validar se a capacidade do tanque atende
     * @return Retorna TRUE caso a quantidade de combustível seja suficiente, retorna FALSE caso contrário
     */
    public boolean tanqueSuficiente(double distanciaRota){
        double autonomiaAtual = this.combustivelAtual.getConsumo() * this.tanque;
        if(autonomiaAtual < distanciaRota){
            return false;
        }
        else{return true;}
    }

    /**
     * Método adiciona um valor double para compor o total gasto em custos esporadicos
     * @param valor Double com o valor do novo gasto esporadico
     * @return Retorna um valor double com o total de gastos esporadicos até o momento
     */
    public double addCustosEsporadicos(double valor){
        this.custosEsporadicos += valor;
        return this.custosEsporadicos;
    }

    /**
     * Método retorna um double com o total gasto em custos variáveis, como combustíveis, manutenções e necessidades esporadicas
     * @return Retorna um double com o total gasto
     */
    public double gastoVariavelTotal() {
        double gastoVar = gastoCombustivel() + outrosCustos() + this.custosEsporadicos;
        return gastoVar;
    }

    /**
     * Método retorna um double com o total gasto em combustível, tendo em base o combustível atual no carro
     * @return Retorna um double com o total gasto
     */
    public double gastoCombustivel(){
        return (this.combustivelAtual.getPreco() * ( kmRodados() / this.combustivelAtual.getConsumo()));
    }

    /**
     * Método retorna um double com o total gasto em custos anuais, como por exemplo o IPVA e Seguro do veículo
     * @return Retorna um double com o total gasto de IPVA e Seguro no ano
     */
    public double custoFixoAnual() {
        return calculaIPVA() + calculaSeguro();
    }

    /**
     * Método retorna um double com o total gasto ao longo do ano com o veículo
     * @return Retorna um double com o total gasto
     */
    public double gastoTotalacumulado() {
        return gastoVariavelTotal() + custoFixoAnual();
    }

    /**
     * Método exibe todos os combustíveis suportados pelo veículo
     */
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

    /**
     * Método calcula a autonomia máxima de um veículo basedo em seu tanque completo com o combustível atual
     * @return Double com o valor máximo de autonomia em km
     */
    public abstract double autonomiaMaxima();
    
    /**
     * 
     * @param tipoCombustivel
     * @return
     */
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
