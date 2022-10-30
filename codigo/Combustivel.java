public abstract class Combustivel {

    protected int identificador;
    protected String descricao;
    protected double preco;
    protected double consumo;

    public Combustivel(String desc, double preco, double consumo, int identificador){
        if(preco < 1){preco = 1.0;}
        if(consumo < 1){consumo = 1.0;}
        this.descricao = desc;
        this.preco = preco;
        this.consumo = consumo;
        this.identificador = identificador;
    }

    public int getIdentificador() {
        return identificador;
    }

    public double getPreco() {
        return preco;
    }

    public double getConsumo() {
        return consumo;
    }

    public String toString(){
        return this.descricao;
    }
}
