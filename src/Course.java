import java.util.List;

public class Course {

    private String courseName;
    private String courseGrade;
    private List<Student> students;
    private Teacher teacher;



    public Course() {}
    public Course(String courseName) {}

    public Course(String courseName, List<Student> students) {
        this.courseName = courseName;
        this.students = students;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseGrade() {
        return courseGrade;
    }

    public void setCourseGrade(String courseGrade) {
        this.courseGrade = courseGrade;
    }
}
