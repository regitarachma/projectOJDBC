/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;
import Daos.JobDAO;
import Icontrollers.IJobController;
import Idaos.IJobDAO;
import Models.Job;
import java.sql.Connection;
import java.util.List;
/**
 *
 * @author WIN7
 */
public class JobController implements IJobController{
    private IJobDAO ijdao;
    
     public JobController(Connection connection){
        ijdao = new JobDAO(connection);
    }

    @Override
    public List<Job> getAll() {
        return ijdao.getAll();
    }

    @Override
    public List<Job> getByid(String id) {
       return ijdao.getById(id);
    }

    @Override
    public List<Job> search(String Title) {
       return ijdao.search(Title);
    }

    @Override
    public String insert(String id, String Title, String Min_Salary, String Max_Salary) {
        String result ="";
        Job job = new Job(id, Title, Integer.parseInt(Min_Salary), Integer.parseInt(Max_Salary));
        if (ijdao.insert(job)){
            result ="Data berhasil disimpan";
        }else{
            result ="Maaf data gagal disimpan";
        }
        return result;
    }

    @Override
    public String update(String id, String Title, String Min_Salary, String Max_Salary) {
       String result ="";
        Job job = new Job(id, Title, Integer.parseInt(Min_Salary), Integer.parseInt(Max_Salary));
        if (ijdao.update(job)){
            result ="Data berhasil diupdate";
        }else{
            result ="Maaf data gagal diupdate";
        }
        return result;
    }

    @Override
    public String delete(String id) {
      String result ="";
       if (ijdao.delete(id)){
           result =" Data berhasil di hapus";
       }else{
           result ="Maaf data gagal di hapus";
       }
       return result;
    }
}



