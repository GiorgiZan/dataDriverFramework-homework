package Steps;

import Pages.RegistrationPage;
import io.qameta.allure.Step;

public class RegistartionPageSteps {
    RegistrationPage registrationPage =new RegistrationPage();


    @Step
    public RegistartionPageSteps fillRegistrationFirstName(String firstName) {
        registrationPage.firstNameInput.setValue(firstName);
        return this;
    }
    @Step
    public RegistartionPageSteps fillRegistrationLastName(String lastName) {
        registrationPage.lastNameInput.setValue(lastName);
        return this;
    }
    @Step
    public RegistartionPageSteps fillRegistrationPhone(String userNumber) {
        registrationPage.userNumberInput.setValue(userNumber);
        return this;
    }


}
