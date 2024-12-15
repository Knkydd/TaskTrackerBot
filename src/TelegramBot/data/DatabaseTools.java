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
        String insertRegistration = String.format("INSERT INTO %s(%s, %s) VALUES(%s, '%s')",
                ConstantDB.TABLE_USERS, ConstantDB.USER_ID, ConstantDB.USER_NAME, chatID, username);
        try (Statement statement = dbConnection.createStatement()) {
            statement.executeUpdate(insertRegistration);
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
        ResultSet resultSet = null;
        String getterResources = String.format("SELECT * FROM %S WHERE %s=%s", ConstantDB.TABLE_RESOURCES, ConstantDB.USER_ID, chatID);
        try (Statement statement = dbConnection.createStatement()) {
            resultSet = statement.executeQuery(getterResources);
            while (resultSet.next()) {
                resources.put("Wood", resultSet.getInt("Wood"));
                resources.put("Gold", resultSet.getInt("Gold"));
                resources.put("Food", resultSet.getInt("Food"));
                resources.put("Stone", resultSet.getInt("Stone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resources;
    }

    public void setResources(long chatID, Map<String, Integer> resources) {
        String insertResources = String.format("UPDATE %s SET %s=%s, %s=%s, %s=%s, %s=%s, WHERE %s=%s",
                ConstantDB.TABLE_RESOURCES, ConstantDB.USER_GOLD, resources.get("Gold"), ConstantDB.USER_WOOD, resources.get("Wood"),
                ConstantDB.USER_FOOD, resources.get("Food"), ConstantDB.USER_STONE, resources.get("Stone"), ConstantDB.USER_ID, chatID);
        try (Statement statement = dbConnection.createStatement()) {
            statement.executeQuery(insertResources);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Map<String, Integer> getLeaderboard() {
        ResultSet resultSet = null;
        String getterUsername = String.format("SELECT %s FROM %s", ConstantDB.USER_NAME, ConstantDB.TABLE_USERS);
        String getterArmyPower = String.format("SELECT %s FROM %s", ConstantDB.USER_ARMY_POWER, ConstantDB.TABLE_ARMY);
        List<String> names = new ArrayList<>();
        int i = 0;
        Map<String, Integer> leaderboard = new HashMap<>();
        try (Statement statement = dbConnection.createStatement()) {
            resultSet = statement.executeQuery(getterUsername);
            while (resultSet.next() && i != 6) {
                names.add(resultSet.getString("username"));
                i++;
            }
            resultSet = statement.executeQuery(getterArmyPower);
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

    public Map<String, Integer> getArmy(long chatID) {
        Map<String, Integer> army = new HashMap<>();
        ResultSet resultSet = null;
        String getterArmy = String.format("SELECT * FROM % WHERE %s=%s", ConstantDB.TABLE_ARMY, ConstantDB.USER_ID, chatID);
        try (Statement statement = dbConnection.createStatement()) {
            resultSet = statement.executeQuery(getterArmy);
            while (resultSet.next()) {
                army.put(ConstantDB.USER_UNIT_1, resultSet.getInt("unit1"));
                army.put(ConstantDB.USER_UNIT_2, resultSet.getInt("unit2"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return army;
    }

    public void setArmy(long chatID, Map<String, Integer> army) {
        String insertArmy = String.format("UPDATE % SET %s=%s, %s=%s WHERE %s=%s",
                ConstantDB.TABLE_ARMY, ConstantDB.USER_UNIT_1, army.get("unit1"), ConstantDB.USER_UNIT_2, army.get("unit2"), ConstantDB.USER_ID, chatID);
        try (Statement statement = dbConnection.createStatement()) {
            statement.executeQuery(insertArmy);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Map<String, Integer> getBuilds(long chatID) {
        Map<String, Integer> builds = new HashMap<>();
        ResultSet resultSet = null;
        String getterBuilds = String.format("SELECT * FROM %s WHERE %s=%s", ConstantDB.TABLE_BUILDS, ConstantDB.USER_ID, chatID);
        try (Statement statement = dbConnection.createStatement()) {
            resultSet = statement.executeQuery(getterBuilds);
            while (resultSet.next()) {
                builds.put("unit1", resultSet.getInt("unit1"));
                builds.put("unit2", resultSet.getInt("unit2"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return builds;
    }
}
