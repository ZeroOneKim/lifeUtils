package binarykim.lifeutils.workManage;

import binarykim.lifeutils.workManage.security.SecurityInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class PageModuler {
    @Autowired SecurityInfo securityInfo;
    private WebDriver driver;

    public PageModuler() {
        this.driver = WebDriverConfig.getDriver();
    }

    private void initializeDriver() {
        if (driver == null) {
            driver = WebDriverConfig.getDriver();
        }
    }

    public void loginPRC() throws Exception {
        initializeDriver();

        System.out.println("CHECKED : " + driver);
        driver.get(securityInfo.getUrl());

        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login_submit"));

        usernameField.sendKeys(securityInfo.getGwUserName());
        passwordField.sendKeys(securityInfo.getGwPassword());

        loginButton.click();
        Thread.sleep(8000);
    }

    public void isSKIP() throws Exception {
        WebElement SKIP = driver.findElement(By.className("welcome_skip"));
        SKIP.click();
        Thread.sleep(500);
    }

    public void prcManage() {
        WebElement workIn = driver.findElement(By.id("workIn"));
        workIn.click();
    }

    public void quitDriver() {
        driver.quit();
        driver = null;
    }
}
