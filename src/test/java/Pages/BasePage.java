package Pages;

import Suporte.Generator;
import Suporte.Screenshot;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(DataDrivenTestRunner.class)

public class BasePage {

    protected WebDriver nav;
    @Rule
    public TestName testname = new TestName();

    public BasePage(WebDriver nav){
        this.nav = nav;
    }
    public void takeScreenSHot(String x){
        Screenshot.takeScreenshot(nav, "C:\\Users\\Laercio\\Documents\\Automação\\Prints\\Task it\\" + Generator.dataHoraArquivo() + testname.getMethodName() + ".png");
    }
}
