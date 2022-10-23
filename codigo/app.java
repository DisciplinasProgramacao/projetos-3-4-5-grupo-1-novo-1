import java.util.Scanner;

public class app {

    public static void main(String[] args) throws Exception {
        Scanner obj = new Scanner(System.in);
        String localPadraoCarregar = "C:/FROTA/Veiculos_ler.txt";
        String localPadraoSalvar = localPadraoCarregar; //"C:/FROTA/ListaVeiculosSalvos.txt";
        Frota virtual = new Frota();
        Veiculo veiculoLocalizar = null;
        String placaVeiculo;
        Rota novaRota = null;
        double kmRota = 0;
        Data dtProducao = null;

        String opcao = "";

        opcao = menu(opcao);

        while (opcao != "F") {

            switch (opcao) {

                case "1":

                    System.out.println("Carregar um conjunto de veículos de um arquivo:\n");
                    System.out.println("Carregando lista de veiculos em: " + localPadraoCarregar);
                    virtual.carregarVeiculosArquivo(localPadraoCarregar, virtual);
                   virtual.imprimeVeiculosFrota();
                    opcao = menu(opcao);
                    break;
                case "2":
                    System.out.println("Salvar um conjunto de veículos em um arquivo:\n");
                    System.out.println("conjunto de veículos:" + localPadraoSalvar);
                    virtual.salvaVeiculosFrota(localPadraoSalvar);
                    opcao = menu(opcao);
                    break;

                case "3":

                    System.out.println("Incluir um novo veículo:\n");
                    System.out.println("\nEntre com os dados do veiculo para incluir:");
                    System.out.print("\nPlaca:");
                    String placa = obj.nextLine().toUpperCase();
                    System.out.print("\nValor de venda:");
                    double valorVenda = obj.nextDouble();
                    obj.nextLine(); // Limpar buffer Scanner?
                    System.out.println("\nEntre com o tipo de Veículo:");
                    System.out.println("1 - Carro");
                    System.out.println("2 - Van");
                    System.out.println("3 - Furgão");
                    System.out.println("4 - Caminhão");
                    System.out.print("Tipo de Veículo:");
                    char tipo = obj.nextLine().charAt(0);

                    switch (tipo) {
                        case '1':
                            Veiculo novoCarro = new Carro(placa, valorVenda);
                            virtual.incluirVeiculo(novoCarro);
                            novoCarro.imprimeVeiculoConsole();
                            break;
                        case '2':
                            Veiculo novaVan = new Van(placa, valorVenda);
                            virtual.incluirVeiculo(novaVan);
                            novaVan.imprimeVeiculoConsole();
                            break;
                        case '3':
                            Veiculo novoFurgao = new Furgao(placa, valorVenda);
                            virtual.incluirVeiculo(novoFurgao);
                            novoFurgao.imprimeVeiculoConsole();
                            break;
                        case '4':
                            Veiculo novoCaminhao = new Caminhao(placa, valorVenda);
                            virtual.incluirVeiculo(novoCaminhao);
                            novoCaminhao.imprimeVeiculoConsole();
                            break;
                        default:
                            System.out.println("opção invalida!");
                            break;
                    }


                   
                    opcao = menu(opcao);
                    break;
                case "4":
                    System.out.println("Incluir rotas para um veículo:\n");
                        System.out.println("\nEntre com os dados da rota para incluir:");
                        System.out.print("\nQuilometros da rota:");
                        kmRota = obj.nextInt();
                        System.out.println("Entre com data para a rota formato DD/MM/AAAA: ");
                        dtProducao = Data.verificaData(obj.nextLine());
                        dtProducao = new Data();
                        novaRota = new Rota(kmRota, dtProducao, Frota.localizarVeiculo(obj.nextLine()));

                    if (virtual.imprimeVeiculosFrota() > 0) {
                       System.out.println("Entre com a placa do veículo para a rota:\n Procurar pela placa: ");
                        veiculoLocalizar = Frota.localizarVeiculo(obj.nextLine());
                    } else {
                        System.out.println("Não há veiculo cadastrado.");
                    }

                    novaRota = new Rota(kmRota, dtProducao, veiculoLocalizar);

                    veiculoLocalizar.addRota(novaRota);

                    opcao = menu(opcao);
                    break;
                case "5":
                    System.out.println("Localizar um veículo da frota.");
                    System.out.println("\nEntre com a placa do Veículo para localizar:");
                    placaVeiculo = obj.nextLine();
                    veiculoLocalizar = Frota.localizarVeiculo(placaVeiculo);
                    veiculoLocalizar.imprimeVeiculoConsole();
                    opcao = menu(opcao);
                    break;
                case "6":
                    System.out.println("Imprimir um relatório do veículo com seus gastos até o momento.\n");
                    System.out.println("\nEntre com a placa do Veículo para imprimir gastos:");
                    placaVeiculo = obj.nextLine();
                    if (Frota.localizarVeiculo(placaVeiculo)!=null){
                    veiculoLocalizar = Frota.localizarVeiculo(placaVeiculo);
                    veiculoLocalizar.imprimeDadosVeiculoConsole();
                    }
                    opcao = menu(opcao);
                    break;
                case "F":
                    System.out.println("Finalizado!");
                    opcao = "F";
                    break;
                default:
                    System.out.println("opção invalida!");
                    opcao = menu(opcao);
                    break;
            }
        }
        obj.close();
    }

    public static String menu(String opc) {
        Scanner objt = new Scanner(System.in);

        System.out.println("\n  FROTA VIRTUAL:  \n");
        System.out.println("1 -  Carregar um conjunto de veículos de um arquivo.");
        System.out.println("2 -  Salvar um conjunto de veículos em um arquivo.");
        System.out.println("3 -  Incluir um novo veículo.");
        System.out.println("4 -  Incluir rotas para um veículo.");
        System.out.println("5 -  Localizar um veículo da frota.");
        System.out.println("6 -  Imprimir um relatório do veículo com seus gastos até o momento.");

        System.out.println("\nEntre com o número correspondente à função ou 'f' para finalizar:\n");
        opc = objt.nextLine().toUpperCase();
        // objt.close();
        return opc;
    }
}