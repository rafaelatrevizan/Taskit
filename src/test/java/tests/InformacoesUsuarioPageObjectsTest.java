package tests;

import Pages.LoginPage;
import Suporte.Web;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class InformacoesUsuarioPageObjectsTest {
    private WebDriver nav;

    @Before
    public void setUp (){
        nav = Web.createChrome();
    }

    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario(){
    new LoginPage(nav)
            .clickSignIn()
            .doLogin("rafatrevs", "123456")
            .clickMe()
            .clickMoreAbout()
            .addContact(0, "123456789");

    }

    //@After
    public void tearDown (){
        nav.quit();
    }
}
