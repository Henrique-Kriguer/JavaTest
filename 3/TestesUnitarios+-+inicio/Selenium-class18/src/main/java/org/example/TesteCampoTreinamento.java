package org.example;

import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCampoTreinamento {
    @Test
    public void testeTextField() {
        System.setProperty("web-driver.gecko.driver", "C:/Learning/Selenium-Java/geckodriver-v0.33.0-win-aarch64/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Teste de escrita");
        Assertions.assertEquals("Teste de escrita", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
       // driver.quit();
    }
        @Test
        public void testeTextArea(){
            System.setProperty("web-driver.gecko.driver","C:/Learning/Selenium-Java/geckodriver-v0.33.0-win-aarch64/geckodriver.exe");
            WebDriver driver = new FirefoxDriver();
            driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
            driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Teste de escrita 2");
            Assertions.assertEquals("Teste de escrita 2", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
            //driver.quit();
    }

    @Test
    public void testeRadioButtonn() {
        System.setProperty("web-driver.gecko.driver", "C:/Learning/Selenium-Java/geckodriver-v0.33.0-win-aarch64/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        driver.findElement(By.id("elementosForm:sexo:0")).click();
        Assertions.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
    }

    @Test
    public void testeCheckBox() {
        System.setProperty("web-driver.gecko.driver", "C:/Learning/Selenium-Java/geckodriver-v0.33.0-win-aarch64/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
        Assertions.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
    }

    @Test
    public void testeComboBox() {
        System.setProperty("web-driver.gecko.driver", "C:/Learning/Selenium-Java/geckodriver-v0.33.0-win-aarch64/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
        Select combo = new Select(element);
        combo.selectByVisibleText("Superior");
        Assertions.assertEquals("Superior", combo.getFirstSelectedOption().getText());

    }
/*
    @Test
    public void testeInteragindoTextArea(){
        WebDriver driver = new FirefoxDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Teste campo textArea");
        Assertions.assertEquals("Teste campo textArea", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
        driver.quit();
    }

    @Test
    public void testeRadioBtn(){
        WebDriver driver = new FirefoxDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");

    }
*/

}
