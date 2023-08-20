package pages;

import libs.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.elements.SinglDoctorPage;

public class DoctorsPageAllDoctors extends ParentPageWithHeader{

    public DoctorsPageAllDoctors(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/doctor/";
    }

    @FindBy(id = "search-price")
    private WebElement searchDoctor;

    @FindBy(xpath = ".//span[@class='highlight']")
    private WebElement searchPriceResult;

    @FindBy(xpath =".//img[@class=' lazyloaded']" )
    private WebElement imageDoctor;


    final String searchPriceResultLocator = ".//img[@alt='%s']";


    public DoctorsPageAllDoctors enterDoctorName(String doctorName) {
        enterTextIntoInput(searchDoctor, doctorName);
        return this;
    }

    public DoctorsPageAllDoctors clickOnButtonSearchDoctor(String doctorName) {
        Util.waitABit(5);
        clickOnElement(searchPriceResult);
        return this;
    }
    public DoctorsPageAllDoctors  checkIsButtonSearchDoctorVisible() {
        checkElementDisplay(searchDoctor);
        return this;
    }

    public DoctorsPageAllDoctors checkIsRedirectToAllDoctorsPage() {
        checkUrl();
        checkIsButtonSearchDoctorVisible();
        return this;
    }

    public SinglDoctorPage clickOnImageDoctor() {
        clickOnElement(imageDoctor);
        return new SinglDoctorPage(webDriver);
    }
}
