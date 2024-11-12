public class Pagina {
    String url;
    Pagina proxima;

    // Construtor para inicializar a URL
    public Pagina(String url) {
        this.url = url;
        this.proxima = null;
    }
}