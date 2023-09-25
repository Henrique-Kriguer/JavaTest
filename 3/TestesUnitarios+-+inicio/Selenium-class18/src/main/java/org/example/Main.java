package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {

   @Test
    public void testeFirefox() {
        System.setProperty("web-driver.gecko.driver","C:/Learning/Selenium-Java/geckodriver-v0.33.0-win-aarch64/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
        Assertions.assertEquals("Google",driver.getTitle());
        driver.quit();
    }


  @Test
  public void testeChrome() {
      System.setProperty("web-driver.chromedriver", "C:/Learning/Selenium-Java/chromedriver_win32/chromedriver.exe");
      WebDriver driver = new ChromeDriver();
      driver.get("https://www.google.com");
      Assertions.assertEquals("Google", driver.getTitle());
      System.out.println(driver.getTitle());
      driver.quit();
}


   @Test
   public void testeEdge(){

      System.setProperty("web-driver.msedgedriver","C:/Learning/Selenium-Java/edgedriver_win64/msedgedriver.exe");
      WebDriver driver = new EdgeDriver();
      driver.manage().window().fullscreen();
      driver.get("https://www.google.com");
      Assertions.assertEquals("Google",driver.getTitle());
       System.out.println(driver.getTitle());
      driver.quit();
   }
}