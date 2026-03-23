package atividade001;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
    private final Scanner scanner;
    private final List<Student> students = new ArrayList<>();
    private int option;

    public StudentManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public void addStudent() {
        int option;
        do {
            Student s = new Student();

            String name = "";
            while (name.isBlank()) {
                System.out.println("Nome: ");
                name = scanner.nextLine().trim();

                if (name.isBlank()) {
                    System.out.println("Nome nao pode estar vazio.");
                }
            }
            s.setName(name);

            System.out.println("Matricula: ");
            s.setRegistration(scanner.nextLine());

            int age = 0;
            while (age <= 0) {
                System.out.println("Idade: ");
                try {
                    age = scanner.nextInt();
                    if (age <= 0) {
                        System.out.println("Idade invalida");
                    }
                } catch (Exception e) {
                    System.out.println("Digite um numero valido!");
                    scanner.nextLine();
                }
            }
            s.setAge(age);
            scanner.nextLine();

            students.add(s);
            System.out.println("Aluno Cadastrado, Aperte 0 Para Sair");
            option = scanner.nextInt();
            scanner.nextLine();
        } while (option != 0);
    }

    public void gradeMenu() {
        System.out.println("""
                \s
                =====REGISTRO DE NOTAS=====
                |1. Ap1;                   |
                |2. Ap2;                   |
                |0. Sair;                  |
                ===========================
                """);
    }

    public void recordGrade() {
        Student s = findStudentByRegistration();
        if (s == null) {
            return;
        }
        do {
            gradeMenu();
            option = scanner.nextInt();
            scanner.nextLine();
            processGradeMenuChoice(s);
        } while (option != 0);
    }

    public void processGradeMenuChoice(Student s) {
        switch (option) {
            case 1 -> {
                while (true) {
                    System.out.println("Nota Ap1: ");
                    try {
                        double ap1 = scanner.nextDouble();
                        scanner.nextLine();

                        if (ap1 < 0 || ap1 > 10) {
                            System.out.println("Nota invalida. Digite entre 0 e 10.");
                            continue;
                        }
                        s.setAp1(ap1);
                        System.out.println("Nota da Ap1 Registrada: ");
                        break;
                    } catch (Exception e) {
                        System.out.println("Entrada invalida. Digite um numero.");
                        scanner.nextLine();
                    }
                }
            }
            case 2 -> {
                while (true) {
                    System.out.println("Nota Ap2: ");
                    try {
                        double ap2 = scanner.nextDouble();
                        scanner.nextLine();

                        if (ap2 < 0 || ap2 > 10) {
                            System.out.println("Nota invalida. Digite entre 0 e 10.");
                            continue;
                        }
                        s.setAp1(ap2);
                        System.out.println("Nota da Ap2 Registrada: ");
                        break;
                    } catch (Exception e) {
                        System.out.println("Entrada invalida. Digite um numero.");
                        scanner.nextLine();
                    }
                }
            }
            case 0 -> System.out.println("Saindo do registro de notas...");
            default -> System.out.println("Opcao invalida.");
        }
    }

    public void viewStudentData() {
        if (students.isEmpty()) {
            System.out.println("Nenhum Aluno Cadastrado.");
            return;
        }

        System.out.println("===LISTA DE ALUNOS===");
        for (Student s : students) {
            System.out.println(s);
        }

    }

    public void calculateClassAverage() {
        if (students.isEmpty()) {
            System.out.println("Nenhum Aluno Cadastrado.");
            return;
        }

        double sum = 0;
        for (Student s : students) {
            sum += s.getFinalGrade();
        }

        double average = sum / students.size();
        System.out.println("Media da turma: " + average);
    }

    private Student findStudentByRegistration() {
        if (students.isEmpty()) {
            System.out.println("Nenhum Aluno Cadastrado.");
            return null;
        }

        System.out.println("Informe a Matricula: ");
        String registration = scanner.nextLine();

        for (Student s : students) {
            if (s.getRegistration().equalsIgnoreCase(registration)) {
                return s;
            }
        }

        System.out.println("Aluno Não Encontrado");
        return null;
    }
}
