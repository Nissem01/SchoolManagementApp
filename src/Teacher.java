import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Teacher extends User{

    private List<Course> courses = new ArrayList<>();



    public Teacher(String name, String email, String password) {
        super(name, email, password);
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
    public void addCourse(Course course){
        courses.add(course);
    }

//    public void setGrades(Student a, String kurs, String grades) {
//        a.updateGrades(a,kurs,grades);
//    }

    public void writeNewsLetters() {
        System.out.println("Write Newsletter:");
        Scanner input = new Scanner(System.in);
        String temp= input.nextLine();
        System.out.println(temp);
        // skriva in ,spara i temp. temp till en textfil. reverse när det skall läsas.


    }

    @Override
    public String toString() {
        return "Teacher " + super.getName();
    }
}
