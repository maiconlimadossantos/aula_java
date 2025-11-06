import java.util.ArrayList;
import java.util.List;

public class Concessionaria {
    protected String nome;
    protected List<Veiculo> veiculos;

    // Construtor
    public Concessionaria(String nome) {
        this.nome = nome;
        this.veiculos = new ArrayList<>();
    }

    // Adiciona um veículo à lista
    public void adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
        System.out.println("Veículo adicionado com sucesso: " + veiculo.getModelo());
    }

    // Lista todos os veículos
    /**
     * 
     */
    public void listarVeiculos() {
        System.out.println("\n--- Veículos disponíveis na " + nome + " ---");
        for (Veiculo v : veiculos) {
            // Exibir informações básicas
            System.out.println("Marca: " + v.getMarca());
            System.out.println("Modelo: " + v.getModelo());
            System.out.println("Ano: " + v.getAno());

            // Se for carro, mostrar também portas e combustível
            if (v instanceof Carro c) {
                System.out.println("Portas: " + c.getPortas());
                System.out.println("Combustível: " + c.getCombustivel());
            }

            // Se for moto, mostrar informações da moto
            if (v instanceof Moto m) {
                System.out.println("Cilindradas: " + m.getCilindradas() + "cc");
                System.out.println("Partida Elétrica: " + (m.isTemPartidaEletrica() ? "Sim" : "Não"));
            }

            System.out.println("------------------------");
        }
    }

    // Busca por marca
    public void buscarPorMarca(String marca) {
        System.out.println("\n--- Veículos da marca: " + marca + " ---");
        for (Veiculo v : veiculos) {
            if (v.getMarca().equalsIgnoreCase(marca)) {
                System.out.println("Modelo: " + v.getModelo() + " | Ano: " + v.getAno());
            }
        }
    }

    // Busca por modelo
    public void buscarPorModelo(String modelo) {
        System.out.println("\n--- Veículos com modelo: " + modelo + " ---");
        for (Veiculo v : veiculos) {
            if (v.getModelo().equalsIgnoreCase(modelo)) {
                System.out.println("Marca: " + v.getMarca() + " | Ano: " + v.getAno());
            }
        }
    }
}
