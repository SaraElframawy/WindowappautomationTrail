
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class FileOnnotePadTest {
    public static WindowsDriver driver;

    @BeforeClass
    public void setUp() {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("app", "C:\\Windows\\System32\\notepad.exe");
        cap.setCapability("platformName", "Windows");
        cap.setCapability("deviceName", "LT-RS01");
        try {
            driver = new WindowsDriver(new URL("http://127.0.0.1:4723/"), cap);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void checkHelpAbout() {
        driver.findElement(By.name("Fil")).click();
        // Add your test logic here
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
