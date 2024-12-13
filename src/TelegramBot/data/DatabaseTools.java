package TelegramBot.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseTools extends Config {
    private final Connection dbConnection;

    public DatabaseTools(Connection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public void registrationUser(long chatID, String username) {
        String registrationString = String.format("INSERT INTO %s(%s, %s) VALUES (%s, '%s')", ConstantDB.TABLE_USERS, ConstantDB.USER_ID, ConstantDB.USER_NAME, chatID, username);
        try (Statement statement = dbConnection.createStatement()) {
            statement.executeUpdate(registrationString);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean isRegistered(long chatID) {
        ResultSet result = null;
        boolean res;
        String regString = String.format("SELECT %s FROM %s where %s=%s", ConstantDB.USER_ID, ConstantDB.TABLE_USERS, ConstantDB.USER_ID, chatID);
        try (Statement statement = dbConnection.createStatement()) {
            result = statement.executeQuery(regString);
            res = result.next();
            if (res){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


}
