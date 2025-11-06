package no;
public class Node<T> {
    private T dado;           // valor armazenado no nó
    private Node<T> proximo;  // referência para o próximo nó

    // Construtor
    public Node(T dado) {
        this.dado = dado;
        this.proximo = null;
    }

    // Getter e Setter para dado
    public T getDado() {
        return dado;
    }

    public void setDado(T dado) {
        this.dado = dado;
    }

    // Getter e Setter para próximo
    public Node<T> getProximo() {
        return proximo;
    }

    public void setProximo(Node<T> proximo) {
        this.proximo = proximo;
    }
}
