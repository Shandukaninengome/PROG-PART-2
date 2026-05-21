package account.creation;

import java.util.Random;

public class Message {

    private int totalMessagesSent = 0;

    // Generate random 10-digit message ID
    public String createMessageID() {
        Random random = new Random();

        long number = 1000000000L
                + (long) (random.nextDouble() * 9000000000L);

        return String.valueOf(number);
    }

    // Validate message length
    public String validateMessageLength(String message) {

        if (message == null || message.isEmpty()) {
            return "Message cannot be empty.";
        }

        if (message.length() <= 250) {
            return "Message ready to send.";
        } else {
            int extraCharacters = message.length() - 250;

            return "Message exceeds 250 characters by "
                    + extraCharacters
                    + ", please reduce the size.";
        }
    }

    // Validate recipient cellphone
    public String checkRecipientCell(String cellphone) {

        if (cellphone != null
                && cellphone.startsWith("+27")
                && cellphone.length() == 12) {

            return "Cell phone number successfully captured.";
        }

        return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
    }

    // Create message hash
    public String createMessageHash(int messageNumber, String message) {

        if (message == null || message.isEmpty()) {
            return "Invalid Message";
        }

        String[] words = message.split(" ");

        String firstWord = words[0].toUpperCase();
        String lastWord = words[words.length - 1].toUpperCase();

        return "00:" + messageNumber + ":" + firstWord + lastWord;
    }

    // Send/store/disregard
    public String sentMessage(String option) {

        if (option.equalsIgnoreCase("Send Message")) {
            totalMessagesSent++;
            return "Message successfully sent.";

        } else if (option.equalsIgnoreCase("Disregard Message")) {
            return "Press 0 to delete the message.";

        } else if (option.equalsIgnoreCase("Store Message")) {
            return "Message successfully stored.";
        }

        return "Invalid option selected.";
    }

    // Return total messages
    public int returnTotalMessages() {
        return totalMessagesSent;
    }
}