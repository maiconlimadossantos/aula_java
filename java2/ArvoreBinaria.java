public class ArvoreBinaria<T> {
    private NodeAr<T> raiz;

    public ArvoreBinaria(){
        this.raiz=null;

    }
    public void adicionar(int valor){
        this.raiz=adicionarRecursivo(this.raiz,valor);  
    }
    private NodeAr<T> adicionarRecursivo(NodeAr<T> atual,int valor){
        if(atual==null){
            return new NodeAr<>(valor);
        }
        if(valor<atual.valor){
            atual.filhoEsquerdo=adicionarRecursivo(atual.filhoEsquerdo,valor);
        }else{
            atual.filhoDireito=adicionarRecursivo(atual.filhoDireito,valor);
        }
        return atual;
    }
    public boolean buscar(int valor) {
        return buscarRecursivo(this.raiz, valor);
    }
    public boolean  buscarRecursivo(NodeAr<T> atual, int valor){
        if(atual==null){
            return false;
        }
        if(valor==atual.valor){
            return true;
        }
        if(valor<atual.valor){
            return buscarRecursivo(atual.filhoEsquerdo,valor);
        }else{
            return buscarRecursivo(atual.filhoDireito, valor);
        }
    }

    public  void mostrar(){
        System.out.println("Elementos (In-Order): ");
        mostrarInOrder(this.raiz);
        System.out.println();
    }
    private  void mostrarInOrder(NodeAr<T> node){
        if(node!=null){
            mostrarInOrder(node.filhoEsquerdo);
            System.out.println(node.valor + "");
            mostrarInOrder(node.filhoDireito);
        }
    }
    public void excluir(int valor){
        this.raiz=excluirRecursivo(this.raiz,valor);
    }
    private NodeAr<T> excluirRecursivo(NodeAr<T> atual,int valor){
        if(atual==null){
            return null;
        }
        if(valor==atual.valor){
            if(atual.filhoEsquerdo==null){
                return atual.filhoDireito;
            }
            if(atual.filhoDireito==null){
                return atual.filhoEsquerdo;
            }
            int menorvalor=encontrarMenorValor(atual.filhoDireito);
            atual.valor=menorvalor;
            atual.filhoDireito=excluirRecursivo(atual.filhoDireito, menorvalor);
            return atual;
        }
        if(valor<atual.valor){
            atual.filhoEsquerdo=excluirRecursivo(atual.filhoEsquerdo, valor);
            return atual;
        }
        atual.filhoDireito=excluirRecursivo(atual.filhoDireito, valor);
        return atual;
    }
    private int encontrarMenorValor(NodeAr<T> root){
        return root.filhoEsquerdo==null ? root.valor:encontrarMenorValor(root.filhoEsquerdo);
    }

}
