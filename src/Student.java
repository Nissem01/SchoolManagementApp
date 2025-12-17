import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Student extends User{

    private ArrayList<Grade> grades = new ArrayList<>();
    private Scanner input = new Scanner(System.in);
    Absence absence = new Absence();

    public Student(String name, String email, String password, SchoolClass schoolClass) {
        super(name, email, password, schoolClass.getClassName());

        for (Course course : schoolClass.getCourses()) {
            grades.add(new Grade(course));
        }
    }

    public void viewGrades() {
        System.out.println("Betyg:");
        for (Grade grade : grades) {
            System.out.println(grade.getCourse().getCourseName() + ": " + grade.getGrade());
        }
    }

    public void setGrade(String courseName, int newGrade) {
        for (Grade grade : grades) {
            if (grade.getCourse().getCourseName().equalsIgnoreCase(courseName)) {
                grade.setGrade(newGrade);
                System.out.println("Betyg uppdaterat");
                return;
            }
        }
        System.out.println("Kursen kunde inte hittas!");
    }

    public void viewSchedule() {
        System.out.println("Här är ditt schema");
    }

    public void viewClassList(){

    }

    public void viewNewsLetter() {
        File file = new File("src/WeeklyNewsLetter.txt");
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Kunde inte hitta veckobrevet.");
        }
    }

    public void viewAbsence (){
        System.out.println("1. Fyll i frånvaro\n" +
                "2. Se frånvaro");
//        return input.nextInt();
        switch (input.nextInt()){
            case 1:
                absence.reportAbsence();
                break;
            case 2:
                absence.checkAbsence();
                break;
            case 3:
                break;
        }
    }
}
