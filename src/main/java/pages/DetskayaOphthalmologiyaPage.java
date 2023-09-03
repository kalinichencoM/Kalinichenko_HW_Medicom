package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DetskayaOphthalmologiyaPage extends ParentPageWithHeader {
    public DetskayaOphthalmologiyaPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/detskaya-oftalmologiya-kiev/";
    }

    @FindBy(xpath = ".//*[contains(text(),'10. Консультація дитячого офтальмолога')]")
    private WebElement punkt10;

    private final String doctorNameLocator = ".//*[text()='%s']";

    private final List<WebElement> doctors = webDriver.findElements(By.xpath(".//div[@class='swiper-wrapper direction-spec-noslider']/div[@class='swiper-slide direction-spec-card ']"));

    public DetskayaOphthalmologiyaPage checkIsRedirectToDetskayaOphthalmologiyaPage() {
        checkUrl();
        checkElementDisplay(punkt10);
        return this;
    }

    public DetskayaOphthalmologiyaPage checkAllDoctorName(List<String> ListValidDoctorOchi) {
        Assert.assertEquals("Number of doctors is not correct", ListValidDoctorOchi.size(), doctors.size());
        for (int i = 0; i < ListValidDoctorOchi.size(); i++) {
            String doctorName = String.format(doctorNameLocator, ListValidDoctorOchi.get(i));
            WebElement ElenentName = webDriver.findElement(By.xpath(doctorName));
            logger.info("Doctor name " + ElenentName.getText() + " is found");
            Assert.assertEquals("Doctor name is not correct", ListValidDoctorOchi.get(i), ElenentName.getText());
        }
        return this;
    }
}
