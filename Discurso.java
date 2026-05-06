public class Discurso{

    public void lerArquivo(){
        try {
            FileReader arq = new FileReader("Discurso1.txt");
            BufferedReader linha1 = new BufferedReader(arq);
            FileReader arq2 = new FileReader("Discurso2.txt"); 
            BufferedReader linha2 = new BufferedReader(arq2);

            aux1 = linha1.readLine();
            aux2 = linha2.readLine();


            int pos = 0; 

            while(aux1!= null && aux2 != null) {
                // separa dentro de vetor sempre que encontra virgula
                // em processo
                String[] dados1 = aux1.split("\\s+");
                String[] dados2 = aux2.split("\\s+");

                Node d1 = new Node(dados1[pos]); 
                ABB1.add(d1);

                Node d2 = new Node(dados2[pos]);
                ABB2.add(d2);

                pos++;
                // proximo exame
                aux1 = linha1.readLine();
                aux2.linha2.readLine();
            }
            arq.close();
            arq2.close();
        }
        catch(Exception e) {
            System.out.println("Erro na leitura do arquivo: " + e.getMessage());
        }
        
    }
}