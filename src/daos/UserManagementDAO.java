package daos;

import java.sql.Connection;
import java.awt.List;
import idaos.IUserManagementDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import models.UserManagement;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author RR17
 */
public class UserManagementDAO implements IUserManagementDAO{
    private Connection connection;
    
    public UserManagementDAO (Connection connection){
        this.connection = connection;
    }

    @Override
    public java.util.List<UserManagement> getByUser(UserManagement u) {
        java.util.List<UserManagement> listUser = new ArrayList<UserManagement>();
        String query = "SELECT * FROM USER_MANAGEMENT WHERE username=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, u.getUsername());
            preparedStatement.executeQuery();
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                UserManagement us = new UserManagement(resultSet.getString(2), resultSet.getString(3));
                listUser.add(us);
             //   result = BCrypt.checkpw(u.getPassword(), us.getPassword());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listUser;
    }

    @Override
    public boolean update(UserManagement u) {
        boolean result = false;
        String query = "UPDATE USER_MANAGEMENT SET password=(?) WHERE username=(?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, u.getPassword());
            preparedStatement.setString(2, u.getUsername());
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean insert(UserManagement u) {
        boolean result = false;
        String query = "INSERT INTO USER_MANAGEMENT(name, username, password) VALUES ((?),(?),(?))";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, u.getUsername());
            preparedStatement.setString(2, u.getPassword());
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    
}
