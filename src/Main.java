import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Run run = new Run();

        SchoolClass A = new SchoolClass("A");

        A.addCourse(new Course("Matematik"));
        A.addCourse(new Course("Engelska"));
        A.addCourse(new Course("Svenska"));

        //fake databas
        ArrayList<User> users = new ArrayList<>();
        users.add(new Student("Nils", "s", "1", A));
        users.add(new Teacher("Annika", "t", "2", "A"));


        User loggedInUser = run.login(users);

        while (loggedInUser == null) {
            loggedInUser = run.login(users);
        }

        while(loggedInUser != null) {

            if(loggedInUser instanceof Student){
                Student student = (Student) loggedInUser;
                int choice = run.displayStudentMenu();

                switch(choice) {
                    case 1:
                        student.viewGrades();
                        break;
                    case 2:
                        student.viewSchedule();
                        break;
                    case 3:
                        student.viewNewsLetters();
                        break;
                    case 4:
                        student.viewClassList();
                        break;
                    case 5:
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
//                        teacher.setGrades();
                        break;
                    case 2:
                        teacher.writeNewsLetters();
                        break;
                    case 3:
                        teacher.viewClassList();
                    case 4:
                        System.out.println("Du loggar ut!");
                        loggedInUser = null;
                        break;
                }
            }
        }
    }
}