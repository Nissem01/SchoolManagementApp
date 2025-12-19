import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Teacher extends User{

    private List<Course> courses = new ArrayList<>();

    public Teacher(String name, String email, String password) {
        super(name, email, password);
        this.courses = courses;
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
    public void setGrades(Teacher teacher,List<Course> courses, List<User> users) {

        Scanner input = new Scanner(System.in);
        System.out.println("Ange studentens namn");
        String studentName = input.nextLine();

        Student selectedStudent = null;
        for (User user : users) {
            if (user instanceof Student && user.getName().equalsIgnoreCase(studentName)) {
                selectedStudent = (Student) user;
                break;
            }
        }
        if (selectedStudent == null){
            System.out.println("Studenten hittades inte");
            return;
        }
//        course
//        selectedStudent.viewGrades();

        System.out.println("Ange kurs:");

        String courseName = input.nextLine();

        System.out.println("Ange betyg:");

        int grade = input.nextInt();

//        selectedStudent.setGrade(courseName, grade);
        //kurs.setgrade(Student, grade)


//        selectedStudent.viewGrades(student);

    }
    public SchoolClass chooseSchoolClass(List<SchoolClass> s){
        System.out.println("Välj klass");
        int count = 1;
        for (SchoolClass c : s) {
            if (count == 1) {
                count++;
                System.out.println("1. " + c);
            } else if (count == 2) {
                count++;
                System.out.println("2. " + c);
            } else if (count == 3) {
                count++;
                System.out.println("3. " + c);
            }
        }
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                System.out.println(s.get(0));
                return s.get(0);
            case 2:
                return s.get(1);
            case 3:
                return s.get(2);


        }
        return null;


    }
    public Course getActiveCourses(List<Course> courses){
        System.out.println("Välj kurs");
        int count = 1;
        for (Course c : courses) {
            if (count == 1) {
                count++;
                System.out.println("1. " + c);
            } else if (count == 2) {
                count++;
                System.out.println("2. " + c);
            } else if (count == 3) {
                count++;
                System.out.println("3. " + c);
            }
        }
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                System.out.println(courses.get(0));
                return courses.get(0);
            case 2:
                return courses.get(1);
            case 3:
                return courses.get(2);


        }
        return null;
    }
    public Student chooseStudentToGrade(List<Student> s){
        for(int i  = 0; i < s.size(); i++){
            System.out.println((i+1) + ". " + s.get(i).getName());
        }
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        if(choice >= 1 && choice <= s.size()){
            Student selectedStudent = s.get(choice-1);
            return selectedStudent;
        }
        return null;
    }
    public int setGradeInt(){
        System.out.println("Sätt betyg 1-5:");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        return choice;
    }



    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
    public void addCourse(Course course){
        courses.add(course);
    }

//    public void setGrades(Student a, String kurs, String grades) {
//        a.updateGrades(a,kurs,grades);
//

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
