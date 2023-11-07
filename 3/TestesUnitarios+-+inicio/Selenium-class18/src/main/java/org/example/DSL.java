package org.example;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DSL {

    private WebDriver driver;

    public DSL(WebDriver driver) {
        this.driver = driver;
    }

    public void escreve(String idCampo, String texto){
        driver.findElement(By.id(idCampo)).sendKeys(texto);
    }

    public String obterValor(String idCampo){
        return driver.findElement(By.id(idCampo)).getAttribute("value");
    }

    public void clicarRadio(String id){
        driver.findElement(By.id(id)).click();
    }

    public boolean isRadioSelected(String id){
       return driver.findElement(By.id(id)).isSelected();
       }

    public void selecionaCombo(String id, String valor){
        WebElement element = driver.findElement(By.id(id));
        Select combo = new Select(element);
        combo.selectByVisibleText(valor);
    }

    public String obterValorCombo(String id){
        WebElement element = driver.findElement(By.id(id));
        Select combo = new Select(element);
        return combo.getFirstSelectedOption().getText();
    }

    public void clicarBtn(String id){
        driver.findElement(By.id(id)).click();
    }

    public void clicarLink(String id){
       driver.findElement(By.linkText(id)).click();
    }

    public String obterTexto(String id){
        return driver.findElement(By.id(id)).getText();
    }
    public String obterTextoTag(String id){
        return driver.findElement(By.tagName(id)).getText();
    }
    public String obterTextoClass(String id){
        return driver.findElement(By.className(id)).getText();
    }
}
