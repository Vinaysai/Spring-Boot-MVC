package com.spring.boot.all.service;

import java.util.List;

import javax.transaction.Transactional;

import com.spring.boot.all.Dao.EmployeeDao;
import com.spring.boot.all.bean.Employee;

public interface EmployeeService {

	void addEmployee(Employee employee);

	void deleteEmployee(Integer employeeId);

	List<Employee> getAllEmployees();

	Employee getEmployee(int empid);

	EmployeeDao getEmployeeDAO();

	void setEmployeeDAO(EmployeeDao employeeDAO);

	Employee updateEmployee(Employee employee);

}