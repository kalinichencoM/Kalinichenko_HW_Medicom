package pages;

import org.openqa.selenium.WebDriver;
import org.junit.Assert;

abstract public class ParentPage extends ActionsWithElements{
    final String baseUrl = "https://medikom.ua";

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

    abstract protected String getRelativeUrl();

    protected void checkUrl(String relativeUrl) {
        Assert.assertEquals("Url is not expected", baseUrl + relativeUrl, webDriver.getCurrentUrl());
    }

    protected void checkUrl() {
        checkUrl(getRelativeUrl());
    }

    //https://medikom.ua/doctor/adamenko-ekaterina-borisovna/
    //https://medikom.ua/doctor/[a-zA-Z0-9-]*
    protected void checkUrlWithPattern(String relativeUrl) {
        Assert.assertTrue("Url is not expected \n" +
                        "Expected result: " + baseUrl + relativeUrl + "\n" +
                        "Actual result: " + webDriver.getCurrentUrl()
                , webDriver.getCurrentUrl().matches(baseUrl + relativeUrl));
    }

    protected void checkUrlWithPattern() {
        checkUrlWithPattern(getRelativeUrl());
    }

}
