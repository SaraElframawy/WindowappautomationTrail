

import io.appium.java_client.windows.WindowsDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

public class FileOnnotePadTest {
   protected static WindowsDriver driver;

   public static String getDate(){
       LocalDate date= LocalDate.now();
       System.out.println(date.toString());

       return date.toString();

   }




    @BeforeClass
    public void setUp() throws InterruptedException {


        try {
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability("app", "C:\\Windows\\System32\\notepad.exe");
            // cap.setCapability("appTopLevelWindow", "Namnlös – Anteckningar++");
            cap.setCapability("paltformName", "windows");
            cap.setCapability("deviceName", "WindowsPC");
            cap.setCapability("automationName","Windows");

            //
           driver = new WindowsDriver(new URL("http://127.0.0.1:4723"), cap);

        } catch (MalformedURLException e) {
           e.printStackTrace();
        }
    //    Thread.sleep(5);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Test
    public void checkHelpAbout() {
      driver.findElement(By.name("Fil")).click();
      driver.findElement(By.name("Spara som"));

      //  driver.findElement(By.name("Textredigerare")).sendKeys("My name is Sara");

    }

    @AfterMethod
    public void cleanUp() throws InterruptedException {
        Thread.sleep(15);
            driver.quit();


    }
    @AfterSuite
    public void tearDown() throws InterruptedException {
       Thread.sleep(10);
       driver.quit();
    }
}
