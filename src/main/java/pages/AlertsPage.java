package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage {

    private WebDriver driver;
    private By jsAlertsButton = By.xpath("//button[text()='Click for JS Alert']");
    private By jsConfirmButton = By.xpath("//button[text()='Click for JS Confirm']");
    private By jsPromptButton = By.xpath("//button[text()='Click for JS Prompt']");
    private By results = By.id("result");

    public AlertsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void triggerAlert(){
        driver.findElement(jsAlertsButton).click();
    }

    public void triggerConfirm(){
        driver.findElement(jsConfirmButton).click();
    }

    public void triggerPrompt(){
        driver.findElement(jsPromptButton).click();
    }

    public void alert_clickToAcceptAlert(){
        driver.switchTo().alert().accept();
    }

    public void alert_clickToDismissAlert(){
        driver.switchTo().alert().dismiss(); //click cancel on alert
    }

    public void alert_setInput(String text){
        driver.switchTo().alert().sendKeys(text);
    }

    public String alert_getText(){
        return driver.switchTo().alert().getText();
    }

    public String getResult(){
        return driver.findElement(results).getText();
    }


}
