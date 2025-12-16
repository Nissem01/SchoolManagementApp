public class Teacher extends User{


    public Teacher(String name, String email, String password) {
        super(name, email, password);
    }

    public void setGrades() {
        System.out.println("Sätter betyg");

    }

    public void writeNewsLetters() {
        System.out.println("Skriver newsletter");

    }

}
