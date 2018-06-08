package Suporte;

import Pages.BasePage;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(DataDrivenTestRunner.class)


public class BaseScreen extends BasePage {
    @Rule
    public TestName testname = new TestName();

    public BaseScreen(WebDriver nav) {
        super(nav);
    }

    public void takeScreenSHot(String x){
        Screenshot.takeScreenshot(nav, "C:\\Users\\Laercio\\Documents\\Automação\\Prints\\Task it\\" + Generator.dataHoraArquivo() + x + ".png");
    }
}
