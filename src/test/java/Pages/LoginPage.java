package Pages;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "InformacoesUsuariosTest.csv")

public class LoginPage extends BasePage  {


    public LoginPage(WebDriver nav) {
        super(nav);
    }

    public LoginFormPage clickSignIn(){

        WebElement Signin =  nav.findElement(By.linkText("Sign in"));
        Signin.click();

        //this.takeScreenSHot(x);

        return new LoginFormPage(nav);
    }

}
