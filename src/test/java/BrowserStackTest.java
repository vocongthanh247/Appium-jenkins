import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class BrowserStackTest {
    public static void main(String[] args) {
        String userName = "thanhvo_DtH7RP"; // Thay bằng tên đăng nhập BrowserStack của bạn
        String accessKey = "AH576ScJ6B8qgD1DxLz6"; // Thay bằng Access Key của bạn

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("device", "Samsung Galaxy S21"); // Thay đổi thiết bị
        caps.setCapability("os_version", "12.0"); // Cập nhật phiên bản OS
        caps.setCapability("browserstack.local", "false");
        caps.setCapability("name", "Samsung Galaxy S21 Test");

        try {
            WebDriver driver = new RemoteWebDriver(
                    new URL("http://" + userName + ":" + accessKey + "@hub-cloud.browserstack.com/wd/hub"),
                    caps);
            driver.get("http://example.com");
            System.out.println("Title: " + driver.getTitle());
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}