package biblioteca.models;

import biblioteca.enums.StatusEmprestimo;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Emprestimo {
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucaoPrevista;
    private StatusEmprestimo status;
    private Livro livro;
    private Leitor leitor;

    public Emprestimo(Leitor leitor, Livro livro, LocalDate dataDevolucaoPrevista) {
        this.leitor = leitor;
        this.livro = livro;
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
        this.status = StatusEmprestimo.ATIVO;
        this.livro.realizarEmprestimo();
        this.leitor.adicionarEmprestimo(this);
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucaoPrevista() {
        return dataDevolucaoPrevista;
    }

    public StatusEmprestimo getStatus() {
        return status;
    }

    public void setStatus(StatusEmprestimo status) {
        this.status = status;
    }

    public Livro getLivro() {
        return livro;
    }

    public Leitor getLeitor() {
        return leitor;
    }

    public double calcularMulta(LocalDate dataAtualDevolucao) {
        if (dataAtualDevolucao.isAfter(this.dataDevolucaoPrevista)) {
            long diasAtraso = ChronoUnit.DAYS.between(this.dataDevolucaoPrevista, dataAtualDevolucao);
            return diasAtraso * 1.50;
        }
        return 0;
    }
}
