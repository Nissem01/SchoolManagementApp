import java.util.Scanner;

public class Run {

    public int getFirstChoice(){
        int choice = 0;
        System.out.println("1. Logga in");
        System.out.println("2. Exit");

        while (choice == 0){
            try{
                Scanner input = new Scanner(System.in);
                choice = input.nextInt();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return choice;
    }

    public int getSecondChoice(){
        int choice = 0;
        System.out.println("1. Visa betyg");
        System.out.println("2. Logga ut");
        while (choice == 0){
            try{
                Scanner input = new Scanner(System.in);
                choice = input.nextInt();
            }catch (Exception e){
                throw new RuntimeException(e);
            }
        }
        return choice;
    }

    public void printWelcomeMessage(){
        System.out.println("Välkommen till superskolan, vad vill du göra?");
    }

}


