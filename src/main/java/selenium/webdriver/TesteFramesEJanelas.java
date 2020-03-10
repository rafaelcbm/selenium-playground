package selenium.webdriver;

import static selenium.core.DriverFactory.getDriver;
import static selenium.core.DriverFactory.killDriver;
import static selenium.webdriver.TestUtil.getPageFromResource;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TesteFramesEJanelas {

	private WebDriver driver;

	@Before
	public void setUp() {
		driver = getDriver();
	}

	@After
	public void finalize() {
		killDriver();
	}

	@Test
	public void deveInteragirComFrames() {
		getPageFromResource(this.driver, "componentes.html");

		driver.switchTo().frame("frame1");
		driver.findElement(By.id("frameButton")).click();
		Alert alert = driver.switchTo().alert();
		String msg = alert.getText();
		Assert.assertEquals("Frame OK!", msg);
		alert.accept();

		driver.switchTo().defaultContent();
		driver.findElement(By.id("elementosForm:nome")).sendKeys(msg);

	}

	@Test
	public void deveInteragirComJanelas() {
		getPageFromResource(this.driver, "componentes.html");

		driver.findElement(By.id("buttonPopUpEasy")).click();
		driver.switchTo().window("Popup");
		driver.findElement(By.tagName("textarea")).sendKeys("Deu certo?");
		driver.close();
		driver.switchTo().window("");
		driver.findElement(By.tagName("textarea")).sendKeys("e agora?");

	}

	@Test
	public void deveInteragirComJanelasSemTitulo() {
		getPageFromResource(this.driver, "componentes.html");

		driver.findElement(By.id("buttonPopUpHard")).click();
		System.out.println(driver.getWindowHandle());
		System.out.println(driver.getWindowHandles());
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]);
		driver.findElement(By.tagName("textarea")).sendKeys("Deu certo?");
		driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]);
		driver.findElement(By.tagName("textarea")).sendKeys("E agora?");

	}
}
