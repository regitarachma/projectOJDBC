package icontrollers;

import java.util.List;
import models.Country;

public interface ICountryController {

    public List<Country> getAll();

    public List<Country> getById(String id);

    public List<Country> search(String key);

    public String insert(String id, String name, String region);

    public String update(String id, String name, String region);

    public String delete(String id);
    
    
}
