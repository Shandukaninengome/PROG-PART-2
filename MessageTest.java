package account.creation;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MessageTest {

    Message message = new Message();

    // Test if cellphone number is correct
    @Test
    public void testCorrectCellNumber() {

        String result =
                message.checkRecipientCell("+27831234567");

        assertEquals(
                "Cell phone number successfully captured.",
                result
        );
    }

    // Test if cellphone number is incorrect
    @Test
    public void testIncorrectCellNumber() {

        String result =
                message.checkRecipientCell("0831234567");

        assertEquals(
                "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.",
                result
        );
    }

    // Test message within allowed limit
    @Test
    public void testMessageLengthSuccess() {

        String result =
                message.validateMessageLength(
                        "Hello, how are you?"
                );

        assertEquals(
                "Message ready to send.",
                result
        );
    }

    // Test message exceeding 250 characters
    @Test
    public void testMessageLengthFailure() {

        String longMessage =
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
              + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
              + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
              + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
              + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
              + "aaaa";

        String result =
                message.validateMessageLength(longMessage);

        assertTrue(
                result.contains("Message exceeds 250 characters")
        );
    }

    // Test message hash creation
    @Test
    public void testCreateMessageHash() {

        String hash =
                message.createMessageHash(
                        1,
                        "Hello world"
                );

        assertEquals(
                "00:1:HELLOWORLD",
                hash
        );
    }

    // Test sending a message
    @Test
    public void testSendMessage() {

        String result =
                message.sentMessage("Send Message");

        assertEquals(
                "Message successfully sent.",
                result
        );
    }

    // Test total messages sent
    @Test
    public void testReturnTotalMessages() {

        message.sentMessage("Send Message");
        message.sentMessage("Send Message");

        assertEquals(
                2,
                message.returnTotalMessages()
        );
    }

    // Test storing a message
    @Test
    public void testStoreMessage() {

        String result =
                message.sentMessage("Store Message");

        assertEquals(
                "Message successfully stored.",
                result
        );
    }

    // Test disregarding a message
    @Test
    public void testDisregardMessage() {

        String result =
                message.sentMessage("Disregard Message");

        assertEquals(
                "Press 0 to delete the message.",
                result
        );
    }
}
