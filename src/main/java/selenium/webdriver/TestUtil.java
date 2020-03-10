package selenium.webdriver;

import org.openqa.selenium.WebDriver;

public class TestUtil {
	
	public static void getPageFromResource(WebDriver driver, String page) {
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/" + page);
	}
}
