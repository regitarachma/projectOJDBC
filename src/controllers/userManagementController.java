package controllers;

import daos.UserManagementDAO;

import icontrollers.IUserManagementController;
import idaos.IUserManagementDAO;
import java.sql.Connection;
import java.util.List;
import models.UserManagement;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author RR17
 */
public class userManagementController implements IUserManagementController{
    private IUserManagementDAO iumdao;
    
    public userManagementController(Connection connection){
        iumdao = new UserManagementDAO(connection);
    }

    
    @Override
    public String insert(String username, String password) {
        String result = "Maaf Gagal Mendaftar";
        UserManagement user = new UserManagement(username, password);
        if (iumdao.insert(user)) {
            BCrypt.hashpw(password, BCrypt.gensalt());
            result = "Berhasil Register";
        }
        return result;
    }

//    @Override
//    public boolean save(String name, String username, String password) {
//        return iudao.save(new User(name, username, password));
//    }
    @Override
    public String login(String username, String password) {
        String result = "Gagal Login";
        UserManagement user = new UserManagement(username, password);
        List<UserManagement> u = iumdao.getByUser(user);
        if (BCrypt.checkpw(password, u.get(0).getPassword())) {
            result = "Berhasil Login";
        }
        return result;
    }

    @Override
    public String change(String username, String password, String newpassword, String r_password) {
        String result = "Maaf Gagal Ganti Password";
        UserManagement um = new UserManagement(username, password);
        if (newpassword.equals(r_password)) {
            List<UserManagement> user = iumdao.getByUser(um);
            if (BCrypt.checkpw(newpassword, user.get(0).getPassword())) {
                if (iumdao.update(um)) {
                    BCrypt.hashpw(newpassword, BCrypt.gensalt());
                    result = "Ganti Password Berhasil ";
                }
                result = "Maaf Gagal Ganti Password";
            }
            result = "Username atau Password Salah";
        } else {
            result = "Pasword Tidak Sama";
        }
        return result;
    }
    
//    @Override
//    public boolean updatePass(String user_name, String password) {
//        return iumdao.updatePass(new UserManagement(user_name, password));
//    }
}
