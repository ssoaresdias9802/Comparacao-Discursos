public class ABB {

    private Node root;
    private int quantidade;
    private Palavra maisFrequente;

    // construtor
    public ABB() {
        root = null;
        quantidade = 0;
    }

    // verifica se árvore está vazia
    public boolean isEmpty() {
        return root == null;
    }

    // adiciona nó como raiz
    public void addRoot(Node e) throws Exception {

        if (root != null) {
            throw new Exception("Árvore já tem raiz!");
        }

        root = e;
    }

    // retorna raiz
    public Node getRoot() {
        return root;
    }

    // verifica se nó é raiz
    public boolean isRoot(Node n) {
        return n.getParent() == null;
    }

    // verifica se nó é interno
    public boolean isInternal(Node n) {
        return n.getLeft() != null || n.getRight() != null;
    }

    // verifica se nó é folha
    public boolean isLeaf(Node n) {
        return n.getLeft() == null && n.getRight() == null;
    }

    // retorna filho esquerdo
    public Node left(Node e) {
        return e.getLeft();
    }

    // verifica se tem filho esquerdo
    public boolean hasLeft(Node e) {
        return e.getLeft() != null;
    }

    // retorna filho direito
    public Node right(Node e) {
        return e.getRight();
    }

    // verifica se tem filho direito
    public boolean hasRight(Node e) {
        return e.getRight() != null;
    }
    
    // **PERCURSOS**
    public void executaPreOrdem(Node no) {

        if (no == null) {
            return;
        }

        System.out.print(no.getElemento() + " ");

        executaPreOrdem(no.getLeft());

        executaPreOrdem(no.getRight());
    }

    public void executaInOrdem(Node no) {

        if (no == null) {
            return;
        }

        executaInOrdem(no.getLeft());

        System.out.print(no.getElemento() + " ");

        executaInOrdem(no.getRight());
    }

    public void executaPosOrdem(Node no) {

        if (no == null) {
            return;
        }

        executaPosOrdem(no.getLeft());

        executaPosOrdem(no.getRight());

        System.out.print(no.getElemento() + " ");
    }

    // **INSERÇÃO**
    //nao insere valores repetidos, apenas incrementa a contagem da palavra
    public void insere(String palavra) {

        Node atual = root;

        Node pai = null;

        while (atual != null) {

            pai = atual;

            String atualNome = atual.getElemento().getNome();

            // palavra já existe
            if (palavra.equals(atualNome)) {

                atual.getElemento().aumentarOcorrencia();

                return;
            }

            // esquerda
            if (palavra.compareTo(atualNome) < 0) {

                atual = atual.getLeft();

            }

            // direita
            else {

                atual = atual.getRight();
            }
        }

        Palavra p = new Palavra(palavra);

        Node novo = new Node(p);

        novo.setParent(pai);

        // árvore vazia
        if (pai == null) {

            root = novo;
        }

        else if (palavra.compareTo(pai.getElemento().getNome()) < 0) {

            pai.setLeft(novo);
        }

        else {

            pai.setRight(novo);
        }
        quantidade++;
    }


    public int contarPalavras() {
        return quantidade;
    }

    // **BUSCA**
    public Node busca(String valor) {

        Node atual = root;

        while (atual != null) {

            String valorAtual = (String) atual.getElemento().getNome();

            // encontrou
            if (valor.equals(valorAtual)) {

                return atual;

            }

            // esquerda
            else if (valor.compareTo(valorAtual) < 0) {

                atual = atual.getLeft();

            }

            // direita
            else {

                atual = atual.getRight();
            }
        }

        return null;
    }

    // **MÁXIMO**
    public Node maximo(Node x) {

        while (x.getRight() != null) {

            x = x.getRight();
        }

        return x;
    }

    // **MÍNIMO**
    public Node minimo(Node x) {

        while (x.getLeft() != null) {

            x = x.getLeft();
        }

        return x;
    }

    // **REMOÇÃO**
    public void delete(Node tree, String valor) {

        Node min;

        if (tree == null) {

            return;

        }

        String valorAtual = (String) tree.getElemento().getNome();

        // busca esquerda
        if (valor.compareTo(valorAtual) < 0) {

            delete(tree.getLeft(), valor);

        }

        // busca direita
        else if (valor.compareTo(valorAtual) > 0) {

            delete(tree.getRight(), valor);

        }

        // encontrou nó
        else {

            // caso: dois filhos
            if (tree.getLeft() != null && tree.getRight() != null) {

                min = minimo(tree.getRight());

                tree.setElemento(min.getElemento());

                delete(tree.getRight(), (String) min.getElemento().getNome());
            }

            // um filho ou nenhum
            else {

                Node filho;

                if (tree.getLeft() != null) {

                    filho = tree.getLeft();

                } else {

                    filho = tree.getRight();
                }

                // removendo raiz
                if (tree.getParent() == null) {

                    root = filho;

                    if (filho != null) {

                        filho.setParent(null);
                    }
                }

                else {

                    if (tree == tree.getParent().getLeft()) {

                        tree.getParent().setLeft(filho);

                    } else {

                        tree.getParent().setRight(filho);
                    }

                    if (filho != null) {

                        filho.setParent(tree.getParent());
                    }
                }
            }
        }
    }
   
    public int totalDistintas(Node no) {
        if (no == null) {
            return 0;
        }

        return 1
                + totalDistintas(no.getLeft())
                + totalDistintas(no.getRight());
    }

    public Palavra palavraMaisFrequente() {

        maisFrequente = null;

        buscarMaisFrequente(root);

        return maisFrequente;
    }

    private void buscarMaisFrequente(Node no) {
        if (no != null) {

            if (maisFrequente == null ||
                no.getElemento().getOcorrencia() >
                maisFrequente.getOcorrencia()) {

                maisFrequente = no.getElemento();
            }

            buscarMaisFrequente(no.getLeft());

            buscarMaisFrequente(no.getRight());
        }
    }

    public int palavrasUnicas(Node no) {

        if (no == null) {
            return 0;
        }

        int contador = 0;

        if (no.getElemento().getOcorrencia() == 1) {

            contador = 1;
        }

        return contador
                + palavrasUnicas(no.getLeft())
                + palavrasUnicas(no.getRight());
    }

    /*private Node raiz;

    // INSERIR
    public void inserir(String texto) {

        raiz = inserirRec(raiz, texto);
    }

    private Node inserirRec(Node atual, String texto) {

        // cria novo nó
        if (atual == null) {

            return new Node(new Palavra(texto));
        }

        int comparacao =
                texto.compareTo(atual.palavra.texto);

        // esquerda
        if (comparacao < 0) {

            atual.esquerda =
                    inserirRec(atual.esquerda, texto);
        }

        // direita
        else if (comparacao > 0) {

            atual.direita =
                    inserirRec(atual.direita, texto);
        }

        // palavra já existe
        else {

            atual.palavra.aumentarOcorrencia();
        }

        return atual;
    }

    // BUSCAR
    public Palavra buscar(String texto) {

        return buscarRec(raiz, texto);
    }


    // EM ORDEM
    public void emOrdem() {

        emOrdemRec(raiz);
    }

    private void emOrdemRec(Node atual) {

        if (atual != null) {

            emOrdemRec(atual.esquerda);

            System.out.println(atual.palavra);

            emOrdemRec(atual.direita);
        }
    }*/
}