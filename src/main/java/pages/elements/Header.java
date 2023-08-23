package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ActionsWithElements;
import pages.DoctorsPageAllDoctors;
import pages.PopUpZapisNaPriyomPage;

public class Header extends ActionsWithElements {
    public Header(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = ".//a[@href='/doctor/']")
    private WebElement doctorLink;

    @FindBy(xpath = ".//a[@id='entry-head']")
    private WebElement zapisNaPriyom;

    public DoctorsPageAllDoctors clickOnButtonSearchDoctor() {
        clickOnElement(doctorLink);
        return new DoctorsPageAllDoctors(webDriver);
    }

    public PopUpZapisNaPriyomPage clickOnButtonZapisNaPriyom() {
        clickOnElement(zapisNaPriyom);
        return new PopUpZapisNaPriyomPage(webDriver);
    }
}
