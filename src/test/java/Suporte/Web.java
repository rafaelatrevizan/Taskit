package Suporte;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Web {
    public static final String USERNAME = "rafaelatrevizan1";
    public static final String AUTOMATE_KEY = "pgTZA849cK6kQfhovJZs";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

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

    public static WebDriver createBrowserStack (){
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "62.0");
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("resolution", "1280x1024");
        caps.setCapability("browserstack.debug", "true");
        WebDriver nav = null;
        try {
            nav = new RemoteWebDriver(new URL(URL), caps);
            nav.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            //Navegando até a página do site
            nav.get("http://www.juliodelima.com.br/taskit");
        } catch (MalformedURLException e) {
            System.out.println("Houveram problemas com a URL:" + e.getMessage());
        }
        return nav;

    }
}
