package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Search_Amazon {
    WebDriver driver;
    public Search_Amazon(){
        System.out.println("Constructor: Search_Amazon");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: Search_Amazon");
        driver.close();
        driver.quit();

    }
    
    public void searchAmazon(){
         //Navigate to google homepage  https://www.google.com/
         driver.get("https://www.google.com/");
         // Search for 'amazon' in google search box Using Locator "ID" sendKeys("amazon") | APjFqb
         WebElement searchbar = driver.findElement(By.name("q"));
         searchbar.sendKeys("amazon");
         // Hit Enter  sendKeys("Keys.RETURN")
         searchbar.sendKeys(Keys.RETURN);
         // Validate the search result  Using Locator "XPath" //span[@data-dtld = 'amazon.in'] or //span[text()='Amazon.in' or text()='Amazon.com']
        // Boolean ans = driver.findElement(By.XPath("//span[@data-dtld = 'amazon.in']")).isDisplayed();
         Boolean ans = driver.findElement(By.xpath("//span[text()='Amazon.in' or text()='Amazon.com']")).isDisplayed();
        System.out.println("Is amazon present in ans : "+ans);
        }


}
