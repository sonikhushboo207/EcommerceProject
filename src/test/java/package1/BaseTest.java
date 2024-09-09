package package1;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

	WebDriver driver;

	@BeforeSuite
	public void setupChrome() {
		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "G:\\ChromeWebDriver\\chromedriver-win64\\chromedriver.exe");

		driver.get("http://live.techpanda.org");
		driver.manage().window().maximize();

	}

	public void captureScreenshot(String filename) {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File screenshotimage = screenshot.getScreenshotAs(OutputType.FILE);
		File image = new File(
				"G:\\Eclispse Folder\\Khushboo Eclipse Workspace\\EcommerceProject\\Screenshot\\" + filename + ".png");

		// copy screenshot from source to the target file
		try {
			FileUtils.copyFile(screenshotimage, image);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
