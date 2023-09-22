package DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DbCustomer {
    public static List<Map<String, String>> fetchCustomerData() {
        List<Map<String, String>> customerDataList = new ArrayList<>();

        try (Connection connection = DbConnection.getConnection();
             Statement statement = connection.createStatement()) {

            String query = "SELECT firstName, lastName, phone FROM students";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Map<String, String> customerInfo = new HashMap<>();
                customerInfo.put("name", resultSet.getString("firstName"));
                customerInfo.put("lastname", resultSet.getString("lastName"));
                customerInfo.put("Phone", resultSet.getString("phone"));
                customerDataList.add(customerInfo);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error while fetching customer data", e);
        }

        return customerDataList;
    }

}
