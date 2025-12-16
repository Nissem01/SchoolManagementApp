import java.util.ArrayList;
import java.util.Scanner;

public class Teacher extends User{


    public Teacher(String name, String email, String password, String schoolClass) {
        super(name, email, password, schoolClass);
    }

    public void setGrades(ArrayList<User> users){
        Scanner input = new Scanner(System.in);

        System.out.println("Ange studentens namn");
        String studentName = input.nextLine();

        Student selectedStudent = null;

        for (User user : users){
            if (user instanceof Student && user.getName().equalsIgnoreCase(studentName)){
                selectedStudent = (Student) user;
                break;
            }
        }

        if (selectedStudent == null){
            System.out.println("Studenten hittades inte");
            return;
        }

        selectedStudent.viewGrades();

        System.out.println("Ange kurs:");

        String courseName = input.nextLine();

        System.out.println("Ange betyg:");

        int grade = input.nextInt();

        selectedStudent.setGrade(courseName, grade);

        selectedStudent.viewGrades();

    }

    public void viewClassList(){

    }

    public void writeNewsLetters() {
        System.out.println("Skriver newsletter");

    }

}
