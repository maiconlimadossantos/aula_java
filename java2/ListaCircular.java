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
           System.out.println("Encontrado: " + dado + " na posição " + posicao + ".");
           return posicao;
       }
       atual = (NodeDuplo<T>) atual.getProximo();
       posicao++;
   } while (atual != frente);

   System.out.println("Não encontrado: " + dado + " na lista.");
   return -1;
}



public void concatenar(ListaCircular<T> outraLista) {
    if (outraLista.frente == null) {
        System.out.println("Lista de origem vazia. Nada a concatenar.");
        return;
    }
    if (this.frente == null) {
        this.frente = outraLista.frente;
        this.tras = outraLista.tras;
        this.tamanho = outraLista.tamanho;
    } else {
        NodeDuplo<T> cauda1 = (NodeDuplo<T>) this.tras;
        NodeDuplo<T> cabeca2 = (NodeDuplo<T>) outraLista.frente;
        NodeDuplo<T> cauda2 = (NodeDuplo<T>) outraLista.tras;
        NodeDuplo<T> cabeca1 = (NodeDuplo<T>) this.frente;
        cabeca2.setAnterior(cauda1);
        cauda1.setProximo(cabeca2);

        // c. Atualizar a cauda da lista resultante
        this.tras = cauda2;

        // d. Manter a circularidade (Fechar o ciclo da nova lista)
        cauda2.setProximo(cabeca1);
        cabeca1.setAnterior(cauda2);

        // e. Atualizar o tamanho
        this.tamanho += outraLista.tamanho;
    }

    // 4. Limpar a lista de origem (outraLista)
    outraLista.frente = null;
    outraLista.tras = null;
    outraLista.tamanho = 0;

    // NOVO: Exibir os elementos da lista concatenada
    System.out.println("Listas concatenadas com sucesso! A lista de origem agora está vazia.");
    mostrarElementos(); 
    System.out.println("Novo tamanho: " + this.tamanho);
}
public void mostrarElementos() {
   if (frente == null) {
       System.out.println("Lista vazia.");
       return;
   }
   
   NodeDuplo<T> atual = (NodeDuplo<T>) frente;
   System.out.print("Elementos da Lista Circular: ");
   
   do {
       System.out.print(atual.getDado() + " ");
       atual = (NodeDuplo<T>) atual.getProximo();
   } while (atual != frente);
   
   System.out.println();

}
   public  void inserirOrdenador(T dado) {
       NodeDuplo<T> novo = new NodeDuplo<>(dado);
       if (frente == null) {
           frente = novo;
           tras = novo;
           manterCircularidade();
           tamanho++;
           return;
       }
       NodeDuplo<T> atual = (NodeDuplo<T>) frente;
       NodeDuplo<T> anterior = (NodeDuplo<T>) tras;
       do {
           if (((Comparable<T>) atual.getDado()).compareTo(dado) >= 0) {
               break;
           }
           anterior = atual;
           atual = (NodeDuplo<T>) atual.getProximo();
       } while (atual != frente);
       novo.setProximo(atual);
       novo.setAnterior(anterior);
       anterior.setProximo(novo);
       atual.setAnterior(novo);
       if (atual == frente && ((Comparable<T>) atual.getDado()).compareTo(dado) >= 0) {
           frente = novo;
       }
       if (anterior == tras && ((Comparable<T>) anterior.getDado()).compareTo(dado) < 0) {
           tras = novo;
       }
       tamanho++;
       manterCircularidade();
   }



}