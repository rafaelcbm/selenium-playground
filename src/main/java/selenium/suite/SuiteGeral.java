package selenium.suite;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import selenium.core.DriverFactory;
import selenium.page.course.app.LoginPage;
import selenium.test.course.app.ContaTest;
import selenium.test.course.app.MovimentacaoTest;
import selenium.test.course.app.RemoverMovimentacaoContaTest;
import selenium.test.course.app.ResumoTest;
import selenium.test.course.app.SaldoTest;

@RunWith(Suite.class)
@SuiteClasses({
	ContaTest.class,
	MovimentacaoTest.class,
	RemoverMovimentacaoContaTest.class,
	SaldoTest.class,
	ResumoTest.class
})
public class SuiteGeral {
	private static LoginPage page = new LoginPage();
	
	@BeforeClass
	public static void reset(){
		page.acessarTelaInicial();
		
		page.setEmail("rafaelcbm@gmail.com");
		page.setSenha("rafael654321");
		page.entrar();
		
		page.resetar();
		
		DriverFactory.killDriver();
	}
}
