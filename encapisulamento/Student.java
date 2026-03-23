package encapisulamento;

public class Student {
    private String studentName;
    private int studentRegistration;

    public void setName(String studentName) {
        this.studentName = studentName;
    }

    public void setRegistration(int studentRegistration) {
        this.studentRegistration = studentRegistration;
    }

    String getName() {
        return studentName;
    }

    int getRegistration() {
        return studentRegistration;
    }

}
