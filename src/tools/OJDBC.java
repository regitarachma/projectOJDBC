package tools;

import controllers.RegionController;
import daos.EmployeeDAO;
import daos.LocationDAO;
import daos.RegionDAO;
import daos.UserManagementDAO;
import icontrollers.IRegionController;
import idaos.IEmployeeDAO;
import idaos.ILocationDAO;
import idaos.IRegionDAO;
import idaos.IUserManagementDAO;
import java.util.Date;
import models.Employee;
import models.Location;
import models.Region;
import models.UserManagement;
import org.mindrot.jbcrypt.BCrypt;
import views.JIRegionView;
import views.JLoginHR;
import views.MainFrame;

/**
 *
 * @author RR17
 */
public class OJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
//        MainFrame mainFrame = new MainFrame();
//        mainFrame.setVisible(true);
        
//        Date d = new Date();
//        java.util.Date date = new java.util.Date();
//        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
//        new MainFrame().setVisible(true);
//        DBConnection connection = new DBConnection();
//        System.out.println(connection.getConnection());
////        IEmployeeDAO iedao = new EmployeeDAO(connection.getConnection());
//        IRegionDAO irdao = new RegionDAO(connection.getConnection());
//        ILocationDAO ildao = new LocationDAO(connection.getConnection());
        
//        menampilkan semua data
//        for (Region region : irdao.getData("", false)) {
//            System.out.println(region.getId());
//            System.out.println(region.getName());
//        }


        //menampilkan semua data
//        for (Location location : ildao.getData("", false)) {
//            System.out.println(location.getId());
//            System.out.println(location.getStreet());
//            System.out.println(location.getPostal());
//            System.out.println(location.getCity());
//            System.out.println(location.getState());
//            System.out.println(location.getCountry_id());
//        }
//        System.out.println("=========");

          //menampilkan search data
//        for (Location location : ildao.getData("House", false)) {
//            System.out.println(location.getStreet());
//            }

          //menampilkan search data by id
//          for (Location location : ildao.getData(7777, true)) {
//            System.out.println(location.getId());
//          }
        
//        }
////        IRegionController icr = new RegionController(connection.getConnection());
//
//        //Check Connection
////        System.out.println(connection.getConnection());

////        DAO
//        //Insert
//        Region r = new Region(12345, "fala");
//        System.out.println(irdao.save(r));

        //View
//        for (Employee employee : iedao.search("211")) {
//            System.out.println(employee.getId());
//            System.out.println(employee.getFirst_name());
//            System.out.println(employee.getLast_name());
//            System.out.println(employee.getEmail());
//            System.out.println(employee.getPhone_number());
//            System.out.println(employee.getHire_date());
//            System.out.println(employee.getJob());
//            System.out.println(employee.getCommission_pct());
//            System.out.println(employee.getManager());
//            System.out.println(employee.getDepartment());
//        }
//        
//        for (Region region : irdao.getById(1)) {
//            System.out.println(region.getId());
//            System.out.println(region.getName());
//        }
        //Update
//        Region region = new Region(111, "Oka Lanang Akbar");
//        System.out.println(irdao.update(region));
        //Delete
//        System.out.println(irdao.delete(111));
        //Search
//        System.out.println(irdao.search("eu"));



          //----------------cek BCrypt------------------------------------------------
//        String password = "upnormal";
//        String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
//        System.out.println(BCrypt.hashpw(password, "$2a$10$avtrICaCW28TfoCtZI1A4."));
//        System.out.println(BCrypt.hashpw(password, "$2a$10$avtrICaCW28TfoCtZI1A4."));
//        System.out.println(BCrypt.hashpw(password, "$2a$10$avtrICaCW28TfoCtZI1A4."));
//        
//        //BCrypt.gensalt() memiliki fungsi by generate random key
//        System.out.println(BCrypt.hashpw(password, BCrypt.gensalt()));
//        System.out.println(BCrypt.hashpw(password, BCrypt.gensalt()).length());
//        System.out.println(BCrypt.hashpw(password, BCrypt.gensalt()));
//        System.out.println(BCrypt.gensalt());

         //cek manual register dan login
//         IUserManagementDAO userManagementDAO = new UserManagementDAO(connection.getConnection());
//         UserManagement userManagement = new UserManagement("bootcamp25", "semangat");
//         System.out.println(userManagementDAO.register(userManagement));
//         System.out.println(userManagementDAO.login(userManagement));
        
        //pengecekan pass (hashed mengecek pass dari database yg sudah dienkripsi)
        //password dapat dari inputan user
//        System.out.println(BCrypt.checkpw(password, hashed));

        //untuk memanggil JFrame login
        JLoginHR jlhr = new JLoginHR();
        jlhr.setVisible(true);
    }
    }
