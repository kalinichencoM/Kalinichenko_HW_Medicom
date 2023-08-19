package searchDoctor;

import baseTest.BaseTest;
import org.junit.Test;

import static testData.TestData.*;

public class SearchDoctor extends BaseTest {

    @Test
    public void searchDoctor() {
        pageProvider.getHomePage()
                .openHomePage()
                .getHeader()
                .clickOnButtonSearchDoctor()
                .checkIsRedirectToAllDoctorsPage()
        ;
        pageProvider.getDoctorsPageAll()
                .enterDoctorName(VALID_DOCTOR_OCHI_1)
                .clickOnButtonSearchDoctor(VALID_DOCTOR_OCHI_1)
                .checkIsButtonSearchDoctorVisible()
        ;
    }
}
