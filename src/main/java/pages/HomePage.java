package pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends ParentPageWithHeader {


    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/";
    }

    public HomePage openHomePage() {
        openPage(baseUrl);
        return this;
    }

}
