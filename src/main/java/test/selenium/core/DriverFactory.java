package test.selenium.core;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

	private static WebDriver driver;

	private DriverFactory() {
	}

	public static WebDriver getDriver() {
		if (driver == null) {
			switch (Propriedades.browser) {
			case FIREFOX:
				driver = new FirefoxDriver();
				break;
			case CHROME:
				/*
				 * Additional path config for chrome driver.
				 * 
				 * System.setProperty("webdriver.chrome.driver",
				 * "/home/users/rafael.bmenezes/dev/bin/chromedriver_linux64/chromedriver");
				 * ChromeOptions options = new ChromeOptions();
				 * options.setExperimentalOption("excludeSwitches", new String[] {
				 * "enable-automation" }); driver = new ChromeDriver(options);
				 */
				
				driver = new ChromeDriver();
				break;
			}
			driver.manage().window().setSize(new Dimension(1200, 765));
		}
		return driver;
	}

	public static void killDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
