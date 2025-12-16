import java.util.ArrayList;

public class SchoolClass {

    private String name;
    private ArrayList<Course> courses = new ArrayList<>();

    public SchoolClass(String className) {
        this.name= className;
    }

    public void addCourse(Course course){
        courses.add(course);
    }

    public ArrayList<Course> getCourses(){
        return courses;
    }

    public String getClassName() {
        return name;
    }
}
