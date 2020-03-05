package br.e2e.selenium.webdriver;

import static br.e2e.selenium.util.TestUtil.getChromeDriver;
import static br.e2e.selenium.util.TestUtil.getPageFromResource;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TesteAlert {

	private WebDriver driver;

	@Before
	public void setUp() {
		driver = getChromeDriver();
	}
	
	@After
	public void finalize() {
		driver.quit();
	}

	@Test
	public void deveInteragirComAlertSimples() {

		getPageFromResource(this.driver, "componentes.html");

		driver.findElement(By.id("alert")).click();
		Alert alert = driver.switchTo().alert();
		String texto = alert.getText();
		Assert.assertEquals("Alert Simples", texto);
		alert.accept();

		driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
	}

	@Test
	public void deveInteragirComAlertConfirm() {

		getPageFromResource(this.driver, "componentes.html");

		driver.findElement(By.id("confirm")).click();
		Alert alerta = driver.switchTo().alert();
		Assert.assertEquals("Confirm Simples", alerta.getText());
		alerta.accept();
		Assert.assertEquals("Confirmado", alerta.getText());
		alerta.accept();

		driver.findElement(By.id("confirm")).click();
		alerta = driver.switchTo().alert();
		Assert.assertEquals("Confirm Simples", alerta.getText());
		alerta.dismiss();
		Assert.assertEquals("Negado", alerta.getText());
		alerta.dismiss();
	}

	@Test
	public void deveInteragirComAlertPrompt() {

		getPageFromResource(this.driver, "componentes.html");

		driver.findElement(By.id("prompt")).click();
		Alert alerta = driver.switchTo().alert();
		Assert.assertEquals("Digite um numero", alerta.getText());
		alerta.sendKeys("12");
		alerta.accept();
		Assert.assertEquals("Era 12?", alerta.getText());
		alerta.accept();
		Assert.assertEquals(":D", alerta.getText());
		alerta.accept();
	}
}