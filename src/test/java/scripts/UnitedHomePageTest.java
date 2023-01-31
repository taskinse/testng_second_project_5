package scripts;

import org.junit.Assert;
import org.testng.annotations.Test;
import utilities.Waiter;

public class UnitedHomePageTest extends UnitedBase {
    @Test(priority = 1, description = "Validate Main Menu navigation items")
    public void validateMainMenuItems() {

        for (int i = 0; i < unitedBasePage.mainMenuNavigation.size(); i++) {
            Assert.assertTrue(unitedBasePage.mainMenuNavigation.get(i).isDisplayed());
        }
    }
    @Test(priority = 2, description = "Validate Book travel menu navigation items")
    public void validateBookTravelManu() {
        for (int i = 0; i < unitedBasePage.bookTravelMenuNavigation.size(); i++) {
            Assert.assertTrue(unitedBasePage.bookTravelMenuNavigation.get(i).isDisplayed());
        }
    }

    @Test(priority = 3, description = "Validate Round-trip and One-way radio buttons")
    public void validateRoundTripAndOneWayButtons(){
        Assert.assertTrue(unitedBasePage.radioButtons.get(0).isDisplayed());
        Assert.assertTrue(unitedBasePage.radioButtonsInput.get(0).isEnabled());
        Assert.assertTrue(unitedBasePage.radioButtonsInput.get(0).isSelected());

        Assert.assertTrue(unitedBasePage.radioButtons.get(1).isDisplayed());
        Assert.assertTrue(unitedBasePage.radioButtonsInput.get(1).isEnabled());
        Assert.assertFalse(unitedBasePage.radioButtonsInput.get(1).isSelected());

        unitedBasePage.radioButtonsInput.get(1).click();
        Assert.assertTrue(unitedBasePage.radioButtonsInput.get(1).isSelected());
        Assert.assertFalse(unitedBasePage.radioButtonsInput.get(0).isSelected());
    }

    @Test(priority = 4, description = "Validate Book with miles and Flexible dates checkboxes")
    public void validateBookWithMilesAndFlexibleDatesCheckboxes(){
        Assert.assertTrue(unitedBasePage.bookWithMilesCheckboxLabel.isDisplayed());
        Assert.assertTrue(unitedBasePage.bookWithMilesCheckboxInput.isEnabled());
        Assert.assertFalse(unitedBasePage.bookWithMilesCheckboxInput.isSelected());

        Assert.assertTrue(unitedBasePage.flexibleDatesLabel.isDisplayed());
        Assert.assertTrue(unitedBasePage.flexibleDatesInput.isEnabled());
        Assert.assertFalse(unitedBasePage.flexibleDatesInput.isSelected());

        unitedBasePage.bookWithMilesCheckboxLabel.click();
        unitedBasePage.flexibleDatesLabel.click();

        Assert.assertTrue(unitedBasePage.bookWithMilesCheckboxInput.isSelected());
        Assert.assertTrue(unitedBasePage.flexibleDatesInput.isSelected());

        unitedBasePage.bookWithMilesCheckboxLabel.click();
        unitedBasePage.flexibleDatesLabel.click();

        Assert.assertFalse(unitedBasePage.bookWithMilesCheckboxInput.isSelected());
        Assert.assertFalse(unitedBasePage.flexibleDatesInput.isSelected());
    }

    @Test(priority = 5,description = "Validate One-way ticket search results from Chicago, IL, US (ORD) to Miami, FL, US (MIA)")
    public void ValidateOneWayTicketSearchResult(){

        unitedBasePage.radioButtonsInput.get(1).click();
        unitedBasePage.flightOriginLocation.clear();
        unitedBasePage.flightOriginLocation.sendKeys("Chicago, IL, US(ORD)");
        unitedBasePage.finalDestinationLocation.sendKeys("Miami, FL, US(MIA)");

        unitedBasePage.departureDate.clear();
        unitedBasePage.departureDate.sendKeys("Feb 28");

        unitedBasePage.passengerSelectButton.click();
        unitedBasePage.addAdultPassenger.click();

        unitedBasePage.classDropDown.click();
        unitedBasePage.clickOnCabinTypeOption("Business or First");

        unitedBasePage.findFlightsButton.click();
        Waiter.pause(3);
        Assert.assertEquals(unitedBasePage.departureMessage.getText(),"DEPART ON: February 28");
    }
}