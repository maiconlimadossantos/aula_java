
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
        pilha.analisesintatico("((2+2)*(4-3))");
        pilha.mostrar();

        System.out.println("\n=== Testando ListaDuplamenteEncadeada ===");   
        ListaDuplamenteEncadeada<Integer> listaInt = new ListaDuplamenteEncadeada<>();
        listaInt.menuInterativo();
    
        
        System.out.println("\n=== Testando ListaCircular ==="); 
        ListaCircular<Integer>listaCircular=new ListaCircular<>(); 
        listaCircular.adicionar(12); 
        listaCircular.adicionar(32);
        listaCircular.adicionar(45);
        listaCircular.adicionar(22);
        listaCircular.adicionar(18);
        listaCircular.mostrar();
        listaCircular.excluir();
        listaCircular.buscar(32);
        listaCircular.mostrar();
        listaCircular.concatenar(listaCircular );
        listaCircular.mostrarElementos();
        listaCircular.inserirOrdenador( 25);
        listaCircular.mostrar();
        



        System.out.println("\n=== Testando ArvoreBinaria ==="); 
        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();
        arvore.adicionar(50);
        arvore.adicionar(30);
        arvore.adicionar(70);
        arvore.adicionar(20);
        arvore.adicionar(40);
        arvore.adicionar(60);
        arvore.adicionar(80);
        
        arvore.mostrar(); 
        System.out.println("Busca por 40: " + arvore.buscar(40)); // true
        System.out.println("Busca por 99: " + arvore.buscar(99)); // false
        arvore.excluir(20);
        arvore.mostrar(); 
        arvore.excluir(50); 
        arvore.mostrar();
    }
}
