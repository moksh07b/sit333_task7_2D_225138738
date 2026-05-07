package web.service;

import org.junit.Before;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationFunctionTest {

	private void sleep(long sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	WebDriver driver;
	WebElement ele;

	@Before
	public void Setup(){
		driver = new ChromeDriver();

		driver.navigate().to(
				"D:/OnTrack Tasks/SIT333 Software Quality and Testing/Task 7.2D/Files/pages/register.html"
				);
	}

	@After
	public void tearDown(){
		if(driver != null)
			driver.close();
	}

	private void register(String fname, String lname, String email, String password, String dob){

		sleep(2);

		ele = driver.findElement(By.id("fname"));
		ele.clear();
		ele.sendKeys(fname);

		ele = driver.findElement(By.id("lname"));
		ele.clear();
		ele.sendKeys(lname);

		ele = driver.findElement(By.id("email"));
		ele.clear();
		ele.sendKeys(email);

		ele = driver.findElement(By.id("password"));
		ele.clear();
		ele.sendKeys(password);

		ele = driver.findElement(By.id("dob"));
		ele.clear();
		ele.sendKeys(dob);

		ele = driver.findElement(By.cssSelector("input[type='submit']"));
		ele.click();

		sleep(2);
	}   

	@Test
	public void testValidRegistrationForm() {

		register(
				"Moksh",
				"Bansal",
				"moksh@email.com",
				"password123",
				"01-01-2002"
				);

		Assert.assertTrue(
				driver.getPageSource().contains("registration successful")
				);
	}

	@Test
	public void testInvalidEmailForm() {

		register(
				"Moksh",
				"Bansal",
				"mokshemail.com",
				"password123",
				"01-01-2002"
				);

		Assert.assertTrue(
				driver.getPageSource().contains("registration failed")
				);
	}

	@Test
	public void testShortPasswordForm() {

		register(
				"Moksh",
				"Bansal",
				"moksh@email.com",
				"123",
				"01-01-2002"
				);

		Assert.assertTrue(
				driver.getPageSource().contains("registration failed")
				);
	}

	@Test
	public void testEmptyFirstNameForm() {

		register(
				"",
				"Bansal",
				"moksh@email.com",
				"password123",
				"01-01-2002"
				);

		Assert.assertTrue(
				driver.getPageSource().contains("registration failed")
				);
	}

	@Test
	public void testEmptyDOBForm() {

		register(
				"Moksh",
				"Bansal",
				"moksh@email.com",
				"password123",
				""
				);

		Assert.assertTrue(
				driver.getPageSource().contains("registration failed")
				);
	}

	@Test
	public void testEmptyLastNameForm() {
		register(
				"Moksh",
				"",
				"moksh@email.com",
				"password123",
				"2002-01-01"
				);

		Assert.assertTrue(
				driver.getPageSource().contains("registration failed")
				);
	}

	@Test
	public void testEmptyEmailForm() {
		register(
				"Moksh",
				"Bansal",
				"",
				"password123",
				"2002-01-01"
				);

		Assert.assertTrue(
				driver.getPageSource().contains("registration failed")
				);
	}

	@Test
	public void testEmptyPasswordForm() {
		register(
				"Moksh",
				"Bansal",
				"moksh@email.com",
				"",
				"2002-01-01"
				);

		Assert.assertTrue(
				driver.getPageSource().contains("registration failed")
				);
	}

	@Test
	public void testAllFieldsEmptyForm() {
		register(
				"",
				"",
				"",
				"",
				""
				);

		Assert.assertTrue(
				driver.getPageSource().contains("registration failed")
				);
	}

	@Test
	public void testFirstNameWithNumberForm() {
		register(
				"Moksh1",
				"Bansal",
				"moksh@email.com",
				"password123",
				"2002-01-01"
				);

		Assert.assertTrue(
				driver.getPageSource().contains("registration failed")
				);
	}

	@Test
	public void testLastNameWithNumberForm() {
		register(
				"Moksh",
				"Bansal1",
				"moksh@email.com",
				"password123",
				"2002-01-01"
				);

		Assert.assertTrue(
				driver.getPageSource().contains("registration failed")
				);
	}

	@Test
	public void testPasswordWithoutNumberForm() {
		register(
				"Moksh",
				"Bansal",
				"moksh@email.com",
				"password",
				"2002-01-01"
				);

		Assert.assertTrue(
				driver.getPageSource().contains("registration failed")
				);
	}

	@Test
	public void testPasswordWithoutLetterForm() {
		register(
				"Moksh",
				"Bansal",
				"moksh@email.com",
				"123456",
				"2002-01-01"
				);

		Assert.assertTrue(
				driver.getPageSource().contains("registration failed")
				);
	}

}