package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alert_Prompt {
    WebDriver driver;
    public Alert_Prompt(){
        System.out.println("Constructor: Alert_Prompt");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    
    public void endTest()
    {
        System.out.println("End Test: Alert_Prompt");
        driver.close();
        driver.quit();

    }
    public void alert_Prompt() throws InterruptedException{

        // Navigate to the url  https://web-locators-static-site-qa.vercel.app/Alerts
        driver.get("https://web-locators-static-site-qa.vercel.app/Alerts");
        // Locate the 'Add Remarks' button Using Locator "XPath" //div[@class='Alert_section3']/button
        WebElement addRemarks = driver.findElement(By.xpath("//div[@class='Alert_section3']/button"));
        // Click on 'Add Remarks' button  .click()
        addRemarks.click();
        Thread.sleep(2000);
        // Switch to the alert  .click()
        // Enter the text in the alert box  alert.sendKeys("1 remark added")
        driver.switchTo().alert().sendKeys("1 remark added");
        // click on ok   driver.switchTo.alert().accept()
        driver.switchTo().alert().accept();
        // Locate the added remark Using Locator "Class" Name Alert_remarkContent'
        WebElement remark = driver.findElement(By.className("Alert_remarkContent"));
        // Check if the added remark matches or not  
        if(remark.getText().equals("1 remark added")){
            System.out.println("Remark "+remark.getText()+" Successfully added");
        }
        else{
            System.out.println("Remark is not added");
        }
    }

}
