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

            s.setName(readNmae());

            System.out.println("Matricula: ");
            s.setRegistration(scanner.nextLine());

            int age = readAge("Idade: ");
            s.setAge(age);

            students.add(s);
            option = readOption();
        } while (option != 0);
    }

    public void recordAp1() {
        Student s = findStudentByRegistration();
        if (s == null) {
            return;
        }
        double ap1 = readGrade("Nota Ap1: ");
        s.setAp1(ap1);
        System.out.println("Nota Registrada");
    }

    public void recordAp2() {
        Student s = findStudentByRegistration();
        if (s == null) {
            return;
        }
        double ap2 = readGrade("Nota Ap2: ");
        s.setAp2(ap2);
        System.out.println("Nota Registrada");
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

    private String readNmae() {
        while (true) {
            System.out.println("Nome: ");
            String name = scanner.nextLine().trim().replaceAll("\\s+", " ");

            if (name.isBlank()) {
                System.out.println("Nome nao pode estar vazio.");
                continue;
            }

            if (!name.matches("^[\\p{L}]+(?: [\\p{L}]+)*$")) {
                System.out.println("Nome invalido. Use apenas letras e espacos.");
                continue;
            }
            return name;
        }
    }

    private int readAge(String prompt) {
        while (true) {
            System.out.println(prompt);
            try {
                int value = scanner.nextInt();
                scanner.nextLine();

                if (value < 0) {
                    System.out.println("Idade Invalida.");
                }
                return value;
            } catch (Exception e) {
                System.out.println("Digite um numero valido!");
                scanner.nextLine();
            }
        }
    }

    private int readOption() {
        while (true) {
            System.out.println("Aluno Cadastrado, Aperte 0 Para Sair, Digite Qualquer Numero Para Continuar");
            try {
                int value = scanner.nextInt();
                scanner.nextLine();
                return value;
            } catch (Exception e) {
                System.out.println("Entrada Invlida.");
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
                    System.out.println("Nota invalida. Digite entre 0 e 10.");
                    continue;
                }
                return value;
            } catch (Exception e) {
                System.out.println("Entrada invalida. Digite um numero.");
                scanner.nextLine();
            }
        }
    }
}
