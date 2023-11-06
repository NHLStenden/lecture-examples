package com.nhlstenden.jallersma;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class SeleniumTest {
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        driver = new FirefoxDriver();
    }

    @Before
    public void setUpBefore() {
        driver.get("http://localhost:9090");
    }

    @Test
    public void RegisterTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1500));
        WebElement registerBtn = driver.findElement(By.cssSelector("input"));
        registerBtn.click();

        WebElement emailTextField = driver.findElement(By.cssSelector("input#user-name"));
        emailTextField.sendKeys("test@test.nl");

        WebElement phoneTextField = driver.findElement(By.cssSelector("input#phone"));
        phoneTextField.sendKeys("000-00-000");

        WebElement submitBtn = driver
                .findElement(By.cssSelector("div.submitDiv"))
                .findElement(By.cssSelector("input"));

        submitBtn.click();

        WebElement thanksHeader = driver.findElement(By.cssSelector("h1"));
        Assert.assertEquals("Bedankt!", thanksHeader.getText());
    }

    @Test
    public void failRegistration() {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1500));
        WebElement registerBtn = driver.findElement(By.cssSelector("input"));
        registerBtn.click();

        WebElement emailTextField = driver.findElement(By.cssSelector("input#user-name"));
        emailTextField.sendKeys("test");

        WebElement phoneTextField = driver.findElement(By.cssSelector("input#phone"));
        phoneTextField.sendKeys("000-00-000");

        WebElement submitBtn = driver
                .findElement(By.cssSelector("div.submitDiv"))
                .findElement(By.cssSelector("input"));

        submitBtn.click();

        WebElement thanksHeader = driver.findElement(By.cssSelector("h1"));
        Assert.assertNotSame("Bedankt!", thanksHeader.getText());
    }
}
