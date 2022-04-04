package frameeditortests;

import base.BaseTests;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FrameEditorTests extends BaseTests {
    @Test
    public void testGetCorrectText(){
        var frameEditorPage = homePage.clickWYSIWYGEditor();
        frameEditorPage.clickEditorFrame();
        frameEditorPage.editText("Hello soda");
        assertEquals(frameEditorPage.getResult(), "Hello soda");
    }

    @Test
    public void testIncreaseIndent(){
        var frameEditorPage = homePage.clickWYSIWYGEditor();
        frameEditorPage.clickEditorFrame();
        frameEditorPage.editText("Hello soda");
        frameEditorPage.increaseIndent();
        assertEquals(frameEditorPage.getResult(), "Hello soda");
    }

}
