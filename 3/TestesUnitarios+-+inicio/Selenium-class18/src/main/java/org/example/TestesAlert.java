package org.example;


//import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestesAlert {

    private static WebDriver driver;

    @BeforeAll
    public static void inicializa(){
        System.setProperty("web-driver.gecko.driver", "C:/Learning/Selenium-Java/geckodriver-v0.33.0-win-aarch64/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
    }

    @AfterAll
    public static void finaliza(){
        driver.quit();
    }
    @Test
    public void testeAlertSimples() {
        driver.findElement(By.id("alert")).click();
        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("Alert Simples", alert.getText());
        String texto = alert.getText();
        alert.accept();
        System.out.println(texto);
        driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);
        driver.quit();

    }

    @Test
    public void testeAlertConfirm() {
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
        driver.quit();

    }
    @Test
    public void testeAlertNotConfirm() {
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
        driver.quit();

    }

    @Test
    public void testeAlertPrompt() {
        driver.findElement(By.id("prompt")).click();
        Alert alert = driver.switchTo().alert();
        Assertions.assertEquals("Digite um numero",alert.getText());
        String numero = "123";
        alert.sendKeys(numero);
        alert.accept();
        Assertions.assertEquals("Era " + numero + '?',alert.getText());
        alert.accept();
        Assertions.assertEquals(":D",alert.getText());
        alert.accept();
        driver.quit();

    }
    @Test
    public void testeCadastroForm() {
        driver.findElement(By.id("elementosForm:nome")).sendKeys("Henrique");
        driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Kriguer");
        driver.findElement(By.id("elementosForm:sexo:0")).click();
        driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
        WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
        Select combo = new Select(element);
        combo.selectByVisibleText("Mestrado");
        WebElement element2 = driver.findElement(By.id("elementosForm:esportes"));
        Select lista = new Select(element2);
        lista.selectByVisibleText("Futebol");
        lista.selectByVisibleText("Corrida");
        driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Montar uma playlist");
        driver.findElement(By.id("elementosForm:cadastrar")).click();
        Assertions.assertTrue(driver.findElement(By.id("resultado")).getText().contains("Cadastrado!"));
        Assertions.assertTrue(driver.findElement(By.id("resultado")).getText().contains("Nome: Henrique"));
        Assertions.assertTrue(driver.findElement(By.id("resultado")).getText().contains("Sobrenome: Kriguer"));
        Assertions.assertTrue(driver.findElement(By.id("resultado")).getText().contains("Sexo: Masculino"));
        Assertions.assertTrue(driver.findElement(By.id("resultado")).getText().contains("Comida: Carne"));
        Assertions.assertTrue(driver.findElement(By.id("resultado")).getText().contains("Escolaridade: mestrado"));
        Assertions.assertTrue(driver.findElement(By.id("resultado")).getText().contains("Esportes: Futebol Corrida"));
        Assertions.assertTrue(driver.findElement(By.id("resultado")).getText().contains("Sugestoes: Montar uma playlist"));
        driver.quit();
    }
}