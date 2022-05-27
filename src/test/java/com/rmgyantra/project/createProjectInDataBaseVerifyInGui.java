package com.rmgyantra.project;

import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Vtiger.Utilitys.DataBaseUtility;
import com.Vtiger.Utilitys.FileUtility;
import com.Vtiger.Utilitys.IconstantPath;
import com.Vtiger.Utilitys.JavaUtility;
import com.Vtiger.Utilitys.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class createProjectInDataBaseVerifyInGui {

	public static void main(String[] args) throws SQLException {
		FileUtility.openPropertyFile(IconstantPath.RMGYANTRA_DATABASE_FILE_PATH);
		DataBaseUtility.openDataBaseConnection(IconstantPath.DATABASEURL+"projects", FileUtility.getDataFromPropetryFile("dbUserName"), FileUtility.getDataFromPropetryFile("dbPassWord"));
		int ran = JavaUtility.getRandomNumber(1000);
		String project="manu";
		String projectid="TY_PROJ_"+ran+"";
		String query= "insert into project(project_id,created_by,created_on,project_name,status,team_size) values('"+projectid+"','"+project+"','29/04/2022','TY_P02','On Going','3')";	
		DataBaseUtility.setDataInDataBase(query);
		DataBaseUtility.closeDataBaseConnection();
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver1 = new FirefoxDriver();
		driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverUtility.navigateApp("http://localhost:8084/", driver1);
		driver1.findElement(By.xpath("//input[@name='username']")).sendKeys(FileUtility.getDataFromPropetryFile("username"));
		driver1.findElement(By.xpath("//input[@name='password']")).sendKeys(FileUtility.getDataFromPropetryFile("password"));
		driver1.findElement(By.xpath("//button[.='Sign in']")).click();
		driver1.findElement(By.xpath("//a[.='Projects']")).click();
		List<WebElement> projectname = driver1.findElements(By.xpath("//table//tbody/tr/td[4]"));
		for (WebElement project1 : projectname) {
			if (project1.getText().equalsIgnoreCase(project)) {
				JavaUtility.printStatement("project name is visible in GUI");
				JavaUtility.printStatement("test case pass");
			}
		}
		WebDriverUtility.quitBrowser(driver1);
	}

}
