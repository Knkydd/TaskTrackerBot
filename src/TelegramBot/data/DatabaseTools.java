package TelegramBot.data;

import TelegramBot.utility.keyboard.ConstantKB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class DatabaseTools extends Config {
    private final Connection dbConnection;

    public DatabaseTools(Connection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public void registrationUser(long chatID, String username) {
        String registrationString = String.format("BEGIN; INSERT INTO %s(%s, %s) VALUES (%s, '%s'); " +
                        "INSERT INTO %s(%s, %s, %s, %s) VALUES (%s, %s, %s, %s); " +
                        "INSERT INTO %s(%s, %s, %s, %s) VALUES (%s, %s, %s, %s); " +
                        "INSERT INTO %s(%s, %s, %s) VALUES (%s, %s, %s); " +
                        "COMMIT;",
                ConstantDB.TABLE_USERS, ConstantDB.USER_ID, ConstantDB.USER_NAME, chatID, username,
                ConstantDB.TABLE_RESOURCES, ConstantDB.USER_ID, ConstantDB.USER_FOOD, ConstantDB.USER_WOOD, ConstantDB.USER_GOLD, chatID, 10, 15, 20,
                ConstantDB.TABLE_ARMY, ConstantDB.USER_ID, ConstantDB.USER_ARMY_POWER, ConstantDB.USER_UNIT_1, ConstantDB.USER_UNIT_2, chatID, 1, 1, 1,
                ConstantDB.TABLE_BUILDS, ConstantDB.USER_ID, ConstantDB.USER_BUILD1, ConstantDB.USER_BUILD2, chatID, 1, 1);
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
            if (res) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Map<String, Integer> getResources(long chatID) {
        Map<String, Integer> resources = new HashMap<>();
        ResultSet result = null;
        String resourcesString = String.format("SELECT * FROM %S WHERE %s=%s", ConstantDB.TABLE_RESOURCES, ConstantDB.USER_ID, chatID);
        try (Statement statement = dbConnection.createStatement()) {
            result = statement.executeQuery(resourcesString);
            while (result.next()) {
                resources.put("Wood", result.getInt("Wood"));
                resources.put("Gold", result.getInt("Gold"));
                resources.put("Food", result.getInt("Food"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resources;
    }

}
