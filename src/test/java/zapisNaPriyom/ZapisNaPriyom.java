package zapisNaPriyom;

import baseTest.BaseTest;
import libs.Util;
import org.junit.Test;

public class ZapisNaPriyom extends BaseTest {

    private final String VALID_NAME = "001 Kalinichenko" + Util.getDateAndTimeFormatted();

    @Test
    public void zapisNaPriyom() {
        pageProvider.getHomePage()
                .openHomePage()
                .getHeader()
                .clickOnButtonZapisNaPriyom()
                .checkIsRedirectToPopUpZapisNaPriyom()
                .enterName(VALID_NAME)
                .enterTelephone("1234567890")
                //.clickOnSubmitButton()
                .checkTextInNameInput(VALID_NAME)
                .checkTextInTelephoneInput("1234567890")
        ;

    }
}
