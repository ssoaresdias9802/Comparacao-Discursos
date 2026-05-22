public class Node {
    private Palavra elemento;

    public Node left;
    public Node right;
    public Node parent;

    // construtor
    public Node(Palavra elemento) {

        this.elemento = elemento;

        left = null;
        right = null;
        parent = null;
    }

    // retorna elemento
    public Palavra getElemento() {

        return elemento;
    }

    // altera elemento
    public void setElemento(Palavra e) {

        this.elemento = e;
    }

    // retorna pai
    public Node getParent() {

        return parent;
    }

    // altera pai
    public void setParent(Node p) {

        this.parent = p;
    }

    // retorna filho esquerdo
    public Node getLeft() {

        return left;
    }

    // altera filho esquerdo
    public void setLeft(Node p) {

        this.left = p;
    }

    // retorna filho direito
    public Node getRight() {

        return right;
    }

    // altera filho direito
    public void setRight(Node p) {

        this.right = p;
    }

    public Palavra getPalavra(){
        return this.elemento;
    }

    /*
     char elemento;
    Node pai;
    Node esq;
    Node dir;

    Node(char elemento){
        this.elemento = elemento;
        pai = esq = dir = null;

    }
    public void mostrarNo(){
        System.out.print(elemento + " ");
    }*/
    /*Palavra palavra;
    Node esquerda;
    Node direita;

    public Node(Palavra palavra) {
        this.palavra = palavra;
    }*/
}