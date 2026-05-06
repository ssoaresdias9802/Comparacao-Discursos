public class Palavra{
    String palavra;
    int ocorrencias;

    public Palavra(String palavra, int ocorrencias){
        this.palavra = palavra;
        this.ocorrencias = ocorrencias;
    }

    public void lerArquivo(){
        try {
            FileReader arq = new FileReader("Discurso1.txt");
            BufferedReader linha = new BufferedReader(arq);
            FileReader arq2 = new FileReader("Discurso2.txt"); 
            BufferedReader linha = new BufferedReader(arq2);


            int pos = 0; 

            while(aux != null) {
                // separa dentro de vetor sempre que encontra virgula
                String[] dados = aux.split(",");
                ABB d1 = new Exame(dados[0],dados[1],Integer.parseInt(dados[2]));
                listaExamesDisponiveis.add(pos,ex);
                pos++;
                // proximo exame
                aux = linha.readLine();
            }
            arq.close();
        }
        catch(Exception e) {
            System.out.println("Erro na leitura do arquivo: " + e.getMessage());
        }
        
    }
}