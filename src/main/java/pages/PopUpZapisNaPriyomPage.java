package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PopUpZapisNaPriyomPage extends ParentPage{
    public PopUpZapisNaPriyomPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/#";
    }

    @FindBy(xpath = ".//div[@class='pop-search-doc']")
    private WebElement popUpZapisNaPriyom;
    
    @FindBy(xpath = ".//div[@class='pop-search-doc']//input[@name='name']")
    private WebElement inputName;

    @FindBy(xpath = ".//div[@class='pop-search-doc']//input[@name='phone']")
    private WebElement inputTelephone;

    @FindBy(xpath = ".//div[@class='pop-search-doc']//button[@type='submit']")
    private WebElement buttonSubmit;


    public PopUpZapisNaPriyomPage checkIsRedirectToPopUpZapisNaPriyom() {
        checkUrl();
        checkIsPopUpZapisNaPriyomPresent();
        return this;
    }

    public PopUpZapisNaPriyomPage checkIsPopUpZapisNaPriyomPresent() {
        checkElementDisplay(popUpZapisNaPriyom);
        return this;
    }
    
    public PopUpZapisNaPriyomPage enterName(String name) {
        enterTextIntoInput(inputName, name);
        return this;
    }

    public PopUpZapisNaPriyomPage enterTelephone(String number) {
        clickOnElement(inputTelephone);
        enterTextIntoInputWihoutClean(inputTelephone, number);

        return this;
    }

    public PopUpZapisNaPriyomPage clickOnSubmitButton() {
        clickOnElement(buttonSubmit);
        return this;
    }

    public PopUpZapisNaPriyomPage checkTextInNameInput(String text) {
        checkTextInInput(inputName, text);
        return this;
    }

    public PopUpZapisNaPriyomPage checkTextInTelephoneInput(String text) {
        checkTextInInput(inputTelephone, text);
        return this;
    }
}
