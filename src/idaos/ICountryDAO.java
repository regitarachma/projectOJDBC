package idaos;

import java.util.List;
import models.Country;

public interface ICountryDAO {
    public List<Country> getAll();

    public List<Country> getById(String id);

    public List<Country> search(String key);

    public boolean insert(Country c);

    public boolean update(Country c);

    public boolean delete(String id);
    
}
