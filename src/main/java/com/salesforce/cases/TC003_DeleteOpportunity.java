package com.salesforce.cases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC003_DeleteOpportunity {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String url = "https://login.salesforce.com/";
		String username = "hari.radhakrishnan@qeagle.com";
		String pwd = "India$321";
		//System.setProperty("webdriver.chrome.drive", "./drivers/chromedriver");
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.navigate().to(url);
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.id("Login")).click();
		Thread.sleep(5000);
		WebElement appLauncher = driver.findElement(By.xpath("//div[@role='navigation']/button/div"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", appLauncher);
		
		WebElement viewAll = driver.findElement(By.xpath("//button[text()='View All']"));
		executor.executeScript("arguments[0].click();", viewAll);
		
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		
		WebElement opportunity = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		executor.executeScript("arguments[0].click();", opportunity);
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys("Adhitya", Keys.ENTER);
		
		Thread.sleep(3000);
		
		WebElement opportunityName = driver.findElement(By.xpath("(//a[text()='Salesforce Automation by Adhitya'])[1]"));
		executor.executeScript("arguments[0].click();", opportunityName);
		
		driver.findElement(By.xpath("//button[text()='Clone']/ancestor::li/following-sibling::li//button")).click();
		
		driver.findElement(By.xpath("//button[text()='Clone']/ancestor::li/following-sibling::li//div//span[text()='Delete']")).click();
		
		driver.findElement(By.xpath("//div[text()='Are you sure you want to delete this opportunity?']/ancestor::div/following-sibling::div//button//span[text()='Delete']")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("(//input[@type='search'])[2]/following::button[1]/lightning-primitive-icon")).click();
		
		driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys("Adhitya", Keys.ENTER);
		
		String actualText = driver.findElement(By.xpath("//span[text()='No items to display.']")).getText();
		
		Assert.assertEquals(actualText, "No items to display.");
		
		Thread.sleep(3000);
		
		driver.close();

	}

}
