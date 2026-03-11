package atividade001;

import java.util.Scanner;

public class Aplicacao {
    private Turma turma;
    private Scanner scanner;

    public Aplicacao() {
        this.turma = new Turma();
        this.scanner = new Scanner(System.in);
    }

    public void executar() {
        int opcao;
        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine();

            processarOpcao(opcao);

        } while (opcao != 0);
        scanner.close();
    }

    private void exibirMenu() {
        System.out.println("\n--- MENU ---");
        System.out.println("1 - Adicionar aluno");
        System.out.println("2 - Registrar frequencia");
        System.out.println("3 - Adicionar nota");
        System.out.println("4 - Ver dados dos alunos");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opcao: ");
    }

    private void processarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                adicionarAluno();
                break;
            case 2:
                registrarFrequencia();
                break;
            case 3:
                adicionarNota();
                break;
            case 4:
                turma.visualizarDados();
                break;
            case 0:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opcao invalida.");
        }
    }

    private void adicionarAluno() {
        System.out.print("Nome do aluno: ");
        String nome = scanner.nextLine();
        System.out.print("Matricula do aluno: ");
        String matricula = scanner.nextLine();

        turma.adicionarAluno(new Aluno(nome, matricula));
        System.out.println("Aluno adicionado com sucesso.");
    }

    private void registrarFrequencia() {
        if (turma.getAlunos().size() == 0) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            System.out.println("Alunos cadastrados:");
            turma.listarAlunos();

            System.out.print("Digite o numero do aluno: ");
            int indiceAluno = scanner.nextInt();

            if (indiceAluno >= 0 && indiceAluno < turma.getAlunos().size()) {
                System.out.print("O aluno esteve presente? (1 para sim, 0 para nao): ");
                int resposta = scanner.nextInt();
                scanner.nextLine();

                turma.registrarFrequencia(indiceAluno, resposta == 1);
                System.out.println("Frequencia registrada com sucesso.");
            } else {
                System.out.println("Aluno invalido.");
                scanner.nextLine();
            }
        }
    }

    private void adicionarNota() {
        if (turma.getAlunos().size() == 0) {
            System.out.println("Nenhum aluno cadastrado.");
        } else {
            System.out.println("Alunos cadastrados:");
            turma.listarAlunos();

            System.out.print("Digite o numero do aluno: ");
            int indiceAluno = scanner.nextInt();

            if (indiceAluno >= 0 && indiceAluno < turma.getAlunos().size()) {
                System.out.print("Digite qual nota deseja lancar (1 ou 2): ");
                int numeroNota = scanner.nextInt();

                if (numeroNota == 1 || numeroNota == 2) {
                    System.out.print("Digite a nota: ");
                    double nota = scanner.nextDouble();
                    scanner.nextLine();

                    turma.adicionarNota(indiceAluno, numeroNota, nota);
                    System.out.println("Nota adicionada com sucesso.");
                } else {
                    System.out.println("Numero de nota invalido.");
                    scanner.nextLine();
                }
            } else {
                System.out.println("Aluno invalido.");
                scanner.nextLine();
            }
        }
    }
}
