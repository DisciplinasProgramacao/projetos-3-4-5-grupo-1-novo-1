public class Gasolina extends Combustivel
{
    private static final String DESCRICAO = "Gasolina";
    private static final double PRECO = 4.8;
    private static final double CONSUMO = 12.0;

    public Gasolina(){
        super(DESCRICAO, PRECO, CONSUMO);
    }
}
