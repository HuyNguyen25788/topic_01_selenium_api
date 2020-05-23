package webdriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class Topic_02_Xpath_Locator {

	WebDriver driver;
	public int randomNumber() {
		Random rand =new Random();
		return rand.nextInt(99999);
	}

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_06_ResgiterToSystem() {
		driver.get("http://live.demoguru99.com/index.php");
		driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
		driver.findElement(By.xpath("//div[@class='buttons-set']//a[@title='Create an Account']")).click();
		driver.findElement(By.id("firstname")).sendKeys("Huy");
		driver.findElement(By.id("middlename")).sendKeys("Nguyen");
		driver.findElement(By.id("lastname")).sendKeys("Dep");
		driver.findElement(By.id("email_address")).sendKeys("HUY"+randomNumber()+"@yopmail.com");
		driver.findElement(By.id("password")).sendKeys("123123123");

		driver.findElement(By.id("confirmation")).sendKeys("123123123");
		
		driver.findElement(By.xpath("//button[@title='Register']")).click();
		
		//Verify
		//Name
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='box-content']//p[contains(text(),'Nguyen')]")).isDisplayed());
		
	}

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}

}
