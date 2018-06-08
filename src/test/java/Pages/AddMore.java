package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;

public class AddMore extends BasePage {
    private WebElement add = nav.findElement(By.id("addmoredata"));

    public AddMore(WebDriver nav) {
        super(nav);
    }

    public AddMore chooseTipeContact(Integer tipo){
        WebElement op = add.findElement(By.name("type"));
        new Select(op).selectByIndex(tipo);
        return this;
    }

    public AddMore typeContact (String contato){
        add.findElement(By.name("contact")).sendKeys(contato);
        return this;
    }

    public MePage clickSave (){
        add.findElement(By.linkText("SAVE")).click();

        return new MePage(nav);
    }

    public MePage addContact (Integer tipo, String contato){
        chooseTipeContact(tipo);
        typeContact(contato);
        clickSave();
        WebElement msgSucesso = nav.findElement(By.id("toast-container"));
        String confirmacao = msgSucesso.getText();
        assertEquals("Your contact has been added!",confirmacao);

        return new MePage(nav);
    }
}
