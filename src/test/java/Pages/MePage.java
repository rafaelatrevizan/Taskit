package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MePage extends BasePage {

    public MePage(WebDriver nav) {
        super(nav);
    }

    public AddMore clickMoreAbout(){
        nav.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
        nav.findElement(By.xpath("//button[contains(text(), \"+ Add more data\")]")).click();

        return new AddMore(nav);
    }


}
