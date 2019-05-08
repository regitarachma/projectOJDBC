
package idaos;

import models.UserManagement;

/**
 *
 * @author RR17
 */
public interface IUserManagementDAO {
    public boolean register(UserManagement um);
    
    public boolean login(UserManagement um);
    public boolean updatePass(UserManagement um);
}
