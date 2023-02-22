import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class BankDb {
    private final ArrayList<Customer> customers = new ArrayList<>();

    public BankDb(String path) {
        try {
            File accounts = new File(path);
            Scanner input = new Scanner(accounts);
            while(input.hasNextLine()){
                String []info = input.nextLine().split(" ");

                Customer customerObj = new Customer(info[0], info[1], info[2], Integer.parseInt(info[3]));
                this.customers.add(customerObj);

            }
        }catch(FileNotFoundException e) {
            System.out.println("Error reading database");
            e.printStackTrace();
        }
    }

    public Customer getCustomer(String cardNumber) {
        for (Customer customer : customers) {
            if (Objects.equals(customer.getCardNumber(), cardNumber)) {
                return customer;
            }
        }
        return null;
    }

    public void updateDb(String path){
        try {
            FileWriter writer = new FileWriter(path);

            for (Customer customer : customers) {
                String whatToWrite = customer.getName() + " " + customer.getCardNumber()
                        + " " + customer.getPin() + " " + customer.getBalance() + "\n";
                writer.write(whatToWrite);
            }

            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
