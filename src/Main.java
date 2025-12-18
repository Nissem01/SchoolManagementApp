import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Run run = new Run();

        //fake databas
        List<SchoolClass> schoolOfCode = new ArrayList<>();

        SchoolClass ettan =new SchoolClass("Ettan");
        SchoolClass tvåan =new SchoolClass("Tvåan");
        schoolOfCode.add(ettan);
        schoolOfCode.add(tvåan);

        Teacher klas = new Teacher("klas", "klasse@themail.com", "jensÄrBäst!");
        Teacher annika = new Teacher("Annika", "t","2");
        ettan.addStudent(new Student("Nils", "s","1"));
        ettan.addStudent(new Student("Jens", "s","1"));
        ettan.addStudent(new Student("Pär", "s","1"));
        ettan.addStudent(new Student("Filip", "s","1"));
        Student pelle = new Student("Pelle", "p","1");
        ettan.addStudent(pelle);


        Course matte = new Course("Matte");
        Course engelska = new Course("Engelska");
//        Course idrott = new Course("Idrott");
        ettan.addCourse(matte);
        ettan.addCourse(engelska);
        matte.setTeacher(annika);
        matte.setGrades(pelle, 1);
        engelska.setGrades(pelle,3);

        List<User> users = new ArrayList<>();
        for (Student student : ettan.getStudents()) {
            users.add(student);
//            System.out.println(student);
        }
        users.add(matte.getTeacher());
        users.add(engelska.getTeacher());



        User loggedInUser = run.login(users);
        System.out.println(loggedInUser);

        while (loggedInUser == null) {
            loggedInUser = run.login(users);
        }

        while(loggedInUser != null) {

            if(loggedInUser instanceof Student){
                Student student = (Student) loggedInUser;
                List<Course> courses= student.getSchoolClass().getCourses();

                int choice = run.displayStudentMenu();

                switch(choice) {
                    case 1:
                        student.viewGrades(courses,student);
                        break;
                    case 2:
                        student.viewSchedule();
                        break;
                    case 3:
                        student.viewNewsLetter();
                        break;
                    case 4:
                        student.viewClassList();
                        break;
                    case 5:
                        student.viewAbsence();
                        break;
                    case 6:
                        System.out.println("Du loggar ut!");
                        loggedInUser = null;
                        break;
                }
            }

            if(loggedInUser instanceof Teacher){
                Teacher teacher = (Teacher) loggedInUser;
                List<Course> courses = teacher.getCourses();
                Course choosenCourse;
                SchoolClass choosenclass;
                List<Student> choosenstudents;
                Student studentToGrade;
                int choice = run.displayTeacherMenu();

                switch(choice) {
                    case 1:
                        choosenCourse=teacher.getActiveCourses(courses);
                        choosenclass=teacher.chooseSchoolClass(schoolOfCode);
                        choosenstudents = choosenclass.getStudents();
                        studentToGrade=teacher.chooseStudentToGrade(choosenstudents);
                        int grade = teacher.setGradeInt();
                        choosenCourse.setGrades(studentToGrade,grade);
                        System.out.println(choosenCourse.getGrades(studentToGrade));

                        System.out.println(studentToGrade+"s Betyg i " + choosenCourse + " är satt till: "+ choosenCourse.getGrades(studentToGrade));

//                        teacher.setGrades(teacher,courses,users);
//                        teacher.setGrades(users);
                        break;
                    case 2:
                        teacher.writeNewsLetter();
                        break;
                    case 3:
                        teacher.resetNewsLetter();
                        break;
                    case 4:
                        teacher.viewClassList();
                        break;
                    case 5:
                        System.out.println("Du loggar ut!");
                        loggedInUser = null;
                        break;
                }
            }
        }
    }
}