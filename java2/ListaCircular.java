public class ListaCircular<T> extends Fila<T>{
    
    public ListaCircular(){
        

 }
 private void manterCircularidade() {
   if (tamanho > 0) {
       ((NodeDuplo<T>) tras).setProximo(frente);
       ((NodeDuplo<T>) frente).setAnterior((NodeDuplo<T>) tras);
   } else {
       frente = null;
       tras = null;
   }
}


@Override
public void adicionar(T dado) {
   NodeDuplo<T> novo = new NodeDuplo<>(dado);
   
   if (frente == null) {
       frente = novo;
       tras = novo;
   } else {
       novo.setProximo(frente); 
       ((NodeDuplo<T>) frente).setAnterior(novo); 
       frente = novo;
   }

   tamanho++;
   manterCircularidade(); // Garante a circularidade
   System.out.println(" Adicionado (Frente): " + dado);
}

@Override
public T excluir() {
   if (frente == null) {
       System.out.println("Lista vazia! Nada para remover.");
       return null;
   }
   
   T dadoRemovido = frente.getDado();
   
   if (tamanho == 1) {
       frente = null;
       tras = null;
   } else {
       
       frente = frente.getProximo();
   }
   
   tamanho--;
   manterCircularidade(); 
   
   System.out.println(" Removido (Frente): " + dadoRemovido);
   return dadoRemovido;
}



public T excluirNaPosicao(int posicao) {
   if (posicao < 0 || posicao >= tamanho || frente == null) {
       System.out.println(" Posição inválida ou lista vazia.");
       return null;
   }
   
   if (posicao == 0) {
       return excluir();
   }
   
   NodeDuplo<T> noParaRemover = (NodeDuplo<T>) frente;
   
   for (int i = 0; i < posicao; i++) {
       noParaRemover = (NodeDuplo<T>) noParaRemover.getProximo();
   }

   T dadoRemovido = noParaRemover.getDado();
   
   NodeDuplo<T> anterior = noParaRemover.getAnterior();
   NodeDuplo<T> proximo = (NodeDuplo<T>) noParaRemover.getProximo();
   
   if (noParaRemover == tras) {
       tras = anterior;
   }
   
   anterior.setProximo(proximo);
   proximo.setAnterior(anterior);

   tamanho--;
   manterCircularidade();

   System.out.println(" Removido: " + dadoRemovido + " da posição " + posicao + ".");
   return dadoRemovido;
}



@Override
public void mostrar() {
   if (frente == null) {
       System.out.println("Lista vazia.");
       return;
   }
   
   NodeDuplo<T> atual = (NodeDuplo<T>) frente;
   System.out.print("Lista Circular (" + tamanho + " elementos): ");
   
   do {
       System.out.print(atual.getDado() + (atual.getProximo() != frente ? " <-> " : " (VOLTA)"));
       atual = (NodeDuplo<T>) atual.getProximo();
   } while (atual != frente);
   
   System.out.println();
}


public int buscar(T dado) {
   if (frente == null) return -1;
   
   NodeDuplo<T> atual = (NodeDuplo<T>) frente;
   int posicao = 0;
   
   do {
       if (atual.getDado().equals(dado)) {
           System.out.println("🔍 Encontrado: " + dado + " na posição " + posicao + ".");
           return posicao;
       }
       atual = (NodeDuplo<T>) atual.getProximo();
       posicao++;
   } while (atual != frente);

   System.out.println("❌ Não encontrado: " + dado + " na lista.");
   return -1;
}



public void concatenar(ListaCircular<T> outraLista) {
   if (outraLista.frente == null) {
       System.out.println("🔗 Lista de origem vazia. Nada a concatenar.");
       return;
   }
   
   if (this.frente == null) {
       this.frente = outraLista.frente;
       this.tras = outraLista.tras;
       this.tamanho = outraLista.tamanho;
   } else {
       
       NodeDuplo<T> cauda1 = (NodeDuplo<T>) this.tras;
       cauda1.setProximo(outraLista.frente);
       ((NodeDuplo<T>) outraLista.frente).setAnterior(cauda1);
       this.tras = outraLista.tras;
       this.tamanho += outraLista.tamanho;
       
       manterCircularidade();
   }
   outraLista.frente = null;
   outraLista.tras = null;
   outraLista.tamanho = 0;
   
   System.out.println(" Listas concatenadas com sucesso! A lista de origem agora está vazia.");
}
}