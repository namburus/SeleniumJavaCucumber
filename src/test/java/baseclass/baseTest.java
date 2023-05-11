package baseclass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class baseTest {

    public static WebDriver driver;
    public static Properties prop = new Properties();
    public static FileReader fr;
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
}
