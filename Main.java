package account.creation;

import java.util.Scanner;
import account.creation.Message;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Message messageApp = new Message();

        System.out.println("Welcome to QuickChat.");

        boolean running = true;

        while (running) {

            System.out.println("\nChoose an option:");
            System.out.println("1. Send Messages");
            System.out.println("2. Show recently sent messages");
            System.out.println("3. Quit");

            String menu = input.nextLine();

            if (menu.equals("1")) {

                System.out.print("Enter recipient cellphone number: ");
                String recipient = input.nextLine();
                System.out.println(
                        messageApp.checkRecipientCell(recipient)
                );

                System.out.print("Enter your message: ");
                String message = input.nextLine();
                System.out.println(
                        messageApp.validateMessageLength(message)
                );

                String hash =
                        messageApp.createMessageHash(
                                messageApp.returnTotalMessages() + 1,
                                message
                        );

                System.out.println("Message Hash: " + hash);

                System.out.println(
                        "Choose option: Send Message / Disregard Message / Store Message"
                );

                String option = input.nextLine();

                System.out.println(
                        messageApp.sentMessage(option)
                );

            } else if (menu.equals("2")) {

                System.out.println(
                        "Coming Soon - feature still in development."
                );

            } else if (menu.equals("3")) {

                System.out.println(
                        "Total messages sent: "
                                + messageApp.returnTotalMessages()
                );

                running = false;

            } else {
                System.out.println("Invalid menu option.");
            }
        }

        input.close();
    }
}
