package com.spring.boot.all.Dao;

import java.util.List;

import com.spring.boot.all.bean.Employee;

public interface EmployeeDao {

	
	
	 public Employee addEmployee(Employee employee);
	 
	    public List<Employee> getAllEmployees();
	 
	    public Employee deleteEmployee(Integer employeeId);
	 
	    public Employee updateEmployee(Employee employee);
	 
	    public Employee getEmployee(int employeeid);
}
