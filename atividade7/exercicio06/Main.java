import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankQueueSimulator bankQueue = new BankQueueSimulator();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Adicionar cliente à fila");
            System.out.println("2. Chamar próximo cliente para atendimento");
            System.out.println("3. Mostrar clientes na fila");
            System.out.println("4. Sair");
            System.out.print("Opção: ");
            int option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1:
                    System.out.print("Digite o nome do cliente: ");
                    String customerName = scanner.nextLine();
                    bankQueue.addCustomer(customerName);
                    break;
                case 2:
                    bankQueue.serveNextCustomer();
                    break;
                case 3:
                    bankQueue.showQueue();
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
