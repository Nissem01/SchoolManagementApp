import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Absence {

    Course course;
    String date;
    Student student = this.student;
    List dates = new ArrayList();


    private Scanner input = new Scanner(System.in);


    public int menu(){
        System.out.println("1. Fyll i frånvaro\n" +
                "2. Se frånvaro");
        return input.nextInt();
    }
    public void reportAbsence (){
        System.out.println("Skriv in datum för dagen du är frånvarande");
        date = input.nextLine();
        System.out.println(date + " Stämmer det? j/n");
        if (input.nextLine().equals("j")) {
            dates.add(date);

        } else return;
    }

    public void checkAbsence (){
//        String name = student.getName();
        System.out.println("Du har vart frånvarande följande dagar" + dates
//                + name
        );
    }
}
