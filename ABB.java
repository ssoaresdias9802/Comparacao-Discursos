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

    public void executaInOrdem() {
       executaInOrdem(root);
    }

    public void executaInOrdem(Node no) {

        if (no == null) {
            return;
        }

        executaInOrdem(no.getLeft());

        System.out.print(" Palavra: " + no.getElemento().getNome() +" - " + no.getElemento().getOcorrencia() + "|");

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


    public int quantidadePalavrasComuns(Node atual, ABB dois){

    int quantidade = 0;

    if(atual != null){

        quantidade += quantidadePalavrasComuns(atual.left, dois);

        if(dois.buscaPalavra(atual.getPalavra().getNome()) > 0){
            quantidade++;
        }

        quantidade += quantidadePalavrasComuns(atual.right, dois);
    }

    return quantidade;
}


    public String compararDiscursos(ABB UM, ABB DOIS){

        int distintas1 = UM.totalDistintas(UM.getRoot());
        int distintas2 = DOIS.totalDistintas(DOIS.getRoot());
        int palavrasComuns = quantidadePalavrasComuns(UM.getRoot(), DOIS);
        int totalSemRepeticao = distintas1 + distintas2 - palavrasComuns;

        double percentual1 = ((double) palavrasComuns / distintas1) * 100;
        double percentual2 = ((double) palavrasComuns / distintas2) * 100;
        double semelhancaLexical = ((double) palavrasComuns / totalSemRepeticao) * 100;

        String resultadoMetodo = "";

        resultadoMetodo += "Discurso 1: "+ distintas1+ " palavras distintas\n";
        resultadoMetodo += "Discurso 2: "+ distintas2+ " palavras distintas\n";
        resultadoMetodo += "Palavras comuns: "+ palavrasComuns + "\n";
        resultadoMetodo += "Percentual comum em relação ao Discurso 1: "+ String.format("%.2f", percentual1)+ "%\n";
        resultadoMetodo += "Percentual comum em relação ao Discurso 2: " + String.format("%.2f", percentual2) + "%\n";
        resultadoMetodo += "Semelhança lexical geral: " + String.format("%.2f", semelhancaLexical)+ "%";
        return resultadoMetodo;
    }


    // **BUSCA**
    public Node buscaNode(String valor) {

        Node atual = root;

        while (atual != null) {

            String valorAtual = atual.getElemento().getNome();

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

    public int buscaPalavra(String valor) {

        Node atual = root;

        while (atual != null) {

            String valorAtual = atual.getElemento().getNome();

            // encontrou
            if (valor.equals(valorAtual)) {
                return atual.getPalavra().getOcorrencia();
                

            }

            // esquerda
            else if (valor.compareTo(valorAtual) < 0) {
                atual = atual.getLeft();
               

            }

            // direita
            else{
                atual = atual.getRight();
               
            }
        }
        return 0;
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
    }*/


    // EM ORDEM
    public void emOrdem_Alfabetica() {
        emOrdemRec(root);
    }

    private void emOrdemRec(Node atual) {

        if (atual != null) {

            emOrdemRec(atual.left);

            System.out.println(atual.getPalavra()+ " : " + atual.getPalavra().getOcorrencia());

            emOrdemRec(atual.right);
        }
    }
}