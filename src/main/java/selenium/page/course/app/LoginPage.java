package selenium.page.course.app;

import selenium.core.BasePage;
import selenium.core.DriverFactory;

public class LoginPage extends BasePage {
	
	public void acessarTelaInicial(){
		DriverFactory.getDriver().get("https://seubarriga.wcaquino.me/");
	}
	
	public void setEmail(String email) {
		escrever("email", email);
	}
	
	public void setSenha(String senha) {
		escrever("senha", senha);
	}
	
	public void entrar(){
		clicarBotaoPorTexto("Entrar");
	}
	
	public void logar(String email, String senha) {
		setEmail(email);
		setSenha(senha);
		entrar();
	}
	
	public void resetar(){
		clicarLink("reset");
	}

}
