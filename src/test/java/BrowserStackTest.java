import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class BrowserStackTest {
    public static void main(String[] args) {
        String userName = "thanhvo_DtH7RP"; // Thay bằng tên đăng nhập BrowserStack của bạn
        String accessKey = "AH576ScJ6B8qgD1DxLz6"; // Thay bằng Access Key của bạn

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("device", "Samsung Galaxy S21"); // Thiết bị
        caps.setCapability("os_version", "12.0"); // Phiên bản OS
        caps.setCapability("browserstack.local", "false");
        caps.setCapability("browser", "chrome"); // Thêm trình duyệt
        caps.setCapability("name", "Samsung Galaxy S21 Test");
        caps.setCapability("browserstack.video", "true"); // Bật ghi video
        caps.setCapability("browserstack.debug", "true"); // Bật ghi log

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