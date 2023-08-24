package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommentPage extends SinglDoctorPage{
    public CommentPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = ".//div[@class='rating-select flex-cont']")
    private WebElement ratingSelect;

    @FindBy(xpath = ".//textarea[@name='description']")
    private WebElement commentField;

    @FindBy(xpath = ".//input[@class='comment-name']")
    private WebElement nameField;

    @FindBy(xpath = ".//input[@class='comment-phone']")
    private WebElement telephoneField;

    @FindBy(xpath = ".//span[@class='checkbox__text']")
    private WebElement checkbox;

    public CommentPage checkIsRedirectToCommentPage() {
        checkUrlWithPattern("/doctor/[a-zA-Z]*-[a-zA-Z]*-[a-zA-Z]*/");
        checkIsRatingSelectVisible();
        return this;
    }

    public CommentPage checkIsRatingSelectVisible() {
        checkElementDisplay(ratingSelect);
        return this;
    }

    public CommentPage enterComment(String comment) {
        enterTextIntoInput(commentField, comment);
        return this;
    }

    public CommentPage enterNameSername(String validName) {
        enterTextIntoInput(nameField, validName);
        return this;
    }

    public CommentPage enterTelephone(String validTelephone) {
        enterTextIntoInput(telephoneField, validTelephone);
        return this;
    }


    public CommentPage checkComment(String comment) {
        Assert.assertEquals("Comment is not expected", comment, commentField.getText());
        return this;
    }

    public CommentPage checkNameSername(String validName) {
        Assert.assertEquals("Name is not expected", validName, nameField.getText());
        return this;
    }

    public CommentPage checkTelephone(String validTelephone) {
        Assert.assertEquals("Telephone is not expected", validTelephone, telephoneField.getText());
        return this;
    }

    public CommentPage checkStatusCheckBoxCommentPage(String status) {
        try {
            if (status.equals("check")) {
                setCheckboxState(checkbox);

            } else if (status.equals("uncheck")) {
                unsetCheckboxState(checkbox);
            } else {
                logger.error("Status should be 'check' or 'uncheck'");
                Assert.fail("Status should be 'check' or 'uncheck'");
            }
        } catch (Exception e) {
            logger.error("Can not work with checkbox");
            Assert.fail("Can not work with checkbox");
        }
        return this;
    }
}
