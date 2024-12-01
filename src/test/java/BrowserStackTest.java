import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class BrowserStackTest {
    public static void main(String[] args) {
        String userName = "thanhvo_DtH7RP"; // Thay bằng tên đăng nhập BrowserStack của bạn
        String accessKey = "thanhvo_DtH7RP"; // Thay bằng Access Key của bạn

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("device", "Samsung Galaxy A32");
        caps.setCapability("os_version", "11.0"); // Cập nhật phiên bản nếu cần
        caps.setCapability("browserstack.local", "false");
        caps.setCapability("name", "Samsung Galaxy A32 Test");

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