import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Absence {
    String date;
    List dates = new ArrayList();


    private Scanner input = new Scanner(System.in);

//    public int menu(){
//        System.out.println("1. Fyll i frånvaro\n" +
//                "2. Se frånvaro");
//        int choice = input.nextInt();
//        return choice;
//    }
    public void reportAbsence (Student s){
        System.out.println("Skriv in dagen du är frånvarande");
        date = input.nextLine();
        System.out.println(date + " Stämmer det? j/n");
        if (input.nextLine().equals("j")) {
            dates.add(s.getName() + " är frånvarande " + date);
        }
    }

    public void checkAbsence (Student s){
        String name = s.getName();
        System.out.println(dates);
    }
}
