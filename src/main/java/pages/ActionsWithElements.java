package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import libs.Util;

import java.time.Duration;


public class ActionsWithElements {

    Logger logger = Logger.getLogger(getClass());
    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait10, webDriverWait15;

    public ActionsWithElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this); // this - means all elements from this class will be initialized elements in FindBy
        webDriverWait10 = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        webDriverWait15 = new WebDriverWait(webDriver, Duration.ofSeconds(15));
    }

    public void enterTextIntoInput(WebElement searchDoctor, String text) {
        try {
            searchDoctor.clear();
            searchDoctor.sendKeys(text);
            logger.info(text + " was inputted into input " + getElementName(searchDoctor));
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void enterTextIntoInputWihoutClean(WebElement searchDoctor, String text) {
        try {
            searchDoctor.sendKeys(text);
            logger.info(text + " was inputted into input " + getElementName(searchDoctor));
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void checkTextInInput(WebElement searchDoctor, String text) {
        try {
            Assert.assertEquals("Text in input is not expected", text, searchDoctor.getAttribute("value"));
            logger.info("Text in input is expected" + text);
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void selectTextInDropDownByUI(WebElement dropDown, String text, String element) {
        try {
            clickOnElement(dropDown);
            Util.waitABit(1);
            clickOnElement(webDriver.findElement(org.openqa.selenium.By.xpath(String.format(element, text))));
            logger.info(text + " was selected in DropDown");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            boolean state = element.isDisplayed();
            if (state) {
                logger.info(getElementName(element) + " Element is displayed");
            } else {
                logger.info(getElementName(element) + " Element is not displayed");
            }
            return state;
        } catch (Exception e) {
            logger.info(getElementName(element) + " Element is not displayed");
            return false;
        }
    }

    public void checkElementDisplay(WebElement element) {
        Assert.assertTrue("Element is not displayed", isElementDisplayed(element));
    }

    public void clickOnElement(WebElement element) {
        try {
            webDriverWait10.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            logger.info(getElementName(element) + " Element was clicked");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    private void printErrorAndStopTest(Exception e) {
        logger.error("Can not work with element " + e);
        Assert.fail("Can not work with element " + e);
    }

    private String getElementName(WebElement element) {
        try {
            return element.getAccessibleName();
        } catch (Exception e) {
            return "";
        }
    }

    public boolean setCheckboxState(WebElement element) {
        try {
            if (!element.isSelected()) {
                element.click();
                logger.info(getElementName(element) + "Checkbox state was changed to set");
                return true;
            } else {
                logger.info(getElementName(element) + "Checkbox state was not changed it is already set");
                return false;
            }
        } catch (Exception e) {
            printErrorAndStopTest(e);
            return false;
        }
    }

    public boolean unsetCheckboxState(WebElement element) {
        try {
            if (element.isSelected()) {
                element.click();
                logger.info(getElementName(element) + "Checkbox state was changed to unset");
                return true;
            } else {
                logger.info(getElementName(element) + "Checkbox state was not changed it is already unset");
                return false;
            }
        } catch (Exception e) {
            printErrorAndStopTest(e);
            return false;
        }
    }

}

