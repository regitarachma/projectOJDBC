/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Idaos;

import Models.Job;
import java.util.List;

/**
 *
 * @author WIN7
 */
public interface IJobDAO {
    public List<Job> getAll();
    
    public List<Job> getById(String id);
    
    public List<Job> search(String Title);
    
    public boolean insert(Job j);
    
    public boolean update(Job j);
    
    public boolean delete(String id);
    
}
