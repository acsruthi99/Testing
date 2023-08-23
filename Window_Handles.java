package demo;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Window_Handles {
    WebDriver driver;
    public Window_Handles(){
        System.out.println("Constructor: Window_Handles");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void endTest()
    {
        System.out.println("End Test: Window_Handles");
        driver.close();
        driver.quit();

    }

    public void window_Handles() throws IOException, InterruptedException{
    
// Navigate to the url  https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open
driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
// Find the element which is having iframe Using Locator "ID" iframecontainer'
// switch to frame  switchTo().frame("iframe");
driver.switchTo().frame("iframeResult");
// locate the 'Tryit' button Using Locator "XPath" switchTo().frame("iframe");
// click on that button  .click()
WebElement tryit =driver.findElement(By.xpath("//button[@onclick='myFunction()']"));
tryit.click();
Thread.sleep(2000);
// Now get the parent window  parentWindow = driver.getWindowHandle();
String parentWindow = driver.getWindowHandle();
// Get all the window handles  child = driver.getWindowHandles();
Set<String> childWindow = driver.getWindowHandles();
// iterate through the child if the parent and child are equal go to the next child  
for (String child : childWindow) {
// if the parent and child are equal go to the next child  driver.switchTo().window(child);
    if(child == parentWindow){
        driver.switchTo().window(child);
        Thread.sleep(2000);
    }

// Get the url of the child window  driver.switchTo().window( child).getCurrentUrl();
System.out.println(driver.switchTo().window( child).getCurrentUrl());
Thread.sleep(2000);
// Get the title of the child window  driver.switchTo().window(child).getTitle();
System.out.println(driver.switchTo().window(child).getTitle());
Thread.sleep(2000);
}
// Take a screen shot of that window  write and use the takescreenshot method()
String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
       AShot ashot = new AShot();
       Screenshot screenshot = ashot.takeScreenshot(driver);
       String fileName = "w3schoolsScreenShot" + timestamp + ".png";
       ImageIO.write(screenshot.getImage(), "PNG", new File(fileName));
        System.out.println("Captured screenshot saved as: " + fileName);
// close the new window  driver.close();
driver.close();
// switch back to the original window using window handle  driver.switchTo().window(parentWindow);
driver.switchTo().window(parentWindow);
    }
}

