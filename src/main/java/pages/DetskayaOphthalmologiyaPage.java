package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DetskayaOphthalmologiyaPage extends ParentPageWithHeader{
    public DetskayaOphthalmologiyaPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "detskaya-oftalmologiya-kiev/";
    }

    @FindBy(xpath = ".//*[contains(text(),'10. Консультація дитячого офтальмолога')]")
    private WebElement punkt10;

    public DetskayaOphthalmologiyaPage checkIsRedirectToDetskayaOphthalmologiyaPage() {
        checkUrl();
        checkElementDisplay(punkt10);
        return this;
    }

    private final List<WebElement> doctors = webDriver.findElements(By.xpath(".//div[@class='swiper-wrapper direction-spec-noslider']/div[@class='swiper-slide direction-spec-card ']"));


    public DetskayaOphthalmologiyaPage checkAllDoctorByDepartmant(List<String> listValidDoctorOchi) {
       if (doctors.size() == listValidDoctorOchi.size()) {


        }
        return this;
    }
}
