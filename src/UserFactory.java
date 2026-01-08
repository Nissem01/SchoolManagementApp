import java.util.List;

public class UserFactory {

    public static User createUser(List<User> users, UserType type, String name, String email, String password, SchoolClass schoolClass) {
        switch(type) {
            case STUDENT:
                Student tempStudent = new Student(name, email, password, schoolClass);
                schoolClass.addStudent(tempStudent);
                users.add(tempStudent);
                return tempStudent;
            case TEACHER:
                Teacher tempTeacher = new Teacher(name, email, password);
                users.add(tempTeacher);
                return tempTeacher;
                default:
                    throw new IllegalArgumentException("Kunde inte hitta användartypen");
        }
    }
}