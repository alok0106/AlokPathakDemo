package webAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {

	WebDriver driver = new ChromeDriver();
	WebElement webel = driver.findElement(By.name("q"));
    //enter text with sendKeys() then apply submit()
    
   
}
