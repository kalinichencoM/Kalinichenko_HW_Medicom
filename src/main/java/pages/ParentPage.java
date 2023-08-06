package pages;

import org.openqa.selenium.WebDriver;
import org.junit.Assert;

public class ParentPage extends ActionsWithElements{
    final String baseUrl = "https://medikom.ua/";

    public ParentPage(WebDriver webDriver) {
        super(webDriver);
    }
    public void openPage(String url) {
        try {
            webDriver.get(url);
            logger.info("Page was opened " + url);
        } catch (Exception e) {
            logger.error("Can not open " + url);
            Assert.fail("Can not open " + url);
        }
    }

}
