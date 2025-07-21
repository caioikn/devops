package pages;

import org.openqa.selenium.WebDriver;

import elementos.Elementos;
import metodos.Metodos;

public class HomePage {
	
	private WebDriver driver;
	private Elementos el = new Elementos();
	private Metodos metodos;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		this.metodos = new Metodos(driver);
	}
	
	public void login(String email, String senha) {
		metodos.clicar(el.menuLogin);
		metodos.escrever(el.email, email);
		metodos.escrever(el.senha, senha);
		metodos.clicar(el.btnLogin);
	}

}
