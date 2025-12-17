import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Teacher extends User{

    private List<Course> courses = new ArrayList<>();



    public Teacher(String name, String email, String password) {
        super(name, email, password);
    }

    public List<Course> getCourses() {
        return courses;
    }
//    public void setGrades(ArrayList<User> users) {
//        Scanner input = new Scanner(System.in);
//
//        System.out.println("Ange studentens namn");
//        String studentName = input.nextLine();
//
//        Student selectedStudent = null;
//        for (User user : users) {
//            if (user instanceof Student && user.getName().equalsIgnoreCase(studentName)) {
//                selectedStudent = (Student) user;
//                break;
//            }
//        }
//        if (selectedStudent == null){
//            System.out.println("Studenten hittades inte");
//            return;
//        }    selectedStudent.viewGrades();
//
//        System.out.println("Ange kurs:");
//
//        String courseName = input.nextLine();
//
//        System.out.println("Ange betyg:");
//
//        int grade = input.nextInt();
//
//        selectedStudent.setGrade(courseName, grade);
//
//        selectedStudent.viewGrades();
//
//    }
    public void setGrades(Teacher teacher) {

        List<Course> temp= teacher.getCourses();
        for (Course course : temp) {
            System.out.println(course);
        }
        Scanner input = new Scanner(System.in);

        System.out.println("Ange studentens namn");
        String studentName = input.nextLine();

        Student selectedStudent = null;
//        for (User user : users) {
//            if (user instanceof Student && user.getName().equalsIgnoreCase(studentName)) {
//                selectedStudent = (Student) user;
//                break;
//            }
//        }
//        if (selectedStudent == null){
//            System.out.println("Studenten hittades inte");
//            return;
//        }    selectedStudent.viewGrades();

        System.out.println("Ange kurs:");

        String courseName = input.nextLine();

        System.out.println("Ange betyg:");

        int grade = input.nextInt();

//        selectedStudent.setGrade(courseName, grade);
        //kurs.setgrade(Student, grade)


//        selectedStudent.viewGrades(student);

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






    public void viewClassList(){

    }

    public void resetNewsLetter() {
        File file = new File("src/WeeklyNewsLetter.txt");

        try (PrintWriter writer = new PrintWriter(file)) {
            System.out.println("Veckobrevet rensades");
        } catch (FileNotFoundException e) {
            System.out.println("Kunde inte rensa veckobrevet");
        }
    }

    public void writeNewsLetter() {
        try (PrintWriter writer = new PrintWriter(new File("src/WeeklyNewsLetter.txt"))) {
            Scanner input = new Scanner(System.in);
            System.out.println("Skriv veckobrevet. Skriv exit för att sluta");

            while(true){
                String text = input.nextLine();
                if (text.equalsIgnoreCase("exit")){
                    break;
                }
                writer.println(text);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Teacher " + super.getName();
    }
}
