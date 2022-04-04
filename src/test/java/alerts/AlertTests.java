package alerts;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.AlertsPage;
import pages.LoginPage;
import pages.SecureAreaPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AlertTests extends BaseTests {

    @Test
    public void testAcceptAlert(){
       var alertsPage = homePage.clickJavaScriptAlerts();
       alertsPage.triggerAlert();
       alertsPage.alert_clickToAcceptAlert();
       assertEquals(alertsPage.getResult(), "You successfully clicked an alert");
    }

    @Test
    public void testGetTextFromAlert(){
        var alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerConfirm();
        String text = alertsPage.alert_getText();
        alertsPage.alert_clickToDismissAlert();
        assertEquals(text, "I am a JS Confirm");
    }

    @Test
    public void testSetInputInAlert(){
        var alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerPrompt();
        String text = "SODAAAAAAAAAAAAAAAAAAAAA";
        alertsPage.alert_setInput(text);
        alertsPage.alert_clickToAcceptAlert();
        assertEquals(alertsPage.getResult(), "You entered: " + text);
    }


}
