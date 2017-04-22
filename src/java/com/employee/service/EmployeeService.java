/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.employee.service;
import java.util.List;  
import com.employee.dao.EmployeeDao;  
import com.employee.model.Employees;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;  
import org.springframework.transaction.annotation.Transactional;  

/**
 *
 * @author Nelson Akpos
 */

public interface EmployeeService {
   public void addEmployee(Employees employee);
   public List<Employees> getAllEmployees();
    public void deleteEmployee(Integer employeeID);
   
   
    public Employees getEmployee(int employeeID);
     public Employees updateEmployee(Employees employee);
    //public List getAllEmployees(); 
 
}