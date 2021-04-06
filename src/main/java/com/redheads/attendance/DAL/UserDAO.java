/**
 * @author kjell
 */

package com.redheads.attendance.DAL;

import com.redheads.attendance.BE.User;
import com.redheads.attendance.Utils.db.DBConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {

    private DBConnector dbConnector;

    public UserDAO() {
        dbConnector = new DBConnector();
    }

    @Override
    public List<User> getUsers() {
        ArrayList<User> allUsers = new ArrayList<>();

        try (Connection connection = dbConnector.getConnection()) {
            String sql = "SELECT * FROM User;";
            Statement statement = connection.createStatement();

            if (statement.execute(sql)) {
                ResultSet resultSet = statement.getResultSet();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String username = resultSet.getString("Username");
                    String name = resultSet.getString("FirstName") + resultSet.getString("LastName");
                    boolean isStudent = resultSet.getBoolean("IsStudent");
                    String course = resultSet.getString("Course");
                    float absence = resultSet.getFloat("Absence");

                    User.UserType userType = User.UserType.TEACHER;

                    if(isStudent)
                        userType = User.UserType.STUDENT;

                    User user = new User(id, username, name, course, absence, userType);
                    allUsers.add(user);
                }
            }

        } catch (SQLException e) {
            // throw new UserException("Could not connect to database", e);
            e.printStackTrace();
        }

        return allUsers;
    }

    @Override
    public List<User> getStudents() {
        ArrayList<User> allStudents = new ArrayList<>();

        try (Connection connection = dbConnector.getConnection()) {
            String sql = "SELECT * FROM User WHERE IsStudent = true;";
            Statement statement = connection.createStatement();

            if (statement.execute(sql)) {
                ResultSet resultSet = statement.getResultSet();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String username = resultSet.getString("Username");
                    String name = resultSet.getString("FirstName") + resultSet.getString("LastName");
                    String course = resultSet.getString("Course");
                    float absence = resultSet.getFloat("Absence");

                    User user = new User(id, username, name, course, absence, User.UserType.STUDENT);
                    allStudents.add(user);
                }
            }

        } catch (SQLException e) {
            // throw new UserDAOException("Could not connect to database", e);
            e.printStackTrace();
        }

        return allStudents;
    }

    @Override
    public float getUserAbsence(User user) {
        float absence = 0;
        try (Connection connection = dbConnector.getConnection()) {
            String sql = "SELECT Absence FROM User WHERE ID=?;";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, user.getId());
            statement.execute();

            if (statement.execute(sql)) {
                ResultSet resultSet = statement.getResultSet();

                while (resultSet.next()) {
                    absence = resultSet.getFloat("Absence");

                }
            }

        } catch (SQLException e) {
            //throw new UserDAOException("Could not connect to database", e); TODO: MAKE CUSTOM EXCEPTION
            e.printStackTrace();
        }

        return absence;
    }

    @Override
    public void updateAttendance(User user, float newAbsence) {
        try(Connection connection = dbConnector.getConnection()) {
            String sql = "UPDATE User SET Absence=? WHERE ID=?";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setFloat(2, newAbsence);
            statement.setInt(2, user.getId());
            statement.execute();

        } catch (SQLException e) {
            //throw new UserDAOException("Could not connect to database", e); TODO: MAKE CUSTOM EXCEPTION
        }
    }

}
