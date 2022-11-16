
public class Caminhao extends Veiculo {
    private static final int MANUTENCAO = 20000;
    private static final int PRECO_MANUTENCAO = 1000;
    private static final int PRECO_VISTORIA = 1000;
     private static final double IPVA = 0.01d;
    private static final int VISTORIA = 30000;
    private static final double SEGURO = 0.02d;
    private final int TANQUE_COMPLETO = 250;
    private double custosEsporadico = 0;

    public Caminhao(String placa, double valorVenda) {
        
        super(placa, valorVenda);
        this.tiposCombustivel.add(Combustivel.DIESEL);
        this.autonomiaMaxima = getAutonomiaMaxima();
        this.autonomiaAtual =  this.autonomiaMaxima;
    }

    public Caminhao() {
    }

    public double getAutonomiaMaxima() {
        double maiorAutonomia = 0;
        for (Combustivel consumo : tiposCombustivel) {
            if (consumo.getConsumo() > maiorAutonomia) {
                maiorAutonomia = consumo.getConsumo();
            }
        }
        return maiorAutonomia * TANQUE_COMPLETO;
    }

    public void calculaCustoFixo() {
        custoFixo = calculaIPVA() + calculaSeguro();
    }

    public double calculaIPVA() {
        return valorVenda * IPVA;
    }

    public double calculaSeguro() {
        return valorVenda * SEGURO;
    }

    public void calculaCustoVariavel() {
        custoVariavel = calculaManutencao() + calculaVistoria() + custosEsporadico;
    }

    public int calculaManutencao() {
        int manutencao = (int)(this.kilometragemTotal/MANUTENCAO);
        return (manutencao * PRECO_MANUTENCAO);
    }

    public int calculaVistoria() {
        int vistoria = (int)(this.kilometragemTotal/VISTORIA);
        return (vistoria * PRECO_VISTORIA);
    }

    public void atualizaCustos() {
        custoFixo = calculaIPVA() + calculaSeguro();
        custoVariavel = calculaManutencao() + calculaVistoria();
    }



    @Override
    public boolean abastecer(int tipoCombustivel) {
        if (tipoCombustivel == 1) {
            autonomiaAtual = TANQUE_COMPLETO * tiposCombustivel.get(1).consumo;
            return true;
        }
        if (tipoCombustivel == 2) {
            autonomiaAtual = TANQUE_COMPLETO * tiposCombustivel.get(2).consumo;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void imprimeVeiculoConsole() {
        System.out.println("Caminhão: Placa: " + placa + " - "
                + " Valor de venda: " + String.format("%.2f", valorVenda) + "\n"
                + " Capacidade Tanque: " + TANQUE_COMPLETO + "\n"
                + " IPVA: " + String.format("%.2f", calculaIPVA()) + "\n"
                + " Seguro + Taxa: " + String.format("%.2f", calculaSeguro()) + "\n"
                + " Combustíveis compatíveis: Gasolina e Etanol" + "\n");
    }

    @Override
    public void imprimeDadosVeiculoConsole() {
        System.out.println("Caminhao: Placa: " + placa + " - "
                + "\nValor de venda: " + String.format("%.2f", valorVenda) + ";"
                + "\n Quilometros rodados: " + String.format("%.2f", kilometragemTotal) + " - "
                + "\nGastos Fixos: " + String.format("%.2f", custoFixo) + " - "
                + "\nGastos Variáveis: " + String.format("%.2f", custoVariavel));
    }

    @Override
    public String escreveVeiculoArquivo() {
        String salvaParaArquivo = "Caminhao;"
                + this.placa + ";"
                + this.valorVenda;
        return salvaParaArquivo;
    }

    @Override
    public void imprimeVeiculoPlaca() {
        System.out.print("Caminhão: Placa: " + this.placa + " - "
                + " Autonomia atual: " + this.autonomiaAtual + " - "
                + " Autonomia Máxima:");
        for (Combustivel combustivel : tiposCombustivel) {
            System.out.print(" " + combustivel.getDescricao() + "=" + this.TANQUE_COMPLETO * combustivel.getConsumo());
        }
        System.out.println();
    }
}
