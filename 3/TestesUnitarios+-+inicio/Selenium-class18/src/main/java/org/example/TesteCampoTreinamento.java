package org.example;

//import org.junit.Ignore;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.sql.Driver;
import java.util.List;

public class TesteCampoTreinamento {

    private static WebDriver driver = new EdgeDriver();
    @BeforeAll
    public static void inicializa(){
        System.setProperty("web-driver.msedgedriver","C:/Learning/Selenium-Java/edgedriver_win64/msedgedriver.exe");
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
       // dsl = new DSL(driver);
    }
    @AfterAll
    public static void finaliza(){
        driver.quit();
    }
      @Test
    public void testeTextField() {

        driver.findElement(By.id("elementosForm:nome")).sendKeys("Teste de escrita");
        Assertions.assertEquals("Teste de escrita", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
    }

    @Test
    public void testeTextArea() {
       driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Teste de escrita 2");
       Assertions.assertEquals("Teste de escrita 2", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
    }

    @Test
    public void testeRadioButtonn() {
        driver.findElement(By.id("elementosForm:sexo:1")).click();
        Assertions.assertTrue(driver.findElement(By.id("elementosForm:sexo:1")).isSelected());
    }

    @Test
    public void testeCheckBox() {
        driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
        Assertions.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:0")).isSelected());
    }

    @Test
    public void testeComboBox() {
        WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
        Select combo = new Select(element);
        combo.selectByVisibleText("Superior");
        Assertions.assertEquals("Superior", combo.getFirstSelectedOption().getText());
    }

    @Test
    public void testeComboBoxMultiplo() {
        WebElement element = driver.findElement(By.id("elementosForm:esportes"));
        Select combo = new Select(element);
        combo.selectByVisibleText("Natacao");
        combo.selectByVisibleText("Corrida");
        combo.selectByVisibleText("Futebol");
        List<WebElement> allSellectedOptions = combo.getAllSelectedOptions();
        Assertions.assertEquals(3, allSellectedOptions.size());
        combo.deselectAll(); // esta opção desmarcados itens marcados anteriormente.
    }

    @Test
    public void testeBtnObrigado() {
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        WebElement botao = driver.findElement(By.id("buttonSimple"));
        botao.click();
        Assertions.assertEquals("Obrigado!", botao.getAttribute("value"));
    }

    @Test
    //@Ignore // esta anotação não funciona, permite pular o teste em uma bateria de testes, mostrando a msg skipped
    public void testeLink() {
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        WebElement link = driver.findElement(By.linkText("Voltar"));
        link.click();
        Assertions.assertEquals("Voltou!", driver.findElement(By.id("resultado")).getText());
    }
    @Test
    public void testeTextoPagina() {
        //Assertions.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Campo de Treinamento"));
        // Este metodo acima é ineficaz pois o java tem que varrer todo body para encontrar o elemento.
        // Caso a tag h3 tivesse mais de uma ocorrencia, o teste daria erro pois ele vai no primeiro tag que encontrar.
        Assertions.assertTrue(driver.findElement(By.tagName("h3")).getText().contains("Campo de Treinamento"));
        Assertions.assertTrue(driver.findElement(By.className("facilAchar")).getText().contains("Cuidado onde clica, muitas armadilhas..."));
    }
}

