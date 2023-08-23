package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinkedIn_Post {
    WebDriver driver;
    public LinkedIn_Post(){
        System.out.println("Constructor: LinkedIn_Post");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }    

    public void endTest()
    {
        System.out.println("End Test: LinkedIn_Post");
        driver.close();
        driver.quit();

    }

    public void linkedinPost() throws InterruptedException{
        
   // Navigate to the LinkedIn landing page  https://in.linkedin.com/
   driver.get("https://in.linkedin.com/");
   // Identifying the username textbox Using Locator "ID"  'session_key'
   WebElement userName = driver.findElement(By.id("session_key"));
   // enter the user name  sendkeys("UserName")
   userName.sendKeys("userName");
   // Identify the Password textbox Using Locator "ID" 'session_password'
   WebElement password = driver.findElement(By.id("session_password"));
   // Enter the password  sendKeys("passcode")
   password.sendKeys("passcode");
   // Identifying the signin button Using Locator "XPath" //*[@data-id='sign-in-form__submit-btn']
   // click on the signin button  .click()
   WebElement signin = driver.findElement(By.xpath("//*[@data-id='sign-in-form__submit-btn']"));
   signin.click();
   Thread.sleep(2000);
   // Get the count of the 'Who's viewed your profile' Using Locator "XPath" (//li/a/div/div[2]/span/strong)[1]
   WebElement profileview = driver.findElement(By.xpath("(//li/a/div/div[2]/span/strong)[1]"));
   System.out.println(profileview.getText()); 
   // Get the count of the 'Impressions of your post' Using Locator "XPath" (//li/a/div/div[2]/span/strong)[2]
   WebElement imprview = driver.findElement(By.xpath("(//li/a/div/div[2]/span/strong)[2]"));
   System.out.println(imprview.getText());
   // Locate start a post button Using Locator "XPath" //div[@class='share-box-feed-entry__top-bar']/button
   // click on that button  .click()
   Thread.sleep(2000);
   WebElement startPost = driver.findElement(By.xpath("//div[@class='share-box-feed-entry__top-bar']/button"));
   startPost.click();
   // identify the button for post settings Using Locator "Class" Name 'share-unified-settings-entry-button'
   // click on that button  .click()
   driver.findElement(By.className("share-unified-settings-entry-button")).click();
   // identify the radio button for connections only option Using Locator "XPath" //button[@id='CONNECTIONS_ONLY']//label
   // select the radio button by clicking on it  .click()
   Thread.sleep(3000);
   WebElement radioButton = driver.findElement(By.xpath("//button[@id='CONNECTIONS_ONLY']"));
   radioButton.click();
   // Identify the 'done' button and click on it Using Locator "XPath" //span[text()='Done'].click()
   Thread.sleep(3000);
   driver.findElement(By.xpath("//span[text()='Done']")).click();
   // Identify the textbox  Using Locator "Class" Name ql-editor ql-blank'
   // write the post   sendKeys("My First post bu Automation")
   Thread.sleep(3000);
   WebElement textfield = driver.findElement(By.xpath("//*[@class='ql-editor ql-blank']"));
   textfield.click();
   textfield.sendKeys("My First post by Automation");
   // Identify the post button Using Locator "XPath" //span[text()='Post']
   // click on that post button   .click()
   Thread.sleep(3000);
   driver.findElement(By.xpath("//span[text()='Post']")).click();
   // verify the post successful message is displayed Using Locator "XPath" //span[text()='Post successful.'] |  .isDisplayed()
   Thread.sleep(3000);
   Boolean msg = driver.findElement(By.xpath("//span[text()='Post successful.']")).isDisplayed();
   System.out.println("Is Message Printed : "+msg);
  
    }
}
