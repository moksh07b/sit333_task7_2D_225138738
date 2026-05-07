package web.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginServiceTest {
	
	WebDriver driver;
	
	private void sleep(long sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Before
	public void setUp() {
		
		driver = new ChromeDriver();		
		System.out.println("Driver info: " + driver);
		
		driver.navigate().to(
				"D:/OnTrack Tasks/SIT333 Software Quality and Testing/Task 7.2D/Files/pages/login.html");
	}
	
	@After
    public void tearDown() {

        if(driver != null) {
            driver.close();
        }
    }
	
	private void login(String username, String password, String dob) {
		WebElement ele;
		
		ele = driver.findElement(By.id("username"));
		ele.clear();
		ele.sendKeys(username);
		
		ele = driver.findElement(By.id("passwd"));
		ele.clear();
		ele.sendKeys(password);
		
		ele = driver.findElement(By.id("dob"));
		ele.clear();
		ele.sendKeys(dob);
		
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.submit();
	}
	
	@Test
    public void testLoginSuccess() throws Exception {

		sleep(2);
		
        login("ahsan", "ahsan_pass", "10012005");

        sleep(1);

        Assert.assertEquals("success", driver.getTitle());
    }
	
	@Test
    public void testLoginFailWrongUsername() {
		sleep(2);
        login("wrong", "ahsan_pass", "10012005");
        sleep(2);
        Assert.assertEquals("fail", driver.getTitle());
    }
	
	@Test
	public void testLoginFailWrongPassword() {
		sleep(2);
		login("ahsan", "wrong_pass", "10012005");
		sleep(2);
		Assert.assertEquals("fail", driver.getTitle());
	}

	@Test
	public void testLoginFailWrongDob() {
		sleep(2);
		login("ahsan", "ahsan_pass", "23012030");
		sleep(2);
		Assert.assertEquals("fail", driver.getTitle());
	}
	
	@Test
	public void testLoginFailEmptyUsername() {
		sleep(2);
		login("", "ahsan_pass", "10012005");
		sleep(2);
		Assert.assertEquals("fail", driver.getTitle());
	}

	@Test
	public void testLoginFailEmptyPassword() {
		sleep(2);
		login("ahsan", "", "10012005");
		sleep(2);
		Assert.assertEquals("fail", driver.getTitle());
	}
	
	@Test
	public void testLoginFailEmptyDob() {
		sleep(2);
		login("ahsan", "ahsan_pass", "");
		sleep(2);
		Assert.assertEquals("fail", driver.getTitle());
	}
	
	@Test
	public void testLoginFailFutureDob() {
		sleep(2);
		login("ahsan", "ahsan_pass", "10012030");
		sleep(2);
		Assert.assertEquals("fail", driver.getTitle());
	}
	
}
