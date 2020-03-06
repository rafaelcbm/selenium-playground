package br.e2e.selenium.dsl;

import static br.e2e.selenium.util.TestUtil.getChromeDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TesteAjax {

	private WebDriver driver;
	private DSL dsl;

	@Before
	public void inicializa() {
		driver = getChromeDriver();
		driver.get("https://www.primefaces.org/showcase/ui/ajax/basic.xhtml");
		dsl = new DSL(driver);
	}

	@After
	public void finaliza() {
		driver.quit();
	}

	@Test
	public void testAjax() {
		dsl.escrever("j_idt720:name", "Teste");
		dsl.clicarBotao("j_idt720:j_idt723");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.textToBe(By.id("j_idt720:display"), "Teste"));
		// Waits for load spinner to become invisible
		// wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("j_idt98")));
		Assert.assertEquals("Teste", dsl.obterTexto("j_idt720:display"));
	}
}
