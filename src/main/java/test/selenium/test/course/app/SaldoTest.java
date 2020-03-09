package test.selenium.test.course.app;

import org.junit.Assert;
import org.junit.Test;

import test.selenium.core.BaseTest;
import test.selenium.core.Propriedades;
import test.selenium.page.HomePage;
import test.selenium.page.MenuPage;

public class SaldoTest extends BaseTest {
	HomePage page = new HomePage();
	MenuPage menu = new MenuPage();

	@Test
	public void testSaldoConta(){
		menu.acessarTelaPrincipal();
		Assert.assertEquals("500.00", page.obterSaldoConta(Propriedades.NOME_CONTA_ALTERADA));
	}
}
