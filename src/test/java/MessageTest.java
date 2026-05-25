/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
import com.mycompany.mychatapp.Message;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {

    @Test
    public void testMessageLengthSuccess() {
        Message msg = new Message(1);
        msg.setMessageText("Hi Mike, can you join us for dinner tonight?");
        assertTrue(msg.getMessageText().length() <= 250, "Message ready to send.");
    }

    @Test
    public void testRecipientFormatSuccess() {
        Message msg = new Message(1);
        msg.setRecipient("+27718693002");
        assertTrue(msg.checkRecipientCell());
    }

    @Test
    public void testRecipientFormatFailure() {
        Message msg = new Message(1);
        msg.setRecipient("0831234567"); // Missing '+' international indicator 
        assertFalse(msg.checkRecipientCell());
    }
}