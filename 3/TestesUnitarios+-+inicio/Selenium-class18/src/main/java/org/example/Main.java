package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {
    @Test
    public void testeFirefox() {
        System.setProperty("web-driver.gecko.driver","C:/Development/JAVA/ProgramsDownloaded/geckodriver-r593/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
        Assertions.assertEquals("Google",driver.getTitle());
    }
    @Test
    public void testeChrome(){
        System.setProperty("web-driver.chromedriver","C:/Development/JAVA/ProgramsDownloaded/cromedriver114/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        Assertions.assertEquals("Google",driver.getTitle());
    }
    @Test
    public void testeEdge(){
        System.setProperty("web-driver.msedgedriver","C:/Development/JAVA/ProgramsDownloaded/edgedriver117/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.google.com");
        Assertions.assertEquals("Google",driver.getTitle());
    }

}