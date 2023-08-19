package pages;

import org.openqa.selenium.WebDriver;
import pages.elements.Header;

public abstract class ParentPageWithHeader extends ParentPage{


    public ParentPageWithHeader(WebDriver webDriver) {
        super(webDriver);
    }

    public Header getHeader() {
        return new Header(webDriver);
    }
}
