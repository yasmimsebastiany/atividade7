public class ListaDeTarefas {
    Tarefa primeiro; 

    public ListaDeTarefas() {
        this.primeiro = null; 
    }

    public void adicionarTarefa(String descricao) {
        Tarefa novaTarefa = new Tarefa(descricao);
        if (primeiro == null) {
            primeiro = novaTarefa; 
        } else {
            Tarefa atual = primeiro;
            while (atual.proxima != null) {
                atual = atual.proxima; 
            }
            atual.proxima = novaTarefa; 
        }
    }

    public void removerTarefa(String descricao) {
        if (primeiro == null) {
            System.out.println("A lista está vazia.");
            return;
        }

        if (primeiro.descricao.equals(descricao)) {
            primeiro = primeiro.proxima;
            return;
        }

        Tarefa atual = primeiro;
        while (atual.proxima != null) {
            if (atual.proxima.descricao.equals(descricao)) {
                atual.proxima = atual.proxima.proxima; 
                return;
            }
            atual = atual.proxima;
        }

        System.out.println("Tarefa não encontrada.");
    }

    public void marcarComoConcluida(String descricao) {
        Tarefa atual = primeiro;
        while (atual != null) {
            if (atual.descricao.equals(descricao)) {
                atual.marcarComoConcluida();
                return;
            }
            atual = atual.proxima;
        }
        System.out.println("Tarefa não encontrada.");
    }

    public void exibirTarefas() {
        if (primeiro == null) {
            System.out.println("Não há tarefas na lista.");
            return;
        }

        Tarefa atual = primeiro;
        while (atual != null) {
            System.out.println(atual);
            atual = atual.proxima;
        }
    }
}