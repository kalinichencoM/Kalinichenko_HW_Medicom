package searchDoctor;

import baseTest.BaseTest;
import org.junit.Test;

import static testData.TestData.*;

public class SearchDoctor extends BaseTest {

    @Test
    public void searchDoctor() {
        pageProvider.getHomePage().getHeader().clickOnButtonSearchDoctor();
        pageProvider.getDoctorsPageAll().enterDoctorName(VALID_DOCTOR_OCHI_1);


    }
}
