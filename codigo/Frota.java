import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Frota {

    protected ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
    protected LinkedList<Rota> rotas = new LinkedList<Rota>();

    public Frota() {
    };

    public Veiculo retornaVeiculoPelaPlaca(String placaProcurar) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca().equals(placaProcurar)) {
                return veiculo;
            }
        }
        return null;
    }

    /**
     * Método booleano para adição de rota. Valida se a rota desejada pode ser
     * atribuída ao veiculo com base na autonomia do
     * combustível atual e na capacidade máxima do tanque
     * 
     * @param rota Objeto da classe Rota
     * @return Retorna TRUE caso a rota tenha sido adicionada, retorna FALSE caso
     *         contrário
     */

    public boolean addRota(Rota rota, Veiculo veiculoParaRota) {

        rotas.add(rota);
        veiculoParaRota.autonomiaAtual -= rota.getDistancia();
        veiculoParaRota.kilometragemTotal += rota.getDistancia();
        veiculoParaRota.calculaCustoVariavel();
        return true;
    }

    public int imprimeVeiculosparaRota(double distancia) {

        List<Veiculo> ListaVeiculosRota = veiculos.stream()
                .filter(veiculos -> veiculos.getAutonomiaMaxima() >= distancia)
                .collect(Collectors.toList());
        ListaVeiculosRota.forEach(s -> s.imprimeVeiculoPlaca());

        if (ListaVeiculosRota.size() > 0) {
            return ListaVeiculosRota.size();
        } else {
            Optional<Veiculo> maiorAutonomia = ListaVeiculosRota
                    .stream()
                    .max(Comparator.comparing(V -> V.getAutonomiaMaxima()));
            System.out.println("não tem carro");
        }
        return ListaVeiculosRota.size();
    }

    public Double quilometragemMediaRotas() {
        double media = rotas.stream()
                .mapToDouble(rota -> rota.getDistancia())
                .average()
                .getAsDouble();
        return media;
    }

    public void veiculosComMaisRotas() {

        Map<Veiculo, Long> agrupaRotas = rotas.stream()
                .collect(Collectors.groupingBy(Rota::getVeiculoRota, Collectors.counting()));
        System.out.println(agrupaRotas.values().toString());

    }

    public void custoVeiculoDescres() {

        List<Veiculo> veiculosOrenados = veiculos.stream()
                .sorted(Comparator.comparingDouble(Veiculo::retornaCustoTotal).reversed())
                .collect(Collectors.toList());
        veiculosOrenados.forEach(v -> v.imprimeVeiculoCustos());
    }

    public void rotasEntreDatas(Data inicial, Data fim) {
        if (inicial.getDiaAno() < fim.getDiaAno()) {
            List<Rota> ListaVeiculosRota = rotas.stream()
                    .filter(rotas -> rotas.verificaDataPeriodo(inicial, fim))
                    .collect(Collectors.toList());
            ListaVeiculosRota.forEach(r -> r.imprimeRota());
        }
    }

    public void salvaVeiculosFrota(String nomeArquivo) {

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
    public void carregarVeiculosArquivo(String localArquivo) {

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
                veiculos.add(novoVeiculo);

            }
            entrada.close();

        } catch (

        FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void salvaRotasFrota(String nomeArquivo) {

        File arquivo = new File(nomeArquivo);
        try {
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }

            FileWriter arqEscrita = new FileWriter(arquivo, false);
            BufferedWriter escritor = new BufferedWriter(arqEscrita);

            for (Rota rota : rotas) {
                // veiculo.imprimeVeiculoConsole();
                escritor.write(rota.escreveRotaArquivo());
                escritor.newLine();
            }

            escritor.close();
            arqEscrita.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void carregarRotasArquivo(String localArquivo) {

        Scanner entrada;
        String linhaLida;
        String[] rotaLida;

        try {
            entrada = new Scanner(new FileReader(localArquivo));
            while (entrada.hasNextLine()) {

                linhaLida = entrada.nextLine();
                System.out.println(linhaLida);
                rotaLida = linhaLida.split(";");
                Rota novaRota = new Rota(Double.parseDouble(rotaLida[0]), Data.verificaData(rotaLida[1]),
                        retornaVeiculoPelaPlaca(rotaLida[2]));

                rotas.add(novaRota);
            }
            entrada.close();

        } catch (

        FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
