package web.service;

import org.junit.Test;
import org.junit.Assert;

public class RegistrationServiceTest {
    @Test
    public void testValidRegistration() {

        boolean result = RegistrationService.register(
                "Moksh",
                "Bansal",
                "moksh@email.com",
                "password123",
                "2002-01-01"
        );

        Assert.assertTrue(result);
    }

    @Test
    public void testEmptyFirstName() {
        boolean result = RegistrationService.register(
                "",
                "Bansal",
                "moksh@email.com",
                "password123",
                "2002-01-01"
        );
        Assert.assertFalse(result);
    }

    @Test
    public void testEmptyLastName() {

        boolean result = RegistrationService.register(
                "Moksh",
                "",
                "moksh@email.com",
                "password123",
                "2002-01-01"
        );

        Assert.assertFalse(result);
    }

    @Test
    public void testInvalidEmail() {

        boolean result = RegistrationService.register(
                "Moksh",
                "Bansal",
                "mokshemail.com",
                "password123",
                "2002-01-01"
        );

        Assert.assertFalse(result);
    }

    @Test
    public void testEmptyPassword() {

        boolean result = RegistrationService.register(
                "Moksh",
                "Bansal",
                "moksh@email.com",
                "",
                "2002-01-01"
        );

        Assert.assertFalse(result);
    }

    @Test
    public void testShortPassword() {

        boolean result = RegistrationService.register(
                "Moksh",
                "Bansal",
                "moksh@email.com",
                "123",
                "2002-01-01"
        );

        Assert.assertFalse(result);
    }

    @Test
    public void testEmptyDOB() {

        boolean result = RegistrationService.register(
                "Moksh",
                "Bansal",
                "moksh@email.com",
                "password123",
                ""
        );

        Assert.assertFalse(result);
    }
    
    @Test
    public void testNullFirstName() {
        boolean result = RegistrationService.register(
                null, "Bansal", "moksh@email.com", "password123", "2002-01-01"
        );
        Assert.assertFalse(result);
    }

    @Test
    public void testFirstNameWithNumber() {
        boolean result = RegistrationService.register(
                "Moksh1", "Bansal", "moksh@email.com", "password123", "2002-01-01"
        );
        Assert.assertFalse(result);
    }

    @Test
    public void testLastNameWithNumber() {
        boolean result = RegistrationService.register(
                "Moksh", "Bansal1", "moksh@email.com", "password123", "2002-01-01"
        );
        Assert.assertFalse(result);
    }

    @Test
    public void testPasswordWithoutNumber() {
        boolean result = RegistrationService.register(
                "Moksh", "Bansal", "moksh@email.com", "password", "2002-01-01"
        );
        Assert.assertFalse(result);
    }

    @Test
    public void testPasswordWithoutLetter() {
        boolean result = RegistrationService.register(
                "Moksh", "Bansal", "moksh@email.com", "123456", "2002-01-01"
        );
        Assert.assertFalse(result);
    }

    @Test
    public void testFutureDOB() {
        boolean result = RegistrationService.register(
                "Moksh", "Bansal", "moksh@email.com", "password123", "2030-01-01"
        );
        Assert.assertFalse(result);
    }

    @Test
    public void testInvalidDOBFormat() {
        boolean result = RegistrationService.register(
                "Moksh", "Bansal", "moksh@email.com", "password123", "01-01-2002"
        );
        Assert.assertFalse(result);
    }

    @Test
    public void testNullDOB() {
        boolean result = RegistrationService.register(
                "Moksh", "Bansal", "moksh@email.com", "password123", null
        );
        Assert.assertFalse(result);
    }

    @Test
    public void testNullEmail() {
        boolean result = RegistrationService.register(
                "Moksh", "Bansal", null, "password123", "2002-01-01"
        );
        Assert.assertFalse(result);
    }

    @Test
    public void testNullPassword() {
        boolean result = RegistrationService.register(
                "Moksh", "Bansal", "moksh@email.com", null, "2002-01-01"
        );
        Assert.assertFalse(result);
    }
}
