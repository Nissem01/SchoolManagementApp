import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Message {

    private String from;
    private String to;
    private String message;

    private static String filePath = "src/Messages.txt";

    public Message(String from, String to, String message) {
        this.from = from;
        this.to = to;
        this.message = message;

    }

    public void send() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath, true))) {
            writer.println(splitMessageToFile(message));
        } catch (IOException e) {
            System.out.println("Kunde inte skicka meddelandet.");
        }
    }

    public static List<Message> getMessages(User user){
        List<Message> messages = new ArrayList<>();
        File file = new File(filePath);

        if (!file.exists()) {
            return messages;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null){
                Message message = splitMessageFromFile(line);
                if(message.to.equals(user.getName())){
                    messages.add(message);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return messages;
    }

    public String splitMessageToFile(String message){
       return from + ";" +  to + ";" + message;
    }

    public static Message splitMessageFromFile(String line){
        String[] parts  = line.split(";");
        return new Message(parts[0], parts[1], parts[2]);
    }

    public String getFrom(){
        return from;
    }
    public String getText(){
        return message;
    }
}
