package package1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class day6Test extends BaseTest {

	@Test
	public void verifyPurchase() {
		String emailId = "niboqidu.efetunu@jollyfree.com";
		String password = "Ram123";
		String userName = "Ram Sharma";
		// Step 1 Login with valid user credentials
		driver.findElement(By.xpath("//a[@class='skip-link skip-account']")).click();
		driver.findElement(By.xpath("//div[@id='header-account']/div/ul/li[1]/a")).click();

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(100));

		wait1.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.page-title")));

		driver.findElement(By.name("login[username]")).sendKeys(emailId);

		driver.findElement(By.name("login[password]")).sendKeys(password);

		driver.findElement(By.id("send2")).click();

		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(100));

		wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='page-title']/h1")));

		String actualwelcomeMsg = driver.findElement(By.xpath("//div[@class='welcome-msg']/p/strong")).getText();

		String expwelcomeMsg = "Hello, " + userName + "!";

		Assert.assertEquals(expwelcomeMsg, actualwelcomeMsg);
		System.out.println(actualwelcomeMsg);

		// Step 2 Click Wishlist link, click Add to Cart and proceed to checkout

		driver.findElement(By.linkText("MY WISHLIST")).click();

		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(100));

		wait3.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//div[@class='page-title title-buttons']/child::h1")));

		// click Add To Cart link
		driver.findElement(By.xpath("//button[@title='Add to Cart']")).click();

		// Step 3 Enter Shipping Info

		WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(100));

		wait4.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//div[@class='page-title title-buttons']/child::h1")));

		String title = driver.findElement(By.xpath("//div[@class='page-title title-buttons']/child::h1")).getText();

		System.out.println(title);

		WebElement countryDropDown = driver.findElement(By.id("country"));

		Select selectCountry = new Select(countryDropDown);

		selectCountry.selectByVisibleText("United States");

		WebElement stateDropDown = driver.findElement(By.xpath("//select[@class='required-entry validate-select']"));

		Select selectState = new Select(stateDropDown);

		selectState.selectByVisibleText("New York");

		driver.findElement(By.name("estimate_postcode")).sendKeys("542896");

		// Step 4 Click Estimate and verify cost generated

		driver.findElement(By.xpath("//button[@title='Estimate']")).click();

		WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(100));

		wait5.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='estimate_method']")));

		String shippingCost = driver
				.findElement(By.xpath("//input[@name='estimate_method']/following-sibling::label/span")).getText();

		System.out.println(shippingCost);

		driver.findElement(By.name("estimate_method")).click();

		driver.findElement(By.xpath("//button[@title='Update Total']")).click();

		WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(100));

		wait6.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//th[text()='Price']/following-sibling::td/span")));

		String subTotal = driver.findElement(By.xpath("//th[text()='Price']/following-sibling::td/span")).getText();

		System.out.println(subTotal);

		// click Proceed to Checkout button
		driver.findElement(By.xpath("//ul[@class='checkout-types top']/li/button")).click();
		// Step 5 Enter Billing Info, Shipping method click Continue and select
		// Cheque/MoneyOrder as

		WebDriverWait wait7 = new WebDriverWait(driver, Duration.ofSeconds(100));

		wait7.until(ExpectedConditions.presenceOfElementLocated(By.name("billing[firstname]")));

		driver.findElement(By.name("billing[firstname]")).clear();
		driver.findElement(By.name("billing[firstname]")).sendKeys("Ram");
		driver.findElement(By.name("billing[lastname]")).clear();
		driver.findElement(By.name("billing[lastname]")).sendKeys("Sharma");
		driver.findElement(By.id("billing:street1")).clear();
		driver.findElement(By.id("billing:street1")).sendKeys("Street ABC");
		driver.findElement(By.name("billing[city]")).clear();
		driver.findElement(By.name("billing[city]")).sendKeys("Gurugram");
		Select stateSelect= new Select(driver.findElement(By.name("billing[region_id]")));
		stateSelect.selectByVisibleText("California");
		driver.findElement(By.name("billing[postcode]")).clear();
		driver.findElement(By.name("billing[postcode]")).sendKeys("122001");
		Select countrySelect= new Select(driver.findElement(By.name("billing[country_id]")));
		countrySelect.selectByVisibleText("United States");
		driver.findElement(By.name("billing[telephone]")).clear();
		driver.findElement(By.name("billing[telephone]")).sendKeys("9977665544");
		driver.findElement(By.xpath("//*[@id=\"billing-buttons-container\"]/button/span/span")).click();
		
				
		// Payment method, and continue

		WebDriverWait wait8 = new WebDriverWait(driver, Duration.ofSeconds(100));

		wait8.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[onClick='shippingMethod.save()']")));

		driver.findElement(By.cssSelector("button[onClick='shippingMethod.save()']")).click();
		
		WebElement chequeRadio= driver.findElement(By.name("payment[method]"));
		if(!chequeRadio.isSelected())
		{
		chequeRadio.click();
		}

		driver.findElement(By.xpath("//*[@id='payment-buttons-container']/button/span/span")).click();

		
		// Place the order and verify if order is generated and note the order no.
        driver.findElement(By.xpath("//button[@class='button btn-checkout']")).click();
		
	}

}
