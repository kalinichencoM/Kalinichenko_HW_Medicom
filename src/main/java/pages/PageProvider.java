package pages;

import org.openqa.selenium.WebDriver;

public class PageProvider {
    WebDriver webDriver;
    public PageProvider(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public HomePage getHomePage() { return new HomePage(webDriver); }
    public DoctorsPageAllDoctors getDoctorsPageAll() { return new DoctorsPageAllDoctors(webDriver); }
}
