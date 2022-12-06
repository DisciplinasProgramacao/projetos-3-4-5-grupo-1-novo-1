import javax.management.InvalidAttributeValueException;

public class FabricaVeiculo {
    static Veiculo criarVeiculo(String tipo, String placa, double valorVenda) throws InvalidAttributeValueException{
        switch (tipo.toUpperCase()){
            case "1": return new Carro(placa, valorVenda);
            case "2": return new Van(placa, valorVenda);
            case "3": return new Furgao(placa, valorVenda);
            case "4":return new Caminhao(placa, valorVenda);
            default: throw new InvalidAttributeValueException("Tipo de Veiculo inexistente");
        }
    } 
}
