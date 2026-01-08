import java.util.ArrayList;
import java.util.List;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Student extends User{


    private SchoolClass schoolClass;
    private ArrayList<Schedule> schedule = new ArrayList<>();
    private Scanner input = new Scanner(System.in);
    private Absence absence = new Absence();

    public Student(String name, String email, String password, SchoolClass schoolClass) {
        super(name, email, password);
        this.schoolClass = schoolClass;
    }
    private void createSchedule(SchoolClass schoolClass){
        List<Course> courses = schoolClass.getCourses();

        schedule.add(new Schedule("Måndag", "08:00", "09:30", courses.get(0)));
        schedule.add(new Schedule("Tisdag", "08:00", "09:30", courses.get(1)));
        schedule.add(new Schedule("Onsdag", "08:30", "10:00", courses.get(2)));
        schedule.add(new Schedule("Torsdag", "09:00", "10:30",courses.get(0)));
        schedule.add(new Schedule("Fredag", "08:30", "10:00", courses.get(1)));
    }
    public void setSchoolClass(SchoolClass schoolClass){
        this.schoolClass = schoolClass ;
    }

    public SchoolClass getSchoolClass(){
        return schoolClass;
    }

    public void viewGrades(List<Course> c,Student s) {
        for (int i = 0; i < c.size(); i++) {
            Course p = c.get(i);
            System.out.println(p.getCourseType() + " " + p.getGrades(s));
        }
    }

    public void viewSchedule() {
        createSchedule(schoolClass);
        System.out.println("\n=== Veckoschema ===\n");
        for (Schedule s : schedule){
            System.out.println(s.getDay() + ":");
            System.out.println(s.getStartTime() + "-" + s.getEndTime() + " " + s.getCourse().getCourseType());
            System.out.println();
        }
    }

    public void viewClassList (SchoolClass s){
        List<Student> students = s.getStudents();
        System.out.println();
        System.out.println("Klass " + s.getSchoolName());
        for(int i  = 0; i < students.size(); i++){
            System.out.println((i+1) + ". " + students.get(i).getName()
                 +   " Mail: " + students.get(i).getEmail()   // Ska elever få tag i varandras mail?
                 );}

        System.out.println();
        System.out.println();
    }

    public void viewNewsLetter() {
        File file = new File("src/WeeklyNewsLetter.txt");
        try (Scanner scanner = new Scanner(file)) {
            System.out.println("Veckobrev:");
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Kunde inte hitta veckobrevet.");
        }
    }

    public void viewAbsence (){
        System.out.println("1. Fyll i frånvaro\n" +
                "2. Se frånvaro");
        switch (input.nextInt()){
            case 1:
                absence.reportAbsence(Student.this);
                break;
            case 2:
                absence.checkAbsence(Student.this);
                break;
            case 3:
                break;
        }
    }
    @Override
    public String toString() {
        return "Student " + super.getName();
    }
}
