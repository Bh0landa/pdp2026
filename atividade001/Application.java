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
                |4. Media da Turma;          |
                |0. Sair;                    |
                ------------------------------
                """);
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

    public void mainMenuDisplay() {
        do {
            mainMenu();
            option = readMenuOption();
            processMainMenuChoice();
        } while (option != 0);
        
        scanner.close();
    }

    public void gradeMenuDisplay() {
        do {
            gradeMenu();
            option = readMenuOption();
            processGradeMenuChoice();
        } while (option != 0);
    }

    public void processMainMenuChoice() {
        switch (option) {
            case 1 -> {
                manager.addStudent();
            }
            case 2 -> {
                gradeMenuDisplay();
            }
            case 3 -> {
                manager.viewStudentData();
            }
            case 4 -> {
                manager.calculateClassAverage();
            }
            case 0 -> System.out.println("Saindo.........");
            default -> System.out.println("Comando inválido");
        }
    }

    public void processGradeMenuChoice() {
        switch (option) {
            case 1 -> {
                manager.recordAp1();
            }
            case 2 -> {
                manager.recordAp2();
            }
            case 0 -> System.out.println("Saindo do registro de notas...");
            default -> System.out.println("Comando inválido");
        }
    }

    private int readMenuOption() {
        while (true) {
            try{
                int value = scanner.nextInt();
                scanner.nextLine();
                return value;
            } catch (Exception e) {
                System.out.println("Entrada Invalida.");
                scanner.nextLine();
            }
        }
    }
}
