package Suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class Web {

    public static WebDriver createChrome(){

        //Abrindo o navegador
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Laercio\\Documents\\Automação\\Chrome Driver\\chromedriver.exe");

        WebDriver nav = new ChromeDriver();

        nav.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //Maximizar a janela do chrome
        nav.manage().window().maximize();

        //Navegando até a página do site
        nav.get("http://www.juliodelima.com.br/taskit");

        return nav;
    }
}
