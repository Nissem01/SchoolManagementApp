import java.util.ArrayList;
import java.util.List;

public class SchoolClass {
    private String schoolName;
    private List<Student> students = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();

//    public SchoolClass(String schoolName) {
//        this.schoolName = schoolName;
//    }
    public SchoolClass(String schoolName) {
        this.schoolName = schoolName;
        this.students = students;
        this.courses = courses;
    }

    public SchoolClass() {

    }

    public void addStudent(Student student){
        students.add(student);
        student.setSchoolClass(this);
    }
    public void addCourse(Course course){
        courses.add(course);

    }

    public List<Student> getStudents(){
        return students;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public String  toString(){
        return schoolName;
    }

}
