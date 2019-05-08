/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.IDepartmentDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Department;


/**
 *
 * @author ASUS
 */
public class DepartmentDAO implements IDepartmentDAO{
    private Connection connection;
    
    public DepartmentDAO (Connection connection){
        this.connection = connection;
    }
    
    @Override
    public List<Department> getAll() {
        List<Department> listDepartment = new ArrayList<Department>();
        String query = "SELECT * FROM DEPARTMENTS ORDER BY department_id";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Department d = new Department(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4));
                d.setDepartment_id(resultSet.getInt(1));
                d.setDepartmen_name(resultSet.getString(2));
                d.setManager_id(resultSet.getInt(3));
                d.setLocation_id(resultSet.getInt(4));
                listDepartment.add(d);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDepartment;
    }

    @Override
    public List<Department> getById(int id) {
        List<Department> listDepartment = new ArrayList<Department>();
        String query = "SELECT * FROM DEPARTMENTS WHERE department_id=(?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Department d = new Department(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4));
                d.setDepartment_id(resultSet.getInt(1));
                d.setDepartmen_name(resultSet.getString(2));
                d.setManager_id(resultSet.getInt(3));
                d.setLocation_id(resultSet.getInt(4));
                listDepartment.add(d);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDepartment;
    }

    @Override
    public List<Department> search(String key) {
        List<Department> listDepartment = new ArrayList<Department>();
        String query = "SELECT * FROM DEPARTMENTS WHERE LOWER(department_id) LIKE (?) OR LOWER(department_name) LIKE (?) ORDER BY department_id";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%"+key+"%");
            preparedStatement.setString(2, "%"+key+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Department d = new Department(resultSet.getInt(1), resultSet.getString(2),resultSet.getInt(3),resultSet.getInt(4));
                d.setDepartment_id(resultSet.getInt(1));
                d.setDepartmen_name(resultSet.getString(2));
                d.setManager_id(resultSet.getInt(3));
                d.setLocation_id(resultSet.getInt(4));
                listDepartment.add(d);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return listDepartment;
    }

    @Override
    public boolean insert(Department d) {
        boolean result = false;
        String query = "INSERT INTO DEPARTMENTS(department_id, department_name, manager_id, location_id) VALUES ((?),(?),(?),(?))";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, d.getDepartment_id());
            preparedStatement.setString(2, d.getDepartmen_name());
            preparedStatement.setInt(3, d.getManager_id());
            preparedStatement.setInt(4, d.getLocation_id());
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean update(Department d) {
        boolean result = false;
        String query = "UPDATE DEPARTMENTS SET department_name=(?), manager_id=(?), location_id=(?) WHERE department_id=(?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, d.getDepartmen_name());
            preparedStatement.setInt(2, d.getManager_id());
            preparedStatement.setInt(3, d.getLocation_id());
            preparedStatement.setInt(4, d.getDepartment_id());
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        String query = "DELETE FROM DEPARTMENTS WHERE department_id=(?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeQuery();
            preparedStatement.executeQuery();
            result = true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
