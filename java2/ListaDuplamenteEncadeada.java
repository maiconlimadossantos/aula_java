import java.util.Scanner;

public class ListaDuplamenteEncadeada <T> extends Fila<T>{
    protected int numero;

    public ListaDuplamenteEncadeada(){
    }
     
@Override
public void adicionar(T dado){
    NodeDuplo<T> novo= new NodeDuplo<>(dado);
    if(frente==null){
        frente=novo;
        tras=novo;
    }else{
        ((NodeDuplo<T>)tras).setProximo(novo);
        novo.setAnterior((NodeDuplo<T>)tras);
        tras=novo;
    }
    tamanho++;
    System.out.println("Adicionado:"+ dado+"(no final).");
}
    
   public int buscar(T dado){
    NodeDuplo<T> atual=(NodeDuplo<T>) frente;
    int posicao=0;
    while (atual != null) {
        if (atual.getDado().equals(dado)) {
            System.out.println("Encontrado: " + dado + " na posição " + posicao + ".");
            return posicao;
        }
        atual = (NodeDuplo<T>) atual.getProximo();
        posicao++;
    }

    System.out.println(" Não encontrado: " + dado + " na lista.");
    return -1; 
}



public T excluirNaPosicao(int posicao) {
    if (posicao < 0 || posicao >= tamanho || frente == null) {
        System.out.println(" Posição inválida ou lista vazia.");
        return null;
    }

    NodeDuplo<T> noParaRemover = (NodeDuplo<T>) frente;
    
    
    for (int i = 0; i < posicao; i++) {
        noParaRemover = (NodeDuplo<T>) noParaRemover.getProximo();
    }

    T dadoRemovido = noParaRemover.getDado();
    
    
    if (noParaRemover == frente) {
        frente = noParaRemover.getProximo();
        if (frente != null) {
            ((NodeDuplo<T>) frente).setAnterior(null);
        } else {
            tras = null; 
        }
    } 
   
    else if (noParaRemover == tras) {
        tras = noParaRemover.getAnterior();
        ((NodeDuplo<T>) tras).setProximo(null);
    }
    
    else {
        NodeDuplo<T> anterior = noParaRemover.getAnterior();
        NodeDuplo<T> proximo = (NodeDuplo<T>) noParaRemover.getProximo();
        
        anterior.setProximo(proximo);
        proximo.setAnterior(anterior);
    }

    tamanho--;
    System.out.println(" Removido: " + dadoRemovido + " da posição " + posicao + ".");
    return dadoRemovido;
}



@Override
public void mostrar() {
    NodeDuplo<T> atual = (NodeDuplo<T>) frente;
    System.out.print("Lista (cabeça <-> cauda) [" + tamanho + " elementos]: ");
    if (atual == null) {
         System.out.print("Lista vazia.");
    }
    while (atual != null) {
        System.out.print(atual.getDado() + (atual.getProximo() != null ? " <-> " : ""));
        atual = (NodeDuplo<T>) atual.getProximo();
    }
    System.out.println();
}
    
    public void menuInterativo() {
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n--- Lista Duplamente Encadeada ---");
            System.out.println("1. Adicionar elemento (no final)");
            System.out.println("2. Excluir elemento (por posição)");
            System.out.println("3. Buscar elemento (por valor)");
            System.out.println("4. Mostrar lista");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Consome a nova linha
            } else {
                System.out.println(" Entrada inválida. Tente novamente.");
                scanner.nextLine();
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.print("Digite o dado a adicionar: ");
                    T dadoAdicionar = (T) scanner.nextLine(); 
                    adicionar(dadoAdicionar);
                    break;
                case 2:
                    System.out.print("Digite a posição para excluir (0 a " + (tamanho - 1) + "): ");
                    int posExcluir = scanner.nextInt();
                    scanner.nextLine();
                    excluirNaPosicao(posExcluir);
                    break;
                case 3:
                    System.out.print("Digite o dado a buscar: ");
                    T dadoBuscar = (T) scanner.nextLine();
                    buscar(dadoBuscar);
                    break;
                case 4:
                    mostrar();
                    break;
                case 0:
                    System.out.println("Saindo do menu.");
                    break;
                default:
                    System.out.println("Opção não reconhecida.");
            }
        }
        scanner.close();
    }
}



