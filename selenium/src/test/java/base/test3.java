package base;

import java.io.FileReader;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class test3 {

    public WebDriver driver;  
    public Logger logger;
    public Properties p;

    @BeforeClass
    @Parameters({"os","browser"})
    public void setup(String os, String br) throws Exception {
        FileReader file = new FileReader("src/test/resources/config.properties");
        p = new Properties();
        p.load(file);

        logger = LogManager.getLogger(this.getClass());
        logger.info("***** Starting test setup *****");

        switch (br.toLowerCase()) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                if (os.equalsIgnoreCase("windows")) chromeOptions.setPlatformName("WINDOWS");
                driver = new RemoteWebDriver(new URL(p.getProperty("grid_url")), chromeOptions);
                break;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (os.equalsIgnoreCase("windows")) firefoxOptions.setPlatformName("WINDOWS");
                driver = new RemoteWebDriver(new URL(p.getProperty("grid_url")), firefoxOptions);
                break;
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                if (os.equalsIgnoreCase("windows")) edgeOptions.setPlatformName("WINDOWS");
                driver = new RemoteWebDriver(new URL(p.getProperty("grid_url")), edgeOptions);
                break;
            default:
                logger.error("No matching browser found: " + br);
                return;
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(
                Long.parseLong(p.getProperty("implicit_wait"))));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(
                Long.parseLong(p.getProperty("page_load_timeout"))));
        logger.info("Connected to Selenium Grid at: " + p.getProperty("grid_url"));
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            logger.info("Browser closed successfully");
        }
    }
}
