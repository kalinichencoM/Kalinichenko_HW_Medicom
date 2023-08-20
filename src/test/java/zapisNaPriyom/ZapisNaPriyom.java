package zapisNaPriyom;

import baseTest.BaseTest;
import libs.Util;
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
                .enterName(VALID_NAME)
                .enterTelephone("0630474773")
                //.clickOnSubmitButton()
                .checkTextInNameInput(VALID_NAME)
                .checkTextInTelephoneInput("+38 (063) 047 47 73") // не працює Actual   :+38 (___) ___ __ __ при включеному дебаг все ок
        ;

    }
}
