import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumBy.ByName;
import io.appium.java_client.windows.WindowsDriver;

import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class NotePadTest {
    public static WindowsDriver driver;
    @BeforeAll
    public static void setUp(){
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("app","C:\\Windows\\System32\\notepad.exe");  //"C:\Windows\System32\notepad.exe"
        cap.setCapability("platformName","Windows");
        cap.setCapability("deviceName","LT-RS01");
        try {
            driver = new WindowsDriver(new URL("http://127.0.0.1:4723/"),cap);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void checkHelpAbout(){
      driver.findElement(By.name("Fil")).click();
    }
    @AfterMethod
    public void cleanUp() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
        setUp();
    }
    @AfterSuite
    public void tearDown(){
        driver.quit();
    }
}
