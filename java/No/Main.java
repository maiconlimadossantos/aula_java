

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Testando Fila ===");
        Fila<Integer> fila = new Fila<>();
        fila.adicionar(10);
        fila.adicionar(20);
        fila.adicionar(30);
        fila.mostrar();
        fila.excluir();
        fila.mostrar();


        System.out.println("\n=== Testando Pilha ===");
        Pilha<Integer> pilha = new Pilha<>();
        pilha.adicionar(10);
        pilha.adicionar(20);
        pilha.adicionar(30);
        pilha.mostrar();
        pilha.excluir();
        pilha.mostrar();
    }
}





