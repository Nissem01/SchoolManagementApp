import java.util.ArrayList;

public class Student extends User{

    private ArrayList<Grade> grades = new ArrayList<>();
    private ArrayList<Schedule> schedule = new ArrayList<>();

    public Student(String name, String email, String password, SchoolClass schoolClass) {
        super(name, email, password, schoolClass.getClassName());

        for (Course course : schoolClass.getCourses()) {
            grades.add(new Grade(course));
        }
        createSchedule(schoolClass);
    }

    private void createSchedule(SchoolClass schoolClass){
        ArrayList<Course> courses = schoolClass.getCourses();

        schedule.add(new Schedule("Måndag", "08:00", "09:30", courses.get(0)));
        schedule.add(new Schedule("Tisdag", "08:00", "09:30", courses.get(1)));
        schedule.add(new Schedule("Onsdag", "08:30", "10:00", courses.get(2)));
        schedule.add(new Schedule("Torsdag", "09:00", "10:30",courses.get(0)));
        schedule.add(new Schedule("Fredag", "08:30", "10:00", courses.get(1)));
    }

    public void viewGrades() {
        System.out.println("Betyg:");
        for (Grade grade : grades) {
            System.out.println(grade.getCourse().getCourseName() + ": " + grade.getGrade());
        }
    }

    public void setGrade(String courseName, int newGrade) {
        for (Grade grade : grades) {
            if (grade.getCourse().getCourseName().equalsIgnoreCase(courseName)) {
                grade.setGrade(newGrade);
                System.out.println("Betyg uppdaterat");
                return;
            }
        }
        System.out.println("Kursen kunde inte hittas!");
    }

    public void viewSchedule() {
        System.out.println("\n=== Veckoschema ===\n");

        for (Schedule s : schedule){
            System.out.println(s.getDay() + ":");
            System.out.println(s.getStartTime() + "-" + s.getEndTime() + " " + s.getCourse().getCourseName());
            System.out.println();
        }
    }

    public void viewClassList(){

    }

    public void viewNewsLetters() {
        System.out.println("Här är veckobrevet");
    }
}
