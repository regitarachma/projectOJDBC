/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author ASUS
 */
public class Department {
    private int department_id;
    private String departmen_name;
    private int manager_id;
    private int location_id;

    public Department() {
    }

    public Department(int department_id, String departmen_name, int manager_id, int location_id) {
        this.department_id = department_id;
        this.departmen_name = departmen_name;
        this.manager_id = manager_id;
        this.location_id = location_id;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getDepartmen_name() {
        return departmen_name;
    }

    public void setDepartmen_name(String departmen_name) {
        this.departmen_name = departmen_name;
    }

    public int getManager_id() {
        return manager_id;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    public int getLocation_id() {
        return location_id;
    }

    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }    
}
