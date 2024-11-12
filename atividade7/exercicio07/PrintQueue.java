import java.util.LinkedList;
import java.util.Queue;

public class PrintQueue {
    private Queue<PrintJob> queue;

    public PrintQueue() {
        queue = new LinkedList<>();
    }

    public void addJob(PrintJob job) {
        queue.add(job);
        System.out.println("Trabalho de impressão adicionado: " + job);
    }

    public void processNextJob() {
        if (queue.isEmpty()) {
            System.out.println("Nenhum trabalho na fila para imprimir.");
        } else {
            PrintJob job = queue.poll(); 
            System.out.println("Imprimindo: " + job);
        }
    }

    public void showQueue() {
        if (queue.isEmpty()) {
            System.out.println("Nenhum trabalho na fila.");
        } else {
            System.out.println("Trabalhos na fila:");
            for (PrintJob job : queue) {
                System.out.println(job);
            }
        }
    }
}
