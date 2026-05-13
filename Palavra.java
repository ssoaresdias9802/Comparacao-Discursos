public class Palavra {

    String palavra;
    int ocorrencias;

    public Palavra(String palavra) {
        this.palavra = palavra;
        this.ocorrencias = 1;
    }

    public void aumentarOcorrencia() {
        ocorrencias++;
    }

    public String toString() {
        return palavra + " = " + ocorrencias;
    }
}