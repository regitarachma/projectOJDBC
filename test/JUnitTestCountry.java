/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import controllers.CountryController;
import icontrollers.ICountryController;
import java.util.List;
import models.Country;
import org.junit.Assert;
import org.junit.Test;
import tools.DBConnection;

/**
 *
 * @author Ode
 */
public class JUnitTestCountry {

    DBConnection connection = new DBConnection();
    ICountryController icc = new CountryController(connection.getConnection());

    public JUnitTestCountry() {
    }

    @Test
    public void testGetAll() {
        List<Country> act1 = icc.getAll();
        Assert.assertNotNull(act1);
    }

    @Test
    public void testGetById() {
        List<Country> act2 = icc.getById("zz");
        Assert.assertNotNull(act2);
    }

    @Test
    public void testSearch() {
        List<Country> act3 = icc.search("zz");
    }

    @Test
    public void testInsert() {
        icc.insert("cc", "ARUL", "3");
        List<Country> country = icc.getById("cc");
        Assert.assertEquals("cc", country.get(0).getId());
        Assert.assertEquals("ARUL", country.get(0).getName());
        Assert.assertEquals(3, country.get(0).getRegion());
    }

    @Test
    public void testUpdate() {
        icc.update("cc", "ARUL", "3");
        List<Country> country = icc.getById("cc");
        Assert.assertEquals("cc", country.get(0).getId());
        Assert.assertEquals("ARUL", country.get(0).getName());
        Assert.assertEquals(3, country.get(0).getRegion());
    }

    @Test
    public void testDelete() {
        icc.delete("cc");
        Assert.assertEquals("[]", icc.getById("cc") + "");
    }

}
