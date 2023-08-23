package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Count_Hyperlinks {
    WebDriver driver;
    public Count_Hyperlinks(){
        System.out.println("Constructor: Count_Hyperlinks");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    
    public void endTest()
    {
        System.out.println("End Test: Count_Hyperlinks");
        driver.close();
        driver.quit();

    }

    public void countHyperlinks(){
        
    // Navigating to BookmyShow Home page  https://in.bookmyshow.com/explore/home/chennai
    driver.get("https://in.bookmyshow.com/explore/home/chennai");
    // Identifying all the hyperlinks on the page Using Locator "Tag Name"  'a' 
    List<WebElement> links = driver.findElements(By.tagName("a"));
    // Count the number of identified links  size() | driver.findElements(By.tagname('a')).size()
    System.out.println("Number of Hyperlinks :" + links.size());
    }
}
