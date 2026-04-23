package biblioteca.models;

import java.util.List;
import java.util.ArrayList;

public class Livro {
    private String titulo;
    private String isbn;
    private int anoPublicacao;
    private int exemplaresDisponiveis;
    private Autor autor;
    private List<Capitulo> capitulos;

    public Livro(String titulo, String isbn, int anoPublicacao, int exemplaresDisponiveis, Autor autor) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.anoPublicacao = anoPublicacao;
        this.exemplaresDisponiveis = exemplaresDisponiveis;
        this.autor = autor;
        this.capitulos = new ArrayList<>();
        this.autor.adicionarLivro(this);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public int getExemplaresDisponiveis() {
        return exemplaresDisponiveis;
    }

    public void setExemplaresDisponiveis(int exemplaresDisponiveis) {
        this.exemplaresDisponiveis = exemplaresDisponiveis;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public List<Capitulo> getCapitulos() {
        return capitulos;
    }

    public void adicionarCapitulo(int numero, String titulo, int quantidadePaginas) {
        this.capitulos.add(new Capitulo(numero, titulo, quantidadePaginas));
    }

    public void realizarEmprestimo() {
        if (this.exemplaresDisponiveis > 0) {
            this.exemplaresDisponiveis--;
        } else {
            throw new IllegalStateException("Não há exemplares disponíveis para empréstimo.");
        }
    }

    public void devolverLivro() {
        this.exemplaresDisponiveis++;
    }
}
