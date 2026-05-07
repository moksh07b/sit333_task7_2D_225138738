package web.service;

import org.junit.Assert;
import org.junit.Test;

public class LoginServiceUnitTest {

    @Test
    public void testValidLogin() {
        boolean result = LoginService.login("ahsan", "ahsan_pass", "2005-10-01");
        Assert.assertTrue(result);
    }

    @Test
    public void testInvalidUsername() {
        boolean result = LoginService.login("wrong", "ahsan_pass", "2005-10-01");
        Assert.assertFalse(result);
    }

    @Test
    public void testInvalidPassword() {
        boolean result = LoginService.login("ahsan", "wrong_pass", "2005-10-01");
        Assert.assertFalse(result);
    }

    @Test
    public void testInvalidDob() {
        boolean result = LoginService.login("ahsan", "ahsan_pass", "2005-01-10");
        Assert.assertFalse(result);
    }

    @Test
    public void testEmptyUsername() {
        boolean result = LoginService.login("", "ahsan_pass", "2005-10-01");
        Assert.assertFalse(result);
    }

    @Test
    public void testEmptyPassword() {
        boolean result = LoginService.login("ahsan", "", "2005-10-01");
        Assert.assertFalse(result);
    }

    @Test
    public void testEmptyDob() {
        boolean result = LoginService.login("ahsan", "ahsan_pass", "");
        Assert.assertFalse(result);
    }

    @Test
    public void testNullUsername() {
        boolean result = LoginService.login(null, "ahsan_pass", "2005-10-01");
        Assert.assertFalse(result);
    }

    @Test
    public void testNullPassword() {
        boolean result = LoginService.login("ahsan", null, "2005-10-01");
        Assert.assertFalse(result);
    }

    @Test
    public void testNullDob() {
        boolean result = LoginService.login("ahsan", "ahsan_pass", null);
        Assert.assertFalse(result);
    }

    @Test
    public void testWrongDobFormat() {
        boolean result = LoginService.login("ahsan", "ahsan_pass", "01102005");
        Assert.assertFalse(result);
    }

    @Test
    public void testAllFieldsInvalid() {
        boolean result = LoginService.login("wrong", "wrong", "wrong");
        Assert.assertFalse(result);
    }
    
    @Test
    public void testFutureDob() {
        boolean result = LoginService.login("ahsan", "ahsan_pass", "2030-01-23");
        Assert.assertFalse(result);
    }
    
}