
import controllers.DepartmentController;
import icontrollers.IDepartmentController;
import java.util.List;
import models.Department;
import org.junit.Assert;
import org.junit.Test;
import tools.DBConnection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yosef
 */
public class JUnitTestDepartment {
    DBConnection connection = new DBConnection();
    IDepartmentController idc = new DepartmentController(connection.getConnection());
    
    public JUnitTestDepartment(){        
    }
   
    @Test
     public void testGetAll(){
         List<Department> act = idc.getAll();
         Assert.assertNotNull(act);
     }
     
     public void testGetById() {
         List<Department> act2 = idc.getById("1");
         Assert.assertNotNull(act2);
     }
     
     public void testSearch() {
         List<Department> act3;
         act3 = idc.search("1");
         Assert.assertNotNull(act3);
     }
     
     public void testInsert(){
         idc.insert("204", "Tester", "100", "1800");
         List<Department> departments = idc.getById("204");
         Assert.assertEquals("204", departments.get(0).getDepartment_id());
         Assert.assertEquals("Tester", departments.get(0).getDepartmen_name());
         Assert.assertEquals("100", departments.get(0).getManager_id());
         Assert.assertEquals("1800", departments.get(0).getLocation_id());
     }

     public void testUpdate(){
         idc.insert("204", "Tester Aja", "100", "1800");
         List<Department> departments = idc.getById("204");
         Assert.assertEquals("204", departments.get(0).getDepartment_id());
         Assert.assertEquals("Tester Aja", departments.get(0).getDepartmen_name());
         Assert.assertEquals("100", departments.get(0).getManager_id());
         Assert.assertEquals("1800", departments.get(0).getLocation_id());
     }
     
     public void testDelete(){
         idc.delete("204");
         Assert.assertNotNull(idc.getById("204"));
     }
}
