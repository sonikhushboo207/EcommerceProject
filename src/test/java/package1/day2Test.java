package package1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class day2Test extends BaseTest {
	
	@Test
	public void compareCost()
	{
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
	
	//Step 1 to get price on List Page
	driver.findElement(By.linkText("MOBILE")).click();
	String price1= driver.findElement(By.xpath("//*[@id=\"product-price-1\"]/child::span")).getText();
	
	
	//Step 2 to get price on the Detail Page
	driver.findElement(By.id("product-collection-image-1")).click();
	String price2= driver.findElement(By.xpath("//span[@id='product-price-1']/child::span")).getText();
	
	//Step 3 Compare price1 with price2
	Assert.assertEquals(price1, price2);
	System.out.println("Prices are equal");
	

}
}