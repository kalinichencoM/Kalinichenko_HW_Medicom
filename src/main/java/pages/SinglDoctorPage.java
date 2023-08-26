package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SinglDoctorPage extends ParentPageWithHeader {
    public SinglDoctorPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = ".//a[@id='open-form-doctor']")
    private WebElement buttonOpenFormRegistrationForDoctorVisiting;

    @FindBy(xpath = ".//div[@class='doc-name']")
    private WebElement doctorName;

    @FindBy(xpath = ".//img[@class='gray-ar']")
    private WebElement buttonComment;


    @Override
    protected String getRelativeUrl() {
        return "/doctor/[a-zA-Z]*-[a-zA-Z]*-[a-zA-Z]*/";
    }

    public SinglDoctorPage checkIsRedirectToSingleDoctorPage() {
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

    public SinglDoctorPage checkDoctorName(String doctortext) {
        WebElement webDoctor = doctorName;
        Assert.assertEquals("Doctor name is not expected", doctortext, webDoctor.getText());
        return this;
    }

    public CommentPage clickOnButtonComment() {
        clickOnElement(buttonComment);
        return new CommentPage(webDriver);
    }
}
