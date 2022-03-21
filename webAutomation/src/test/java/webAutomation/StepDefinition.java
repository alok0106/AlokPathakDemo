package webAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class StepDefinition {

	   public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver","X:\\eclipse\\chromedriver\\chromedriver.exe");
	      WebDriver driver = new ChromeDriver();
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      driver.get("https://www.google.com/");
	      
	      Thread.sleep(5000);
	     
	      WebElement p=driver.findElement(By.name("q"));
	      
	      p.sendKeys("Automation");
	      // Explicit wait condition for search results
	      WebDriverWait w = new WebDriverWait(driver, 5);
	      w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul")));
	      
	      
	      driver.findElement(By.xpath(".//a[contains(@href,'wikipedia.org')]")).click();
	      
	      List<String> allParagraphsValues = new ArrayList<String>();
	      List<WebElement> allParagraphs = driver.findElements(By.xpath("//span[text()='Subtitles']//following::p"));

	     
	      for(WebElement ele : allParagraphs){
	            allParagraphsValues.add(ele.getText());
	      }

	     
}
}