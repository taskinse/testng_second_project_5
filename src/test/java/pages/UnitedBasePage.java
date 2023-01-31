package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class UnitedBasePage {

    public UnitedBasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(css = "ul[class='app-components-GlobalHeader-globalHeader__globalBottomNav--2aHvD app-components-GlobalHeader-globalHeader__hpBottomNav--3SjnI']")
    public List<WebElement> mainMenuNavigation;

    @FindBy(css = "ul[class='app-components-BookTravel-bookTravel__travelNav--3RNBj']")
    public List<WebElement> bookTravelMenuNavigation;

    @FindBy(css = "div[class*='radioContainer'] label")
    public List<WebElement> radioButtons;

    @FindBy(css = "div[class*='radioContainer'] input")
    public List<WebElement> radioButtonsInput;

    @FindBy(css = "div[class*='awardTravelContainer'] label")
    public WebElement bookWithMilesCheckboxLabel;

    @FindBy(css = "div[class*='awardTravelContainer'] input")
    public WebElement bookWithMilesCheckboxInput;

    @FindBy(css = "div[class*='flexibleDatesContainer'] label")
    public WebElement flexibleDatesLabel;

    @FindBy(css = "div[class*='flexibleDatesContainer'] input")
    public WebElement flexibleDatesInput;


    @FindBy(id ="bookFlightOriginInput")
    public WebElement flightOriginLocation;

    @FindBy(id = "bookFlightDestinationInput")
    public WebElement finalDestinationLocation;

    @FindBy(id = "DepartDate")
    public WebElement departureDate;

    @FindBy(css = "button[aria-labelledby='stuff']")
    public WebElement passengerSelectButton;

    @FindBy(css = "button[aria-label='Substract one Adult']")
    public WebElement addAdultPassenger;

    @FindBy(css = "div[aria-label='Economy']")
    public WebElement classDropDown;


    @FindBy(css = "li[id^='cabinType_item-']")
    public List<WebElement> cabinType;

    public void clickOnCabinTypeOption(String optionText){
        for(WebElement element : cabinType){
            if(element.getText().equals(optionText)){
                element.click();
                break;
            }
        }
    }

    @FindBy(css = "button[class*='bookFlightForm__findFlightBtn']")
    public WebElement findFlightsButton;

    @FindBy(xpath = "(//div[contains(@class,'app-components-Shopping-ColumnSortResultHeader-styles__d')]/span)[2]")
    public WebElement departureMessage;


   // @FindBy(id = "bBVS9xtLghf")
   // public WebElement businessFirstCabin;

}