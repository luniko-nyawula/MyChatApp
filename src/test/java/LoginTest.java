/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
import com.mycompany.mychatapp.Login;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


 /**
  * 
  * @author ST10518479
  *@author  Luniko Nyawula
  */
 

public class LoginTest {
    
    
    @Test
    public void testUsernameCorrectFormat() {
        Login login = new Login("kyl_1", "Password1!", "+27838996876");
        String message = login.returnLoginStatus(true);

        assertEquals("Welcome kyl_1 it is great to see you again. ", message);
    }

    @Test
    public void testUsernameIncorrectFormat() {
        Login login = new Login("kyle!!!!!!!!!", "Password1!", "+27838996876");
        String result = login.registerUser();

        assertEquals("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.", result);
    }

    @Test
    public void testPasswordCorrect() {
        Login login = new Login("kyl_1", "Ch@&sec@ke99!", "+27838996876");
        String result = login.registerUser();

        // beginner style: just checking part of message
        assertTrue(result.contains("Password successfully captured"));
    }

    @Test
    public void testPasswordIncorrect() {
        Login login = new Login("kyl_1", "password", "+27838996876");
        String result = login.registerUser();

        assertEquals("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.", result);
    }

    @Test
    public void testCellPhoneCorrect() {
        Login login = new Login("kyl_1", "Password1!", "+27838996876");
        boolean result = login.checkCellPhoneNumber();

        assertTrue(result);
    }

    @Test
    public void testCellPhoneIncorrect() {
        Login login = new Login("kyl_1", "Password1!", "08996053");
        boolean result = login.checkCellPhoneNumber();

        assertFalse(result);
    }


    // =========================
    // TABLE 2: assertTrue/False
    // =========================

    @Test
    public void testLoginSuccessful() {
        Login login = new Login("kyl_1", "Password1!", "+27838996876");
        boolean result = login.loginUser("kyl_1", "Password1!");

        assertTrue(result);
    }

    @Test
    public void testLoginFailed() {
        Login login = new Login("kyl_1", "Password1!", "+27838996876");
        boolean result = login.loginUser("wrong", "wrong");

        assertFalse(result);
    }

    @Test
    public void testUsernameTrue() {
        Login login = new Login("kyl_1", "Password1!", "+27838996876");
        assertTrue(login.checkUserName());
    }

    @Test
    public void testUsernameFalse() {
        Login login = new Login("kyle!!!!!!!!!", "Password1!", "+27838996876");
        assertFalse(login.checkUserName());
    }

    @Test
    public void testPasswordTrue() {
        Login login = new Login("kyl_1", "Ch@&sec@ke99!", "+27838996876");
        assertTrue(login.checkPasswordComplexity());
    }

    @Test
    public void testPasswordFalse() {
        Login login = new Login("kyl_1", "password", "+27838996876");
        assertFalse(login.checkPasswordComplexity());
    }

    @Test
    public void testCellPhoneTrue() {
        Login login = new Login("kyl_1", "Password1!", "+27838996876");
        assertTrue(login.checkCellPhoneNumber());
    }

    @Test
    public void testCellPhoneFalse() {
        Login login = new Login("kyl_1", "Password1!", "08996053");
        assertFalse(login.checkCellPhoneNumber());
    }
    
}

