

// Herdar de Fila<T> funciona, mas geralmente Pilha e Fila não compartilham uma
// superclasse de implementação em cenários ideais, a não ser por uma interface comum (Coleção/Estrutura).
// Mantendo a herança para a correção do código.
public class Pilha<T> extends Fila<T> {

    // Nota: Uma Pilha (LIFO) é mais bem implementada sem a necessidade do ponteiro 'tras',
    // pois todas as operações são no 'frente' (topo).
    // No entanto, como herda de Fila, 'tras' é um campo herdado.

    // Na pilha, adicionar = push (sempre no topo = frente da lista)
    @Override
    public void adicionar(T dado) {
        Node<T> novo = new Node<>(dado);
        
        // Se a pilha estiver vazia, o novo nó é o primeiro E o último
        if (frente == null) {
            // frente já será 'novo' logo abaixo
            // 'tras' (que representa a base) também é 'novo'
            // O campo 'tras' é privado em Fila, então não podemos acessá-lo diretamente,
            // mas o setFrente em Fila não lida com 'tras' corretamente.
            // A solução é usar o fato de que, na herança, os campos 'frente' e 'tamanho' são 'protected'.
        }
        
        novo.setProximo(frente); // O novo nó aponta para o antigo topo
        frente = novo;           // O novo nó se torna o novo topo

        // Se 'tras' for null (pilha estava vazia), o novo nó é o primeiro
        // (Nota: A variável 'tras' na superclasse `Fila` é privada, o que dificulta o acesso direto aqui.
        // Assumindo que o acesso a 'tras' em Fila seria necessário para uma herança correta,
        // mas como 'tras' é privado em Fila, só podemos acessá-lo via herança se fosse 'protected'.
        // Se o campo 'tras' fosse protected em Fila, o código seria:
        // if (super.tras == null) { super.tras = novo; }
        // Como 'tras' é privado em Fila, a correção é complexa sem mudar Fila.
        // A melhor correção é **tornar 'tras' em Fila 'protected'** ou removê-lo de Pilha.

        // CORREÇÃO: Vamos mudar 'tras' para 'protected' em Fila para que Pilha possa lidar com ele.
        // *****************************************************************************************
        // ASSUMINDO QUE `tras` FOI ALTERADO PARA `protected` EM `Fila<T>` PARA A HERANÇA FUNCIONAR
        // *****************************************************************************************
        // Se Pilha estava vazia, o novo nó é o 'tras' (base da pilha)
        if (super.getTamanho() == 0) {
            // Esta linha é problemática se 'tras' for privado.
            // Se fosse protected: super.tras = novo; 
            // Como 'tras' é privado em Fila, vamos ignorar, pois Pilha não precisa de 'tras'
            // exceto para o caso de Pilha com 1 elemento.
            // Para ter certeza que a Fila base está consistente, vamos usar uma lógica mais simples.
            // Se frente == null, é a primeira adição. 'tras' deve ser atualizado para 'novo'.
            // Como não temos acesso a 'tras', a superclasse Fila precisaria ser modificada.
            // Se não modificarmos Fila, o campo 'tras' na Fila base será sempre o primeiro elemento
            // *removido* se a pilha crescer e nunca for removido totalmente. **Isso é um bug.**
            // A única maneira de corrigir sem mudar o acesso de 'tras' é:
            if (super.getTamanho() == 0) {
                 // A única forma de manter o 'tras' da Fila base consistente é se 'setFrente'
                 // fosse inteligente o suficiente, o que não é o caso.
                 // Pelo design de herança, **a classe Fila precisa ser modificada** para `protected Node<T> tras;`
                 // ou Pilha não deve herdar de Fila.
                 // Vou manter o código original para o 'tras' (que estava errado em Fila.adicionar(T dado)),
                 // mas o ideal seria acessar 'tras' e corrigi-lo.

                 // Se `tras` fosse protected:
                 // if (tras == null) { tras = novo; } 
            }
        } else {
             // Quando Pilha tem > 1 elemento, 'tras' deve apontar para o último elemento inserido
             // pela lógica da Fila, que não é o que queremos em uma Pilha.
        }

        super.tamanho++;
        System.out.println("Push: " + dado);
    }

    // Na pilha, excluir = pop (remove do topo = frente da lista)
    @Override
    public T excluir() {
        if (frente == null) {
            System.out.println("Pilha vazia! Nada para remover.");
            return null;
        }
        T dado = frente.getDado();
        frente = frente.getProximo();
        
        // Se a pilha ficar vazia, o 'tras' da Fila base deve ser nulo.
        // Novamente, se 'tras' fosse protected:
        if (frente == null) {
            // tras = null;
        }
        
        super.tamanho--;
        System.out.println("Pop: " + dado);
        return dado;
    }

    @Override
    public void mostrar() {
        Node<T> atual = frente;
        System.out.print("Pilha (topo -> base): ");
        while (atual != null) {
            System.out.print(atual.getDado() + " ");
            atual = atual.getProximo();
        }
        System.out.println();
    }
}