/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import controllers.EmployeeController;
import icontrollers.IEmployeeController;
import java.util.Date;
import java.util.List;
import models.Employee;
import models.Region;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tools.DBConnection;

/**
 *
 * @author Relion31
 */
public class JUnitTestEmployee {
    Date d = new Date();
    DBConnection connection = new DBConnection();
    IEmployeeController iec = new EmployeeController(connection.getConnection());
    public JUnitTestEmployee() {
    }
    
    @Test
    public void testGetById(){
        List<Employee> act = iec.getById("199");
        Assert.assertNotNull(act);
    }
    @Test
    public void testGetAll(){
        List<Employee> act3 = iec.getAll();
        Assert.assertNotNull(act3);
    }
    @Test
    public void testSearch(){
        List<Employee> act2 = iec.search("199");
        Assert.assertNotNull(act2);
    }
    @Test
    public void testInsert(){
        iec.insert("211", "Aku", "saya", "namasaya1@gmail.com", "08987676", "06-05-2019", "SA_REP", "15000", "0.8", "122", "50");
        List<Employee> m = iec.getById("211");
        Assert.assertEquals("211", m.get(0).getId());
        Assert.assertEquals("nama", m.get(0).getFirst_name());
        Assert.assertEquals("saya", m.get(0).getLast_name());
        Assert.assertEquals("namasaya@gmail.com", m.get(0).getEmail());
        Assert.assertEquals("08987676", m.get(0).getPhone_number());
        Assert.assertEquals("06-05-2019", m.get(0).getHire_date());
        Assert.assertEquals("SA_REP", m.get(0).getJob());
        Assert.assertEquals("15000", m.get(0).getSalary());
        Assert.assertEquals("0.8", m.get(0).getCommission_pct());
        Assert.assertEquals("122", m.get(0).getManager());
        Assert.assertEquals("50", m.get(0).getDepartment());
    }
    @Test
    public void testUpdate(){
        iec.update("211", "Aku", "sayaIni", "namasaya1@gmail.com", "08987676", "2019-05-06", "SA_REP", "15000", "0.8", "122", "50");
        List<Employee> m = iec.getById("211");
        Assert.assertEquals("211", m.get(0).getId());
        Assert.assertEquals("nama", m.get(0).getFirst_name());
        Assert.assertEquals("saya", m.get(0).getLast_name());
        Assert.assertEquals("namasaya@gmail.com", m.get(0).getEmail());
        Assert.assertEquals("08987676", m.get(0).getPhone_number());
        Assert.assertEquals("06-05-2019", m.get(0).getHire_date());
        Assert.assertEquals("SA_REP", m.get(0).getJob());
        Assert.assertEquals("15000", m.get(0).getSalary());
        Assert.assertEquals("0.8", m.get(0).getCommission_pct());
        Assert.assertEquals("122", m.get(0).getManager());
        Assert.assertEquals("50", m.get(0).getDepartment());
    }
    @Test
    public void testDelete(){
        iec.delete("211");
        Assert.assertNotNull(iec.getById("211"));
    }
    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
//    @Before
//    public void setUp() {
//    }
//    
//    @After
//    public void tearDown() {
//    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
