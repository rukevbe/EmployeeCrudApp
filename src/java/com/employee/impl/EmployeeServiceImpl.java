/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.employee.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.employee.dao.EmployeeDao;
import com.employee.model.Employees;
import com.employee.service.EmployeeService;

/**
 *
 * @author Nelson Akpos
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public void addEmployee(Employees employee) {
		employeeDao.addEmployee(employee);
	}

	@Override
	public List<Employees> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}

	@Override
	public void deleteEmployee(Integer employeeID) {
		employeeDao.deleteEmployee(employeeID);
	}

	@Override
	public Employees getEmployee(int employeeID) {
		return employeeDao.getEmployee(employeeID);
	}
    

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	
	public Employees updateEmployee(Employees employee) {
		// TODO Auto-generated method stub
		 return employeeDao.updateEmployee(employee);
	}
}
