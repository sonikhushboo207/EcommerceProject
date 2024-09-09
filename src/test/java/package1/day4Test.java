package package1;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class day4Test extends BaseTest{
	
	@Test
	public void verifyCompareFunc() {
		
	//Access the Mobile section
	driver.findElement(By.linkText("MOBILE")).click();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
	
	//Click "Add to Compare" for Sony Xperia and iPhone
	driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[2]/div/div[3]/ul/li[2]/a")).click();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(300));
	
	driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[3]/div/div[3]/ul/li[2]/a")).click();
	
	//Click Compare button
	WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(200));
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Compare']")));
	
	driver.findElement(By.xpath("//span[text()='Compare']")).click();
	
	
	
	//Storing current window's id as a string
	String currentWindow= driver.getWindowHandle();
	Set <String> windowsids= driver.getWindowHandles();
	
	//Moving focus to the second window/pop-up that has opened up
	for(String s: windowsids)
	{
	
	if(!s.equalsIgnoreCase(currentWindow))
	{
		driver.switchTo().window(s);
		String file= "myFile";
		captureScreenshot(file);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
		driver.close();
		//driver.findElement(By.xpath("//button[@title='Close Window']/span/span")).click();
	}

	}
	}
}
