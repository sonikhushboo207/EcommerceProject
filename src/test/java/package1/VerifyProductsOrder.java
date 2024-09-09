package package1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyProductsOrder extends BaseTest {

	@Test
	public void verifyTitlenOrder() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class= 'page-title']/child::h2")));

		// verifying the title "This is Demo site.." of the page
		WebElement siteTitle = driver.findElement(By.xpath("//div[@class= 'page-title']/child::h2"));
		String siteTitleText = siteTitle.getText();

		Assert.assertTrue(siteTitleText.contains("THIS IS DEMO SITE"));

	}

	@Test
	public void verifyMobilePage() {
		// click on mobile menu
		driver.findElement(By.xpath("//a[text()= 'Mobile']")).click();
		
		// verify the title of the page
		String mobilepageTitle= driver.findElement(By.xpath("//div[@class= 'page-title category-title']/child::h1")).getText();
		Assert.assertEquals(mobilepageTitle, "MOBILE");
	}

	

	
	@Test
	public void verifyOrderbyName()
	{
		
		// select name menu in the drop-down
		new Select(driver.findElement(By.cssSelector("select[title=\"Sort By\"]"))).selectByVisibleText("Name");

		
	}
	
	

	

}
