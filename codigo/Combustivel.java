public abstract class Combustivel {

    protected String descricao;
    protected double preco;
    protected double consumo;

    public Combustivel(String desc, double preco, double consumo){
        if(preco < 1){preco = 1.0;}
        if(consumo < 1){consumo = 1.0;}
        this.descricao = desc;
        this.preco = preco;
        this.consumo = consumo;
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
