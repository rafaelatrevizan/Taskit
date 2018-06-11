package tests;

import Pages.LoginPage;
import Suporte.Web;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "InformacoesUsuariosTest.csv")

public class InformacoesUsuarioPageObjectsTest {
    private WebDriver nav;

    @Before
    public void setUp (){
        nav = Web.createBrowserStack();
    }

    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario (
            @Param(name = "login") String login,
            @Param(name = "senha") String senha,
            @Param(name = "telefone") Integer telefone,
            @Param(name = "contato") String contato,
            @Param(name="mensagem") String mensagem){
    String textoSucessMessage = new LoginPage(nav)
            .clickSignIn()
            .doLogin(login, senha)
            .clickMe()
            .clickMoreAbout()
            .addContact(telefone, contato)
            .sucessMessage();

        assertEquals(mensagem, textoSucessMessage);

    }

    @After
    public void tearDown (){
        nav.quit();
    }
}
