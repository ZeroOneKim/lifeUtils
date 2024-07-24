package binarykim.lifeutils.workManage;

import binarykim.lifeutils.workManage.security.SecurityInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WorkManager {
    @Autowired private SecurityInfo securityInfo;

    public void doTest() {
        Thread thread = new Thread();

        WebDriverManager.chromedriver().setup();

        // Chrome 옵션 설정 (예: 브라우저 창 숨기기)
        ChromeOptions options = new ChromeOptions();
//      options.addArguments("--headless"); // GUI를 띄우지 않고 실행

        WebDriver driver = new ChromeDriver(options);

        try {
            driver.get(securityInfo.getUrl());

            WebElement usernameField = driver.findElement(By.id("username")); // 사용자명 입력 필드
            WebElement passwordField = driver.findElement(By.id("password")); // 비밀번호 입력 필드
            WebElement loginButton = driver.findElement(By.id("login_submit")); // 로그인 버튼
            //스킵 처리 필수 >> Element > "welcome_skip"

            // 사용자명과 비밀번호 입력
            usernameField.sendKeys(securityInfo.getGwUserName());
            passwordField.sendKeys(securityInfo.getGwPassword());

            loginButton.click();

            thread.sleep(3000);
            WebElement SKIP = driver.findElement(By.className("welcome_skip"));
            SKIP.click();

            WebElement workIn = driver.findElement(By.id("workIn"));
            System.out.println(workIn);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            driver.quit(); // 브라우저 닫기
        }
    }
}
