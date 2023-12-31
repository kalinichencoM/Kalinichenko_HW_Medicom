package pages;

import org.junit.Assert;
import libs.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

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


    @FindBy(xpath = ".//select[@name='clinics']/../div[@class='jsSelectricView selectize-control single']/div[@class='selectize-input items full has-options has-items']")
    private WebElement selectClinic;

    @FindBy(xpath = ".//select[@name='select-prof']/../div[@class='jsSelectricView selectize-control single']/div[@class='selectize-input items full has-options has-items']")
    private WebElement selectProf;

    @FindBy(xpath = ".//div[@class='jsSelectricViewClear selectize-control single']")
    private WebElement selectSpecialization;

    @FindBy(xpath = ".//div[@class='jsSelectricViewClear selectize-control single']/div/input")
    private WebElement selectSpecializationInput;


    final String searchDoctorResultLocator = ".//div[@class='doctors-result-cards flex-cont justify-sb']//span[contains(text(),'%s')]/../../../a/img";
    final String selectProfDD = ".//select[@name='select-prof']/../div[@class='jsSelectricView selectize-control single']/div[@class='single selectize-dropdown jsSelectricView']/div/*[contains(text(),'%s')]";
    final String selectClinicDD = ".//select[@name='clinics']/../div[@class='jsSelectricView selectize-control single']/div[@class='single selectize-dropdown jsSelectricView']/div/*[contains(text(),'%s')]";
    final String selectSpecializationDD = ".//div[@class='single selectize-dropdown jsSelectricViewClear']/div/div/span";
    private final String doctorNameLocator = ".//*[contains(text(),'%s')]";
    private final String doctors = ".//div[@class='doctors-result-cards flex-cont justify-sb']/div[@class='doc-card active']";

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
        selectTextInDropDownByUI(selectClinic, clinic, selectClinicDD);
        return this;
    }

    public DoctorsPageAllDoctors selectProf(String prof) {
        selectTextInDropDownByUI(selectProf, prof, selectProfDD);
        return this;
    }

    public DoctorsPageAllDoctors selectSpecialization(String specialization) {
        clickOnElement(selectSpecialization);
        enterTextIntoInput(selectSpecializationInput, specialization);
        clickOnElement(webDriver.findElement(By.xpath(String.format(selectSpecializationDD, specialization))));
        return this;
    }

    public DoctorsPageAllDoctors checkAllDoctorName(List<String> LIST_VALID_DOCTOR_UZI) {
        List<WebElement> doctorsList = webDriver.findElements(By.xpath(doctors));
        Assert.assertEquals("Number of doctors is not correct", LIST_VALID_DOCTOR_UZI.size(), doctorsList.size());
        for (int i = 0; i < LIST_VALID_DOCTOR_UZI.size(); i++) {
            String doctorSurname = String.format(doctorNameLocator, listDoctorsSurname(LIST_VALID_DOCTOR_UZI).get(i));
            WebElement ElenentName = webDriver.findElement(By.xpath(doctorSurname));
            logger.info("Doctor name " + ElenentName.getText() + " is found");
        }
        return this;
    }

    public SinglDoctorPage clickOnImageDoctor(String doctorName) {
        String[] doctorNameLocator = doctorName.split(" ");
        clickOnElement(webDriver.findElement(By.xpath(String.format(searchDoctorResultLocator, doctorNameLocator[0]))));
        return new SinglDoctorPage(webDriver);
    }

    private List<String> listDoctorsSurname(List<String> LIST_VALID_DOCTOR){
        List<String> LIST_DOCTOR_NAME = new ArrayList<>();
        for (int i = 0; i < LIST_VALID_DOCTOR.size(); i++) {
            String[] doctorName = LIST_VALID_DOCTOR.get(i).split(" ");
            LIST_DOCTOR_NAME.add(doctorName[0]);
        }
        return LIST_DOCTOR_NAME;
    }
}
