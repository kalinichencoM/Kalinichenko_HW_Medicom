package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DetskayaOphthalmologiyaPage extends ParentPageWithHeader{
    public DetskayaOphthalmologiyaPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "detskaya-oftalmologiya-kiev/";
    }

    public DetskayaOphthalmologiyaPage checkIsRedirectToDetskayaOphthalmologiyaPage() {
        checkUrl();
        return this;
    }

    private final List<WebElement> doctors = webDriver.findElements(By.xpath(".//div[@class='swiper-wrapper direction-spec-noslider']/div[@class='swiper-slide direction-spec-card ']"));


}
