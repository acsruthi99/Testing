package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinkedIn_ImagePost {
    WebDriver driver;
    public LinkedIn_ImagePost(){
        System.out.println("Constructor: LinkedIn_ImagePost");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    public void endTest()
    {
        System.out.println("End Test: LinkedIn_ImagePost");
        driver.close();
        driver.quit();

    }
    public void  linkedIn_ImgPost() throws InterruptedException{
        
// Navigate to the url  https://in.linkedin.com/
driver.get("https://in.linkedin.com/");
// Enter the email or phone no. Using Locator "ID" session_key | userName
WebElement userName = driver.findElement(By.id("session_key"));
userName.sendKeys("userName");
// Enter the password Using Locator "ID" session_password | passcode
WebElement password = driver.findElement(By.id("session_password"));
password.sendKeys("passcode");
// Click on sign in button Using Locator "XPath" session_password | abc@123
WebElement signin = driver.findElement(By.xpath("//*[@data-id='sign-in-form__submit-btn']"));
   signin.click();
   Thread.sleep(2000);
// Identifying the 'add a photo' element Using Locator "XPath" //button[@aria-label="Add a photo"]
// click on the 'add a photo' element  .click()
WebElement addaphoto = driver.findElement(By.xpath("//button[@aria-label='Add a photo']"));
addaphoto.click();
Thread.sleep(2000);
// locate the element having input field Using Locator "XPath" driver.findElement(By.xpath("//input[@id='image-sharing-detour-container__file-input']"))
WebElement inputfield = driver.findElement(By.xpath("//input[@id='image-sharing-detour-container__file-input']"));
inputfield.sendKeys("C:\\screenshot\\Screenshot.png");
Thread.sleep(2000);
// select the path of the image and paste with the help of sendKeys method  .sendKeys("location of the file in local")
// click on the 'Done' button Using Locator "XPath" //span[text() = 'Done']
WebElement done = driver.findElement(By.xpath("//span[text() = 'Done']"));
done.click();
Thread.sleep(2000);
driver.findElement(By.xpath("//span[text()='Post']")).click();
    }
}
