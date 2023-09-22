package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteFrameEjanelas {

    @Test
    public void testeBotaoDentroFrame() {
        System.setProperty("web-driver.gecko.driver", "C:/Learning/Selenium-Java/geckodriver-v0.33.0-win-aarch64/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        driver.switchTo().frame("frame1");
        driver.findElement(By.id("frameButton")).click();
        Alert alert = driver.switchTo().alert();
        String msg = alert.getText();
        Assertions.assertEquals("Frame OK!",msg);
        alert.accept();
        driver.switchTo().defaultContent();
        driver.findElement(By.id("elementosForm:nome")).sendKeys(msg);
    }

    @Test
    public void testeScriptJanela() {
        System.setProperty("web-driver.gecko.driver", "C:/Learning/Selenium-Java/geckodriver-v0.33.0-win-aarch64/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        driver.findElement(By.id("buttonPopUpEasy")).click();
        driver.switchTo().window("Popup");
        driver.findElement(By.tagName("textarea")).sendKeys("Deu certo !!");
        driver.close();
    }

    @Test
    public void testeScriptJanelaSemTitulo() {
        System.setProperty("web-driver.gecko.driver", "C:/Learning/Selenium-Java/geckodriver-v0.33.0-win-aarch64/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        driver.findElement(By.id("ButtonPopUpHard")).click();
        System.out.println(driver.getWindowHandle());
        System.out.println(driver.getWindowHandles());
       /* driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]);
        driver.findElement(By.tagName("textarea")).sendKeys("Escrevi aqui !");
        driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]);
        driver.findElement(By.tagName("textarea")).sendKeys("Escrevi aqui também !");
*/


    }
}
