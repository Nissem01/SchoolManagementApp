import java.util.HashMap;

public class Course {

    private String courseName;
    private Teacher teacher;
    private HashMap<Student, Integer> grades = new HashMap<>();


    public Course(String courseName) {
        this.courseName = courseName;
    }

    public Course(String courseName, Teacher teacher) {
        this.courseName = courseName;
        this.teacher = teacher;
        teacher.addCourse(this);
    }

    public void setGrades(Student student, int grade) {
        grades.put(student, grade);
    }
    public Integer getGrades(Student student) {
        return grades.get(student);
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
        teacher.addCourse(this);
    }

    public String toString(){
        return courseName;
    }

}
