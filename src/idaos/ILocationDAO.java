package idaos;

import java.util.List;
import models.Location;

/**
 *
 * @author RR17
 */
public interface ILocationDAO {
    
    public List<Location> getData(Object key, boolean isGetById);
    
    public boolean save(Location l);
    
    public boolean delete(int id);
    
//    public List<Location> getAll();
//
//    public List<Location> getById(int id);
//
//    public List<Location> search(String key);
    
//    public boolean insert(Location l);
//
//    public boolean update(Location l);
    
}
