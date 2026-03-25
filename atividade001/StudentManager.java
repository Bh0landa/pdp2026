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
        do {
            Student s = new Student();

            s.setName(readName("Nome: "));

            s.setRegistration(readRegistration("Matricula: "));

            int age = readAge("Idade: ");
            s.setAge(age);

            students.add(s);
            option = readMenuOption();
        } while (option != 0);
    }

    public void recordAp1() {
        Student s = findStudentByRegistration();
        if (s == null) {
            return;
        }
        double ap1 = readGrade("Nota Ap1: ");
        s.setAp1(ap1);
        System.out.println("Nota Ap1 Registrada: " + String.format("%.2f", ap1));
    }

    public void recordAp2() {
        Student s = findStudentByRegistration();
        if (s == null) {
            return;
        }
        double ap2 = readGrade("Nota Ap2: ");
        s.setAp2(ap2);
        System.out.println("Nota Ap2 Registrada: " + String.format("%.2f", ap2));
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
        System.out.println("Media da turma: " + String.format("%.2f", average));
    }

    private Student findStudentByRegistration() {
        if (students.isEmpty()) {
            System.out.println("Nenhum Aluno Cadastrado.");
            return null;
        }
        while (true) {
            System.out.println("Informe a Matricula ou aperte 0 para sair: ");
            String registration = normalizeRegistration(scanner.nextLine());

            if (registration.equals("0")) {
                System.out.println("Operacão Cancelada");
                return null;
            }

            if (registration.isEmpty()) {
                System.out.println("Matricula não pode estar vazia.");
                continue;
            }

            for (Student s : students) {
                if (s.getRegistration().equalsIgnoreCase(registration)) {
                    return s;
                }
            }

            System.out.println("Aluno Não Encontrado");
        }
    }

    private String readName(String prompt) {
        while (true) {
            System.out.println(prompt);
            String name = scanner.nextLine().trim().replaceAll("\\s+", " ");

            if (name.isBlank()) {
                System.out.println("Nome não pode estar vazio.");
                continue;
            }

            if (!name.matches("^[\\p{L}]+(?: [\\p{L}]+)*$")) {
                System.out.println("Nome inválido. Use apenas letras e espacos.");
                continue;
            }
            return name.toUpperCase(java.util.Locale.ROOT);
        }
    }

    private String normalizeRegistration(String raw) {
        return raw.replaceAll("\\s+", "").toUpperCase(java.util.Locale.ROOT);
    }

    private String readRegistration(String prompt) {
        while (true) {
            System.out.println(prompt);
            String registration = normalizeRegistration(scanner.nextLine());

            if (registration.isBlank()) {
                System.out.println("Matricula não pode estar vazia.");
                continue;
            }

            if (!registration.matches("^[A-Za-z0-9]+$")) {
                System.out.println("Matricula inválida. Use apenas letras e numeros.");
                continue;
            }
            if (isRegistrationTaken(registration)) {
                System.out.println("Matricula ja registrada");
                continue;
            }
            return registration.toUpperCase(java.util.Locale.ROOT);
        }
    }

    private boolean isRegistrationTaken(String registration) {
        for (Student s : students) {
            if (s.getRegistration().equalsIgnoreCase(registration)) {
                return true;
            }
        }
        return false;
    }

    private int readAge(String prompt) {
        while (true) {
            System.out.println(prompt);
            try {
                int value = scanner.nextInt();
                scanner.nextLine();

                if (value <= 15) {
                    System.out.println("Idade Inválida.");
                    continue;
                }
                return value;
            } catch (Exception e) {
                System.out.println("Digite um numero válido!");
                scanner.nextLine();
            }
        }
    }

    private int readMenuOption() {
        while (true) {
            System.out.println("Aluno Cadastrado. Digite 1 para continuar ou 0 para sair:");
            try {
                int value = scanner.nextInt();
                scanner.nextLine();

                if (value == 0 || value == 1) {
                    return value;
                }
                System.out.println("Opcao inválida. Use apenas 0 ou 1.");
            } catch (Exception e) {
                System.out.println("Entrada Inválida. Digite um numero");
                scanner.nextLine();
            }
        }
    }

    private double readGrade(String prompt) {
        while (true) {
            System.out.println(prompt);
            try {
                double value = scanner.nextDouble();
                scanner.nextLine();

                if (value < 0 || value > 10) {
                    System.out.println("Nota inválida. Digite entre 0 e 10.");
                    continue;
                }
                return value;
            } catch (Exception e) {
                System.out.println("Entrada inválida. Digite um numero.");
                scanner.nextLine();
            }
        }
    }
}
