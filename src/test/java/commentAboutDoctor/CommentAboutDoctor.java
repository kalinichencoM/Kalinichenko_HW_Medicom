package commentAboutDoctor;

import baseTest.BaseTest;
import libs.ExcelDriver;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

import static libs.ConfigProvider.configProperties;
import static testData.TestData.*;


public class CommentAboutDoctor extends BaseTest {
    private final String comment = "004 Kalinichenko " + libs.Util.getDateAndTimeFormatted();
    private final String VALID_NAME = "Kalinichenko";
    private final String VALID_TELEPHONE = "0630474773";

    @Test
    public void invalidCommentAboutDoctor() throws IOException {
        Map<String, String> dataToSelect = ExcelDriver.getData(configProperties.DATA_FILE(), "ErrorComment");
        String telephon = dataToSelect.get("error_telephon");
        String name = dataToSelect.get("error_name");
        String star = dataToSelect.get("error_star");
        pageProvider.getHomePage()
                .openHomePage()
                .getHeader()
                .clickOnButtonSearchDoctor()
                .checkIsRedirectToAllDoctorsPage()
                .enterDoctorName(VALID_DOCTOR_UZD_1)
                .checkIsButtonSearchDoctorVisible()
                .clickOnButtonSearchDoctor(VALID_DOCTOR_UZD_1)
                .clickOnImageDoctor(VALID_DOCTOR_UZD_1)
                .checkIsRedirectToSingleDoctorPage()
                .checkDoctorName(VALID_DOCTOR_UZD_1)
        ;
        pageProvider.getSingleDoctorPage()
                .clickOnButtonComment()
                .checkIsRedirectToCommentPage()
                .enterComment(comment)
                .checkStatusCheckBoxCommentPage("check")
                .clickOnButtonSubmit()
                .checkErrorMessageTeelphone(telephon)
                .checkErrorMessageName(name)
                .checkErrorMessageStar(star)
        ;
    }
}
