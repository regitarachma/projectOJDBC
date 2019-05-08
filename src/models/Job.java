/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author WIN7
 */
public class Job {
    
    private String job_id;
    private String job_Title;
    private int Min_Salary;
    private int Max_Salary;
                    
    public Job(){
        
    }

    public Job(String job_id, String job_Title, int Min_Salary, int Max_Salary) {
        this.job_id = job_id;
        this.job_Title = job_Title;
        this.Min_Salary = Min_Salary;
        this.Max_Salary = Max_Salary;
    }

    public String getJob_id() {
        return job_id;
    }

    public void setJob_id(String job_id) {
        this.job_id = job_id;
    }

    public String getJob_Title() {
        return job_Title;
    }

    public void setJob_Title(String job_Title) {
        this.job_Title = job_Title;
    }

    public int getMin_Salary() {
        return Min_Salary;
    }

    public void setMin_Salary(int Min_Salary) {
        this.Min_Salary = Min_Salary;
    }

    public int getMax_Salary() {
        return Max_Salary;
    }

    public void setMax_Salary(int Max_Salary) {
        this.Max_Salary = Max_Salary;
    }

 
    
}
