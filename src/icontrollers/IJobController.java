/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Icontrollers;

import Models.Job;
//import Models.Region;
import java.util.List;

/**
 *
 * @author WIN7
 */
public interface IJobController {
    
    public List<Job> getAll();    
    public List<Job> getByid(String id);    
    public List<Job> search(String key);
    public String insert(String id, String Title, String Min_Salary, String Max_Salary);
    public String update(String id, String Title, String Min_Salary, String Max_Salary);
    public String delete(String id);

}
