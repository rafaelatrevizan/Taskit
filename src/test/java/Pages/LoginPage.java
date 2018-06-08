package Pages;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "InformacoesUsuariosTest.csv")

public class LoginPage extends BasePage  {
    @Rule
    public TestName testname = new TestName();

    public LoginPage(WebDriver nav) {
        super(nav);
    }

    public LoginFormPage clickSignIn(){

        WebElement Signin =  nav.findElement(By.linkText("Sign in"));
        Signin.click();
        String x = testname.getMethodName();
        this.takeScreenSHot(x);
        //Screenshot.takeScreenshot(nav, "C:\\Users\\Laercio\\Documents\\Automação\\Prints\\Task it\\" + Generator.dataHoraArquivo() + testname.getMethodName() + ".png");
        return new LoginFormPage(nav);
    }

}
