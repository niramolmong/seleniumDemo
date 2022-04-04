package base;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseTests {
    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver"); //resources/chromedriver is the path of driver
        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); //wait 30 secs for finding elements before throwing exceptions
        goHome();
        setCookie();
        driver.manage().window().setSize(new Dimension(800, 900));
        System.out.println("The website's title: " + driver.getTitle());

        homePage = new HomePage(driver);
        System.out.println("HomePage");
    }

    @BeforeMethod
    public void goHome(){
        driver.get("https://the-internet.herokuapp.com/");
    }

    public WindowManager getWindowManager(){
        return  new WindowManager(driver); //handle window manager
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

//    @AfterMethod
//    public void takeScreenShot(){
//        var camera = (TakesScreenshot)driver; // cast driver to TakesScreenshot of Selenium
//        File screenshot = camera.getScreenshotAs(OutputType.FILE); // save to screenshot as a file
////        System.out.println("Screenshot taken: " + screenshot.getAbsolutePath()); // Screenshot taken: /var/folders/c9/m8f4w8z10sx6bv0d460xfnp00000gq/T/screenshot4453918812146818560.png
//
//        try {
//            Files.move(screenshot, new File("resources/screenshots/test.png")); //Files = com.google.common.io, resources/screenshots/test.png = directory for saving screenshot
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//    }

//    @AfterMethod
//    public void takeScreenShotOfFailure(ITestResult result){ // only run when failed
//        if(ITestResult.FAILURE == result.getStatus()){
//            var camera = (TakesScreenshot)driver; // cast driver to TakesScreenshot of Selenium
//            File screenshot = camera.getScreenshotAs(OutputType.FILE); // save to screenshot as a file
////        System.out.println("Screenshot taken: " + screenshot.getAbsolutePath()); // Screenshot taken: /var/folders/c9/m8f4w8z10sx6bv0d460xfnp00000gq/T/screenshot4453918812146818560.png
//
//            try {
//                Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png")); //Files = com.google.common.io, resources/screenshots/test.png = directory for saving screenshot
//            }catch (IOException e){
//                e.printStackTrace();
//            }
//        }
//
//    }

    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        return options;
    }

    private void setCookie(){
        Cookie cookie = new Cookie.Builder("soda", "123")
                .domain("the-internet.herokuapp.com")
                .build();
        driver.manage().addCookie(cookie); // check in inspect->application->cookies
    }
}
