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
        Scanner sc = new Scanner(System.in);
        int opcao;
        ABB discurso1 = new ABB();
        ABB discurso2 = new ABB();
        Discurso discurso = new Discurso();
        boolean carregCase1 = false;

        do{
            mostrarMenu();
            System.out.println("Qual opção você deseja acessar?");
            opcao = sc.nextInt();

            switch (opcao){
                case 1:
                    discurso.lerArquivo("Discurso1.txt",discurso1);
                    discurso.lerArquivo("Discurso2.txt",discurso2);
                    System.out.println("Discursos carregados com sucesso");
                    System.out.println("Discurso 1: Coordenadora residente da ONU no Brasil, Silvia Rucks, na celebração global do Dia Internacional das Meninas nas TIC 2026, em 23 de abril");
                    System.out.println("Discurso 2: Malala, na Assembleia Geral da ONU, no “Dia Malala”, em 12 de julho de 2013");
                    carregCase1 = true;
                    break;
                case 2:
                    if(carregCase1 != true){
                        System.out.println("Necessário carregar discursos primeiro!");
                        break;
                    }
                    System.out.println("--- Discurso 1 Estatíscicas ---");
                    System.out.println("Total de palavras: " );
                    System.out.println("Total de palavras distintas:");
                    System.out.println("Palavra mais frequente");
                    System.out.println("Quantidade de palavras que aparecem apenas uma vez:");
                    System.out.println("-------------------------------");
                    //cada discurso: total de palavras, total de palavras distintas,palavra mais frequente, quantidade de palavras que aparecem apenas uma vez.
                    break;
                case 3:
                    if(carregCase1 != true){
                        System.out.println("Necessário carregar discursos primeiro!");
                        break;
                    }
                    System.out.println("--- Discurso 2 Estatíscicas ---");
                    System.out.println("Total de palavras: " );
                    System.out.println("Total de palavras distintas:");
                    System.out.println("Palavra mais frequente");
                    System.out.println("Quantidade de palavras que aparecem apenas uma vez:");
                    System.out.println("-------------------------------");
                    //cada discurso: total de palavras, total de palavras distintas,palavra mais frequente, quantidade de palavras que aparecem apenas uma vez.
                    break;
                case 4:
                    if(carregCase1 != true){
                        System.out.println("Necessário carregar discursos primeiro!");
                        break;
                    }

                    break;
                case 5:
                    if(carregCase1 != true){
                        System.out.println("Necessário carregar discursos primeiro!");
                        break;
                    }
                    break;
                case 6:
                    if(carregCase1 != true){
                        System.out.println("Necessário carregar discursos primeiro!");
                        break;
                    }
                    break;
                case 7:
                    if(carregCase1 != true){
                        System.out.println("Necessário carregar discursos primeiro!");
                        break;
                    }
                    break;
                case 8:
                    System.out.println("Over!");
                    System.out.println("Integrandes: Laura Rocha Yaguiu, Stephanie Soares Dias");
                    break;
                default:
                    break;
            }

        }while(opcao != 8);
    }
}