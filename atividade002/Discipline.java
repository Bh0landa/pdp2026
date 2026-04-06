package atividade002;

import java.util.ArrayList;
import java.util.List;

public class Discipline {
    private String name;
    private String code;
    private Professor professor;
    private final List<Student> students = new ArrayList<>();

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public Professor getProfessor() {
        return professor;
    }

    public List<Student> getStudents() {
        return students;
    }

    public boolean addStudent(Student student) {
        if (students.contains(student)) {
            return false;
        }

        students.add(student);
        return true;
    }

    public boolean removeStudent(Student student) {
        return students.remove(student);
    }

    public String getDetailedInfo() {
        String professorName = (professor == null) ? "SEM PROFESSOR" : professor.getName();
        return "Nome: " + name + " | Codigo: " + code + " | Professor: " + professorName;
    }

    @Override
    public String toString() {
        String professorName = (professor == null) ? "SEM PROFESSOR" : professor.getName();
        return "Nome: " + name + " | Codigo: " + code + " | Professor: " + professorName
                + " | Alunos: " + students.size();
    }
}