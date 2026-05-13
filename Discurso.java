import java.io.*;
import java.util.*;

public class Discurso{
    public static void lerArquivo(
            String nomeArquivo,
            ABB arvore) {

        try {
            BufferedReader br = new BufferedReader(new FileReader(nomeArquivo));
            String linha;

            while ((linha = br.readLine()) != null) {

                //linha = linha.toLowerCase();
                String[] palavras = linha.split("\\s+");
                
                for (String palavra : palavras) {
                    if (!palavra.isEmpty()) {
                        arvore.inserir(palavra);
                        /*
                        Node novo = new Node(palavra);
                        arvore.insere(novo);*/
                    }
                }
                
            }

            br.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
    /*public int totalPalavras(String nomeArquivo){
        int cont = 0;
        try {
            FileReader arq = new FileReader(nomeArquivo);
            BufferedReader br = new BufferedReader(arq);
        
            String linha;

            while ((linha = br.readLine()) != null) {

                String[] palavras = linha.split("\\s+");

            
                for (String palavra : palavras) {
                    cont++;
                }
            } 
        } catch (Exception e) {
            System.out.println("Erro ao tentar somar palavras:" + e.getMessage());
        }
        return cont;
    }*/
}
}