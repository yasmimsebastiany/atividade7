import java.util.LinkedList;
import java.util.Queue;

public class ProcessQueue {
    private Queue<Process> queue;

    public ProcessQueue() {
        queue = new LinkedList<>();
    }

    public void addProcess(Process process) {
        queue.add(process);
        System.out.println("Processo adicionado: " + process);
    }

    public void executeNextProcess() {
        if (queue.isEmpty()) {
            System.out.println("Nenhum processo na fila para execução.");
        } else {
            Process process = queue.poll(); 
            System.out.println("Executando: " + process);
        }
    }

    public void showQueue() {
        if (queue.isEmpty()) {
            System.out.println("Nenhum processo na fila.");
        } else {
            System.out.println("Processos na fila:");
            for (Process process : queue) {
                System.out.println(process);
            }
        }
    }
}
