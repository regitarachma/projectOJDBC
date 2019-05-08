package icontrollers;

/**
 *
 * @author RR17
 */
public interface IUserManagementController {
    public boolean login(String user_name, String password);
    public String register(String user_name, String password);
    
}
