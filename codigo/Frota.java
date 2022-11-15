import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Frota {

    protected static List<Veiculo> veiculos = new ArrayList<Veiculo>();

    public static void incluirVeiculo(Veiculo veiculoIncluir) {
        veiculos.add(veiculoIncluir);
        // return veiculos.get(veiculos.size() - 1);
    }

    public Frota() {
    };

    public static Veiculo localizarVeiculo(String placaProcurar) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca().compareTo(placaProcurar) == 0) {
                veiculo.imprimeVeiculoConsole();
                return veiculo;
            }
        }
        return null;
    }

    public static int imprimeVeiculosFrota() {
        veiculos.forEach(veiculo -> {veiculo.imprimeVeiculoPlaca();});
        return Frota.veiculos.size();
    }

    public int imprimeVeiculosPlaca() {
        veiculos.forEach(veiculo -> {veiculo.imprimeVeiculoConsole();});
        return Frota.veiculos.size();
    }

    public static void salvaVeiculosFrota(String nomeArquivo) {

        File arquivo = new File(nomeArquivo);
        try {
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }

            FileWriter arqEscrita = new FileWriter(arquivo, false);
            BufferedWriter escritor = new BufferedWriter(arqEscrita);

            for (Veiculo veiculo : veiculos) {
                // veiculo.imprimeVeiculoConsole();
                escritor.write(veiculo.escreveVeiculoArquivo());
                escritor.newLine();
            }
            escritor.close();
            arqEscrita.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * @param localArquivo
     * @param virtual
     *                     Recebe String do local do arquivo que contém lista de
     *                     Veiculos para leitura e
     *                     endereço da Frota para adicioná-lo.
     *                     Retorna Frota contendo os Veiculos lidos do arquivo txt
     * @return
     */
    public static void carregarVeiculosArquivo(String localArquivo) {

        Scanner entrada;
        Veiculo novoVeiculo = null;

        String linhaLida;
        String[] veiculoLido;

        try {
            entrada = new Scanner(new FileReader(localArquivo));
            while (entrada.hasNextLine()) {

                linhaLida = entrada.nextLine();
                System.out.println(linhaLida);
                veiculoLido = linhaLida.split(";");
                switch (veiculoLido[0]) {

                    case ("Carro"):
                        novoVeiculo = new Carro(veiculoLido[1], Double.parseDouble(veiculoLido[2]));

                        break;

                    case ("Van"):
                        novoVeiculo = new Van(veiculoLido[1], Double.parseDouble(veiculoLido[2]));

                        break;

                    case ("Furgao"):
                        novoVeiculo = new Furgao(veiculoLido[1], Double.parseDouble(veiculoLido[2]));

                        break;

                    case ("Caminhao"):
                        novoVeiculo = new Caminhao(veiculoLido[1], Double.parseDouble(veiculoLido[2]));

                        break;
                }
                Frota.veiculos.add(novoVeiculo);

            }
            entrada.close();

        } catch (

        FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
