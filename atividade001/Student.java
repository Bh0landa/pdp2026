package atividade001;

public class Student {
    private String studentName;
    private String studentRegistration;
    private int studentAge;
    private Double studentAp1;
    private Double studentAp2;

    public void setName(String studentName) {
        this.studentName = studentName;
    }

    public void setRegistration(String studentRegistration) {
        this.studentRegistration = studentRegistration;
    }

    public void setAge(int studentAge) {
        this.studentAge = studentAge;
    }

    public void setAp1(Double studentAp1) {
        this.studentAp1 = studentAp1;
    }

    public void setAp2(Double studentAp2) {
        this.studentAp2 = studentAp2;
    }

    public String getName() {
        return studentName;
    }

    public String getRegistration() {
        return studentRegistration;
    }

    public int getAge() {
        return studentAge;
    }

    public Double getAp1() {
        return studentAp1;
    }

    public Double getAp2() {
        return studentAp2;
    }

    public Double getFinalGrade() {
        Double ap1 = (studentAp1 == null) ? 0.0 : studentAp1;
        Double ap2 = (studentAp2 == null) ? 0.0 : studentAp2;
        return (ap1 + ap2) / 2.0;
    }

    @Override
    public String toString() {
        Double ap1 = (studentAp1 == null) ? 0.0 : studentAp1;
        Double ap2 = (studentAp2 == null) ? 0.0 : studentAp2;
        
        return "Nome: " + studentName
        + "| Matricula: " + studentRegistration
        + "| Idade: " + studentAge
        + "| Ap1: " + ap1
        + "| Ap2: " + ap2
        + "| Nota Final: " + getFinalGrade();
    }
}
