
public class Fila<T> {
    public Node<T> frente;  
    public Node<T> tras;    
    protected int tamanho;


    public Fila() {
        this.frente = null;
        this.tras = null;
        this.tamanho = 0;
    }


    @SuppressWarnings({ "rawtypes", "unchecked" })
    public Fila(Node frente) {
        this.frente = frente;
    }


    public void adicionar(T dado) {
        Node<T> novo = new Node<>(dado); // aqui Node<T> é reconhecido
        if (tras != null) {
            tras.setProximo(novo);
        }
        tras = novo;
        if (frente == null) {
            frente = tras;
        }
        tamanho++;
        System.out.println("Adicionado: " + dado);
    }


    public T excluir() {
        if (frente == null) {
            System.out.println("Fila vazia! Nada para remover.");
            return null;
        }
        T dado = frente.getDado();
        frente = frente.getProximo();
        if (frente == null) {
            tras = null;
        }
        tamanho--;
        System.out.println("Removido: " + dado);
        return dado;
    }


    public void mostrar() {
        Node<T> atual = frente;
        System.out.print("Fila: ");
        while (atual != null) {
            System.out.print(atual.getDado() + " ");
            atual = atual.getProximo();
        }
        System.out.println();
    }


    public boolean estaVazia() {
        return tamanho == 0;
    }


    public int getTamanho() {
        return tamanho;
    }


    @SuppressWarnings("rawtypes")
    public Node getFrente() {
        return frente;
    }


    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void setFrente(Node frente) {
        this.frente = frente;
    }
}


