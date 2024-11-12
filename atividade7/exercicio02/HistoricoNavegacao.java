public class HistoricoNavegacao {
    private Pagina primeiro; 
    private int tamanhoAtual;
    private int tamanhoMaximo;

    public HistoricoNavegacao(int tamanhoMaximo) {
        this.primeiro = null;
        this.tamanhoAtual = 0;
        this.tamanhoMaximo = tamanhoMaximo;
    }

    public void adicionarPagina(String url) {
        Pagina novaPagina = new Pagina(url);
        if (primeiro == null) {
            primeiro = novaPagina; 
        } else {
            Pagina atual = primeiro;
            while (atual.proxima != null) {
                atual = atual.proxima;
            }
            atual.proxima = novaPagina;
        }

        tamanhoAtual++;

        if (tamanhoAtual > tamanhoMaximo) {
            removerPaginaAntiga();
        }
    }

    private void removerPaginaAntiga() {
        if (primeiro != null) {
            primeiro = primeiro.proxima; 
            tamanhoAtual--;
        }
    }

    public void exibirHistorico() {
        if (primeiro == null) {
            System.out.println("O histórico está vazio.");
            return;
        }

        Pagina atual = primeiro;
        System.out.println("Histórico de navegação:");
        while (atual != null) {
            System.out.println(atual.url);
            atual = atual.proxima;
        }
    }
}