class NodeDuplo<T> extends Node<T>{
    private NodeDuplo<T> anterior;
    public NodeDuplo(T dado){
        super(dado);
        this.anterior=null;
    }
    public NodeDuplo<T> getAnterior(){
        return anterior;
    }
    public void setAnterior(NodeDuplo<T> anterior){
        this.anterior=anterior;
    }
   
}