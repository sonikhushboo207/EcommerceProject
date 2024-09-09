package package1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class day3Test extends BaseTest {

	@Test
	public void verifyAddToCart() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));

		// Step 1 Click Mobile menu and then add Sony Xperia mobile to cart
		driver.findElement(By.linkText("MOBILE")).click();
		driver.findElement(By.xpath("//a[@title='Xperia']/following-sibling::div/div[3]/button/span/span")).click();

		// Step 2 Update the quantity to 1000
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));

		driver.findElement(By.xpath("//*[@id='shopping-cart-table']/tbody/tr/td[4]/input")).clear();

		driver.findElement(By.xpath("//*[@id='shopping-cart-table']/tbody/tr/td[4]/input")).sendKeys("1000");

		// Handling timeout exception by adding explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//*[@id='shopping-cart-table']/tbody/tr/td[4]/button/span/span")));

		// Clicking on update button
		WebElement updateButton = driver
				.findElement(By.xpath("//*[@id='shopping-cart-table']/tbody/tr/td[4]/button/span/span"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", updateButton);
	

	//Verifying the error message
	String error = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div/div/ul/li/ul/li/span"))
			.getText();

	String expectedError= "Some of the products cannot be ordered in requested quantity.";
	
	Assert.assertEquals(error, expectedError);
	System.out.println(error);
	
	//Click Empty Cart button
	driver.findElement(By.id("empty_cart_button")).click();
	
	//Verifying if cart has been empty
	String emptyCartMessage= driver.findElement(By.xpath("//*[@id='top']/body/div/div/div[2]/div/div/div[1]/h1")).getText();
	
	Assert.assertEquals(emptyCartMessage, "SHOPPING CART IS EMPTY");

	System.out.println("Cart is empty.");

}
}
