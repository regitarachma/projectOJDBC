package controllers;
import daos.LocationDAO;
import icontrollers.ILocationController;
import idaos.ILocationDAO;
import java.sql.Connection;
import java.util.List;
import javax.swing.JTextField;
import models.Location;
/**
 *
 * @author RR17
 */
public class LocationController implements ILocationController{
    private ILocationDAO ildao;
    
     public LocationController(Connection connection){
        ildao = new LocationDAO(connection);
    }
    
    @Override
    public List<Location> getAll() {
        return ildao.getData("", false);
    }

    @Override
    public List<Location> getById(String id) {       
        return ildao.getData(Integer.parseInt(id), true);
    }

    @Override
    public List<Location> search(String key) {        
         return ildao.getData(key,false);
    }
    
    @Override
    public String save(String id, String street, String postal, String city, String state, String countryId) {
        String result = "Maaf data gagal disimpan";
        Location location = new Location(Integer.parseInt(id), street, postal, city, state, countryId);
        if (ildao.save(location)) {
            result = "Data berhasil disimpan";
        }
        return result;
    }
    
    @Override
    public String delete(String id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String result = "Maaf data gagal dihapus";
        if (ildao.delete(Integer.parseInt(id))) {
            result = "Data berhasil dihapus";
        } else {
            
        }
        return result;
    }

//    @Override
//    public String insert(String id, String street, String postal, String city, String state, String countryId) {
//        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        String result = "Maaf data gagal disimpan";
//        Location location = new Location(Integer.parseInt(id), street, postal, city, state, countryId);
//        if (ildao.insert(location)) {
//            result = "Data berhasil disimpan";
//        }
//        return result;
//    }
//
//    @Override
//    public String update(String id, String street, String postal, String city, String state, String countryId) {
//        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        String result = "Maaf data gagal disimpan";
//        Location location = new Location(Integer.parseInt(id), street, postal, city, state, countryId);
//        if (ildao.update(location)) {
//            result = "Data berhasil diupdate";
//        }
//        return result;
//    }
    
}
