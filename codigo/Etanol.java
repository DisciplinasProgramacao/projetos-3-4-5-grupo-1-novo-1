public class Etanol extends Combustivel{
    
    private static final String DESCRICAO = "Etanol";
    private static final double PRECO = 3.65;
    private static final double CONSUMO = 8.0;

    public Etanol(){
        super(DESCRICAO, PRECO, CONSUMO);
    }
}
