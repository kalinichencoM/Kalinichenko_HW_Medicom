package pages;

import org.openqa.selenium.WebDriver;

public class PageProvider {
    WebDriver webDriver;
    public PageProvider(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public HomePage getHomePage() { return new HomePage(webDriver); }
    public DoctorsPageAllDoctors getDoctorsPageAll() { return new DoctorsPageAllDoctors(webDriver); }
    public SinglDoctorPage getSingleDoctorPage() { return new SinglDoctorPage(webDriver); }
    public CommentPage getCommentPage() { return new CommentPage(webDriver); }
}
