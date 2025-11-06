public class Carro extends Veiculo {
    protected  int portas;
    protected  String combustivel;

    public Carro(String marca, String modelo, int ano, int portas, String combustivel) {
        super(marca, modelo, ano);
        this.portas = portas;
        this.combustivel = combustivel;
    }

    public int getPortas() {
        return portas;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setPortas(int portas) {
        this.portas = portas;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public void ligar() {
        System.out.println("O carro está ligado.");
    }

    @Override
    public void exibirInfo() {
        super.exibirInfo();
        System.out.println("Portas: " + portas);
        System.out.println("Combustível: " + combustivel);
    }
}
