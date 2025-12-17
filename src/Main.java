import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Run run = new Run();


        SchoolClass ettan =new SchoolClass("Ettan");



        Teacher klas = new Teacher("klas", "klasse@themail.com", "jensÄrBäst!");
        Teacher annika = new Teacher("Annika", "t","2");
        ettan.addStudent(new Student("Nils", "s","1"));
//        System.out.println(ettan.getStudents());


//        A.addCourse(new Course("Matematik"));
//        A.addCourse(new Course("Engelska"));
//        A.addCourse(new Course("Svenska"));
        Course matte = new Course("Matte");
        ettan.addCourse(matte);
        matte.setTeacher(annika);
//        System.out.println(annika.getCourses());


//        Course engelska = new Course("Engelska");
//        Course idrott = new Course("Idrott");



        //fake databas
        List<User> users = new ArrayList<>();
        for (Student student : ettan.getStudents()) {
            users.add(student);
            System.out.println(student);
        }
        users.add(matte.getTeacher());
        System.out.println(users.size());
        System.out.println(users.get(0) +" "+  users.get(1));
//        users.add(new Student("Nils", "s", "1"));
//        users.add(new Teacher("Annika", "t", "2", "A"));
//        users.add(new Teacher("Annika", "t", "2"));


        User loggedInUser = run.login(users);
        System.out.println(loggedInUser);

        while (loggedInUser == null) {
            loggedInUser = run.login(users);
        }

        while(loggedInUser != null) {

            if(loggedInUser instanceof Student){
                Student student = (Student) loggedInUser;

                int choice = run.displayStudentMenu();

                switch(choice) {
                    case 1:
                        student.viewGrades(student);
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
                int choice = run.displayTeacherMenu();

                switch(choice) {
                    case 1:
                        teacher.setGrades(teacher);
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