import java.util.ArrayList;
import java.util.List;

public class SchoolClass {
    private String schoolName;
    private List<Student> students = new ArrayList<>();

    public SchoolClass(String schoolName) {
        this.schoolName = schoolName;
    }

    public SchoolClass() {

    }

    public void addStudent(Student student){
        students.add(student);
        student.setSchoolClass(this);
    }

    public List<Student> getStudents(){
        return students;
    }

}
