import java.util.ArrayList;
import java.util.List;

public class Student extends User{

    private SchoolClass schoolClass;

    List<Course> courses = new ArrayList<Course>();


    public Student(String name, String email, String password) {
        super(name, email, password);
    }
    public void setSchoolClass(SchoolClass schoolClass){
        this.schoolClass = schoolClass ;
    }
    public SchoolClass getSchoolClass(){
        return schoolClass;
    }



    public void viewSchedule() {
    }

    public void viewNewsLetters() {
    }

//    public void updateGrades(Student a, String course, String grade) {
//       for (Course c : courses){
//           if(c.getCourseName().equalsIgnoreCase(course)){
//               System.out.println(c.getCourseName());
//
//           }
//           else System.out.println("Course not found");
//       }
//    }
    public String toString(){
        return super.getName();
    }

}
