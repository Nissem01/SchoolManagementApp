public class Grade {

    private Course course;
    private int grade;

    public Grade(Course course) {
        this.course = course;
        this.grade = 0;
    }

    public Course getCourse() {
        return course;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
