package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sample {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://practice.automationtesting.in/");
		driver.findElement(By.linkText("Read more")).click();
		driver.findElement(By.linkText("Add to basket")).click();
		driver.findElement(By.linkText("View Basket")).click();

	}

}
