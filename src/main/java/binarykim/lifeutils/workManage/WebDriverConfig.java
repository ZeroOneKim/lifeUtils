package binarykim.lifeutils.workManage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Component;

/**
 * @Configuration 사용 시, Spring Container가 종료 되는 시점 Bean을 정리 함.
 * 즉 스프링 애플리케이션이 종료되는 순간 Bean의 라이프사이클이 끝나게 되므로, 하나의 드라이버로 브라우저를 컨트롤 못함으로 생각됨.
 */
public class WebDriverConfig {
    private static WebDriver driver;

    private WebDriverConfig() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(options);
        }
        return driver;
    }
}
