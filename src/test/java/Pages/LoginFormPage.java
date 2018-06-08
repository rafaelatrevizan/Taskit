package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFormPage extends BasePage {
    public LoginFormPage(WebDriver nav) {
        super(nav);
    }

    // public LoginFormPage typeLogin(String Login){
   //     nav.findElement(By.id("signinbox")).findElement(By.name("login")).sendKeys("rafatrevs");
   //     return this;
   // }

    //public LoginFormPage typePassword(String senha){
    //    nav.findElement(By.id("signinbox")).findElement(By.name("password")).sendKeys("123456");
    //    return this;
   // }

   // public HomePage clickSignIn (){
    //    nav.findElement(By.id("signinbox")).findElement(By.linkText("SIGN IN")).click();
    //    return new HomePage(nav);
   // }

    public HomePage doLogin (String login, String senha){
        nav.findElement(By.id("signinbox")).findElement(By.name("login")).sendKeys("rafatrevs");
        nav.findElement(By.id("signinbox")).findElement(By.name("password")).sendKeys("123456");
        nav.findElement(By.id("signinbox")).findElement(By.linkText("SIGN IN")).click();

        return new HomePage(nav);
    }

}
