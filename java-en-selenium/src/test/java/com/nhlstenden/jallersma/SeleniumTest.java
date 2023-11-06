package com.nhlstenden.jallersma;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class SeleniumTest {
    @Test
    public void RegisterTest() {
        WebDriver driver = new FirefoxDriver();

        driver.get("http://localhost:9090");

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1500));
        WebElement registerBtn = driver.findElement(By.cssSelector("input"));
        registerBtn.click();
    }
}
