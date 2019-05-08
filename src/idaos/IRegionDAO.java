/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaos;

import java.util.List;
import models.Region;

/**
 *
 * @author Okala
 */
public interface IRegionDAO {

    public List<Region> getData(Object key, boolean isGetById);
    
    public boolean delete(int id);
    
    public boolean save(Region r);
    
//    public List<Region> getAll();
//    
//    public List<Region> getById(int id);
//
//    public List<Region> search(String key);

//    public boolean insert(Region r);
//
//    public boolean update(Region r);
    
}