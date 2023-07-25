package service;

import dao.DbContext;
import model.Role;
import model.User;
import untils.PasswordUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService extends DbContext implements IUserService {

    private static final String SQL_FIND_USERNAME = "SELECT * FROM user WHERE name = ?";

    @Override
    public User findUserByUserName(String name){
        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_FIND_USERNAME);
            ps.setString(1, name );
            System.out.println("findUserByUserName: " + ps);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                long idDB = rs.getLong("id");
                String usernameDB = rs.getString("name");
                String passwordDB = rs.getString("password");
                String email = rs.getString("email");
                String fullname = rs.getString("fullname");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                String strRole = rs.getString("role");
                Role role = Role.valueOf(strRole);
                return new User(idDB, usernameDB, passwordDB, email, fullname, phone,address,role);
            }
        } catch (SQLException sqlException) {
            printSQLException(sqlException);
        }
        return null;
    }

    @Override
    public void createUser(User user) {
        try {
            Connection connection = getConnection();

            String strPass = PasswordUtils.hashPassword(user.getPassword());
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `user` (`name`, `password`) VALUES (?, ?)");

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, strPass);

            System.out.println("createUser: " +  preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            printSQLException(sqlException);
        }
    }

    @Override
    public void updateUser(long id, User user) {
        try{
            Connection connection =getConnection();
//
            PreparedStatement pr = connection.prepareStatement("UPDATE `user` SET `fullname` = ?, `email` = ?, `phone` = ?, `address` = ? WHERE `id` = ?");
            pr.setString(1, user.getFullname());
            pr.setString(2, user.getEmail());
            pr.setString(3, user.getPhone());
            pr.setString(4,user.getAddress());
            pr.setLong(5, id);
            System.out.println("update: " + pr);
            pr.executeUpdate();
            connection.close();
        }catch (SQLException e){
            printSQLException(e);
        }
    }
    public User findUserById(long id) {
        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM user WHERE `id` like ?");
            ps.setLong(1, id );
            System.out.println("findUserById: " + ps);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
//                int idDB = rs.getInt("id");
                String usernameDB = rs.getString("name");
                String passwordDB = rs.getString("password");
                String fullname = rs.getString("fullname");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String role = rs.getString("role");
                Role role1 = Role.valueOf(role);
//                return new User(usernameDB, passwordDB, eRole);
                return new User(id, usernameDB, passwordDB, fullname, email, phone, role1);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }

    @Override
    public void updatePassword(long id, User user){
        try{
            Connection connection = getConnection();
            String strPass = PasswordUtils.hashPassword(user.getPassword());
            PreparedStatement pr = connection.prepareStatement("UPDATE `user` SET `password` = ? WHERE `id` = ?");
            pr.setString(1, strPass);
            pr.setLong(2, id);
            System.out.println("updatePassword: " + pr);
            pr.executeUpdate();
            connection.close();
        }catch (SQLException e){
            printSQLException(e);
        }
    }
}
