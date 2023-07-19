package org.example;

import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteCampoTreinamento {

    @Test
    public void testeTextField(){
        System.setProperty("web-driver.gecko.driver","C:/Development/JAVA/ProgramsDownloaded/geckodriver-r593/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Teste de escrita");
        Assertions.assertEquals("Teste de escrita", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
        driver.quit();
    }

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
}
