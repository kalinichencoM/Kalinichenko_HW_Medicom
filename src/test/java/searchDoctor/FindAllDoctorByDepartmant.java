package searchDoctor;

import baseTest.BaseTest;
import org.junit.Test;

public class FindAllDoctorByDepartmant extends BaseTest {

    @Test
    public void FindAllDoctorByDepartmant() {
pageProvider.getHomePage()
        .openHomePage()
        .getHeader()
        .getChildrenPage()
        .checkIsRedirectToChildrenPage()
        .clickOphthalmologist();
    }
}
