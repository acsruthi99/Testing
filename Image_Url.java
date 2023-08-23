package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Image_Url {
    WebDriver driver;
    public Image_Url(){
        System.out.println("Constructor: Image_Url");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: Image_Url");
        driver.close();
        driver.quit();

    }
    
    public void imageURL() throws InterruptedException{
       // List <String> list ;
        //Navigate to the url https://in.bookmyshow.com/explore/home/chennai
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        // locate the movies list in the recommende movies Using Locator "xpath" //h2[text()='Recommended Movies']/../../../following-sibling::div/div/div/div/a
       // driver.findElement(By.xpath("//h2[text()='Recommended Movies']/../../../following-sibling::div/div//*[@fill='#FFFFFF']/..")).click();
        List<WebElement> recommendedMovies = driver.findElements(By.xpath("//h2[text()='Recommended Movies']/../../../following-sibling::div//a//img"));
        int count = recommendedMovies.size();
        System.out.println("Movies Count : "+count);
        for (WebElement rmovies : recommendedMovies) { 
            System.out.println(rmovies.getAttribute("src"));
        }
       


    // // Locate SeeAll for Recommended movies and click on it
    // WebElement seeAll = driver.findElement(By.xpath("//h2[text()='Recommended Movies']/../following-sibling::div/a"));
    // seeAll.click();
    // Thread.sleep(3000);
    // List<WebElement> recommendedMovies = driver.findElements(By.xpath("//*[@alt='Coming Soon']/../../../../../../../../following-sibling::div//a//img"));
    // for (WebElement rm2 : recommendedMovies) { 
    //              System.out.println(rm2.getAttribute("src"));
    //          }
    //          int count = recommendedMovies.size();    
    //   System.out.println(count);
        //System.out.println(recommendedMovies.getAttribute("src"));
        
    }
}
