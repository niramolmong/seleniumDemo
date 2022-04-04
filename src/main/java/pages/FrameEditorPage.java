package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class FrameEditorPage {
    private WebDriver driver;
    private String editorFrame = "mce_0_ifr";
    private By textArea = By.id("tinymce");
    private By increaseIndentButton = By.xpath("//button[@title='Increase indent']");

    public FrameEditorPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickEditorFrame(){
        switchToEditArea();//switch to iframe ID
        driver.findElement(textArea).clear();
        switchToMainArea();
    }

    public void editText(String editText){
        switchToEditArea();
        driver.findElement(textArea).sendKeys(editText);
        switchToMainArea();
    }

    public void increaseIndent(){
        driver.findElement(increaseIndentButton).click();
    }

    public String getResult(){
        switchToEditArea();
        String text = driver.findElement(textArea).getText();
        switchToMainArea();
        return text;
    }

    private void switchToEditArea(){
        driver.switchTo().frame(editorFrame);
    }

    private void switchToMainArea(){
        driver.switchTo().parentFrame();
    }


}
