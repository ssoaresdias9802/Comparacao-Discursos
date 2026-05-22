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
                    discurso.lerArquivo("data/Discurso1.txt",discurso1);
                    discurso.lerArquivo("data/Discurso2.txt",discurso2);
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
                    System.out.println("Total de palavras: " + discurso1.contarPalavras());
                    System.out.println("Total de palavras distintas: " + discurso1.totalDistintas(discurso1.getRoot()));
                    System.out.println("Palavra mais frequente: " + discurso1.palavraMaisFrequente());
                    System.out.println("Quantidade de palavras que aparecem apenas uma vez: " + discurso1.palavrasUnicas(discurso1.getRoot()));
                    System.out.println("-------------------------------");
                    //cada discurso: total de palavras, total de palavras distintas,palavra mais frequente, quantidade de palavras que aparecem apenas uma vez.
                    break;
                case 3:
                    if(carregCase1 != true){
                        System.out.println("Necessário carregar discursos primeiro!");
                        break;
                    }
                    System.out.println("--- Discurso 2 Estatíscicas ---");
                    System.out.println("Total de palavras: " + discurso2.contarPalavras());
                    System.out.println("Total de palavras distintas: " + discurso2.totalDistintas(discurso2.getRoot()));
                    System.out.println("Palavra mais frequente: " + discurso2.palavraMaisFrequente());
                    System.out.println("Quantidade de palavras que aparecem apenas uma vez: " + discurso2.palavrasUnicas(discurso2.getRoot()));
                    System.out.println("-------------------------------");
                    //cada discurso: total de palavras, total de palavras distintas,palavra mais frequente, quantidade de palavras que aparecem apenas uma vez.
                    break;
                case 4:
                    if(carregCase1 != true){
                        System.out.println("Necessário carregar discursos primeiro!");
                        break;
                    }
                    String palavraBusca;
                    System.out.println("Palavra para busca:");
                    sc.nextLine();
                    palavraBusca = sc.nextLine();
                    int frequenciaBusca1 = discurso1.buscaPalavra(palavraBusca);
                    int frequenciaBusca2 = discurso2.buscaPalavra(palavraBusca);
                    if (frequenciaBusca1 > 0 && frequenciaBusca2 > 0 ){
                        System.out.println("Palavra encontrada no discurso 1: "+ frequenciaBusca1 + " vezes. Palavra encontrado no discurso 2: "+ frequenciaBusca2 + " vezes.");
                    }
                    else if(frequenciaBusca1 > 0){
                        System.out.println("Palavra encontrada no discurso 1: "+ frequenciaBusca1 + " vezes.");
                    }
                    else if(frequenciaBusca2 > 0){
                        System.out.println("Palavra encontrado no discurso 2: "+ frequenciaBusca2 + " vezes.");
                    }
                    else{
                        System.out.println("Palavra não encontrada.");
                    }
                    
                    break;
                case 5:
                    if(carregCase1 != true){
                        System.out.println("Necessário carregar discursos primeiro!");
                        break;
                    }
                    System.out.println("--- Discurso 1 Ordem Alfabética ---");
                    discurso1.emOrdem_Alfabetica();
                    System.out.println("");
                    System.out.println("--- Discurso 2 Ordem Alfabética ---");
                    discurso2.emOrdem_Alfabetica();
                    break;
                case 6:
                    if(carregCase1 != true){
                        System.out.println("Necessário carregar discursos primeiro!");
                        break;
                    }
                    System.out.println(discurso1.compararDiscursos(discurso1, discurso2));
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