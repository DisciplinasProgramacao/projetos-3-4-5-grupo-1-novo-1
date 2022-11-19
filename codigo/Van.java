
public class Van extends Veiculo {
    private static final int ALINHAMENTO = 100;
    private static final int PRECO_ALINHAMENTO = 120;
    private static final int PRECO_VISTORIA = 500;
    private static final double IPVA = 0.03;
    private static final int VISTORIA = 10000;
    private static final double SEGURO = 0.03;
    private final int TANQUE_COMPLETO = 60;
    private double custosEsporadico = 0;


    public Van(String placa, double valorVenda) {
        super(placa, valorVenda);
        this.tiposCombustivel.add(Combustivel.GASOLINA);
        this.tiposCombustivel.add(Combustivel.DIESEL);
        this.autonomiaMaxima = getAutonomiaMaxima();
        this.autonomiaAtual =  this.autonomiaMaxima;
    }

    public Van() {
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

 

    public double calculaIPVA() {
        return valorVenda * IPVA;
    }

    public double calculaSeguro() {
        return valorVenda * SEGURO;
    }
  

    public int calculaAlinhamento() {
        int alinhamento = (int) (kilometragemTotal / ALINHAMENTO);
        return (alinhamento * PRECO_ALINHAMENTO);
    }

    public int calculaVistoria() {
        int vistoria = (int)(this.kilometragemTotal/VISTORIA);
        return (vistoria * PRECO_VISTORIA);
    }
    @Override
    public Double calculaCustoFixo() {
        return custoFixo = calculaIPVA() + calculaSeguro();
    }

    @Override
    public Double calculaCustoVariavel() {
        return custoVariavel = calculaAlinhamento() + calculaVistoria() + custosEsporadico;
    }
    @Override
    public void atualizaCustos() {
        super.custoFixo = calculaIPVA() + calculaSeguro();
        super.custoVariavel = calculaAlinhamento() + calculaVistoria();
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
        System.out.println("Van     : Placa: " + placa + " - "
                + " Valor de venda: " + String.format("%.2f", valorVenda) + "\n"
                + " Capacidade Tanque: " + TANQUE_COMPLETO + "\n"
                + " IPVA: " + String.format("%.2f", calculaIPVA()) + "\n"
                + " Seguro + Taxa: " + String.format("%.2f", calculaSeguro()) + "\n"
                + " Combustíveis compatíveis: Gasolina e Etanol" + "\n");
    }

    @Override
    public void imprimeDadosVeiculoConsole() {
        System.out.println("Van     : Placa: " + placa + " - "
                + "\nValor de venda: " + String.format("%.2f", valorVenda) + ";"
                + "\n Quilometros rodados: " + String.format("%.2f", kilometragemTotal) + " - "
                + "\nGastos Fixos: " + String.format("%.2f", custoFixo) + " - "
                + "\nGastos Variáveis: " + String.format("%.2f", custoVariavel));
    }

    @Override
    public String escreveVeiculoArquivo() {
        String salvaParaArquivo = "Van;"
                + this.placa + ";"
                + this.valorVenda;
        return salvaParaArquivo;
    }

    @Override
    public void imprimeVeiculoPlaca() {
        System.out.print("Van     : Placa: " + this.placa + " - "
                + " Autonomia atual: " + this.autonomiaAtual + " - "
                + " Autonomia Máxima:");
        for (Combustivel combustivel : tiposCombustivel) {
            System.out.print(" " + combustivel.getDescricao() + "=" + this.TANQUE_COMPLETO * combustivel.getConsumo());
        }
        System.out.println();
    }
}
