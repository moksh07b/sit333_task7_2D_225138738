package web.service;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class LoginService {

	/**
	 * Static method returns true for successful login, false otherwise.
	 * @param username
	 * @param password
	 * @return
	 */
	public static boolean login(String username, String password, String dob) {
		
		if (username == null || password  == null || dob == null) {
			return false;
		}
		
		if (username.isEmpty() || password.isEmpty() || dob.isEmpty()) {
			return false;
		}
		
		try {
			LocalDate.parse(dob);
		}catch(DateTimeParseException e) {
			return false;
		}
		
		if ("ahsan".equals(username) && "ahsan_pass".equals(password) && "2005-10-01".equals(dob)) {
			return true;
		}
		
		return false;
	}
	
	
}
