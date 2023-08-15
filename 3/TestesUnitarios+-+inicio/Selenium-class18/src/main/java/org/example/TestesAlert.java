package org.example;


import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestesAlert {

    @Test
    public void testeAlertSimples() {
        System.setProperty("web-driver.gecko.driver", "C:/Learning/Selenium-Java/geckodriver-v0.33.0-win-aarch64/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        driver.findElement(By.id("alert")).click();
        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("Alert Simples", alert.getText());
        String texto = alert.getText();
        alert.accept();
        System.out.println(texto);
        driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
    }
}