package selenium.test.course.app;

import org.junit.Assert;
import org.junit.Test;

import selenium.core.BaseTest;
import selenium.page.course.app.HomePage;
import selenium.page.course.app.MenuPage;

public class SaldoTest extends BaseTest {
	HomePage page = new HomePage();
	MenuPage menu = new MenuPage();

	@Test
	public void testSaldoConta(){
		menu.acessarTelaPrincipal();
		Assert.assertEquals("534.00", page.obterSaldoConta("Conta para saldo"));
	}
}
