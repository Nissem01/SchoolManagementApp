import java.util.ArrayList;
import java.util.List;

public class SchoolClass {
    Student s;
    Teacher t;
    String year;
    List<Student> students;

    private List<Course> courses;
    private List<Student> ettan = new ArrayList<>();
    private List<Student> tvan = new ArrayList<>();
    public SchoolClass(String year, Teacher t, List<Student> students) {
        this.t = t;
        this.year = year;
        this.students = students;


    }
    public SchoolClass() {}


    public List<Student> getTvan() {
        return tvan;
    }

    public void setTvan(List<Student> tvan) {
        this.tvan = tvan;
    }

    public List<Student> getEttan() {
        return ettan;
    }

    public void setEttan(List<Student> ettan) {
        this.ettan = ettan;
    }

    public void viewClasslist(List<Student> year){
        System.out.println(ettan.toString());
    }

    public Teacher getT() {
        return t;
    }

    public void setT(Teacher t) {
        this.t = t;
    }

    public void addStudentToClass(Student sd, List<Student> list, String year){
            list.add(sd);

    }





}
