package commentAboutDoctor;

import baseTest.BaseTest;
import org.junit.Test;

import static testData.TestData.*;


public class CommentAboutDoctor extends BaseTest {
    private final String comment = "004 Kalinichenko " + libs.Util.getDateAndTimeFormatted();
    private final String VALID_NAME = "Kalinichenko";
    private final String VALID_TELEPHONE = "0630474773";

    @Test
    public void commentAboutDoctor() {
        pageProvider.getHomePage()
                .openHomePage()
                .getHeader()
                .clickOnButtonSearchDoctor()
                .checkIsRedirectToAllDoctorsPage()
                .enterDoctorName(VALID_DOCTOR_UZD_1)
                .checkIsButtonSearchDoctorVisible()
                .clickOnButtonSearchDoctor(VALID_DOCTOR_UZD_1)
                .clickOnImageDoctor()
                .checkIsRedirectToSingleDoctorPage()
                .checkDoctorName(VALID_DOCTOR_UZD_1)
        ;
        pageProvider.getSingleDoctorPage()
                .clickOnButtonComment()
                .checkIsRedirectToCommentPage()
                .enterComment(comment)
                .enterNameSername(VALID_NAME)
                .enterTelephone(VALID_TELEPHONE)
                .checkStatusCheckBoxCommentPage("check")
                //.clickOnButtonSubmit()
                .checkIsRedirectToSingleDoctorPage()
        ;
        pageProvider.getCommentPage()
//                .checkComment(comment)
//                .checkNameSername(VALID_NAME)
//                .checkTelephone(VALID_TELEPHONE)
                .checkStatusCheckBoxCommentPage("check")
        ;
    }
}
