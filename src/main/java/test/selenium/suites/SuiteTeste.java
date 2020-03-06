package test.selenium.suites;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.selenium.core.DriverFactory;
import test.selenium.test.TesteCadastro;
import test.selenium.test.TesteRegrasCadastro;

@RunWith(Suite.class)
@SuiteClasses({ TesteCadastro.class, TesteRegrasCadastro.class })
public class SuiteTeste {

	@AfterClass
	public static void finalizaTudo() {
		DriverFactory.killDriver();
	}

}
