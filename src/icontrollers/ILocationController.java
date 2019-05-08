package icontrollers;
import java.util.List;
import javax.swing.JTextField;
import models.Location;
/**
 *
 * @author RR17
 */
public interface ILocationController {
    
    public List<Location> getAll();
    public List<Location> getById(String id);
    public List<Location> search(String key);
    
    public String save(String id, String street, String postal, String city, String state, String countryId);
    
    public String delete(String id);
    
//    public List<Location> getAll();
//
//    public List<Location> getById(String id);
//
//    public List<Location> search(String key);

//    public String insert(String id, String street, String postal, String city, String state, String countryId);
//
//    public String update(String id, String street, String postal, String city, String state, String countryId);

}
