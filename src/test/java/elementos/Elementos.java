package elementos;

import org.openqa.selenium.By;

public class Elementos {
	
	public By menuLogin = By.xpath("//a[@href='/login']");
	public By email = By.id("Email");
	public By senha = By.id("Password");
	public By btnLogin = By.xpath("//input[@value='Log in']");
	
	public By emailLogado = By.xpath("//a[@href='/customer/info']");

}
