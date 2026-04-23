package biblioteca.models;

import java.util.List;
import java.util.ArrayList;

public class Biblioteca {
    private String nome;
    private String endereco;

    /*
     * A relação entre Biblioteca e Livro é uma AGREGAÇÃO.
     * A Biblioteca possui uma coleção de Livros (acervo), mas os Livros existem
     * independentemente da Biblioteca. Se a Biblioteca for destruída, os Livros
     * continuam a existir.
     *
     * Isso difere da COMPOSIÇÃO (ex: Livro e Capítulo), onde os Capítulos não
     * existem sem o Livro. Se o Livro for destruído, seus Capítulos também são.
     */
    private List<Livro> acervo;

    public Biblioteca(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.acervo = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void adicionarLivro(Livro livro) {
        this.acervo.add(livro);
    }

    public void removerLivro(Livro livro) {
        this.acervo.remove(livro);
    }

    public List<Livro> getAcervo() {
        return acervo;
    }
}
