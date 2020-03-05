package br.e2e.selenium.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestUtil {

	public static ChromeDriver getChromeDriver() {
		
		System.setProperty("webdriver.chrome.driver",
				"/home/users/rafael.bmenezes/dev/bin/chromedriver_linux64/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		return new ChromeDriver(options);		
	}
	
	public static void getPageFromResource(WebDriver driver, String page) {
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/" + page);
	}
}
