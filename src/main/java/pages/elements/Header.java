package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ActionsWithElements;
import pages.DoctorsPageAllDoctors;

public class Header extends ActionsWithElements {
    public Header(WebDriver webDriver) {
        super(webDriver);
    }
    @FindBy(xpath = ".//a[@href='/doctor/']")
    private WebElement doctorLink;

    public DoctorsPageAllDoctors clickOnButtonSearchDoctor() {
        clickOnElement(doctorLink);
        return new DoctorsPageAllDoctors(webDriver);
    }
}
