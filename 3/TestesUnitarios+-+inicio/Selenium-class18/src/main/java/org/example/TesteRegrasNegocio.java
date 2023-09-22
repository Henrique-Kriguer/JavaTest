package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteRegrasNegocio {

        @Test
        public void testeNameTextField() {
            System.setProperty("web-driver.gecko.driver", "C:/Learning/Selenium-Java/geckodriver-v0.33.0-win-aarch64/geckodriver.exe");
            WebDriver driver = new FirefoxDriver();
            driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
            driver.findElement(By.id("elementosForm:cadastrar")).click();
            Alert alert = driver.switchTo().alert();
            Assertions.assertEquals("Nome eh obrigatorio", alert.getText());
            alert.accept();
            driver.findElement(By.id("elementosForm:nome")).sendKeys("Henrique");
            driver.findElement(By.id("elementosForm:cadastrar")).click();
            alert.accept();
            driver.quit();
        }

        @Test
        public void testeSurNameTextfield() {
            System.setProperty("web-driver.gecko.driver", "C:/Learning/Selenium-Java/geckodriver-v0.33.0-win-aarch64/geckodriver.exe");
            WebDriver driver = new FirefoxDriver();
            driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
            driver.findElement(By.id("elementosForm:nome")).sendKeys("Henrique");
            driver.findElement(By.id("elementosForm:cadastrar")).click();
            Alert alert = driver.switchTo().alert();
            Assertions.assertEquals("Sobrenome eh obrigatorio", alert.getText());
            alert.accept();
            driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Kriguer");
            driver.findElement(By.id("elementosForm:cadastrar")).click();
            alert.accept();
            driver.quit();
        }

            @Test
            public void testeSexoRadioButton(){
            System.setProperty("web-driver.gecko.driver", "C:/Learning/Selenium-Java/geckodriver-v0.33.0-win-aarch64/geckodriver.exe");
            WebDriver driver = new FirefoxDriver();
            driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
            driver.findElement(By.id("elementosForm:nome")).sendKeys("Henrique");
            driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Kriguer");
            driver.findElement(By.id("elementosForm:cadastrar")).click();
            Alert alert = driver.switchTo().alert();
            Assertions.assertEquals("Sexo eh obrigatorio", alert.getText());
            alert.accept();
            driver.findElement(By.id("elementosForm:sexo:0")).click();
            driver.findElement(By.id("elementosForm:cadastrar")).click();
            driver.quit();
        }

             @Test
             public void testeCheckBox() {
                 System.setProperty("web-driver.gecko.driver", "C:/Learning/Selenium-Java/geckodriver-v0.33.0-win-aarch64/geckodriver.exe");
                 WebDriver driver = new FirefoxDriver();
                 driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
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

             }
}
