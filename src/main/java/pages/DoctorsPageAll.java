package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DoctorsPageAll extends ParentPageWithHeader{

    public DoctorsPageAll(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(id = "search-price")
    private WebElement searchDoctor;

    @FindBy(xpath = ".//span[@class='highlight']")
    private WebElement searchPriceResult;

    final String searchPriceResultLocator = ".//img[@alt='%s']";

    public DoctorsPageAll enterDoctorName(String doctorName) {
        enterTextIntoInput(searchDoctor, doctorName);
        return this;
    }

    public DoctorsPageAll clickOnButtonSearchDoctor(String doctorName) {
        clickOnElement((WebElement) By.xpath(
                String.format(searchPriceResultLocator, doctorName)
        ));
        return this;
    }
}
