public class UserFactory {

    public enum UserType {
        STUDENT,
        TEACHER
    }

    public static User createUser(UserType type, String name, String email, String password) {
        switch(type) {
            case STUDENT:
                return new Student(name, email, password);
            case TEACHER:
                return new Teacher(name, email, password);
                default:
                    throw new IllegalArgumentException("Kunde inte hitta användartypen");
        }
    }
}
