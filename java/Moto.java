public class Moto extends Veiculo {
    // Atributos específicos da moto
    protected  int cilindradas;
    protected  boolean temPartidaEletrica;

    // Construtor
    public Moto(String marca, String modelo, int ano, int cilindradas, boolean temPartidaEletrica) {
        super(marca, modelo, ano); // chama o construtor da classe Veiculo
        this.cilindradas = cilindradas;
        this.temPartidaEletrica = temPartidaEletrica;
    }

    // Getters
    public int getCilindradas() {
        return cilindradas;
    }

    public boolean isTemPartidaEletrica() {
        return temPartidaEletrica;
    }

    // Setters
    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
    }

    public void setTemPartidaEletrica(boolean temPartidaEletrica) {
        this.temPartidaEletrica = temPartidaEletrica;
    }

    // Método específico de Moto
    public void empinar() {
        System.out.println("A moto está empinando! 🏍️");
    }

    // Sobrescrevendo o método exibirInfo
    @Override
    public void exibirInfo() {
        super.exibirInfo(); // exibe marca, modelo, ano
        System.out.println("Cilindradas: " + cilindradas + "cc");
        System.out.println("Partida Elétrica: " + (temPartidaEletrica ? "Sim" : "Não"));
    }
}
