package atividade001;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private List<Aluno> alunos;

    public Turma() {
        this.alunos = new ArrayList<>();
    }

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public void registrarFrequencia(int indiceAluno, boolean presente) {
        if (indiceAluno >= 0 && indiceAluno < alunos.size()) {
            alunos.get(indiceAluno).registrarFrequencia(presente);
        }
    }

    public void adicionarNota(int indiceAluno, int numeroNota, double nota) {
        if (indiceAluno >= 0 && indiceAluno < alunos.size()) {
            if (numeroNota == 1) {
                alunos.get(indiceAluno).definirNota1(nota);
            } else if (numeroNota == 2) {
                alunos.get(indiceAluno).definirNota2(nota);
            }
        }
    }

    public void listarAlunos() {
        for (int i = 0; i < alunos.size(); i++) {
            System.out.println(i + " - " + alunos.get(i).getNome());
        }
    }

    public void visualizarDados() {
        for (int i = 0; i < alunos.size(); i++) {
            System.out.println(alunos.get(i));
            System.out.println();
        }
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }
}
