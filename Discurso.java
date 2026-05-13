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

                linha = linha.toLowerCase();
                String[] palavras = linha.split("\\s+");
                
                for (String palavra : palavras) {
                    if (!palavra.isEmpty()) {arvore.inserir(palavra);}
                }
            }

            br.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
}