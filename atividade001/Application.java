package atividade001;

import java.util.Scanner;

public class Application {
    private final Scanner scanner = new Scanner(System.in);
    private final StudentManager manager = new StudentManager(scanner);
    private int option;

    public void mainMenu() {
        System.out.println("""
                \s
                -----------M E N U------------
                |O QUE DESEJA FAZER?         |
                |1. Adicionar Aluno;         |
                |2. Registrar Nota;          |
                |3. Ver Dados dos Alunos;    |
                |4. Meddia da Turma;         |
                |0. Sair;                    |
                ------------------------------
                """);
    }

    public void mainMenuDisplay() {
        do {
            mainMenu();
            option = scanner.nextInt();
            scanner.nextLine();
            processMainMenuChoice();
        } while (option != 0);
        
        scanner.close();
    }

    public void processMainMenuChoice() {
        switch (option) {
            case 1 -> {
                manager.addStudent();
            }
            case 2 -> {
                manager.recordGrade();
            }
            case 3 -> {
                manager.viewStudentData();
            }
            case 4 -> {
                manager.calculateClassAverage();
            }
            case 0 ->System.out.println("Saindo.........");
            default -> System.out.println("Comando inválido");
        }
    }
}
