package fileupload;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FileUploadTests extends BaseTests {
    @Test
    public void testFileUpload(){
        var uploadPage = homePage.clickFileUpload();
        uploadPage.uploadFile("/Users/niramol.mo/Documents/seleniumDemo/resources/chromedriver");
        assertEquals(uploadPage.getUploadedFile(), "chromedriver");


    }
}
