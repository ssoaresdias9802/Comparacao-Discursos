public class ABB {

    private Node raiz;

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
    }
}