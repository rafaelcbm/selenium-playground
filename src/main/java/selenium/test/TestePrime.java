package selenium.test;

import static selenium.core.DriverFactory.getDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import selenium.core.DSL;

public class TestePrime {

	private WebDriver driver;
	private DSL dsl;

	@Before
	public void inicializa() {
		getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		dsl = new DSL();
	}

	@After
	public void finaliza() {
		driver.quit();
	}

	@Test
	public void deveInteragirComRadioPrime() {
		driver.get("https://www.primefaces.org/showcase/ui/input/oneRadio.xhtml");

		dsl.clicarRadio(By.xpath("//input[@id='j_idt721:console:0']/../..//span"));
		Assert.assertTrue(dsl.isRadioMarcado("j_idt721:console:0"));

		dsl.clicarRadio(By.xpath("//label[. ='PS4']/..//span"));
		Assert.assertTrue(dsl.isRadioMarcado("j_idt721:console:1"));
	}

	@Test
	public void deveInteragirComSelectPrime() {
		driver.get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml");

		dsl.selecionarComboPrime("j_idt721:console", "Xbox One");
		Assert.assertEquals("Xbox One", dsl.obterTexto("j_idt721:console_label"));
	}
}
