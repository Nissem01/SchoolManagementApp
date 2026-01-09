import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class User {

    private String name;
    private String email;
    private String password;

    protected Scanner input = new Scanner(System.in);


    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User chooseUserToMessage(List<User> users) {
        System.out.println("Välj mottagare:");
        int index = 0;
        List<User> availableUsers = new ArrayList<>();


        for (User user : users) {
            if (!user.equals(this)) {
                System.out.println(index + ". " + user.getName());
                availableUsers.add(user);
                index++;
            }
        }

        int choice = input.nextInt();
        input.nextLine();

        return availableUsers.get(choice);
    }

    public void displayMessageMenu(List<User> users) {
        System.out.println("1. Visa meddelanden");
        System.out.println("2. Skicka meddelanden");

        int choice = input.nextInt();
        input.nextLine();

        switch (choice) {
            case 1:
                viewMessages();
                break;
            case 2:
                User reciever = chooseUserToMessage(users);
                sendMessage(reciever);
                break;
        }
    }

    public void sendMessage(User reciever){
        System.out.println("Skriv ditt meddelande:");
        System.out.println("Skriv exit för att sluta skriva meddelande");

        String text = "";

        while(true){
            String line = input.nextLine();

            if (line.equalsIgnoreCase("exit")){
                break;
            }

            text += line + " ";
        }

        if (text.isEmpty()){
            System.out.println("Inget meddelande skicades.");
            return;
        }

        Message message = new Message(this.getName(), reciever.getName(), text);
        message.send();

        System.out.println("Meddelande skickat.");
    }

    public void viewMessages(){
        List<Message> messages = Message.getMessages(this);

        if (messages.isEmpty()) {
            System.out.println("Du har inga meddelanden att läsa");
            System.out.println("");
            return;
        }

        System.out.println("Dina meddelanden:");
        for (Message message : messages) {
            System.out.println("Meddelande från: " + message.getFrom());
            System.out.println(message.getText());
            System.out.println("");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
