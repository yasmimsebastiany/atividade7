import java.util.Scanner;

class Node {
    String operation;
    Node prev;
    Node next;

    public Node(String operation) {
        this.operation = operation;
        this.prev = null;
        this.next = null;
    }
}

class TextEditor {
    private Node current; 
    private Node head;    
    private Node tail;    

    public void addOperation(String operation) {
        Node newNode = new Node(operation);
        if (current != null) {
            current.next = null;
        } else if (head == null) {
            head = newNode;
        }

        newNode.prev = current;
        if (current != null) {
            current.next = newNode;
        }
        current = newNode;
        tail = current; 
        System.out.println("Operação adicionada: " + operation);
    }

    public void undoOperation() {
        if (current == null) {
            System.out.println("Nenhuma operação para desfazer.");
            return;
        }
        System.out.println("Operação desfeita: " + current.operation);
        current = current.prev; 
    }

    public void redoOperation() {
        if (current == null) {
            if (tail != null) {
                current = tail;
                System.out.println("Operação refeita: " + current.operation);
            } else {
                System.out.println("Nenhuma operação para refazer.");
            }
            return;
        }

        if (current.next == null) {
            System.out.println("Nenhuma operação para refazer.");
            return;
        }

        current = current.next; 
        System.out.println("Operação refeita: " + current.operation);
    }

    public void showOperations() {
        System.out.println("Operações registradas:");
        Node node = head;
        while (node != null) {
            System.out.println(node.operation);
            node = node.next;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TextEditor editor = new TextEditor();

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Adicionar operação");
            System.out.println("2. Desfazer operação (Undo)");
            System.out.println("3. Refazer operação (Redo)");
            System.out.println("4. Mostrar operações registradas");
            System.out.println("5. Sair");
            System.out.print("Opção: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Digite a operação para adicionar: ");
                    String operation = scanner.nextLine();
                    editor.addOperation(operation);
                    break;
                case 2:
                    editor.undoOperation();
                    break;
                case 3:
                    editor.redoOperation();
                    break;
                case 4:
                    editor.showOperations();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
