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
    private static DSL dsl;
    private static CampoTreinamentoPage page;
    @BeforeAll
    public static void inicializa() {
        System.setProperty("web-driver.gecko.driver", "C:/Learning/Selenium-Java/geckodriver-v0.33.0-win-aarch64/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
        dsl = new DSL(driver);
        page = new CampoTreinamentoPage(driver);
    }

    @AfterAll
    public static void finaliza() {
        driver.quit();
    }

    @Test
    public void testeNameTextField() {
        dsl.clicarBtn("elementosForm:cadastrar");
        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("Nome eh obrigatorio", alert.getText());
        alert.accept();
        page.setNome("Henrique");
        dsl.clicarBtn("elementosForm:cadastrar");
        alert.accept();
    }

    @Test
    public void testeSurNameTextfield() {
        dsl.escreve("elementosForm:nome","Henrique");
        dsl.clicarBtn("elementosForm:cadastrar");
        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("Sobrenome eh obrigatorio", alert.getText());
        alert.accept();
        dsl.escreve("elementosForm:sobrenome","Kriguer");
        dsl.clicarBtn("elementosForm:cadastrar");
        alert.accept();
        //driver.quit();
    }

    @Test
    public void testeSexoRadioButton() {
        dsl.escreve("elementosForm:nome","Henrique");
        dsl.escreve("elementosForm:sobrenome","Kriguer");
        dsl.clicarBtn("elementosForm:cadastrar");
        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("Sexo eh obrigatorio", alert.getText());
        alert.accept();
        dsl.clicarRadio("elementosForm:sexo:0");
        dsl.clicarBtn ("elementosForm:cadastrar");
    }

    @Test
    public void testeCheckBox() {
        dsl.escreve("elementosForm:nome","Henrique");
        dsl.escreve("elementosForm:sobrenome","Kriguer");
        dsl.clicarRadio("elementosForm:sexo:0");
        dsl.clicarRadio("elementosForm:sexo:1");
        dsl.clicarRadio("elementosForm:comidaFavorita:0");
        dsl.clicarRadio("elementosForm:comidaFavorita:1");
        dsl.clicarRadio("elementosForm:comidaFavorita:2");
        dsl.clicarRadio("elementosForm:comidaFavorita:3");
        dsl.clicarRadio("elementosForm:cadastrar");
        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("Tem certeza que voce eh vegetariano?", alert.getText());
        alert.accept();
        dsl.clicarRadio("elementosForm:comidaFavorita:3");
        dsl.clicarRadio("elementosForm:cadastrar");
    }

    @Test
    public void testeCombo() {
        dsl.escreve("elementosForm:nome","Henrique");
        dsl.escreve("elementosForm:sobrenome","Kriguer");
        dsl.clicarRadio("elementosForm:sexo:0");
        dsl.selecionaCombo("elementosForm:esportes","Natacao");
        dsl.selecionaCombo("elementosForm:esportes","Futebol");
        dsl.selecionaCombo("elementosForm:esportes","Corrida");
        dsl.selecionaCombo("elementosForm:esportes","Karate");
        dsl.selecionaCombo("elementosForm:esportes","O que eh esporte?");
        dsl.clicarBtn("elementosForm:cadastrar");
        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("Voce faz esporte ou nao?", alert.getText());
        alert.accept();
        dsl.deselecionaCombo("elementosForm:esportes","O que eh esporte?");
        dsl.clicarBtn("elementosForm:cadastrar");
    }
}
