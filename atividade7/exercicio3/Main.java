import java.util.Scanner;

class Node {
    String operation;
    Node next;

    public Node(String operation) {
        this.operation = operation;
        this.next = null;
    }
}

class UndoSystem {
    private Node top;

    public void addOperation(String operation) {
        Node newNode = new Node(operation);
        newNode.next = top;
        top = newNode;
        System.out.println("Operação adicionada: " + operation);
    }

    public void undoOperation() {
        if (top == null) {
            System.out.println("Nenhuma operação para desfazer.");
            return;
        }
        System.out.println("Operação desfeita: " + top.operation);
        top = top.next; 
    }

    public void showOperations() {
        if (top == null) {
            System.out.println("Nenhuma operação registrada.");
            return;
        }
        System.out.println("Operações registradas:");
        Node current = top;
        while (current != null) {
            System.out.println(current.operation);
            current = current.next;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UndoSystem undoSystem = new UndoSystem();

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Adicionar operação");
            System.out.println("2. Desfazer operação");
            System.out.println("3. Mostrar operações");
            System.out.println("4. Sair");
            System.out.print("Opção: ");
            int option = scanner.nextInt();
            scanner.nextLine();  

            switch (option) {
                case 1:
                    System.out.print("Digite a operação para adicionar: ");
                    String operation = scanner.nextLine();
                    undoSystem.addOperation(operation);
                    break;
                case 2:
                    undoSystem.undoOperation();
                    break;
                case 3:
                    undoSystem.showOperations();
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
