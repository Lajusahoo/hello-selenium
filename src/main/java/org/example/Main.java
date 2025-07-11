package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.flipkart.com");
        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys("iphone 15");
        search.submit();
        String ID=driver.getWindowHandle();
        System.out.println("ID ="+ID);
        WebElement iphone = driver.findElement(By.xpath("//img[@class='DByuf4'and@alt='Apple iPhone 15 (Black, 128 GB)']"));
        iphone.click();
        Set<String>childID=driver.getWindowHandles();
        childID.remove(ID);
        for(String iD:childID){
            if(iD.equals(ID)) {
                driver.switchTo().window(iD);
                break;
            }
            }
        WebElement ADD=driver.findElement(By.xpath("//button[text()='Add to cart']"));
        ADD.click();
        System.out.println("Navigated to flipkart add to cart a product");
//       driver.quit();
    }
}

