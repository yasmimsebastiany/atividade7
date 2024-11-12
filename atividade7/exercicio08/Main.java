import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProcessQueue processQueue = new ProcessQueue();

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Adicionar processo à fila");
            System.out.println("2. Executar próximo processo");
            System.out.println("3. Mostrar processos na fila");
            System.out.println("4. Sair");
            System.out.print("Opção: ");
            int option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1:
                    System.out.print("Digite o nome do processo: ");
                    String processName = scanner.nextLine();
                    System.out.print("Digite o ID do processo: ");
                    int processId = scanner.nextInt();
                    scanner.nextLine(); 
                    Process process = new Process(processName, processId);
                    processQueue.addProcess(process);
                    break;
                case 2:
                    processQueue.executeNextProcess();
                    break;
                case 3:
                    processQueue.showQueue();
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
