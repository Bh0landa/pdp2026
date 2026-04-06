package atividade002;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private String registration;
    private final List<Discipline> disciplines = new ArrayList<>();

    public void setName(String name) {
        this.name = name;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getName() {
        return name;
    }

    public String getRegistration() {
        return registration;
    }

    public List<Discipline> getDisciplines() {
        return disciplines;
    }

    public boolean addDiscipline(Discipline discipline) {
        if (disciplines.contains(discipline)) {
            return false;
        }

        disciplines.add(discipline);
        return true;
    }

    public boolean removeDiscipline(Discipline discipline) {
        return disciplines.remove(discipline);
    }

    @Override
    public String toString() {
        return "Nome: " + name + " | Matricula: " + registration;
    }
}