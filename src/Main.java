import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Run run = new Run();

        //fake databas
        List<SchoolClass> schoolOfCode = new ArrayList<>();

        SchoolClass ettan = new SchoolClass("Ettan");
        SchoolClass tvåan = new SchoolClass("Tvåan");
        schoolOfCode.add(ettan);
        schoolOfCode.add(tvåan);

        Teacher klas = (Teacher) UserFactory.createUser(UserFactory.UserType.TEACHER,"Klas", "klasse@themail.com", "jensÄrBäst!");
        Teacher annika = (Teacher) UserFactory.createUser(UserFactory.UserType.TEACHER,"Annika", "t", "2");
        Student nils = (Student) UserFactory.createUser(UserFactory.UserType.STUDENT, "Nils", "s", "1");
        Student pär = (Student) UserFactory.createUser(UserFactory.UserType.STUDENT, "Pär", "pe", "3");
        Student jens = (Student) UserFactory.createUser(UserFactory.UserType.STUDENT, "Jens", "s", "1");
        Student filip = (Student) UserFactory.createUser(UserFactory.UserType.STUDENT, "Filip", "s", "1");
        Student pelle = (Student) UserFactory.createUser(UserFactory.UserType.STUDENT, "Pelle", "p", "1");

        ettan.addStudent(nils);
        ettan.addStudent(jens);
        tvåan.addStudent(pär);
        ettan.addStudent(filip);
        ettan.addStudent(pelle);

        Course matte = CourseFactory.createCourse("Matte", annika);
        Course engelska =  CourseFactory.createCourse("English", annika);
        Course idrott = CourseFactory.createCourse("Idrott", annika);

        ettan.addCourse(matte);
        ettan.addCourse(engelska);
        ettan.addCourse(idrott);

        matte.setGrades(pelle, 1);
        engelska.setGrades(pelle, 3);

        List<User> users = new ArrayList<>();
        for (Student student : ettan.getStudents()) {
            users.add(student);

        }
        for (Student student : tvåan.getStudents()) {
            users.add(student);
        }
        users.add(matte.getTeacher());
        users.add(engelska.getTeacher());


        int i = 0;
        while (i <= 0) {

            int choices = run.displayStartMenu();
            switch (choices) {
                case 1:
                    User loggedInUser = run.login(users);

                    while (loggedInUser == null) {
                        loggedInUser = run.login(users);
                    }

                    while (loggedInUser != null) {

                        if (loggedInUser instanceof Student) {
                            Student student = (Student) loggedInUser;
                            List<Course> courses = student.getSchoolClass().getCourses();
                            SchoolClass schoolClass = student.getSchoolClass();

                            int choice = run.displayStudentMenu();

                            switch (choice) {
                                case 1:
                                    student.viewGrades(courses, student);
                                    break;
                                case 2:
                                    student.viewSchedule();
                                    break;
                                case 3:
                                    student.viewNewsLetter();
                                    break;
                                case 4:
                                    student.viewClassList(schoolClass);
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

                        if (loggedInUser instanceof Teacher) {
                            Teacher teacher = (Teacher) loggedInUser;
                            List<Course> courses = teacher.getCourses();
                            Course choosenCourse;
                            SchoolClass choosenclass;
                            List<Student> choosenstudents;
                            Student studentToGrade;
                            int choice = run.displayTeacherMenu();

                            switch (choice) {
                                case 1:
                                    choosenCourse = teacher.getActiveCourses(courses);
                                    choosenclass = teacher.chooseSchoolClass(schoolOfCode);
                                    choosenstudents = choosenclass.getStudents();
                                    studentToGrade = teacher.chooseStudentToGrade(choosenstudents);
                                    int grade = teacher.setGradeInt();
                                    choosenCourse.setGrades(studentToGrade, grade);
                                    System.out.println(choosenCourse.getGrades(studentToGrade));

                                    System.out.println(studentToGrade + "s Betyg i " + choosenCourse + " är satt till: " + choosenCourse.getGrades(studentToGrade));

                                    break;
                                case 2:
                                    teacher.writeNewsLetter();
                                    break;
                                case 3:
                                    teacher.resetNewsLetter();
                                    break;
                                case 4:
                                    choosenclass = teacher.chooseSchoolClass(schoolOfCode);
                                    teacher.viewClassList(choosenclass);
                                    break;
                                case 5:
                                    System.out.println("Du loggar ut!");
                                    loggedInUser = null;
                                    break;
                            }
                        }
                    }
                    break;
                case 2:   i = 1;
            }
        }
    }
}