import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListaDeTarefas lista = new ListaDeTarefas();
        Scanner scanner = new Scanner(System.in);

        // Menu de opções
        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Adicionar tarefa");
            System.out.println("2. Exibir tarefas");
            System.out.println("3. Marcar tarefa como concluída");
            System.out.println("4. Remover tarefa");
            System.out.println("5. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.print("Digite a descrição da tarefa: ");
                    String descricao = scanner.nextLine();
                    lista.adicionarTarefa(descricao); 
                    System.out.println("Tarefa adicionada: " + descricao);
                    break;

                case 2:
                    System.out.println("\nTarefas:");
                    lista.exibirTarefas();
                    break;

                case 3:
                    System.out.print("Digite a descrição da tarefa para marcar como concluída: ");
                    String tarefaConcluida = scanner.nextLine();
                    lista.marcarComoConcluida(tarefaConcluida);
                    break;

                case 4:
                    System.out.print("Digite a descrição da tarefa para remover: ");
                    String tarefaRemover = scanner.nextLine();
                    lista.removerTarefa(tarefaRemover);
                    break;

                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    return; 

                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }
}