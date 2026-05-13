import java.io.*;
import java.util.*;

public class Discurso{
    HashMap<String, Palavra> contador;
    public Discurso(){
        contador = new HashMap<>();
    }
    public void lerArquivo(String nomeArquivo) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(nomeArquivo));
            String linha;

            while ((linha = br.readLine()) != null) {
                linha = linha.toLowerCase();
                String[] palavras = linha.split("\\s+");
                for (String texto : palavras) {

                    if (texto.isEmpty()) {
                        continue;
                    }

                    if (contador.containsKey(texto)) {
                        contador.get(texto).aumentarOcorrencia();

                    } else {

                        Palavra nova = new Palavra(texto);
                        contador.put(texto, nova);
                    }
                }
            }

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarContagem() {

        for (String chave : contador.keySet()) {
            Palavra p = contador.get(chave);
            System.out.println(p);
        }
    }
}