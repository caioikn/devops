package utils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {
	
	public static void screenshot(WebDriver driver, String nomeFuncionalidade, String nomeTeste) {
		String timestamp = new SimpleDateFormat("yyyyMMdd_" + "HHmmss").format(new Date());
		String fileName = nomeTeste + "_" + timestamp + ".png";
		String dirPath = "target/evidencias/" + nomeFuncionalidade;

		try {
			Path diretorio = Paths.get(dirPath);

			if (!Files.exists(diretorio)) {
				Files.createDirectories(diretorio);
			}

			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			Path destinoPath = Paths.get(dirPath, fileName);
			
			Files.copy(screenshot.toPath(), destinoPath);
		} catch (Exception e) {
			System.err.println("Erro ao salvar a evidência: " + e.getMessage());
		}
	}

}
