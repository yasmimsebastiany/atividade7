import java.util.LinkedList;
import java.util.Queue;

public class BankQueueSimulator {
    private Queue<String> customerQueue;

    public BankQueueSimulator() {
        customerQueue = new LinkedList<>();
    }

    public void addCustomer(String customerName) {
        customerQueue.add(customerName);
        System.out.println("Cliente " + customerName + " adicionado à fila.");
    }

    public void serveNextCustomer() {
        if (customerQueue.isEmpty()) {
            System.out.println("Nenhum cliente na fila para atender.");
        } else {
            String nextCustomer = customerQueue.poll(); 
            System.out.println("Atendendo o cliente: " + nextCustomer);
        }
    }

    public void showQueue() {
        if (customerQueue.isEmpty()) {
            System.out.println("Nenhum cliente na fila.");
        } else {
            System.out.println("Clientes na fila: " + customerQueue);
        }
    }
}
