/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.DepartmentDAO;
import icontrollers.IDepartmentController;
import idaos.IDepartmentDAO;
import java.sql.Connection;
import java.util.List;
import models.Department;

/**
 *
 * @author ASUS
 */
public class DepartmentController implements IDepartmentController {

    private IDepartmentDAO iddao;

    public DepartmentController(Connection connection) {
        iddao = new DepartmentDAO(connection);
    }

    @Override
    public List<Department> getAll() {
        return iddao.getAll();
    }

    @Override
    public List<Department> getById(String id) {
        return iddao.getById(Integer.parseInt(id));
    }

    @Override
    public List<Department> search(String key) {
        return iddao.search(key);
    }

    @Override
    public String insert(String id, String name, String manager, String location) {
        String result = "Maaf data gagal disimpan";
        Department d = new Department(Integer.parseInt(id), name, Integer.parseInt(manager), Integer.parseInt(location));
        if (iddao.insert(d)) {
            result = "Data berhasil disimpan";
        }
        return result;
    }

    @Override
    public String update(String id, String name, String manager, String location) {
        String result = "Maaf data gagal disimpan";
        Department d = new Department(Integer.parseInt(id), name, Integer.parseInt(manager), Integer.parseInt(location));
        if (iddao.update(d)) {
            result = "Data berhasil disimpan";
        }
        return result;
    }

    @Override
    public String delete(String id) {
        String result = "Maaf data gagal dihapus";
        if (iddao.delete(Integer.parseInt(id))) {
            result = "Data berhasil dihapus";
        } else {

        }
        return result;
    }

}
