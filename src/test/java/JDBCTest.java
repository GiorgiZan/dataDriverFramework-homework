import Steps.RegistartionPageSteps;
import org.testng.annotations.Test;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;

public class JDBCTest extends SelenideConfig{
    RegistartionPageSteps registartionPageSteps = new RegistartionPageSteps();



    @Test(dataProvider = "customerData", dataProviderClass = ProvidingData.class)
    public void fillFormWithCustomerInfo(Map<String, String> customerInfo) {
        open("https://demoqa.com/automation-practice-form");


        registartionPageSteps.fillRegistrationFirstName( customerInfo.get("name"))
                .fillRegistrationLastName(customerInfo.get("lastname"))
                .fillRegistrationPhone( customerInfo.get("Phone"));


    }
}


