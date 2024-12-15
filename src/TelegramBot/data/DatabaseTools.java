package TelegramBot.data;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseTools extends Config {
    private final Connection dbConnection;

    public DatabaseTools(Connection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public void registrationUser(long chatID, String username) {
        String registrationString = String.format("INSERT INTO %s(%s, %s) VALUES(%s, '%s')",
                ConstantDB.TABLE_USERS, ConstantDB.USER_ID, ConstantDB.USER_NAME, chatID, username);
        try (Statement statement = dbConnection.createStatement()) {
            statement.executeUpdate(registrationString);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean isRegistered(long chatID) {
        ResultSet result = null;
        String regString = String.format("SELECT %s FROM %s where %s=%s", ConstantDB.USER_ID, ConstantDB.TABLE_USERS, ConstantDB.USER_ID, chatID);
        try (Statement statement = dbConnection.createStatement()) {
            result = statement.executeQuery(regString);
            if (result.next()) {
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

    public Map<String, Integer> getLeaderboard() {
        ResultSet resultSet = null;
        String res = String.format("SELECT %s FROM %s", ConstantDB.USER_NAME, ConstantDB.TABLE_USERS);
        String res1 = String.format("SELECT %s FROM %s", ConstantDB.USER_ARMY_POWER, ConstantDB.TABLE_ARMY);
        List<String> names = new ArrayList<>();
        int i = 0;
        Map<String, Integer> leaderboard = new HashMap<>();
        try (Statement statement = dbConnection.createStatement()) {
            resultSet = statement.executeQuery(res);
            while (resultSet.next() && i != 6) {
                names.add(resultSet.getString("username"));
                i++;
            }
            resultSet = statement.executeQuery(res1);
            while (resultSet.next() && i != 6) {
                leaderboard.put(names.getFirst(), resultSet.getInt("armyPower"));
                names.removeFirst();
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return leaderboard;
    }
}
