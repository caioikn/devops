package testes;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import drivers.Drivers;
import pages.HomePage;
import utils.ScreenshotUtil;

public class LoginTest {
	
	private WebDriver driver;
	private HomePage home;
	
	@BeforeEach
	public void setup() {
		driver = Drivers.criarDriver();
		home = new HomePage(driver);
	}
	
	@AfterEach
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void loginSucesso() {
		home.login("cefapem931@cxnlab.com", "123456");
		ScreenshotUtil.screenshot(driver, "Login", "LoginSucesso");
	}

}
