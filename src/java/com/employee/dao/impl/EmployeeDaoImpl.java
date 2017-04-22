/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.employee.dao.impl;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.employee.dao.EmployeeDao;
import com.employee.model.Employees;

/**
 *
 * @author Nelson Akpos
 */
@Repository
@Transactional
public  class EmployeeDaoImpl implements EmployeeDao{
   @Autowired
    private SessionFactory sessionFactory;
    
    
    @Override
    @Transactional
    public void addEmployee(Employees employee){
        //sessionFactory.getCurrentSession().saveOrUpdate(employee);
    	Session currentSession = sessionFactory.getCurrentSession();
        Transaction beginTransaction = currentSession.beginTransaction();
        currentSession.saveOrUpdate(employee);
       // List<Employees> list = currentSession.createCriteria(Employees.class).list();
        beginTransaction.commit();
    }
       
    @SuppressWarnings("unchecked")
    @Override
    public List<Employees> getAllEmployees(){
    	Session currentSession = sessionFactory.getCurrentSession();
    	Transaction beginTransaction = currentSession.beginTransaction();
        List<Employees> list = currentSession.createCriteria(Employees.class).list();
        beginTransaction.commit();
        return list;
        
    }
    @Override
    public void deleteEmployee(Integer employeeID){
    	
    	 Session currentSession = sessionFactory.getCurrentSession();
         Transaction beginTransaction = currentSession.beginTransaction();
         Employees employee=(Employees) sessionFactory.getCurrentSession().load(Employees.class, employeeID);
         this.sessionFactory.getCurrentSession().delete(employee);
        
    	
        /*Employees employee=(Employees) sessionFactory.getCurrentSession().load(Employees.class, employeeID);
                if(null!=employee){
            this.sessionFactory.getCurrentSession().delete(employee);
        }*/
    }
    
    @Override
    public Employees getEmployee(int empID){
       //return (Employees) sessionFactory.getCurrentSession().get(Employees.class, empID);
       
       Session currentSession = sessionFactory.getCurrentSession();
       Transaction beginTransaction = currentSession.beginTransaction();
       
       Session session1 = sessionFactory.openSession();
       return (Employees) session1.get(Employees.class, empID);
       
     // return (Employees) currentSession.get(Employees.class, empID);
      // List<Employees> list = currentSession.createCriteria(Employees.class).list();
      //  beginTransaction.commit();
    }
    @Override
    public Employees updateEmployee(Employees employee){
    	Session currentSession = sessionFactory.getCurrentSession();
        Transaction beginTransaction = currentSession.beginTransaction();
        Employees e = (Employees)currentSession.get(Employees.class, employee.getEmployeeID());
        copy(employee, e);
        currentSession.update(e);
        beginTransaction.commit();
        return employee;
    }
    
    private void copy(Employees from, Employees to){
    	to.setAddress(from.getAddress());
    	to.setEmail(from.getEmail());
    	to.setFirstname(from.getFirstname());
    	to.setDate_of_birth(from.getDate_of_birth());
    	to.setGender(from.getGender());
    	to.setPhone(from.getPhone());
    	to.setSalary(from.getSalary());
    	to.setSurname(from.getSurname());
    }
}