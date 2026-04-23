package biblioteca.models;

public class Capitulo {
    private int numero;
    private String titulo;
    private int quantidadePaginas;

    Capitulo(int numero, String titulo, int quantidadePaginas) {
        this.numero = numero;
        this.titulo = titulo;
        this.quantidadePaginas = quantidadePaginas;
    }

    public int getNumero() {
        return numero;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getQuantidadePaginas() {
        return quantidadePaginas;
    }
}
