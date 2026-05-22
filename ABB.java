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


    // retorna raiz
    public Node getRoot() {
        return root;
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

        if(UM.contarPalavras() > DOIS.contarPalavras()){
            resultadoMetodo += "O discurso 1 é o mais longo com "+ UM.contarPalavras()+ " palavras.";
        }
        else if(UM.contarPalavras() < DOIS.contarPalavras()){
            resultadoMetodo += "O discurso 2 é o mais longo com "+ DOIS.contarPalavras()+ " palavras.";
        }
        else{
            resultadoMetodo = "Os dois discursos têm a mesma quantidade de palavras: "+ DOIS.contarPalavras();
        }

        resultadoMetodo += "\nDiscurso 1: "+ distintas1+ " palavras distintas\n";
        resultadoMetodo += "Discurso 2: "+ distintas2+ " palavras distintas\n";
        resultadoMetodo += "Palavras comuns: "+ palavrasComuns + "\n";
        resultadoMetodo += "Percentual comum em relação ao Discurso 1: "+ String.format("%.2f", percentual1)+ "%\n";
        resultadoMetodo += "Percentual comum em relação ao Discurso 2: " + String.format("%.2f", percentual2) + "%\n";
        resultadoMetodo += "Semelhança lexical geral: " + String.format("%.2f", semelhancaLexical)+ "%";
        return resultadoMetodo;
    }

    public String palavrasComuns(Node atual, ABB dois){
        String resultado = "";
        if(atual != null){
            resultado += palavrasComuns(atual.left, dois);
            int freq2 = dois.buscaPalavra(atual.getPalavra().getNome());
            if(freq2 > 0){
                resultado += atual.getPalavra().getNome()+ " - Discurso 1: "+ atual.getPalavra().getOcorrencia() + " | Discurso 2: "+ freq2 + "\n";
            }
            resultado += palavrasComuns(atual.right, dois);
        }

        return resultado;
}

    public String exibirPalavrasComuns(ABB UM, ABB DOIS){
        String resultado = "";
        resultado += "\n\nPalavras em comum:\n";
        resultado += palavrasComuns(UM.getRoot(), DOIS);
        return resultado;

    }


    // **BUSCA**


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