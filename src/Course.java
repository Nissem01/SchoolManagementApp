import java.util.HashMap;

public class Course {

    private CourseType courseType;
    private Teacher teacher;
    private HashMap<Student, Integer> grades = new HashMap<>();


    public Course(CourseType courseType) {
        this.courseType = courseType;
    }

    public Course(String courseName, Teacher teacher) {
        this.courseType = courseType;
        this.teacher = teacher;
        teacher.addCourse(this);
    }

    public void setGrades(Student student, int grade) {
        grades.put(student, grade);
    }
    public Integer getGrades(Student student) {
        return grades.get(student);
    }

    public CourseType getCourseType() {
        return courseType;
    }

    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
        teacher.addCourse(this);
    }

    public String toString(){
        return courseType.getDisplayName();
    }

}
