package br.e2e.selenium;

import static br.e2e.selenium.Util.getPageFromResource;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TesteCampoTreinamento {
	
	private WebDriver driver;

	@Before
	public void setUp() {
		driver = Util.getChromeDriver();
	}
	
	@After
	public void finalize() {
		driver.quit();
	}

	@Test
	public void testeTextField(){

		getPageFromResource(this.driver, "componentes.html");
		
		driver.findElement(By.id("elementosForm:nome")).sendKeys("Teste de escrita");
		Assert.assertEquals("Teste de escrita", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		
		
	}
	
	@Test
	public void deveIntegarirComTextArea(){
		
		getPageFromResource(this.driver, "componentes.html");
		
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("teste\n\naasldjdlks\nUltima linha");
		Assert.assertEquals("teste\n\naasldjdlks\nUltima linha", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
		
		
		
	}
	
	@Test
	public void deveIntegarirComRadioButton(){
		
		getPageFromResource(this.driver, "componentes.html");
		
		driver.findElement(By.id("elementosForm:sexo:0")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
		
	}
	
	@Test
	public void deveIntegarirComCheckbox(){
		
		getPageFromResource(this.driver, "componentes.html");
		
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
		
	}
	
	@Test
	public void deveIntegarirComCombo(){
		
		getPageFromResource(this.driver, "componentes.html");
		
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
//		combo.selectByIndex(2);
//		combo.selectByValue("superior");
		combo.selectByVisibleText("2o grau completo");
		
		Assert.assertEquals("2o grau completo", combo.getFirstSelectedOption().getText());
		
	}
	
	@Test
	public void deveVerificarValoresCombo(){
		
		getPageFromResource(this.driver, "componentes.html");
		
		WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		Assert.assertEquals(8, options.size());
		
		boolean encontrou = false;
		for(WebElement option: options) {
			if(option.getText().equals("Mestrado")){
				encontrou = true;
				break;
			}
		}
		Assert.assertTrue(encontrou);
	}
	
	@Test
	public void deveVerificarValoresComboMultiplo(){
		
		getPageFromResource(this.driver, "componentes.html");
		
		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		Select combo = new Select(element);
		combo.selectByVisibleText("Natacao");
		combo.selectByVisibleText("Corrida");
		combo.selectByVisibleText("O que eh esporte?");
		
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(3, allSelectedOptions.size());
		
		combo.deselectByVisibleText("Corrida");
		allSelectedOptions = combo.getAllSelectedOptions();
		Assert.assertEquals(2, allSelectedOptions.size());
		
	}
	
	@Test
	public void deveinteragirComBotoes(){
		getPageFromResource(this.driver, "componentes.html");

		WebElement botao = driver.findElement(By.id("buttonSimple"));
		botao.click();
		
		Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
		
		
	}
	
	@Test
	public void deveinteragirComLinks(){
		getPageFromResource(this.driver, "componentes.html");
	
		driver.findElement(By.linkText("Voltar")).click();
		
		Assert.assertEquals("Voltou!", driver.findElement(By.id("resultado")).getText());
		
	}
	
	@Test
	public void deveBuscarTextosNaPagina(){
		getPageFromResource(this.driver, "componentes.html");
		
//		Assert.assertTrue(driver.findElement(By.tagName("body"))
//				.getText().contains("Campo de Treinamento"));
		Assert.assertEquals("Campo de Treinamento", 
				driver.findElement(By.tagName("h3")).getText());
		
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", 
				driver.findElement(By.className("facilAchar")).getText());
		
	}
	
}


