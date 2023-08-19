package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ParentPageWithHeader;

public class SinglDoctorPage extends ParentPageWithHeader {
    public SinglDoctorPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = ".//a[@id='open-form-doctor']")
    private WebElement buttonOpenFormRegistrationForDoctorVisiting;



    @Override
    protected String getRelativeUrl() {
        return "/doctor/[a-zA-Z]*-[a-zA-Z]*-[a-zA-Z]*";
    }

    public SinglDoctorPage isRedirectToSinglDoctorPage() {
        checkUrlWithPattern();
        checkIsButtonOpenFormRegistrationForDoctorVisitingVisible();
        return this;
    }

    public SinglDoctorPage clickOnButtonOpenFormRegistrationForDoctorVisiting() {
        clickOnElement(buttonOpenFormRegistrationForDoctorVisiting);
        return this;
    }

    public SinglDoctorPage checkIsButtonOpenFormRegistrationForDoctorVisitingVisible() {
        checkElementDisplay(buttonOpenFormRegistrationForDoctorVisiting);
        return this;
    }

}
