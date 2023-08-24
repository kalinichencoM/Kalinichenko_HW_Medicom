package searchDoctor;

import baseTest.BaseTest;
import org.junit.Test;

import static testData.TestData.*;

public class FindAllDoctorByDepartmant extends BaseTest {

    @Test
    public void FindAllDoctorByDepartmant() {
pageProvider.getHomePage()
        .openHomePage()
        .getHeader()
        .getChildrenPage()
        .checkIsRedirectToChildrenPage()
        .clickOphthalmologist()
        .checkIsRedirectToDetskayaOphthalmologiyaPage()
        .checkAllDoctorByDepartmant(LIST_VALID_DOCTOR_OCHI)
        ;
    }
}
