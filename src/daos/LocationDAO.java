package daos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import idaos.ILocationDAO;
import models.Location;
/**
 *
 * @author RR17
 */
public class LocationDAO implements ILocationDAO{
    private Connection connection;
    
    public LocationDAO (Connection connection){
        this.connection = connection;
    }

//    @Override
//    public List<Location> getAll() {
//        List<Location> listlocation  = new ArrayList<Location>();
//        String query = "SELECT * FROM LOCATIONS";
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()){
//                Location l = new Location(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6));
//                l.setId(resultSet.getInt(1));
//                l.setStreet(resultSet.getString(2));
//                l.setPostal(resultSet.getString(3));
//                l.setCity(resultSet.getString(4));
//                l.setState(resultSet.getString(5));
//                l.setCountry_id(resultSet.getString(6));
//                listlocation.add(l);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }return listlocation;
//    }
//
//    @Override
//    public List<Location> getById(int id) {
//        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        List<Location> listlocation  = new ArrayList<Location>();
//        String query = "SELECT * FROM LOCATIONS WHERE location_id = ?";
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setInt(1, id);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()){
//                Location l = new Location(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6));
//                l.setId(resultSet.getInt(1));
//                l.setStreet(resultSet.getString(2));
//                l.setPostal(resultSet.getString(3));
//                l.setCity(resultSet.getString(4));
//                l.setState(resultSet.getString(5));
//                l.setCountry_id(resultSet.getString(6));
//                listlocation.add(l);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }return listlocation;
//    }
//
//    @Override
//    public List<Location> search(String key) {
//        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        List<Location> listLocation = new ArrayList<Location>();
//        String query = "SELECT * FROM LOCATIONS WHERE location_id LIKE (?) OR street_address LIKE (?) OR postal_code LIKE (?) OR city LIKE (?) OR state_province LIKE (?) OR country_ID LIKE (?)";
//        try {
//            //preparedStatement yang berfungsi untuk memanipulasi database dengan menggunakan query-query 
//            //yang memiliki parameter yang dikirimkan ke database pada saat query dieksekusi). 
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setString(1, "%"+key+"%");
//            preparedStatement.setString(2, "%"+key+"%");
//            preparedStatement.setString(3, "%"+key+"%");
//            preparedStatement.setString(4, "%"+key+"%");
//            preparedStatement.setString(5, "%"+key+"%");
//            preparedStatement.setString(6, "%"+key+"%");
//            //resulSet untuk menampung hasil eksekusi dari database.
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                Location l = new Location(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6));
//                l.setId(resultSet.getInt(1));
//                l.setStreet(resultSet.getString(2));
//                l.setPostal(resultSet.getString(3));
//                l.setCity(resultSet.getString(4));
//                l.setState(resultSet.getString(5));
//                l.setCountry_id(resultSet.getString(6));
//                listLocation.add(l);
//            }
//        } catch (Exception e) {
//            e.getStackTrace();
//        }
//        return listLocation;
//    }
    
    @Override
    public List<Location> getData(Object key, boolean isGetById) {
        List<Location> listLocation = new ArrayList<Location>();
        //ifelse dalam bentuk cepat
        String query = (isGetById)
                ?"SELECT * FROM LOCATIONS WHERE location_id = ?"
                :"SELECT * FROM LOCATIONS WHERE location_id LIKE (?) OR street_address LIKE (?) OR postal_code LIKE (?) OR city LIKE (?) OR state_province LIKE (?) OR country_ID LIKE (?)";
//        if (isGetById) {
//            query = "SELECT * FROM LOCATIONS WHERE location_id = ?";
//        } else {
//            query = "SELECT * FROM LOCATIONS WHERE location_id LIKE (?) OR street_address LIKE (?) OR postal_code LIKE (?) OR city LIKE (?) OR state_province LIKE (?) OR country_ID LIKE (?)";
//        }
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            if (isGetById) {
                preparedStatement.setInt(1, (int) key);
            } else {
                preparedStatement.setString(1, "%" + key + "%");
                preparedStatement.setString(2, "%" + key + "%");
                preparedStatement.setString(3, "%" + key + "%");
                preparedStatement.setString(4, "%" + key + "%");
                preparedStatement.setString(5, "%" + key + "%");
                preparedStatement.setString(6, "%" + key + "%");
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Location l = new Location(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6));
                listLocation.add(l);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listLocation;
    }
    
    @Override
    public boolean save(Location l) {
        boolean result = false;
        //ifelse dengan bentuk lebih sederhana
        String query = (getData(l.getId(), true).isEmpty())
                ? "INSERT INTO LOCATIONS (street_address, postal_code, city, state_province, country_id, location_id) VALUES ((?),(?),(?),(?),(?),(?))"
                : "UPDATE LOCATIONS SET street_address = (?), postal_code = (?), city = (?), state_province = (?), country_id = (?) WHERE location_id = (?)";
//        if(getById(r.getId()).isEmpty()){
//            query = "INSERT INTO LOCATIONS (street_address, postal_code, city, state_province, country_id, location_id) VALUES ((?),(?),(?),(?),(?),(?))";
//        }
//        else{
//            query = "UPDATE LOCATIONS SET street_address = (?), postal_code = (?), city = (?), state_province = (?), country_id = (?) WHERE location_id = (?)";
//        }
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, l.getStreet());
            preparedStatement.setString(2, l.getPostal());
            preparedStatement.setString(3, l.getCity());
            preparedStatement.setString(4, l.getState());
            preparedStatement.setString(5, l.getCountry_id());
            preparedStatement.setInt(6, l.getId());
            
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    @Override
    public boolean delete(int id) {        
         boolean result = false;
            String query = "DELETE FROM LOCATIONS WHERE location_id=(?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

//    @Override
//    public boolean insert(Location l) {
//        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        boolean result = false;
//        String query = "INSERT INTO LOCATIONS (location_id, street_address, postal_code, city, state_province, country_id) VALUES ((?),(?),(?),(?),(?),(?))";
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setInt(1, l.getId());
//            preparedStatement.setString(2, l.getStreet());
//            preparedStatement.setString(3, l.getPostal());
//            preparedStatement.setString(4, l.getCity());
//            preparedStatement.setString(5, l.getState());
//            preparedStatement.setString(6, l.getCountry_id());
//            preparedStatement.executeQuery();
//            result = true;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }return result;
//    }
//
//    @Override
//    public boolean update(Location l) {
//        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        boolean result = false;
//        String query = "UPDATE LOCATIONS SET street_address = (?), postal_code = (?), city = (?), state_province = (?), country_id = (?) WHERE location_id = (?)";
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setString(1, l.getStreet());
//            preparedStatement.setString(2, l.getPostal());
//            preparedStatement.setString(3, l.getCity());
//            preparedStatement.setString(4, l.getState());
//            preparedStatement.setString(5, l.getCountry_id());
//            preparedStatement.setInt(6, l.getId());
//            preparedStatement.executeQuery();
//            result = true;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }return result;
//    }    
    
}
