package com.nhlstenden.jallersma;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class SeleniumTest {
    static ChromeDriver driver;

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
    }

    @After
    public void breakDown() {
        driver.get("chrome://settings/");
        driver.executeScript("chrome.settingsPrivate.setDefaultZoom(1);");
    }

    @Test
    public void checkForAboutBtn() {
        driver.get("http://localhost:9090");

        WebDriverWait wait = new WebDriverWait(driver, Duration.of(5, ChronoUnit.SECONDS));
        WebElement aboutBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input.btn#about")));
        aboutBtn.click();

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.of(5, ChronoUnit.SECONDS));
        WebElement aboutHeader = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1#about")));
        Assert.assertNotNull(aboutHeader);
    }

    @Test
    public void checkForAboutBtnWithZoom() {
        driver.get("chrome://settings/");
        driver.executeScript("chrome.settingsPrivate.setDefaultZoom(5);");
        driver.get("http://localhost:9090");

        WebDriverWait wait = new WebDriverWait(driver, Duration.of(5, ChronoUnit.SECONDS));
        WebElement aboutBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input.btn#about")));
        aboutBtn.click();

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.of(5, ChronoUnit.SECONDS));
        WebElement aboutHeader = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1#about")));

        Assert.assertNotNull(aboutHeader);
    }
}
