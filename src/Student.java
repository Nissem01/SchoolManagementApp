import java.sql.SQLOutput;

public class Student extends User{

    public Student(String name, String email, String password) {
        super(name, email, password);
    }

    public void viewGrades() {
        System.out.println("Här är dina betyg!");

    }

    public void viewSchedule() {
        System.out.println("Här är ditt schema");
    }

    public void viewNewsLetters() {
        System.out.println("Här är veckobrevet");
    }

}
