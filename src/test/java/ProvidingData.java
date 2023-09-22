
import DB.DbCustomer;
import org.testng.annotations.DataProvider;

import java.util.List;
import java.util.Map;

public class ProvidingData {

    @DataProvider(name = "customerData")
        public Object[][] provideCustomerData() {
          List<Map<String, String>> customerDataList = DbCustomer.fetchCustomerData();

        Object[][] customerData = new Object[customerDataList.size()][1];
        for (int i = 0; i < customerDataList.size(); i++) {
            customerData[i][0] = customerDataList.get(i);
        }

        return customerData;
    }
}
