package Suporte;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class Screenshot {
    public static void takeScreenshot(WebDriver nav, String arquivo){
        File screen = ((TakesScreenshot)nav).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screen, new File(arquivo));
        }catch (Exception e){
            System.out.println("Houveram problemas para copiar o arquivo" + e.getMessage());
        }


    }
}
