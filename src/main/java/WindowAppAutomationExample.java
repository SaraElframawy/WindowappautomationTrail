import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class WindowAppAutomationExample {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        // Define the Appium server URL
        URL appiumServerURL = new URL("http://127.0.0.1:4723"); // Update with your Appium server URL

        // Set desired capabilities for your Windows application automation
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "C:\\Windows\\System32\\notepad.exe");
        capabilities.setCapability("deviceName", "WindowsPC");
        capabilities.setCapability("platformName", "windows");
        capabilities.setCapability("automationName", "Windows");

        // Create a WindowsDriver instance
        WindowsDriver<WindowsElement> driver = new WindowsDriver<>(appiumServerURL, capabilities);

        // Now, you can perform automation actions on your Windows application using the 'driver' object
        // For example, you can find elements and interact with them, such as clicking buttons or entering text.

        // Close the driver when done

        Thread.sleep(15);
        driver.quit();
    }
}

