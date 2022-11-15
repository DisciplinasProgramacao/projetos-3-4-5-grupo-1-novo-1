import java.util.ArrayList;
import java.util.List;

public abstract class Veiculo {
    protected String placa;
    protected double valorVenda;
    protected int tanque;
    protected double custosEsporadicos;
    protected double kilometragemTotal;
    protected Combustivel combustivelAtual;
    protected List<Combustivel> tiposCombustivel = new ArrayList<Combustivel>();
    protected List<Rota> rotas = new ArrayList<Rota>();

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
        tiposCombustivel.forEach(combustivel -> {System.out.printf("\n" + combustivel.getDescricao());});
    }

    public String getPlaca() {
        return this.placa;
    }

    public int getTanque(){
        return this.tanque;
    }

    /**
     * Método abstrato implementado nas classes filhas de veículo calcula a autonomia máxima de um veículo basedo em seu tanque completo com o combustível atual
     * @return Double com o valor máximo de autonomia em km
     */
    public abstract double autonomiaMaxima();
    
    /**
     * Método abstrato implementado nas classes filhas de veículo booleano para verificar se foi possível abastecer o tanque do veículo com o combustível informado. O tanque é abastecido
     * até sua capacidade máxima
     * @param tipoCombustivel Inteiro relacionado ao identificador do combustível, sendo 1 para gasolina, 2 para etanol e 3 para diesel
     * @return Retorna TRUE caso tenha abastecido, retorna FALSE caso contrário
     */
    public abstract boolean abastecer(int tipoCombustivel);

    /**
     * Método abstrato implementado nas classes filhas de veículo retorna um valor double com o total pago anualmente de IPVA
     * @return Valor total IPVA
     */
    public abstract double calculaIPVA();

    /**
     * Método abstrato implementado nas classes filhas de veículo retorna um valor double com o total pago anualmente de seguro
     * @return Valor total seguro
     */
    public abstract double calculaSeguro();
    
    /**
     * Método abstrato implementado nas classes filhas de veículo retorna um valor double com o total pago em manutenções, com base a quilometragem percorrida pelo veículo
     * @return
     */
    public abstract double outrosCustos();

    /**
     * Método abstrato implementado nas classes filhas de veículo que imprime dados básicos do veículo no console
     */
    public abstract void imprimeVeiculoConsole();

    /**
     * Método abstrato implementado nas classes filhas de veículo que imprime dados do veículo no console, incluindo os custos
     */
    public abstract void imprimeDadosVeiculoConsole();

    /**
     * Método abstrato implementado nas classes filhas de veículo que escreve os dados referentes ao veículo em um arquivo, sendo estes a placa e o valor de venda
     * @return
     */
    public abstract String escreveVeiculoArquivo();

    /**
     * Método abstrato implementado nas classes filhas de veículo que imprime a placa do veículo e capacidade atual do tanque
     */
    public void imprimeVeiculoPlaca() {
    }
}
