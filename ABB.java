public class ABB<T extends Comparable<T>> {   

    private Node<T> raiz; // Nó raiz da ABB

    // Construtor da ABB
    public ABB() {
        raiz = null;
    }

    // Verifica se a ABB está vazia
    public boolean isEmpty() {
        return (raiz == null);
    }

    // Configura a raiz da árvore
    public void setRaiz(Node<T> araiz) {
        raiz = araiz;
    }

    // Obtém o nó raiz da ABB
    public Node<T> getRaiz() {
        return raiz;
    }

    // Procura o elemento e na ABB
    public Node<T> search(T e){
    	return search( raiz, e );
    }
    // Método que procura o elemento e na ABB de raiz
    public Node<T> search( Node<T> node, T e ){
        if (node == null) // elemento não foi encontrado
            return null;
        else if (compara(e, node.getValue()) == 0)
            return node;
        else  if (compara(e, node.getValue() ) < 0) 
            return search( node.getFilhoEsquerdo(), e );
        else return search( node.getFilhoDireito(), e );
    }    
    
    // Método público que insere "valor" na ABB.
    // Ou seja, responsável por chamar o método que
    // insere um novo nó (contendo "valor") na ABB de "raiz"
    public T inserir(T valor) {
        try {
            Node<T> novo = new Node<>(valor);
            raiz = inserir(novo, raiz);
            return valor;
        } catch (Exception e) {
            return null;
        }
    }

    // Método que realiza a inserção de um novo nó (novo) 
    // na ABB 
    private Node<T> inserir(Node<T> novo, Node<T> atual) {
        if (atual == null) {
            return novo;
        }

        if (compara(novo.getValue(), atual.getValue()) < 0) {
            atual.setFilhoEsquerdo(inserir(novo, atual.getFilhoEsquerdo()));
        } else {
            atual.setFilhoDireito(inserir(novo, atual.getFilhoDireito()));
        }

        return atual;
    }

    // Encarregado de chamar o método que percorre a ABB em
    // emOrdem a partir do raiz
    public String emOrdem() {
        return emOrdem(raiz);
    }

    // Encarregado de chamar o método que percorre a ABB em
    // emOrdem2 a partir do raiz
    public void emOrdem2() {
        emOrdem2(raiz);
    }

    // Encarregado de chamar o método que percorre a ABB em
    // preOrdem a partir do raiz
    public void preOrdem() {
        preOrdem(raiz);
    }

    // Encarregado de chamar o método que percorre a ABB em
    // posOrdem a partir do raiz
    public void posOrdem() {
        posOrdem(raiz);
    }

    // Método que percorre a ABB em Ordem
    // retornando uma String com os valores
    // concatenados do nó
    public String emOrdem(Node<T> no) {
        if (no == null) return "";
        
        StringBuilder sb = new StringBuilder();
        sb.append(emOrdem(no.getFilhoEsquerdo()));
        sb.append(no.getValue() + " ");
        sb.append(emOrdem(no.getFilhoDireito()));
        
        return sb.toString();
    }

    // Método que percorre a ABB em Ordem
    // e imprime os valores dos nós
    public void emOrdem2(Node<T> no) {
        if (no != null) {
            emOrdem2(no.getFilhoEsquerdo());
            System.out.print(no.getValue() + "\n");
            emOrdem2(no.getFilhoDireito());
        }
    }

    // Método que percorre a ABB em preOrdem
    // e imprime os valores dos nós
    public void preOrdem(Node<T> no) {
        if (no != null) {
            System.out.print(no.getValue() + "   ");
            preOrdem(no.getFilhoEsquerdo());
            preOrdem(no.getFilhoDireito());
        }
    }

    // Método que percorre a ABB em posOrdem
    // e imprime os valores dos nós
    public void posOrdem(Node<T> no) {
        if (no != null) {
            posOrdem(no.getFilhoEsquerdo());
            posOrdem(no.getFilhoDireito());
            System.out.print(no.getValue() + "   ");
        }
    }

    // Método que percorre a ABB em Nível
    // e imprime os valores dos nós
    public void emNivel() {
        //Método iterativo que utiliza uma fila auxiliar
        Node<T> noAux;
        // Observe que a LinkedList está funcionando como uma Fila
        LinkedList<Node<T>> fila = new LinkedList<Node<T>>();
        fila.addLast(raiz);  // Adiciona no Final
        while (!fila.isEmpty()) {
            noAux = (Node<T>) fila.pollFirst();  // Remove do Começo
            if (noAux.getFilhoEsquerdo() != null) {
                fila.addLast(noAux.getFilhoEsquerdo());
            }
            if (noAux.getFilhoDireito() != null) {
                fila.addLast(noAux.getFilhoDireito());
            }
            System.out.print(noAux.getValue() + "   ");
        }
    }

    // Método que compara dois objetos  do tipo T genérico)
    private int compara(T ob1, T ob2) {
        return ob1.compareTo( ob2);
    }
    
    //Determina o menor elemento a partir de um nó
    public Node<T> getMenor(Node<T> node) {
        if (isEmpty()) {
            return null;
        }
        if (node.getFilhoEsquerdo() == null) {
            return node;
        } else {
            return getMenor(node.getFilhoEsquerdo());
        }
    }

    //Determina o maior elemento a partir de um nó
    public Node<T> getMaior(Node<T> node) {
        if (isEmpty()) {
            return null;
        }
        if (node.getFilhoDireito() == null) {
            return node;
        } else {
            return getMaior(node.getFilhoDireito());
        }
    }

    // Obtém o maior elemento a partir de um nó
    public Node<T> getMax(Node<T> raiz, Node<T> paiRaiz) {
        if (isEmpty()) {
            return null;
        }
        Node<T> aux;
        //Se não tiver mais filho direito
        if (raiz.getFilhoDireito() == null) {
            aux = raiz;
            //Se tiver um pai, ele assume o filho esquerdo
            if (paiRaiz != null) {
                if (paiRaiz.getFilhoEsquerdo() == raiz) // se é filho esquerdo
                {
                    paiRaiz.setFilhoEsquerdo(raiz.getFilhoEsquerdo());
                } else {
                    paiRaiz.setFilhoDireito(raiz.getFilhoEsquerdo());
                }
            }
            return aux;
        } else {
            return getMax(raiz.getFilhoDireito(), raiz);
        }
    }
    

    // Implementação iterativa da Inserção
    public T insert(T valor) {
        try {
            Node<T> novoNodo = new Node<>(valor);

            if (isEmpty()) {
                raiz = novoNodo;
                return valor;
            }

            Node<T> atual = raiz;
            Node<T> pai = null;

            while (atual != null) {
                pai = atual;
                if (compara(valor, atual.getValue()) < 0) {
                    atual = atual.getFilhoEsquerdo();
                } else {
                    atual = atual.getFilhoDireito();
                }
            }

            if (compara(valor, pai.getValue()) < 0) {
                pai.setFilhoEsquerdo(novoNodo);
            } else {
                pai.setFilhoDireito(novoNodo);
            }

            return valor;
        } catch (Exception e) {
            return null;
        }
    }  
}
