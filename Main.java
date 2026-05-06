import java.util.*;
public class Main{

    public static void mostrarMenu(){
        System.out.println("---MENU---");
        System.out.println("1. Carregar discursos");
        System.out.println("2. Exibir estatísticas do Discurso 1");
        System.out.println("3. Exibir estatísticas do Discurso 2");
        System.out.println("4. Buscar palavra nos discursos");
        System.out.println("5. Exibir as palavras dos discursos em ordem alfabética");
        System.out.println("6. Comparar discursos");
        System.out.println("7. Exibir palavras comuns");
        System.out.println("8. Sair");
        System.out.println("----------");
    }

    public static void main (String [] args){
        do{
            mostrarMenu();
            System.out.println("Qual opção você deseja acessar?");
            opcao = sc.nextInt();

            switch (opcao){
                case 1:
                    System.out.println("Discursos carregados com sucesso");
                    System.out.println("Discurso 1: Coordenadora residente da ONU no Brasil, Silvia Rucks, na celebração global do Dia Internacional das Meninas nas TIC 2026, em 23 de abril");
                    System.out.println("Discurso 2: Malala, na Assembleia Geral da ONU, no “Dia Malala”, em 12 de julho de 2013");
                    break;
                case 2:
                    //cada discurso: total de palavras, total de palavras distintas,palavra mais frequente, quantidade de palavras que aparecem apenas uma vez.
                    break;
                case 3:
                    //cada discurso: total de palavras, total de palavras distintas,palavra mais frequente, quantidade de palavras que aparecem apenas uma vez.
                    break;
                case 4:

                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    System.out.println("Over!");
                    System.out.println("Integrandes: Laura Rocha Yaguiu, Stephanie Soares Dias");
                    break;
                default:
                    break;
            }

        }while(opcao != 8)
    }
}