package atividade002;

import java.util.Scanner;

public class Application {
    private final Scanner scanner = new Scanner(System.in);
    private final AcademicManager manager = new AcademicManager(scanner);
    private int option;

    public void mainMenu() {
        System.out.println("""
                
                ------------M E N U------------
                |O QUE DESEJA FAZER?          |
                |1. Cadastrar Aluno;          |
                |2. Cadastrar Professor;      |
                |3. Cadastrar Disciplina;     |
                |4. Vincular Aluno;           |
                |5. Listar Disciplinas Aluno; |
                |6. Listar Disciplinas Prof.; |
                |7. Remover Disc. do Aluno;   |
                |8. Remover Disc. do Prof.;   |
                |9. Buscar Disciplina;        |
                |0. Sair;                     |
                -------------------------------
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

    public void processMainMenuChoice() {
        switch (option) {
            case 1 -> manager.addStudent();
            case 2 -> manager.addProfessor();
            case 3 -> manager.addDiscipline();
            case 4 -> manager.linkStudentToDiscipline();
            case 5 -> manager.listStudentDisciplines();
            case 6 -> manager.listProfessorDisciplines();
            case 7 -> manager.removeDisciplineFromStudent();
            case 8 -> manager.removeDisciplineFromProfessor();
            case 9 -> manager.searchDisciplineForStudent();
            case 0 -> System.out.println("Saindo.........");
            default -> System.out.println("Comando inválido");
        }
    }

    private int readMenuOption() {
        while (true) {
            try {
                int value = scanner.nextInt();
                scanner.nextLine();
                return value;
            } catch (Exception e) {
                System.out.println("Entrada Inválida.");
                scanner.nextLine();
            }
        }
    }
}