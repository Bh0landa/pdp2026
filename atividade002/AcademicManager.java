package atividade002;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AcademicManager {
    private final Scanner scanner;
    private final Map<String, Student> students = new HashMap<>();
    private final Map<String, Professor> professors = new HashMap<>();
    private final Map<String, Discipline> disciplines = new HashMap<>();

    public AcademicManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public void addStudent() {
        Student student = new Student();
        student.setName(readName("Nome do aluno: "));
        student.setRegistration(readUniqueKey("Matricula do aluno: ", students));
        students.put(student.getRegistration(), student);
        System.out.println("Aluno cadastrado com sucesso.");
    }

    public void addProfessor() {
        Professor professor = new Professor();
        professor.setName(readName("Nome do professor: "));
        professor.setRegistration(readUniqueKey("Registro do professor: ", professors));
        professors.put(professor.getRegistration(), professor);
        System.out.println("Professor cadastrado com sucesso.");
    }

    public void addDiscipline() {
        Discipline discipline = new Discipline();
        discipline.setName(readName("Nome da disciplina: "));
        discipline.setCode(readUniqueKey("Codigo da disciplina: ", disciplines));

        disciplines.put(discipline.getCode(), discipline);
        System.out.println("Disciplina cadastrada com sucesso.");
    }

    public void linkProfessorToDiscipline() {
        Discipline discipline = findDisciplineByCode();
        if (discipline == null) {
            return;
        }

        Professor professor = findProfessorByRegistration();
        if (professor == null) {
            return;
        }

        Professor previousProfessor = discipline.getProfessor();
        if (previousProfessor == professor) {
            System.out.println("Este professor ja esta vinculado a disciplina.");
            return;
        }

        if (previousProfessor != null) {
            previousProfessor.removeDiscipline(discipline);
        }

        discipline.setProfessor(professor);
        professor.addDiscipline(discipline);
        System.out.println("Professor vinculado a disciplina com sucesso.");
    }

    public void linkStudentToDiscipline() {
        Discipline discipline = findDisciplineByCode();
        if (discipline == null) {
            return;
        }

        Student student = findStudentByRegistration();
        if (student == null) {
            return;
        }

        if (discipline.addStudent(student)) {
            student.addDiscipline(discipline);
            System.out.println("Aluno vinculado a disciplina com sucesso.");
        } else {
            System.out.println("Este aluno ja esta vinculado a disciplina.");
        }
    }

    public void listStudentDisciplines() {
        Student student = findStudentByRegistration();
        if (student == null) {
            return;
        }

        System.out.println("=== DISCIPLINAS DO ALUNO ===");
        if (student.getDisciplines().isEmpty()) {
            System.out.println("Nenhuma disciplina cadastrada para este aluno.");
            return;
        }

        for (Discipline discipline : student.getDisciplines()) {
            System.out.println(discipline);
        }
    }

    public void listProfessorDisciplines() {
        Professor professor = findProfessorByRegistration();
        if (professor == null) {
            return;
        }

        System.out.println("=== DISCIPLINAS DO PROFESSOR ===");
        if (professor.getDisciplines().isEmpty()) {
            System.out.println("Nenhuma disciplina cadastrada para este professor.");
            return;
        }

        for (Discipline discipline : professor.getDisciplines()) {
            System.out.println(discipline);
        }
    }

    public void removeDisciplineFromStudent() {
        Student student = findStudentByRegistration();
        if (student == null) {
            return;
        }

        Discipline discipline = findDisciplineForStudent(student);
        if (discipline == null) {
            return;
        }

        student.removeDiscipline(discipline);
        discipline.removeStudent(student);
        System.out.println("Disciplina removida do aluno com sucesso.");
    }

    public void removeDisciplineFromProfessor() {
        Professor professor = findProfessorByRegistration();
        if (professor == null) {
            return;
        }

        Discipline discipline = findDisciplineForProfessor(professor);
        if (discipline == null) {
            return;
        }

        professor.removeDiscipline(discipline);
        discipline.setProfessor(null);
        System.out.println("Disciplina removida do professor com sucesso.");
    }

    public void searchDisciplineForStudent() {
        Student student = findStudentByRegistration();
        if (student == null) {
            return;
        }

        Discipline discipline = findDisciplineForStudent(student);
        if (discipline == null) {
            return;
        }

        System.out.println("=== INFORMAÇÕES DA DISCIPLINA ===");
        System.out.println(discipline.getDetailedInfo());
    }

    private Student findStudentByRegistration() {
        if (students.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return null;
        }

        while (true) {
            String registration = readLookupCode("Informe a matricula do aluno ou 0 para cancelar:", "Matricula nao pode estar vazia.");
            if (registration == null) {
                return null;
            }

            Student student = students.get(registration);
            if (student != null) {
                return student;
            }

            System.out.println("Aluno nao encontrado.");
        }
    }

    private Professor findProfessorByRegistration() {
        if (professors.isEmpty()) {
            System.out.println("Nenhum professor cadastrado.");
            return null;
        }

        while (true) {
            String registration = readLookupCode("Informe o registro do professor ou 0 para cancelar:", "Registro nao pode estar vazio.");
            if (registration == null) {
                return null;
            }

            Professor professor = professors.get(registration);
            if (professor != null) {
                return professor;
            }

            System.out.println("Professor nao encontrado.");
        }
    }

    private Discipline findDisciplineByCode() {
        if (disciplines.isEmpty()) {
            System.out.println("Nenhuma disciplina cadastrada.");
            return null;
        }

        while (true) {
            String code = readLookupCode("Informe o codigo da disciplina ou 0 para cancelar:", "Codigo nao pode estar vazio.");
            if (code == null) {
                return null;
            }

            Discipline discipline = disciplines.get(code);
            if (discipline != null) {
                return discipline;
            }

            System.out.println("Disciplina nao encontrada.");
        }
    }

    private Discipline findDisciplineForStudent(Student student) {
        if (student.getDisciplines().isEmpty()) {
            System.out.println("Este aluno nao possui disciplinas cadastradas.");
            return null;
        }

        while (true) {
            String code = readLookupCode("Informe o codigo da disciplina ou 0 para cancelar:", "Codigo nao pode estar vazio.");
            if (code == null) {
                return null;
            }

            for (Discipline discipline : student.getDisciplines()) {
                if (discipline.getCode().equalsIgnoreCase(code)) {
                    return discipline;
                }
            }

            System.out.println("Disciplina nao encontrada para este aluno.");
        }
    }

    private Discipline findDisciplineForProfessor(Professor professor) {
        if (professor.getDisciplines().isEmpty()) {
            System.out.println("Este professor nao possui disciplinas cadastradas.");
            return null;
        }

        while (true) {
            String code = readLookupCode("Informe o codigo da disciplina ou 0 para cancelar:", "Codigo nao pode estar vazio.");
            if (code == null) {
                return null;
            }

            for (Discipline discipline : professor.getDisciplines()) {
                if (discipline.getCode().equalsIgnoreCase(code)) {
                    return discipline;
                }
            }

            System.out.println("Disciplina nao encontrada para este professor.");
        }
    }

    private String readName(String prompt) {
        while (true) {
            System.out.println(prompt);
            String name = scanner.nextLine().trim().replaceAll("\\s+", " ");

            if (name.isBlank()) {
                System.out.println("Nome nao pode estar vazio.");
                continue;
            }

            if (!name.matches("^[\\p{L}]+(?: [\\p{L}]+)*$")) {
                System.out.println("Nome invalido. Use apenas letras e espacos.");
                continue;
            }

            return name.toUpperCase(java.util.Locale.ROOT);
        }
    }

    private String readUniqueKey(String prompt, Map<String, ?> registry) {
        while (true) {
            System.out.println(prompt);
            String key = normalizeCode(scanner.nextLine());

            if (key.isBlank()) {
                System.out.println("Registro nao pode estar vazio.");
                continue;
            }

            if (!key.matches("^[A-Za-z0-9]+$")) {
                System.out.println("Registro invalido. Use apenas letras e numeros.");
                continue;
            }

            if (registry.containsKey(key)) {
                System.out.println("Registro ja cadastrado.");
                continue;
            }

            return key;
        }
    }

    private String readLookupCode(String prompt, String emptyMessage) {
        while (true) {
            System.out.println(prompt);
            String code = normalizeCode(scanner.nextLine());

            if (code.equals("0")) {
                System.out.println("Operacao cancelada.");
                return null;
            }

            if (code.isBlank()) {
                System.out.println(emptyMessage);
                continue;
            }

            return code;
        }
    }

    private String normalizeCode(String raw) {
        return raw.replaceAll("\\s+", "").toUpperCase(java.util.Locale.ROOT);
    }
}