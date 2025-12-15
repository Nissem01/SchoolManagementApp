import java.util.Scanner;

public class Teacher extends User{


    public Teacher(String name, String email, String password) {
        super(name, email, password);
    }

    public void setGrades(Student a, String kurs, String grades) {
        a.updateGrades(a,kurs,grades);
    }

    public void writeNewsLetters() {
        System.out.println("Write Newsletter:");
        Scanner input = new Scanner(System.in);
        String temp= input.nextLine();
        System.out.println(temp);
        // skriva in ,spara i temp. temp till en textfil. reverse när det skall läsas.


    }

}
