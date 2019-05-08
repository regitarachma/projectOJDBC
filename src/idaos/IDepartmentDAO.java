/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaos;

import java.util.List;
import models.Department;

/**
 *
 * @author ASUS
 */
public interface IDepartmentDAO {
    public List<Department> getAll();

    public List<Department> getById(int id);

    public List<Department> search(String key);

    public boolean insert(Department r);

    public boolean update(Department r);

    public boolean delete(int id);
}
