package web.service;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class RegistrationService {

    public static boolean register(String fName, String lName, String email, String password, String dob) {

        if(fName == null || fName.trim().isEmpty() || !fName.matches(".*[A-Za-z].*") || fName.matches(".*[0-9].*")) return false;
        if(lName == null || lName.trim().isEmpty()  || !lName.matches(".*[A-Za-z].*") || lName.matches(".*[0-9].*")) return false;
        if(email == null || email.trim().isEmpty() || !email.contains("@")) return false;
        if(password == null || password.trim().isEmpty() || password.length() < 6) return false;
        
        if (!password.matches(".*[A-Za-z].*")) return false;    // Check if it has atleaset one character
        if (!password.matches(".*[0-9].*")) return false;   // Check if it has atleaset one number

        if (dob == null || dob.trim().isEmpty()) return false;

        try {
            LocalDate date = LocalDate.parse(dob);
            if (date.isAfter(LocalDate.now())) return false;
        } catch (DateTimeParseException e) {
            return false;
        }
        
        System.out.println("First name: " + fName);
        System.out.println("Last name: " + lName);
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);
        System.out.println("DoB (yyyy-mm-dd): " + dob);

        return true;
    }
}