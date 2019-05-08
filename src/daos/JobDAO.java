/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;



import Idaos.IJobDAO;
import Models.Job;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author WIN7
 */
public class JobDAO implements IJobDAO {
    private Connection connection;
    
    public JobDAO(Connection connection){
        this.connection = connection;
    }

    @Override
    public List<Job> getAll() {
        List<Job> listJob = new ArrayList<Job>();
        String query ="SELECT * FROM JOBS";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()) {
                Job j= new Job(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4));
                j.setJob_id(resultSet.getString(1));
                j.setJob_Title(resultSet.getString(2));
                j.setMin_Salary(resultSet.getInt(3));
                j.setMax_Salary(resultSet.getInt(4));
                listJob.add(j);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listJob;
       // return null;
   
    }

    @Override
    public List<Job> getById(String id) {
        List<Job> listJob = new ArrayList<Job>();
        String query ="SELECT * FROM JOBS WHERE job_id=(?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()) {
                Job j= new Job(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4));
                j.setJob_id(resultSet.getString(1));
                j.setJob_Title(resultSet.getString(2));
                j.setMin_Salary(resultSet.getInt(3));
                j.setMax_Salary(resultSet.getInt(4));
                
                listJob.add(j);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listJob;
        
    }
    
    @Override
    public List<Job> search(String Title) {
           List<Job> listJob = new ArrayList<Job>();
        String query ="SELECT * FROM JOBS WHERE job_id LIKE(?) OR job_title LIKE(?) OR min_salary LIKE(?) OR max_salary LIKE(?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,"%"+Title+"%");
            preparedStatement.setString(2,"%"+Title+"%");
            preparedStatement.setString(3,"%"+Title+"%");
            preparedStatement.setString(4,"%"+Title+"%");
            //menampung hasil eksekusi dari database
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()) {
                Job j= new Job(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4));
                j.setJob_id(resultSet.getString(1));
                j.setJob_Title(resultSet.getString(2));
                j.setMin_Salary(resultSet.getInt(3));
                j.setMax_Salary(resultSet.getInt(4));
                
                listJob.add(j);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listJob;
    }

    @Override
    public boolean insert(Job j) {
        boolean result = false;
        String query = "INSERT INTO JOBS(job_id, job_title, min_salary, max_salary) VALUES (?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, j.getJob_id());
            preparedStatement.setString(2, j.getJob_Title());
            preparedStatement.setInt(3, j.getMin_Salary());
            preparedStatement.setInt(4, j.getMax_Salary());
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean update(Job j) {
        boolean result = false;
        String query = "UPDATE JOBS SET job_title=(?), min_salary=(?),max_salary=(?) WHERE job_id=(?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, j.getJob_Title());
            preparedStatement.setInt(2, j.getMin_Salary());
            preparedStatement.setInt(3, j.getMax_Salary());
            preparedStatement.setString(4, j.getJob_id());
            preparedStatement.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        String query ="DELETE FROM JOBS WHERE job_id=(?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    }
    
  
    
    

