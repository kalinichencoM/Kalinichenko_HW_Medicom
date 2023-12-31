package searchDoctor;

import baseTest.BaseTest;
import libs.ExcelDriver;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

import static libs.ConfigProvider.configProperties;
import static testData.TestData.*;

public class FindAllDoctotsByFilter_doctors_klinicks_spec extends BaseTest {

    @Test
    public void findAllDoctotsByFilter_doctors_klinicks_spec() throws IOException {
        Map<String, String> dataToSelect = ExcelDriver.getData(configProperties.DATA_FILE(), "FilterForDoctor");
        String clinic = dataToSelect.get("clinic");
        String doctor = dataToSelect.get("doctor");
        String specialization = dataToSelect.get("specialization");
        pageProvider.getHomePage()
                .openHomePage()
                .getHeader()
                .clickOnButtonSearchDoctor()
                .checkIsRedirectToAllDoctorsPage()
                .selectSpecialization(specialization)
                .selectProf(doctor)
                .selectClinic(clinic)
                .checkAllDoctorName(LIST_VALID_DOCTOR_UZI)
        ;
    }
}
