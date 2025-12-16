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
        System.out.println("Grades:");
        for (Grade grade : grades) {
            System.out.println(grade.getCourse().getCourseName() + ": " + grade.getGrade());
        }
    }

    public void viewSchedule() {
        System.out.println("Här är ditt schema");
    }

    public void viewClassList(){

    }

    public void viewNewsLetters() {
        System.out.println("Här är veckobrevet");
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
