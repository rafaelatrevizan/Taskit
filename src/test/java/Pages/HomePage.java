package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{


    public HomePage(WebDriver nav) {
        super(nav);
    }

    public MePage clickMe (){
        nav.findElement(By.className("me")).click();

        return new MePage(nav);
    }
}
