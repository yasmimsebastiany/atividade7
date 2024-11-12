import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintQueue printQueue = new PrintQueue();

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Adicionar trabalho de impressão");
            System.out.println("2. Processar próximo trabalho");
            System.out.println("3. Mostrar trabalhos na fila");
            System.out.println("4. Sair");
            System.out.print("Opção: ");
            int option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1:
                    System.out.print("Digite o nome do trabalho de impressão: ");
                    String jobName = scanner.nextLine();
                    System.out.print("Digite o número de páginas: ");
                    int pages = scanner.nextInt();
                    scanner.nextLine(); 
                    PrintJob job = new PrintJob(jobName, pages);
                    printQueue.addJob(job);
                    break;
                case 2:
                    printQueue.processNextJob();
                    break;
                case 3:
                    printQueue.showQueue();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
