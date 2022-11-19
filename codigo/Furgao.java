
public class Furgao extends Veiculo {
    private static final int ALINHAMENTO = 100;
    private static final int PRECO_ALINHAMENTO = 120;
    private static final int PRECO_VISTORIA = 500;
    private static final double IPVA = 0.03d;
    private static final double VISTORIA = 10000d;
    private static final double SEGURO = 0.03d;
    private final int TANQUE_COMPLETO = 80;
    private double custosEsporadico = 0;

    public Furgao(String placa, double valorVenda) {

        super(placa, valorVenda);
        this.tiposCombustivel.add(Combustivel.GASOLINA);
        this.autonomiaMaxima = getAutonomiaMaxima();
        this.autonomiaAtual = this.autonomiaMaxima;
    }

    public Furgao() {
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

    public Double calculaCustoFixo() {
        return custoFixo = calculaIPVA() + calculaSeguro();
    }

    public double calculaIPVA() {
        return valorVenda * IPVA;
    }

    public double calculaSeguro() {
        return valorVenda * SEGURO;
    }

    public Double calculaCustoVariavel() {
        return custoVariavel = calculaAlinhamento() + calculaVistoria() + custosEsporadico;
    }

    public int calculaAlinhamento() {
        int alinhamento = (int) (kilometragemTotal / ALINHAMENTO);
        return (alinhamento * PRECO_ALINHAMENTO);
    }

    public int calculaVistoria() {
        int vistoria = (int) (this.kilometragemTotal / VISTORIA);
        return (vistoria * PRECO_VISTORIA);
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

    public void atualizaCustos() {
        custoFixo = calculaIPVA() + calculaSeguro();
        custoVariavel = calculaAlinhamento() + calculaVistoria();
      }

    public void imprimeVeiculoConsole() {
        System.out.println("Furgão    : Placa: " + placa + " - "
                + " Valor de venda: " + String.format("%.2f", valorVenda) + "\n"
                + " Capacidade Tanque: " + TANQUE_COMPLETO + "\n"
                + " IPVA: " + String.format("%.2f", calculaIPVA()) + "\n"
                + " Seguro + Taxa: " + String.format("%.2f", calculaSeguro()) + "\n"
                + " Combustíveis compatíveis: Gasolina e Etanol" + "\n");
    }

    public void imprimeDadosVeiculoConsole() {
        System.out.println("Furgão    : Placa: " + placa + " - "
                + "\nValor de venda: " + String.format("%.2f", valorVenda) + ";"
                + "\n Quilometros rodados: " + String.format("%.2f", kilometragemTotal) + " - "
                + "\nGastos Fixos: " + String.format("%.2f", custoFixo) + " - "
                + "\nGastos Variáveis: " + String.format("%.2f", custoVariavel));
    }

    public String escreveVeiculoArquivo() {
        String salvaParaArquivo = "Furgao;"
                + this.placa + ";"
                + this.valorVenda;
        return salvaParaArquivo;
    }

    public void imprimeVeiculoPlaca() {
        System.out.print("Furgão  : Placa: " + this.placa + " - "
                + " Autonomia atual: " + this.autonomiaAtual + " - "
                + " Autonomia Máxima:");
        for (Combustivel combustivel : tiposCombustivel) {
            System.out.print(" " + combustivel.getDescricao() + "=" + this.TANQUE_COMPLETO * combustivel.getConsumo());
        }
        System.out.println();
    }

   
}
