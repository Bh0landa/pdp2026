package atividade001;

public class Aluno {
    private String nome;
    private String matricula;
    private int totalAulas;
    private int presencas;
    private double nota1;
    private double nota2;

    public Aluno(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
        this.totalAulas = 0;
        this.presencas = 0;
        this.nota1 = -1;
        this.nota2 = -1;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public int getTotalAulas() {
        return totalAulas;
    }

    public int getPresencas() {
        return presencas;
    }

    public double getNota1() {
        return nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void definirNota1(double nota1) {
        this.nota1 = nota1;
    }

    public void definirNota2(double nota2) {
        this.nota2 = nota2;
    }

    public void registrarFrequencia(boolean presente) {
        totalAulas++;

        if (presente) {
            presencas++;
        }
    }

    public double calcularFrequencia() {
        if (totalAulas == 0) {
            return 0;
        }

        return (presencas * 100.0) / totalAulas;
    }

    public double calcularMedia() {
        if (nota1 != -1 && nota2 != -1) {
            return (nota1 + nota2) / 2;
        }

        return 0;
    }

    private String mostrarNota(double nota) {
        if (nota == -1) {
            return "Nao lancada";
        }

        return String.valueOf(nota);
    }

    @Override
    public String toString() {
        return "Nome: " + nome
                + "\nMatricula: " + matricula
                + "\nNota 1: " + mostrarNota(nota1)
                + "\nNota 2: " + mostrarNota(nota2)
                + "\nMedia: " + (nota1 != -1 && nota2 != -1 ? calcularMedia() : "Nao calculada")
                + "\nPresencas: " + presencas
                + "\nTotal de aulas: " + totalAulas
                + "\nFrequencia: " + calcularFrequencia() + "%";
    }
}
