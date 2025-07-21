package metodos;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Metodos {
	
	private WebDriver driver;
	
	public Metodos(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clicar(By locator) {
		try {
			driver.findElement(locator).click();
		} catch (Exception e) {
			throw new NoSuchElementException("Elemento não encontrado: " + locator);
		}
	}
	
	public void escrever(By locator, String texto) {
		try {
			driver.findElement(locator).sendKeys(texto);
		} catch (Exception e) {
			throw new NoSuchElementException("Elemento não encontrado: " + locator);
		}
	}
	
}
