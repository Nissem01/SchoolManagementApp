import java.util.ArrayList;
import java.util.List;

public class SchoolClass {
    private String schoolName;
    private List<Student> students = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();
    private List<Schedule> schedule = new ArrayList<>();


    public SchoolClass(String schoolName) {
        this.schoolName = schoolName;
        this.students = students;
        this.courses = courses;
    }

    public void addStudent(Student student){
        students.add(student);
        student.setSchoolClass(this);
    }
    public void addCourse(Course course){
        courses.add(course);
    }

    public void addSchedule(Schedule s){
        schedule.add(s);
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

    public List <Schedule> getSchedule(){
        return schedule;
    }
}
