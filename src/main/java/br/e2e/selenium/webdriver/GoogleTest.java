package br.e2e.selenium.webdriver;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GoogleTest {

	@Test
	public void helloWorldTest() {

		System.setProperty("webdriver.chrome.driver",
				"/home/users/rafael.bmenezes/dev/bin/chromedriver_linux64/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });

		// Other drivers
		// WebDriver driver = new FirefoxDriver();
		// WebDriver driver = new InternetExplorerDriver();
		WebDriver driver = new ChromeDriver(options);

		// Posionamento na tela
		// driver.manage().window().setPosition(new Point(100, 100));

		// Tamanho Janela
		driver.manage().window().setSize(new Dimension(1200, 765));
		// driver.manage().window().maximize();

		driver.get("https://stackoverflow.com/");
		Assert.assertTrue(driver.getTitle().contains("Stack Overflow"));

		// Just closes tabs
		// driver.close();

		// Kill driver process
		driver.quit();
	}
}
