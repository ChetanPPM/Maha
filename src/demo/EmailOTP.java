package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class EmailOTP
{
	public static void main(String[] args) throws InterruptedException 
	{

		ChromeOptions option=new ChromeOptions();
		option.addArguments("incognito");
		System.setProperty("webdriver.chrome.driver", "C:\\Browser2\\chromedriver.exe");
		
		WebDriver driver =new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://testdbtapp.mahaitgov.in/RegistrationLogin/RegistrationLogin");
		 
		driver.findElement(By.xpath("//input[@name=\"Email\"]")).sendKeys("slwawon0208@anomgo.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id=\"btnGetOTP_Email\"]")).click();
        

            WebDriverWait wait = new WebDriverWait(driver, 15);
            wait.until(ExpectedConditions.alertIsPresent());

            Alert alert = driver.switchTo().alert();
            System.out.println(alert.getText());
            alert.accept();
            
//              Thread.sleep(10000);
//            JavascriptExecutor js = (JavascriptExecutor)driver;
//            js.executeScript("document.getElementById('temp_EmailOTP').value='123';");
//            Thread.sleep(10000);
            
            
            WebElement Mob = driver.findElement(By.xpath("//input[@id=\"MobileNo\"]"));
            Mob.sendKeys("9822222221");
            Thread.sleep(10000);//input[@id="temp_MobileOTP"]
            driver.findElement(By.xpath("//button[@id=\"btnGetOTP_Mobile\"]")).click();
            Thread.sleep(10000);
            Alert alert2 = driver.switchTo().alert();
            alert2.accept();
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("document.getElementById('temp_MobileOTP').value='1234';");
            Thread.sleep(10000);
           driver.quit();
		}
}