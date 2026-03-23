package encapisulamento;

public class Application {
    public static void main(String[] args) {
        
        Student student = new Student();
        
        student.setRegistration(8008135);
        student.setName("Holanda");

        System.out.println("Matricula: " + student.getRegistration());
        System.out.println("Nome: " + student.getName());
    }

}
