import java.util.ArrayList;

public class Student extends User{

    private ArrayList<Grade> grades = new ArrayList<>();

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

}
