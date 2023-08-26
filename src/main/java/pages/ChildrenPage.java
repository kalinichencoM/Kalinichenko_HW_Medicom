package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChildrenPage extends ParentPageWithHeader {
    public ChildrenPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/";
    }

    @FindBy(xpath = ".//div[@id='dropdown-3']//*[text()='Діагностика']")
    private WebElement diagnostic;

    @FindBy(xpath = ".//div[@id='dropdown-3']//*[text()='Офтальмологія']")
    private WebElement ophthalmologist;

    public ChildrenPage checkIsDiagnosticIsVisible() {
        checkElementDisplay(diagnostic);
        return this;
    }

    public ChildrenPage checkIsRedirectToChildrenPage() {
        checkUrl();
        checkIsDiagnosticIsVisible();
        return this;
    }

    public DetskayaOphthalmologiyaPage clickOphthalmologist() {
        clickOnElement(ophthalmologist);
        return new DetskayaOphthalmologiyaPage(webDriver);
    }
}
