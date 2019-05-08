package daos;

import java.sql.Connection;
import java.awt.List;
import idaos.IUserManagementDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    public boolean register(UserManagement um) {
        boolean result = false;
        String query = "INSERT INTO USER_MANAGEMENT (user_name, password) VALUES ((?), (?))";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, um.getUsername());
            preparedStatement.setString(2, BCrypt.hashpw(um.getPassword(), BCrypt.gensalt()));
            preparedStatement.executeQuery();            
            result =  true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean login(UserManagement um) {       
        boolean result = false;
        //query
        String query = "SELECT * FROM USER_MANAGEMENT WHERE user_name = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            
            //pemanggilan username dari query, 1 menandakan tandatanyanya
            preparedStatement.setString(1, um.getUsername());
            
            //proses query dieksekusi
            preparedStatement.executeQuery();           
            
            //resultset untuk melakukan kegiatan berhubungan dgn data dari database
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                //resultset.getString(1) menunjukkan kolom pada tabel
                UserManagement u = new UserManagement(resultSet.getString(2), resultSet.getString(3));
//                System.out.println(u.getPassword());
//                System.out.println(u.getUsername());
                
                //proses untuk cek password dengan memanggil inputan Password dan hash password dari database
                result = BCrypt.checkpw(um.getPassword(), u.getPassword());                     
            }              
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    @Override
    public boolean updatePass(UserManagement u) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        boolean result = false;
        String query = "UPDATE USER_MANGEMENT SET password = (?)";      
        if (login(u)) {
            
        }        
        return false;
    }
    
    
}
