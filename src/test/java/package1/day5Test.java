package package1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class day5Test extends BaseTest {

	@Test
	public void verifyAccountCreation() {

		// clicking My Account menu
		driver.findElement(By.xpath("//a[@class='skip-link skip-account']")).click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
		driver.findElement(By.linkText("My Account")).click();

		// clicking Create an account link
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("firstname")));

		driver.findElement(By.id("firstname")).clear();
		driver.findElement(By.id("firstname")).sendKeys("Ram");

		driver.findElement(By.id("lastname")).clear();
		driver.findElement(By.id("lastname")).sendKeys("Sharma");

		driver.findElement(By.id("email_address")).clear();
		driver.findElement(By.id("email_address")).sendKeys("niboqidu.efetunu@jollyfree.com");

		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("Ram123");

		driver.findElement(By.id("confirmation")).clear();
		driver.findElement(By.id("confirmation")).sendKeys("Ram123");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));

		driver.findElement(By.xpath("//span[text()='Register']")).click();

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(300));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@class='success-msg']/ul/li/span")));

		String successMsg = driver.findElement(By.xpath("//li[@class='success-msg']/ul/li/span")).getText();

		String thanksMsg = "Thank you for registering with Main Website Store.";

		Assert.assertEquals(successMsg, thanksMsg);
		System.out.println("Registeration successfully done");
	
		// Click TV menu and adding Samsung TV to wishlist
		driver.findElement(By.xpath("//a[text()='TV']")).click();
		driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[2]/div/div[3]/ul/li[1]/a")).click();

		
		WebDriverWait wait2= new WebDriverWait(driver, Duration.ofSeconds(200));
		
		wait2.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.page-title.title-buttons")));
		
		//print the page title
		String pageTitle= driver.findElement(By.cssSelector("div.page-title.title-buttons")).getText();
		System.out.println(pageTitle);

		// Sharing the wishlist
		driver.findElement(By.xpath("//span[text()='Share Wishlist']")).click();
		
		
		driver.findElement(By.cssSelector("textarea#email_address.validate-emails.required-entry")).sendKeys("sonikhushboo207@gmail.com");
		
		driver.findElement(By.id("message")).sendKeys("Hello, this is a test message.");
		
		driver.findElement(By.xpath("//span[text()='Share Wishlist']")).click();
		
		WebDriverWait wait3= new WebDriverWait(driver, Duration.ofSeconds(200));
		
		wait3.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@class='success-msg']/ul/li/span")));
		
		String msgAppeared= driver.findElement(By.xpath("//li[@class='success-msg']/ul/li/span")).getText();
		
		String successfullySharedMsg= "Your Wishlist has been shared.";
		
		Assert.assertEquals(msgAppeared, successfullySharedMsg);
		System.out.println("Wishlist has been shared.");
		
		
	}
	

}
