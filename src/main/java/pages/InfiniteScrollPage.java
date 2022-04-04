package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class InfiniteScrollPage {
    private WebDriver driver;
    private By textBlocks = By.className("jscroll-added");

    public InfiniteScrollPage(WebDriver driver) {this.driver = driver;}

    public void scrollToParaGraph(int index){ // scroll until paragraph with index specified is in view (index 1-based)
        String script = "window.scrollTo(0, document.body.scrollHeight)";// window.scrollTo(horizontal scroll, vertical scroll)
        var jsExecutor = (JavascriptExecutor)driver;

        while (getNumberOfParagraphsPresent() < index){
            jsExecutor.executeScript(script);
        }
    }

    private int getNumberOfParagraphsPresent(){
        return  driver.findElements(textBlocks).size();
    }

}
