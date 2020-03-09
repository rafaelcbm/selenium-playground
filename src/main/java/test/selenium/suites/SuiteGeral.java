package test.selenium.suites;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.selenium.core.DriverFactory;
import test.selenium.page.LoginPage;
import test.selenium.test.course.app.ContaTest;
import test.selenium.test.course.app.MovimentacaoTest;
import test.selenium.test.course.app.RemoverMovimentacaoContaTest;
import test.selenium.test.course.app.ResumoTest;
import test.selenium.test.course.app.SaldoTest;

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
	public static void inicializa(){
		page.acessarTelaInicial();
		
		page.setEmail("rafaelcbm@gmail.com");
		page.setSenha("rafael654321");
		page.entrar();
	}
	
	@AfterClass
	public static void finaliza(){
		DriverFactory.killDriver();
	}
}
