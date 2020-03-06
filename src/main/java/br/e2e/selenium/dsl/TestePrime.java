package br.e2e.selenium.dsl;

import static br.e2e.selenium.util.TestUtil.getChromeDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestePrime {

	private WebDriver driver;
	private DSL dsl;

	@Before
	public void inicializa() {
		driver = getChromeDriver();
		dsl = new DSL(driver);
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
