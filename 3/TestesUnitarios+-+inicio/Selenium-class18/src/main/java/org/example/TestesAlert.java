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

    @Test
    public void testeAlertConfirm() {
        System.setProperty("web-driver.gecko.driver", "C:/Learning/Selenium-Java/geckodriver-v0.33.0-win-aarch64/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        driver.findElement(By.id("confirm")).click();
        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("Confirm Simples", alert.getText());
        String texto = alert.getText();
        alert.accept(); // clica no ok e surge outro alerta na tela



        Alert alertConfirma = driver.switchTo().alert();
        Assertions.assertEquals("Confirmado", alertConfirma.getText());
        String texto2 = alertConfirma.getText();
        alertConfirma.accept(); // fecha o segundo alerta
        driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys(texto2);
        System.out.println(texto);
        System.out.println(texto2);


    }
    @Test
    public void testeAlertNotConfirm() {
        System.setProperty("web-driver.gecko.driver", "C:/Learning/Selenium-Java/geckodriver-v0.33.0-win-aarch64/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        driver.findElement(By.id("confirm")).click();
        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("Confirm Simples", alert.getText());
        String texto3 = alert.getText();
        alert.dismiss(); // clica no cancelar e surge outro alerta na tela

        Alert alertCancela = driver.switchTo().alert();
        Assertions.assertEquals("Negado", alertCancela.getText());
        String texto4 = alertCancela.getText();
        alertCancela.accept(); // fecha o segundo alerta
        driver.findElement(By.id("elementosForm:nome")).sendKeys(texto3);
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys(texto4);
        System.out.println(texto3);
        System.out.println(texto4);


    }

}