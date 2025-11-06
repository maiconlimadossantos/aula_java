


public class Node<T> {
    private T dado;
    private Node<T> proximo;
    public Object setProximo;

    public Node(T dado) {
        this.dado = dado;
        this.proximo = null;
    }

    public T getDado() {
        return dado;
    }

    public void setDado(T dado) {
        this.dado = dado;
    }

    public Node<T> getProximo() {
        return proximo;
    }

    public Object setProximo(Node<T> proximo) {
        this.proximo = proximo;
    }
}