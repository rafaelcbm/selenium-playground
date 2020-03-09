package test.selenium.test.course.app;

import static test.selenium.core.DriverFactory.getDriver;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import test.selenium.core.BaseTest;
import test.selenium.core.DriverFactory;
import test.selenium.page.MenuPage;
import test.selenium.page.ResumoPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ResumoTest extends BaseTest {
	private MenuPage menuPage = new MenuPage();
	private ResumoPage resumoPage = new ResumoPage();

	@Test
	public void test1ExcluirMovimentacao(){
		menuPage.acessarTelaResumo();
		
		resumoPage.excluirMovimentacao();
		
		Assert.assertEquals("Movimentação removida com sucesso!",
				resumoPage.obterMensagemSucesso());
	}
	
//	@Test(expected=NoSuchElementException.class)
	@Test
	public void test2ResumoMensal(){
		menuPage.acessarTelaResumo();
		
		Assert.assertEquals("Seu Barriga - Extrato", getDriver().getTitle());
		
//		DriverFactory.getDriver().findElement(By.xpath("//*[@id='tabelaExtrato']/tbody/tr"));
		
//		try{
//			DriverFactory.getDriver().findElement(By.xpath("//*[@id='tabelaExtrato']/tbody/tr"));
//			Assert.fail();
//		} catch (NoSuchElementException e) {
//			
//		}
		
		List<WebElement> elementosEncontrados = 
				DriverFactory.getDriver().findElements(By.xpath("//*[@id='tabelaExtrato']/tbody/tr"));
		for (WebElement webElement : elementosEncontrados) {
			System.out.println(webElement.getText());
		}
		Assert.assertEquals(0, elementosEncontrados.size());
	}
}
