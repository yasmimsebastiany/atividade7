import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HistoricoNavegacao historico = new HistoricoNavegacao(5);

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Adicionar URL ao histórico");
            System.out.println("2. Exibir histórico");
            System.out.println("3. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite a URL para adicionar: ");
                    String url = scanner.nextLine();
                    historico.adicionarPagina(url); 
                    System.out.println("URL adicionada ao histórico.");
                    break;

                case 2:
                    historico.exibirHistorico();
                    break;

                case 3:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}