package biblioteca.models;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Leitor {
    private String nome;
    private String cpf;
    private String email;
    private LocalDate dataCadastro;
    private List<Emprestimo> emprestimos;

    public Leitor(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.dataCadastro = LocalDate.now();
        this.emprestimos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public List<Emprestimo> getEmprestimos() {
        return this.emprestimos;
    }

    public void adicionarEmprestimo(Emprestimo emprestimo) {
        this.emprestimos.add(emprestimo);
    }

    public double calcularMultaTotal(LocalDate dataAtual) {
        double multaTotal = 0;
        long emprestimosAtrasados = 0;

        for (Emprestimo emprestimo : this.emprestimos) {
            double multa = emprestimo.calcularMulta(dataAtual);
            if (multa > 0) {
                multaTotal += multa;
                emprestimosAtrasados++;
            }
        }

        if (emprestimosAtrasados > 3) {
            return multaTotal * 2;
        }

        return multaTotal;
    }
}
