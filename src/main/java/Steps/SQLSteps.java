package Steps;

import DB.SQLQuery;
import io.qameta.allure.Step;
import org.testng.Assert;



public class SQLSteps {


        @Step
        public void testInsertStudent(int id, String fName, String lName, String phone, boolean mode) {
            SQLQuery.insertStudent(id, fName, lName, phone, mode);
        }

        @Step
        public void doesStudentExist(int id, String fName, String lName, String phone){
            boolean studentExists = SQLQuery.isStudentInTable(id, fName, lName, phone);
            Assert.assertTrue(studentExists, "Student was not created");
        }
        @Step
        public void updateStudentFirstName(int id, String fName, boolean mode) {
            SQLQuery.updateFirstName(id, fName, mode);

        }

}
