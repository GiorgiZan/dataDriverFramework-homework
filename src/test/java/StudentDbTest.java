import DB.DbConnection;
import DB.DbCustomer;
import DB.SQLQuery;
import Data.SQLData;
import Steps.SQLSteps;

import org.testng.annotations.*;


public class StudentDbTest {
    SQLSteps sqlSteps = new SQLSteps();
    SQLData sqlData = new SQLData();


@Test
public void test(){
    System.out.println("before inserting there were: " + DbCustomer.fetchCustomerData().size() + " rows");
    //Insert in database students new row (with  autocommit false mode )
    sqlSteps.testInsertStudent(sqlData.studentId, sqlData.studentFirstName, sqlData.studentLastName, sqlData.studentPhone, false);
    //Validate that row wasn't created
    System.out.println("number of rows now: " + DbCustomer.fetchCustomerData().size() + "  new row wasn't created");

    //Insert in database students new row with commit()
    sqlSteps.testInsertStudent(sqlData.studentId, sqlData.studentFirstName, sqlData.studentLastName, sqlData.studentPhone, true);

    //Validate all the values of inserted row using TestNG (assertion in step class)
    sqlSteps.doesStudentExist(sqlData.studentId, sqlData.studentFirstName, sqlData.studentLastName, sqlData.studentPhone);
    System.out.println("number of rows now: " + DbCustomer.fetchCustomerData().size() + "  new row was created");
    //Update firstName of added student
    sqlSteps.updateStudentFirstName(1004, sqlData.newStudenFirstName, true);
    //Validate updated firstName using TestNG (assertion in step class)
    sqlSteps.doesStudentExist(sqlData.studentId, sqlData.newStudenFirstName, sqlData.studentLastName, sqlData.studentPhone);


}




}