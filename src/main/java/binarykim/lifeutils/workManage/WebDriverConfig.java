package binarykim.lifeutils.workManage;

import binarykim.lifeutils.workManage.security.SecurityInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * @Configuration 사용 시, Spring Container가 종료 되는 시점 Bean을 정리 함.
 * 즉 스프링 애플리케이션이 종료되는 순간 Bean의 라이프사이클이 끝나게 되므로, 하나의 드라이버로 브라우저를 컨트롤 못함으로 생각됨.
 */
public class WebDriverConfig {
    private static WebDriver driver;

    private WebDriverConfig() {
    }

    public static WebDriver getDriver() {
        String compIpInfo = new SecurityInfo().getCompIp();

        if (driver == null) {
            WebDriverManager.chromedriver().setup();

            Proxy proxy = new Proxy();
            proxy.setHttpProxy(compIpInfo);
            proxy.setSslProxy(compIpInfo);

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.setProxy(proxy);

            driver = new ChromeDriver(options);
        }
        return driver;
    }
}
