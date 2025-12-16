import java.util.ArrayList;

public class Teacher extends User{


    public Teacher(String name, String email, String password, String schoolClass) {
        super(name, email, password, schoolClass);
    }

//    public void setGrades(ArrayList<User> users, String name, Course course, int newGrade) {

//    }

    public void viewClassList(){

    }

    public void writeNewsLetters() {
        System.out.println("Skriver newsletter");

    }

}
