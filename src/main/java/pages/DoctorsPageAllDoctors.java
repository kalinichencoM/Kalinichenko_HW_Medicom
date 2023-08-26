package pages;

import libs.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DoctorsPageAllDoctors extends ParentPageWithHeader {

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

    @FindBy(xpath = ".//img[@class=' lazyloaded']")
    private WebElement imageDoctor;


    @FindBy(xpath = ".//select[@name='clinics']")
    private WebElement selectClinic;

    @FindBy(xpath = ".//select[@name='select-prof']")
    private WebElement selectProf;

    @FindBy(xpath = ".//select[@name='specialization']")
    private WebElement selectSpecialization;


    final String searchDoctorResultLocator = ".//div[@class=\"doctors-result-cards flex-cont justify-sb\"]//span[contains(text(),'%s')]/../../../a/img";
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

    public DoctorsPageAllDoctors checkIsButtonSearchDoctorVisible() {
        checkElementDisplay(searchDoctor);
        return this;
    }

    public DoctorsPageAllDoctors checkIsRedirectToAllDoctorsPage() {
        checkUrl();
        checkIsButtonSearchDoctorVisible();
        return this;
    }

    public DoctorsPageAllDoctors selectClinic(String clinic) {
        selectTextInDropDown(selectClinic, clinic);
        return this;
    }

    public DoctorsPageAllDoctors selectProf(String prof) {
        selectTextInDropDown(selectProf, prof);
        return this;
    }

    public DoctorsPageAllDoctors selectSpecialization(String specialization) {
        selectTextInDropDown(selectSpecialization, specialization);
        return this;
    }

    public SinglDoctorPage clickOnImageDoctor(String doctorName) {
        String[] doctorNameLocator = doctorName.split(" ");
        clickOnElement(webDriver.findElement(By.xpath(String.format(searchDoctorResultLocator, doctorNameLocator[0]))));
        return new SinglDoctorPage(webDriver);
    }
}
