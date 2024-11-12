import java.util.Scanner;

class Card {
    String value;  
    Card prev;     
    Card next;     

    public Card(String value) {
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}

class CardHand {
    private Card head; 
    private Card tail; 

    public void addCard(String value) {
        Card newCard = new Card(value);
        if (head == null) {
            head = newCard;
            tail = newCard;
        } else {
            tail.next = newCard;
            newCard.prev = tail;
            tail = newCard;
        }
        System.out.println("Carta adicionada: " + value);
    }

    public void removeCard(String value) {
        if (head == null) {
            System.out.println("A mão está vazia. Nenhuma carta para remover.");
            return;
        }
        Card current = head;
        while (current != null) {
            if (current.value.equals(value)) {
                if (current == head) {
                    head = current.next;
                    if (head != null) {
                        head.prev = null;
                    }
                } else if (current == tail) {
                    tail = current.prev;
                    if (tail != null) {
                        tail.next = null;
                    }
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                System.out.println("Carta removida: " + value);
                return;
            }
            current = current.next;
        }
        System.out.println("Carta não encontrada: " + value);
    }

    public void moveCard(String value, int newPosition) {
        if (head == null) {
            System.out.println("A mão está vazia.");
            return;
        }

        Card current = head;
        while (current != null && !current.value.equals(value)) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Carta não encontrada: " + value);
            return;
        }

        if (current == head) {
            head = current.next;
            if (head != null) {
                head.prev = null;
            }
        } else if (current == tail) {
            tail = current.prev;
            if (tail != null) {
                tail.next = null;
            }
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }

        if (newPosition <= 0) {
            current.next = head;
            if (head != null) {
                head.prev = current;
            }
            head = current;
            head.prev = null;
            if (tail == null) {
                tail = head;
            }
        } else {
            Card temp = head;
            int pos = 0;
            while (temp != null && pos < newPosition) {
                temp = temp.next;
                pos++;
            }

            if (temp == null) {
                tail.next = current;
                current.prev = tail;
                tail = current;
                tail.next = null;
            } else {
                current.next = temp;
                current.prev = temp.prev;
                if (temp.prev != null) {
                    temp.prev.next = current;
                }
                temp.prev = current;
                if (temp == head) {
                    head = current;
                }
            }
        }

        System.out.println("Carta movida para a nova posição: " + value);
    }

    public void showHand() {
        if (head == null) {
            System.out.println("A mão está vazia.");
            return;
        }
        Card current = head;
        System.out.println("Cartas na mão:");
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CardHand hand = new CardHand();

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Adicionar carta");
            System.out.println("2. Remover carta");
            System.out.println("3. Mover carta para nova posição");
            System.out.println("4. Mostrar cartas na mão");
            System.out.println("5. Sair");
            System.out.print("Opção: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Digite o nome da carta para adicionar: ");
                    String cardToAdd = scanner.nextLine();
                    hand.addCard(cardToAdd);
                    break;
                case 2:
                    System.out.print("Digite o nome da carta para remover: ");
                    String cardToRemove = scanner.nextLine();
                    hand.removeCard(cardToRemove);
                    break;
                case 3:
                    System.out.print("Digite o nome da carta para mover: ");
                    String cardToMove = scanner.nextLine();
                    System.out.print("Digite a nova posição (0 para início): ");
                    int newPosition = scanner.nextInt();
                    hand.moveCard(cardToMove, newPosition);
                    break;
                case 4:
                    hand.showHand();
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
