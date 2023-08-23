package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nested_Frames {
    WebDriver driver;
    public Nested_Frames(){
        System.out.println("Constructor: Nested_Frames");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }
    
    public void endTest()
    {
        System.out.println("End Test: Nested_Frames");
        driver.close();
        driver.quit();

    }

    public void nestedFrames(){
        
// Navigate to address bar and enter the url  https://the-internet.herokuapp.com/nested_frames
driver.get("https://the-internet.herokuapp.com/nested_frames");
// First switch to the frame-top  switchTo().frame("frame-top")
driver.switchTo().frame("frame-top");
// Need to switch to the left child frame  switchTo().frame("frame-left")
driver.switchTo().frame("frame-left");
// Get and print the text from the left child frame  switchTo().frame("frame-left")
WebElement leftFrame = driver.findElement(By.tagName("body"));
String lefttext =leftFrame.getText();
System.out.println("Text in left Frame : "+ lefttext);
// switch to back to the parent frame  driver.switchTo.ParentFrame()
driver.switchTo().parentFrame();
// Switch to the middle child frame  switchTo().frame("frame-middle")
driver.switchTo().frame("frame-middle");
// Get and print the text from the middle child frame  String str1= middleFrame.getText() | Sout("str1")
WebElement middleFrame = driver.findElement(By.tagName("body"));
String middletext =middleFrame.getText();
System.out.println("Text in middle Frame : "+ middletext);
// switch back to the parent frame  driver.switchTo.ParentFrame()
driver.switchTo().parentFrame();
// switch to the right child frame  switchTo().frame("frame-right")
driver.switchTo().frame("frame-right");
// Get and print the text from the right child frame  String str2= rightFrame.getText() | Sout("str2")
WebElement rightFrame = driver.findElement(By.tagName("body"));
String righttext =rightFrame.getText();
System.out.println("Text in right Frame : "+ righttext);
// switch back to the default frame  driver.switchTo.defaultContent()
driver.switchTo().defaultContent();
// switch to the frame-bottom frame  switchTo().frame("frame-bottom")
driver.switchTo().frame("frame-bottom");
// Get and print the text from that bottom frame  String str3= bottomFrame.getText() | Sout("str3")
WebElement bottomFrame = driver.findElement(By.tagName("body"));
String bottomtext =bottomFrame.getText();
System.out.println("Text in bottom Frame : "+ bottomtext);
// switch back to the default frame  driver.switchTo.defaultContent()
driver.switchTo().defaultContent();
    }
}
