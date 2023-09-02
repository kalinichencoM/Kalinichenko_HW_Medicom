package zapisNaPriyom;

import baseTest.BaseTest;
import testData.libs.Util;
import org.junit.Test;


public class ZapisNaPriyom extends BaseTest {

    private final String VALID_NAME = "001 " + Util.getDateAndTimeFormatted();

    @Test
    public void zapisNaPriyom() {
        pageProvider.getHomePage()
                .openHomePage()
                .getHeader()
                .clickOnButtonZapisNaPriyom()
                .checkIsRedirectToPopUpZapisNaPriyom()
                .enterTelephone("0123456789")
                .enterName(VALID_NAME)
                //.clickOnSubmitButton()
                .checkTextInNameInput(VALID_NAME)
                .checkTextInTelephoneInput("+38 (012) 345 67 89")
        ;

    }
}
