public class Node <T> {  // Nodo, nó ou elemento da árvore

    private T value;  // Dado a ser inserido no nó
    private Node<T> filhoEsquerdo; // Nó filho esquerdo
    private Node<T> filhoDireito; // Nó filho direito
    
    // Converte e retorna o dado do nó (valor) para String
    public String toString () {
        return palavra.toString();
    }
        
    // Construtor
    public Node(T palavra) {
        this.palavra = palavra;
    }

    // Pega o dado (valor) do nó
    public T getPalavra() {
        return palavra;
    }

    // Alera o conteúdo (valor) do nó
    public void setPalavra(T value) {
        this.palavra = palavra;
    }

    // Obtém o nó esquerdo
    public Node<T> getFilhoEsquerdo() {
        return filhoEsquerdo;
    }

    // Altera o nó esquerdo
    public void setFilhoEsquerdo(Node<T> filhoEsquerdo) {
        this.filhoEsquerdo = filhoEsquerdo;
    }

    // Obtém o nó direito
    public Node<T> getFilhoDireito() {
        return filhoDireito;
    }

    // Altera o nó direito
    public void setFilhoDireito(Node<T> filhoDireito) {
        this.filhoDireito = filhoDireito;
    }
    
}