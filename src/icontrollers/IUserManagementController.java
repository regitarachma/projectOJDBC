package icontrollers;

/**
 *
 * @author RR17
 */
public interface IUserManagementController {
    public String login(String username, String password);

    public String insert(String username, String password);

    public String change(String username, String password, String newpassword, String r_password);
    
}
