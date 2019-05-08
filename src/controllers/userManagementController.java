package controllers;

import daos.UserManagementDAO;
import icontrollers.IUserManagementController;
import idaos.IUserManagementDAO;
import java.sql.Connection;
import models.UserManagement;

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
    public boolean login(String user_name, String password) {
        return iumdao.login(new UserManagement(user_name, password));
    }

    @Override
    public String register(String user_name, String password) {
        String result = "Maaf data gagal disimpan";
        UserManagement um = new UserManagement(user_name, password);
        if (iumdao.register(um)) {
            result = "Data berhasil disimpan";
        }
        return result;
    }
    
//    @Override
//    public boolean updatePass(String user_name, String password) {
//        return iumdao.updatePass(new UserManagement(user_name, password));
//    }
}
