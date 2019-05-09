
package idaos;

import java.util.List;
import models.UserManagement;

/**
 *
 * @author RR17
 */
public interface IUserManagementDAO {
    public boolean insert(UserManagement u);
    public List<UserManagement> getByUser(UserManagement u);
    public boolean update(UserManagement u);
}
