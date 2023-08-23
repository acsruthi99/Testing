package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Imdb_Ratings {
    WebDriver driver;
    public Imdb_Ratings(){
        System.out.println("Constructor: Imdb_Ratings");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: Imdb_Ratings");
        driver.close();
        driver.quit();

    }

    public void imdb_Ratings() throws InterruptedException{
        
// Navigate to the url  https://www.imdb.com/chart/top/
driver.get("https://www.imdb.com/chart/top/");
// click on the 'sortby' dropdown Using Locator "ID" WebElement sortDropdown = driver.findElement(By.id("sort-by-selector"));
WebElement sortDropdown = driver.findElement(By.id("sort-by-selector"));
// As it is a dropdown with select tag create an object for the select class  Select select = new Select(sortDropdown);
// Select the 'IMDB rating' from the dropdown  Select select = new Select(sortDropdown);
Select select = new Select(sortDropdown);
select.selectByVisibleText("IMDb rating");
Thread.sleep(2000);
// Locate the highest rated movie on IMDB Using Locator "XPath" //ul[@role='presentation']/li[1]//div/a[@class='ipc-title-link-wrapper']
// Get text of that highest rated movie  .getText()
WebElement highRatedMovie = driver.findElement(By.xpath("//ul[@role='presentation']/li[1]//div/a[@class='ipc-title-link-wrapper']"));
Thread.sleep(2000);
System.out.println("Highest Rated Movie is "+highRatedMovie.getText());
// Locate all the movies in the table in IMDB Using Locator "XPath" //div[@data-testid='chart-layout-main-column']/ul/li
// get how many movies are involved in the table  //div[@data-testid='chart-layout-main-column']/ul/li.size();
List <WebElement> moviesInTable = driver.findElements(By.xpath("//div[@data-testid='chart-layout-main-column']/ul/li"));
Thread.sleep(2000);
int count = moviesInTable.size();
System.out.println("List of movies in Table :: "+ count);
// click on the 'sortby' dropdown Using Locator "ID" WebElement sortDropdown = driver.findElement(By.id("sort-by-selector"));
sortDropdown.click();
// As it is a dropdown with select tag create an object for the select class  Select select1 = new Select(sortDropdown);
// Select the 'Release Date' from the dropdown  select1.selectByVisibleText("Release date");
// Select select1 = new Select(sortDropdown);
select.selectByVisibleText("Release date");
Thread.sleep(2000);
// Locate and get the size of all the movies in the table in IMDB Using Locator "XPath" count = //div[@data-testid='chart-layout-main-column']/ul/li.size(); | moviesInTable.size();
// get the oldest movie on the list Using Locator "XPath" //div[@data-testid='chart-layout-main-column']/ul/li[count]
WebElement oldestMovie = driver.findElement(By.xpath("//div[@data-testid='chart-layout-main-column']/ul/li["+count+"]//h3"));
Thread.sleep(2000);
System.out.println("The most oldest movie :: "+ oldestMovie.getText());
// get the most recent movie on the list Using Locator "XPath" //div[@data-testid='chart-layout-main-column']/ul/li[1]
WebElement onTopMovie = driver.findElement(By.xpath("//div[@data-testid='chart-layout-main-column']/ul/li[1]//h3"));
Thread.sleep(2000);
System.out.println("The most recent movie :: "+ onTopMovie.getText());
// click on the 'sortby' dropdown Using Locator "ID" WebElement sortDropdown = driver.findElement(By.id("sort-by-selector"));
// As it is a dropdown with select tag create an object for the select class  Select select2 = new Select(sortDropdown);
sortDropdown.click();
// Select the 'Number of ratings' from the dropdown  select2.selectByVisibleText("Number of ratings");
select.selectByVisibleText("Number of ratings");
Thread.sleep(2000);
// get the movie with most user ratings Using Locator "XPath" //div[@data-testid='chart-layout-main-column']/ul/li[1]
WebElement userRatedMovie = driver.findElement(By.xpath("//div[@data-testid='chart-layout-main-column']/ul/li[1]//div[@data-testid='ratingGroup--container']/span"));
Thread.sleep(2000);
System.out.println("The most user Rated movie :: "+ userRatedMovie.getText());

    }
}
