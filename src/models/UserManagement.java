package models;

/**
 *
 * @author RR17
 */
public class UserManagement {
    private int id;
    private String username;
    private String password;

    public UserManagement() {
    }

    public UserManagement(String username, String password) {
        this.username = username;
        this.password = password;
    }
     
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
              
}