package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Google_NameLinks {
    WebDriver driver;
    public Google_NameLinks(){
        System.out.println("Constructor: Google_NameLinks");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
     }

     public void endTest()
    {
        System.out.println("End Test: Google_NameLinks");
        driver.close();
        driver.quit();

    }

    public void google_NameLinks() throws InterruptedException{
       
// Navigate to google home page  www.google.com
driver.get("https://www.google.com/");
// Identify the search box Using Locator "ID"  'APjFqb'
WebElement searchbar = driver.findElement(By.id("APjFqb"));
Thread.sleep(2000);
// Type 'SruthaKeerthi' in google search box Using Locator "ID" sendKeys("Sruthakeerthi")
searchbar.sendKeys("Sruthakeerthi");
Thread.sleep(2000);
// Hit Enter  sendKeys("Keys.RETURN")
searchbar.sendKeys(Keys.RETURN);
// Identify the links with 'Sruthakeerthi' in it Using Locator "XPath" sendKeys("Sruthakeerthi")
Thread.sleep(2000);
List <WebElement> links = driver.findElements(By.xpath("//h3[contains(text(),'Sruthakeerthi')]"));
// get the count of links with 'Sruthakeerthi'   .size() | driver.findElements(By.xpath("//h3[contains(text(),'Sruthakeerthi')]")).size()
int count = links.size();
System.out.println("The count of links with name 'Sruthakeerthi' is :: "+ count);
    }
    
}
