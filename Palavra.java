public class Palavra {


    private String nome;

    private int ocorrencia;

    public Palavra(String nome) {

        this.nome = nome;

        this.ocorrencia = 1;
    }


    public String getNome() {
        return nome;
    }

    public int getOcorrencia() {
        return ocorrencia;
    }

    public void aumentarOcorrencia() {
        ocorrencia++;
    }
    public String toString(){
        return  getNome();
    }
}
    /*Se ocorrer
repetição de uma palavra no texto, deverá ser feita a contagem, a partir desta
classe:  */
