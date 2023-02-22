import java.util.Scanner;

public class AtmUI {
    private final Atm atm;
    public AtmUI() {
        this.atm = new Atm();
    }

    public void init() {
        mainScreen();

    }

    private void mainScreen() {

        boolean running = true;

        while(running) {

            Scanner input = new Scanner(System.in);

            String action;

            System.out.println("Welcome to FANE Bank!");
            System.out.println("Press 1 to enter your credit card\nPress 2 to exit");

            action = input.nextLine();

            switch (action) {
                case "1" -> credentialsScreen();
                case "2" -> {
                    running = false;
                    atm.requestUpdate();
                }
                default -> System.out.println("Invalid operation");
            }
        }

    }

    private void credentialsScreen() {

        Scanner input = new Scanner(System.in);

        String cardNumber;
        String pin;

        System.out.println("Enter your credit card number: ");

        cardNumber = input.nextLine();

        Customer acc = atm.requestLogIn(cardNumber);

        if(acc != null) {
            System.out.println("Enter your PIN: ");

            pin = input.nextLine();

            if (!acc.validate(pin)) {
                System.out.println("Invalid pin");
            } else {
                accountScreen(acc);
            }
        } else {
            System.out.println("Invalid card number");
        }
    }

    private void accountScreen(Customer acc) {

        boolean loggedIn = true;

        while(loggedIn) {
            Scanner input = new Scanner(System.in);
            String action;

            System.out.println("Hello " + acc.getName() + "!");
            System.out.println("Balance: " + acc.getBalance() + " RON");
            System.out.println("Press 1 to add funds\nPress 2 to withdraw\nPress 3 to exit");

            action = input.nextLine();

            switch (action) {
                case "1" -> requestAddFunds(acc);
                case "2" -> requestWithdraw(acc);
                case "3" -> loggedIn = false;
                default -> System.out.println("Invalid operation");
            }
        }
    }

    private void requestAddFunds(Customer acc) {
        System.out.println("Enter the amount: ");
        Scanner input = new Scanner(System.in);
        int value = input.nextInt();
        acc.addFunds(value);
    }

    private void requestWithdraw(Customer acc){
        System.out.println("Enter the amount: ");
        Scanner input = new Scanner(System.in);
        int value = input.nextInt();
        if(acc.getBalance() >= value){
            acc.withdrawFunds(value);
        }else{
            System.out.println("Insufficient funds");
        }
    }
}
