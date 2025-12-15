public class Main {
    public static void main(String[] args) {

        Run run = new Run();
        Student Nils = new Student("Nils", "nils@fakemail.se", "hamburger");

        run.printWelcomeMessage();

        int running = 1;
        while(running == 1){
            int choice = run.getFirstChoice();
            switch (choice){

                case 1:
                    int loggedIn = 1;
                    System.out.println("Du loggade in!");
                    while(loggedIn == 1){
                        choice = run.getSecondChoice();
                        switch(choice){
                            case 1:
                                System.out.println("Dina betyg: Programmering = MVG");
                                break;
                            case 2:
                                System.out.println("Du loggar ut:");
                                loggedIn = 0;
                                break;
                        }
                    }
                    break;
                case 2:
                    running = 0;
                    System.out.println("Stänger av");
                    break;
            }
        }
    }
}