/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.employee.dao;
import com.employee.model.Employees;
import java.util.List;


/**
 *
 * @author Nelson Akpos
 */

public interface EmployeeDao {
    public void addEmployee(Employees employee);
     public List<Employees> getAllEmployees();
     //public void updateEmployee(Employees employee);
    public void deleteEmployee(Integer employeeID);
    //public void getEmployee(int employeeID);
    public Employees updateEmployee(Employees employee);
    public Employees getEmployee(int employeeID);
    //public List getAllEmployees();
   /* @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sf) { 
        this.sessionFactory = sf;
    }

public List<Employees> getAllEmployees() { 
Session session = this.sessionFactory.getCurrentSession(); 
List<Employees> employeeList = session.createQuery("from employee_info").list();
return employeeList; 
}

public Employees getEmployee(int id) 
{ 
Session session = this.sessionFactory.getCurrentSession(); 
Employees employee = (Employees) session.load(Employees.class, new Integer(id));
  return employee; 
  }
 public Employees addEmployee(Employees employee)
 { Session session = this.sessionFactory.getCurrentSession();
 session.persist(employee); return employee;
 }
 public void updateEmployee(Employees employee) { 
     Session session = this.sessionFactory.getCurrentSession();
     session.update(employee); 
 }
 public void deleteEmployee(int id) {
     Session session = this.sessionFactory.getCurrentSession(); 
     Employees p = (Employees) session.load(Employees.class, new Integer(id)); 
     if (null != p) { session.delete(p); } }*/
}
