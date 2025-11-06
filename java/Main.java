public class Main {
    public static void main(String[] args) {
        Veiculo veiculo = new Veiculo("Toyota", "Corolla", 2020);
        System.out.println("--- Informações do Veículo ---");
        veiculo.exibirInfo();

        veiculo.setAno(2022);
        veiculo.setModelo("Corolla Cross");

        System.out.println("\n--- Informações do Veículo Após Alterações ---");
        veiculo.exibirInfo();

        Carro carro = new Carro("Honda", "Civic", 2023, 4, "Gasolina");

        System.out.println("\n--- Informações do Carro ---");
        carro.exibirInfo();

        carro.ligar();
        Concessionaria concessionaria = new Concessionaria("AutoCenter 123");

        // Criando veículos
        Veiculo v1 = new Veiculo("Toyota", "Corolla", 2020);
        Carro c1 = new Carro("Honda", "Civic", 2023, 4, "Gasolina");
        Carro c2 = new Carro("Ford", "Focus", 2019, 4, "Flex");

        // Adicionando à concessionária
        concessionaria.adicionarVeiculo(v1);
        concessionaria.adicionarVeiculo(c1);
        concessionaria.adicionarVeiculo(c2);

        // Listando todos os veículos
        concessionaria.listarVeiculos();

        // Buscar por marca
        concessionaria.buscarPorMarca("Honda");

        // Buscar por modelo
        concessionaria.buscarPorModelo("Focus");
        Moto moto1 = new Moto("Yamaha", "MT-03", 2022, 321, true);

        // Exibindo informações
        System.out.println("--- Informações da Moto ---");
        moto1.exibirInfo();

        // Chamando método específico da moto
        moto1.empinar();
    }
}
