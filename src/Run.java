import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Run {

    private Scanner input = new Scanner(System.in);

    public User login(List<User> users) {
        input.nextLine();
        System.out.println("Email:");
        String email = input.nextLine();

        System.out.println("Password:");
        String password = input.nextLine();

        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                System.out.println("Välkommen " + user.getName());
                return user;
            }
        }

        System.out.println("Fel email eller lösen");
        return null;
    }
    public int displayStartMenu() {
        System.out.println("==| Bästa Skolan |===");
        System.out.println("1. Logga in");
        System.out.println("2. Stäng av");
        return input.nextInt();
    }

    public int displayStudentMenu() {
        System.out.println("1. Visa betyg");
        System.out.println("2. Visa schema");
        System.out.println("3. Visa veckobrev");
        System.out.println("4. Visa klasslista");
        System.out.println("5. Hantera frånvaro");
        System.out.println("6. Logga ut");
        return input.nextInt();
    }


    public int displayTeacherMenu() {
        System.out.println("1. Sätt betyg");
        System.out.println("2. Skriv veckobrev");
        System.out.println("3. Rensa veckobrevet");
        System.out.println("4. Visa klasslista");
        System.out.println("5. Logga ut");
        return input.nextInt();
    }

}

