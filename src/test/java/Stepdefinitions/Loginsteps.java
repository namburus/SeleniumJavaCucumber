package Stepdefinitions;

import baseclass.baseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class Loginsteps extends baseTest {
/*	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static FileReader fr;*/
	@Before
	public void setup() throws IOException {
		if (driver==null){
			fr = new FileReader("D:/SendMessages/src/test/java/utilities/config.properties");
			prop.load(fr);
		}
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")){
			driver = WebDriverManager.chromedriver().create();
		} else if ((prop.getProperty("browser").equalsIgnoreCase("firefox"))) {
			driver = WebDriverManager.firefoxdriver().create();
		}else if (prop.getProperty("browser").equalsIgnoreCase("edge")){
			driver = WebDriverManager.edgedriver().create();
		}else {
			System.out.print("This browser hasnt been implemneted yet");
		}
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();

	}
	@After
	public void teardown(){
		driver.close();
	}

	@Given("user in on the web site")
	public void user_in_on_the_web_site() {
		System.out.print("shifted to upside");
		/*driver = WebDriverManager.firefoxdriver().create();
		driver.get("https://sendmessages.co.uk/");*/
	}

	@When("the user enters the details")
	public void the_user_enters_the_details() {
		driver.findElement(By.linkText("Admin Login")).click();
	   	driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("sn42116991@gmail.com");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("Shivaji@namburu");
	}

	@When("click login")
	public void click_login() {
		 driver.findElement(By.name("submit")).click();
	   
	}

	@Then("the user is logged in")
	public void the_user_is_logged_in() {

		 if (driver.getTitle().equals("Dashboard | Bulk SMS")){
			 System.out.print("landed on correct page");
		}else {
			 System.out.print("wrong page");
		 }

	}

}
