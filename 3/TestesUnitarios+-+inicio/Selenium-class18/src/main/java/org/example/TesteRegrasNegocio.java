package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteRegrasNegocio {

    private static WebDriver driver;

    @BeforeAll
    public static void inicializa() {
        System.setProperty("web-driver.gecko.driver", "C:/Learning/Selenium-Java/geckodriver-v0.33.0-win-aarch64/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
    }

    @AfterAll
    public static void finaliza() {
        driver.quit();
    }

    @Test
    public void testeNameTextField() {

        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("Nome eh obrigatorio", alert.getText());
        alert.accept();
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Henrique");
        driver.findElement(By.id("elementosForm:cadastrar")).click();
        alert.accept();
       // driver.quit();
    }

    @Test
    public void testeSurNameTextfield() {
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Henrique");
        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("Sobrenome eh obrigatorio", alert.getText());
        alert.accept();
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Kriguer");
        driver.findElement(By.id("elementosForm:cadastrar")).click();
        alert.accept();
        //driver.quit();
    }

    @Test
    public void testeSexoRadioButton() {
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Henrique");
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Kriguer");
        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("Sexo eh obrigatorio", alert.getText());
        alert.accept();
        driver.findElement(By.id("elementosForm:sexo:0")).click();
        driver.findElement(By.id("elementosForm:cadastrar")).click();
        //driver.quit();
    }

    @Test
    public void testeCheckBox() {
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Henrique");
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Kriguer");
        driver.findElement(By.id("elementosForm:sexo:0")).click();
        driver.findElement(By.id("elementosForm:sexo:1")).click();
        driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
        driver.findElement(By.id("elementosForm:comidaFavorita:1")).click();
        driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
        driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("Tem certeza que voce eh vegetariano?", alert.getText());
        alert.accept();
        driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
        driver.findElement(By.id("elementosForm:cadastrar")).click();
       // driver.quit();
    }

    @Test
    public void testeCombo() {
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Henrique");
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Kriguer");
        driver.findElement(By.id("elementosForm:sexo:0")).click();
        WebElement element = driver.findElement(By.id("elementosForm:esportes"));
        Select combo = new Select(element);
        combo.selectByVisibleText("Natacao");
        combo.selectByVisibleText("Futebol");
        combo.selectByVisibleText("Corrida");
        combo.selectByVisibleText("Karate");
        combo.selectByVisibleText("O que eh esporte?");
        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("Voce faz esporte ou nao?", alert.getText());
        alert.accept();
        combo.deselectByVisibleText("O que eh esporte?");
        driver.findElement(By.id("elementosForm:cadastrar")).click();
        //driver.quit();
    }
}
