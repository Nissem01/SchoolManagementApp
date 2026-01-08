import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Run run = new Run();

        //fake databas
        List<SchoolClass> schoolOfCode = new ArrayList<>();
        List<User> users = new ArrayList<>();

        SchoolClass ettan = new SchoolClass("Ettan");
        SchoolClass tvåan = new SchoolClass("Tvåan");
        schoolOfCode.add(ettan);
        schoolOfCode.add(tvåan);

        Teacher klas = (Teacher) UserFactory.createUser(users, UserType.TEACHER,"Klas", "klasse@themail.com", "jensÄrBäst!", ettan);
        Teacher annika = (Teacher) UserFactory.createUser(users, UserType.TEACHER,"Annika", "t", "2", ettan);
        UserFactory.createUser(users, UserType.STUDENT, "Nils", "s", "1", ettan);
        UserFactory.createUser(users, UserType.STUDENT, "Pär", "pe", "3", tvåan);
        UserFactory.createUser(users, UserType.STUDENT, "Jens", "s", "1",ettan);
        UserFactory.createUser(users, UserType.STUDENT, "Filip", "s", "1", ettan);

        //bara för att hårdkoda betyget som ett exempel
        Student pelle = (Student) UserFactory.createUser(users, UserType.STUDENT, "Pelle", "p", "1", ettan);

        Course matte = CourseFactory.createCourse("matte", annika, ettan);
        Course engelska = CourseFactory.createCourse("engelska", annika, ettan);
        CourseFactory.createCourse("idrott", annika, ettan);

        ettan.addSchedule(new Schedule("Onsdag", "08:00", "09:30", engelska));
        ettan.addSchedule(new Schedule("Onsdag", "10:00", "11:30", matte));

        tvåan.addSchedule(new Schedule("Onsdag", "08:00", "09:30", matte));
        tvåan.addSchedule(new Schedule("Onsdag", "10:00", "11:30", engelska));
        matte.setTeacher(annika);
        matte.setGrades(pelle, 1);
        engelska.setGrades(pelle, 3);

        int i = 0;
        while (i <= 0) {

            int choices = run.displayStartMenu();
            switch (choices) {
                case 1:
                    User loggedInUser = run.login(users);
            System.out.println(loggedInUser);

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
                                    run.pressEnter();
                                    break;
                                case 2:
                                    student.viewSchedule();
                                    run.pressEnter();
                                    break;
                                case 3:
                                    student.viewNewsLetter();
                                    run.pressEnter();
                                    break;
                                case 4:
                                    student.viewClassList(schoolClass);
                                    run.pressEnter();
                                    break;
                                case 5:
                                    student.viewAbsence();
                                    run.pressEnter();
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

                                    run.pressEnter();
                                    break;
                                case 2:
                                    teacher.writeNewsLetter();
                                    run.pressEnter();
                                    break;
                                case 3:
                                    teacher.resetNewsLetter();
                                    run.pressEnter();
                                    break;
                                case 4:
                                    choosenclass = teacher.chooseSchoolClass(schoolOfCode);
                                    teacher.viewClassList(choosenclass);
                                    run.pressEnter();
                                    break;
                                case 5:
                                    break;
                                case 6:
                                    teacher.showAbsentStudents(schoolOfCode);
                                    break;
                                case 7:
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