

    
    public class ListaDuplamenteEncadeada <T> extends Fila<T>{
        protected int numero;
    
        public ListaDuplamenteEncadeada(){
           this.numero = 0;
        }
        public 
    
       

        @Override
        public void adicionarfrente(T dado){
            Node<T> novo = new Node<>(dado);
            if(Frente==null){
                Frente.setProximo(novo);
            }
            frente=novo;
            if (tras == null) {
                tras = frente;
            }
            tamanho++;
            System.out.println("Adicionado: " + dado);
        }
        
    
        @Override
       public void adicionartras(T dado){
        Node<T> novo = new Node<>(dado); 
        if(tras==null){
            tras.setProximo(novo);
         }
         Atras=novo;
         if (frente == null) {
            frente = tras;
        }
        tamanho++;
        System.out.println("Adicionado: " + dado);
    }
       
       
   }
   
}
