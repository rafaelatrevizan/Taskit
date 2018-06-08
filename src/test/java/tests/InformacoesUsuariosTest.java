package tests;

import Suporte.Generator;
import Suporte.Screenshot;
import Suporte.Web;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "InformacoesUsuariosTest.csv")
public class InformacoesUsuariosTest {
    private WebDriver nav;

    @Rule
    public TestName testname = new TestName();

    @Before
    public void setUp(){
        nav = Web.createChrome();

        //Clicar no link Sign, Preencher os campos, Clicar no botão SIGN IN
        //Guardar o elemento do link em uma variável
        WebElement Signin =  nav.findElement(By.linkText("Sign in"));
        //Clicar no link
        Signin.click();

        //Guardar o elemento do box para login dentro de uma variável
        WebElement signInBox = nav.findElement(By.id("signinbox"));
        //Preenche o campo login
        signInBox.findElement(By.name("login")).sendKeys("rafatrevs");

        //Preenche o campo senha
        signInBox.findElement(By.name("password")).sendKeys("123456");
        //Clicar no botão para entrar
        signInBox.findElement(By.linkText("SIGN IN")).click();

        //Validação de duas variáveis
        //String login = nav.findElement(By.className("me")).getText();
        //assertEquals("Hi, Rafaela",login);

        //Clicar no nome do login para entrar em mais informações
        nav.findElement(By.className("me")).click();
        //Clicar na aba more about you
        nav.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
    }

    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario(@Param(name = "telefone") Integer telefone, @Param(name = "contato") String contato, @Param(name="mensagem") String mensagem){

        //Clicar no botão para adicionar mais informações
        nav.findElement(By.xpath("//button[contains(text(), \"+ Add more data\")]")).click();

        //Identificar o modal
        WebElement add = nav.findElement(By.id("addmoredata"));

        //Selecionar no combo a opção Phone
        WebElement op = add.findElement(By.name("type"));
        new Select(op).selectByIndex(telefone);

        //digitar o telefone
        add.findElement(By.name("contact")).sendKeys(contato);

        //Clicar no botão para salvar
        add.findElement(By.linkText("SAVE")).click();

        //Confirmar mensagem de sucesso
        WebElement msgSucesso = nav.findElement(By.id("toast-container"));
        String confirmacao = msgSucesso.getText();
        assertEquals(mensagem,confirmacao);
    }

    //@Test
    public void removerContato(){
        //Reconhecendo qual numero vou deletar pelo xpath //span[contains(text(), "123456")]/following-sibling::a
        //Clicar na lixeira
        nav.findElement(By.xpath("//span[contains(text(), \"11912345678\")]/following-sibling::a")).click();

        //Clicar no Sim da mensagem - janela javascript
        nav.switchTo().alert().accept();

        //Confimar mensagem de exclusão: Rest in peace, dear phone!
        WebElement msgSucesso = nav.findElement(By.id("toast-container"));
        String confirmacao = msgSucesso.getText();
        assertEquals("Rest in peace, dear phone!",confirmacao);

        Screenshot.takeScreenshot(nav, "C:\\Users\\Laercio\\Documents\\Automação\\Prints\\Task it\\" + Generator.dataHoraArquivo() + testname.getMethodName() + ".png");

        //espero explícita
        WebDriverWait aguardar = new WebDriverWait(nav, 10);
        aguardar.until(ExpectedConditions.stalenessOf(msgSucesso));

        //Fazer logout
        nav.findElement(By.linkText("Logout")).click();

    }

    @After
    public void TearDown(){
        //Fechar navegador
        nav.quit();
    }
}
