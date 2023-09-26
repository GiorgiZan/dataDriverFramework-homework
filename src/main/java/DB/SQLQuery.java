package DB;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class SQLQuery {



    public static void insertStudent(int id, String firstName, String lastName, String phone, boolean mode) {

        try (Connection connection = DbConnection.getConnection()){
            connection.setAutoCommit(mode);
            String insertQuery = "INSERT INTO students (id, firstname, lastname, phone) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, phone);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected != 1) {
                throw new RuntimeException("Insert operation failed");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error inserting student: " + e.getMessage());
        }

    }

    public static boolean isStudentInTable(int id, String firstName, String lastName, String phone) {

        try (Connection connection = DbConnection.getConnection()){
            String selectQuery = "SELECT * FROM students WHERE id = ? AND firstname = ? AND lastname = ? AND phone = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, phone);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            throw new RuntimeException("Error querying the database: " + e.getMessage());
        }
    }

    public static void updateFirstName(int id, String newFirstName, boolean mode) {
        try(Connection connection = DbConnection.getConnection()) {
            connection.setAutoCommit(mode);
            String updateQuery = "UPDATE students SET firstname = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setString(1, newFirstName);
            preparedStatement.setInt(2, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected != 1) {
                throw new RuntimeException("Update operation failed");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error updating student: " + e.getMessage());
        }
    }
}

