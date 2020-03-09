package test.selenium.test.course.app;

import org.junit.Assert;
import org.junit.Test;

import test.selenium.core.BaseTest;
import test.selenium.core.Propriedades;
import test.selenium.page.ContasPage;
import test.selenium.page.MenuPage;

public class RemoverMovimentacaoContaTest extends BaseTest {
	
	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();

	@Test
	public void testExcluirContaComMovimentacao(){
		menuPage.acessarTelaListarConta();
		
		contasPage.clicarExcluirConta(Propriedades.NOME_CONTA_ALTERADA);
		
		Assert.assertEquals("Conta em uso na movimentações", contasPage.obterMensagemErro());
	}
}
