import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
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

    public void writeNewsLetter() {
        try (PrintWriter output = new PrintWriter(new File("WeeklyNewsLetter.txt"))) {
            Scanner input = new Scanner(System.in);
            System.out.println("Skriv veckobrevet. Skriv exit för att sluta");
            String text = "";
            while(true){
                text = input.nextLine();
                if (text.equalsIgnoreCase("exit")){
                    break;
                }
                output.append(text);
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
